/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.DAO.Interface;

import java.util.Collection;
import mto.cr.Model.User;

/**
 *
 * @author bouda
 */
public interface IAdministrateurDAO extends IDAO<User>{
    
    
    boolean delete(String val);
    boolean activation(User user);
    boolean desactivation (User user);
    User findByEmail (String email);
    
}
