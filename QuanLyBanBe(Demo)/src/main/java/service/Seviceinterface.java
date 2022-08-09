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
public interface Seviceinterface<T> {
    List<T> getAll();
    T getOne(T t);
    String add(T t);
    String update(T t);
    String delete(T t);
    String check(T t);
}
