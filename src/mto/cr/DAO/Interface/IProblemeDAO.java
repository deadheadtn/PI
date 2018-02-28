/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.DAO.Interface;

import java.util.Collection;
import java.util.List;
import mto.cr.Model.Probleme;
import mto.cr.Model.User;

/**
 *
 * @author bouda
 */
public interface IProblemeDAO extends IDAO<Probleme>{
      boolean delete(int val);
      List<Probleme>  findBySecteur(String secteur);
      List<Probleme> findByEtat(String etat);
      List<Probleme> orderByCommentaire ();
      List<Probleme>  findOrderByCom();
}
