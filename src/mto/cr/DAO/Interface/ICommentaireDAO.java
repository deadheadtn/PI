/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.DAO.Interface;

import java.util.List;
import mto.cr.Model.CommentaireProbleme;
import mto.cr.Model.User;

/**
 *
 * @author bouda
 */
public interface ICommentaireDAO extends IDAO<CommentaireProbleme> {
    boolean voterCommentaire (CommentaireProbleme cp);
    List<CommentaireProbleme> findAllByProbleme(int id);
    List<CommentaireProbleme> getByUser(User u);
    
}
