/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.DAO.Interface;

import java.util.List;

/**
 *
 * @author PC
 */
public interface IDAO<T> {
    
    boolean ajouter (T t);
 //  boolean delete (int id); 
 //  void afficher (); 
    T getById(int id); 
    List<T> getAll();   

    List<T> findAllOrderBy();
    
    boolean update(T t);

    boolean insert(T t);

    boolean clean();
}
