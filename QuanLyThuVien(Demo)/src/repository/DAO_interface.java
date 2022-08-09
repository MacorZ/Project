/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author acer
 */
public interface DAO_interface <T>{
    public T selectObj(T t);
    public List<T> selectAll();
    
    
}
