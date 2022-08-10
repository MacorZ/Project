/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reposirory;

import java.util.List;

/**
 *
 * @author acer
 */
public interface ICommon<T> {

    public List<T> selectAll();

    public T selectOne(T t);

    public boolean add(T t);

    public boolean update(T t);

    public boolean delete(T t);

}
