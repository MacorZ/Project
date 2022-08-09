/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class Users {
    private String userName;
    private String displayName;
    private String Password;
    private String Description;

    public Users(String userName, String displayName, String Password, String Description) {
        this.userName = userName;
        this.displayName = displayName;
        this.Password = Password;
        this.Description = Description;
    }

    public Users() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Users{" + "userName=" + userName + ", displayName=" + displayName + ", Password=" + Password + ", Description=" + Description + '}';
    }
    
    
}
