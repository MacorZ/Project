/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author acer
 */
public interface ServiceInterface <T>{
     public List<T> selectAll();
    public T selectOne(T t);
    public String add(T t);
    public String update(T t);
    public String delete(T t);
    public String check(T t);
}
