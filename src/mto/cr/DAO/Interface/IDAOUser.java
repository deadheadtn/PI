/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.DAO.Interface;

import mto.cr.Model.User;

/**
 *
 * @author Chiheb
 */
public interface IDAOUser extends IDAO<User>{
   User getByUsername(String username);
   User getByEmail(String email);
   int Login(User U);
   void updatePassword(User U);
   void updateLastLogin(User U);
   void updateSolde(double s,User u);
   void userConnecte(User u);
   void userDecoonnecte(User u);
}
