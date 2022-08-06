/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author bcamacho
 * @param <T>
 */
public interface CRUD<T> {
    
    public List listar();
    
    public T getData(int id);
  
    public boolean add(T _objeto);
    
    public boolean edit(T _objeto);
    
    public boolean delete(int id);
    
}
