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
public interface Repointerface <T>{
    List<T> getAll();
    T getOne(T t);
    boolean add(T t);
    boolean update(T t);
    boolean delete(T t);
    
}
