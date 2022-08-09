package utility;



import java.util.Properties;
import model.Grade;
import model.Students;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author acer
 */
public class HibenateUtil {
    private static final SessionFactory FACTORY;
    static{
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DIALECT,"org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER,"com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FPL_DAOTAO;encrypt=true;trustServerCertificate=true;");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "sa");
        properties.put(Environment.SHOW_SQL, "true");
        //        gen db tư động
//        properties.put(Environment.HBM2DDL_AUTO, "create");
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Students.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Grade.class);
        
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        FACTORY = configuration.buildSessionFactory(registry);
    }
    public static SessionFactory getFactory(){
        return FACTORY;
    }
    public static void main(String[] args) {
        getFactory();
    }
}
