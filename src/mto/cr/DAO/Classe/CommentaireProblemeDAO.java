/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.DAO.Classe;

import mto.cr.Technique.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mto.cr.DAO.Interface.ICommentaireDAO;
import mto.cr.Model.CommentaireProbleme;
import mto.cr.Model.User;

/**
 *
 * @author bouda
 */
public class CommentaireProblemeDAO implements ICommentaireDAO {

    private Connection db;
    private ProblemeDAO probleme = new ProblemeDAO();

    public CommentaireProblemeDAO() {
        db = DataBase.getInstance().getConnection();
    }

    @Override
    public boolean voterCommentaire(CommentaireProbleme cp) {
        return false;
    }

    @Override
    public List<CommentaireProbleme> getAll() {
        String req = "select * from commentaireprobleme ";
        List<CommentaireProbleme> commentaireList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            CommentaireProbleme p;
            while (result.next()) {
                p = new CommentaireProbleme();
                p.setIdCommentaire(result.getInt("idCommentaire"));
                p.setContenue(result.getString("contenu"));
                p.setDateCommentaire(result.getString("dateCommentaire"));
                p.setNbrVote(result.getInt("nbrVote"));
                p.setValide(result.getInt("valide"));
                p.setProbleme(probleme.getById(result.getInt("idProbleme_cp")));

                commentaireList.add(p);

            }
            return commentaireList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return commentaireList;
    }

    @Override
    public List<CommentaireProbleme> findAllOrderBy() {
        String req = "select * from commentaireProbleme order By  nbrvote ASC";

        List<CommentaireProbleme> commentaireList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            CommentaireProbleme p = new CommentaireProbleme();
            while (result.next()) {

                p.setIdCommentaire(result.getInt("idCommentaire"));
                p.setContenue(result.getString("contenu"));
                p.setDateCommentaire(result.getString("dateCommentaire"));
                p.setNbrVote(result.getInt("nbrVote"));
                p.setValide(result.getInt("valide"));
                p.setProbleme(probleme.getById(result.getInt("idProbleme_cp")));

                commentaireList.add(p);
                p = new CommentaireProbleme();

            }
            return commentaireList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return commentaireList;

    }

    @Override
    public boolean update(CommentaireProbleme t) {
   String req = "update CommentaireProbleme set Contenu='"+t.getContenue()+"' where idCommentaire="+t.getIdCommentaire();
    
    Statement statement;
        try {
            statement = db.createStatement();
            statement.executeUpdate(req);
            

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }

    @Override
    public boolean insert(CommentaireProbleme t) {
       
        String req = "insert into commentaireProbleme (contenu,dateCommentaire,notif,nbrVote,valide,iduser_cp,idProbleme_cp,notificationadmin) values ('" + t.getContenue() + "','" + t.getDateCommentaire() + "','" + t.getNotif() + "','" + t.getNbrVote() + "','" + t.getValide() + "','" + t.getUser().getId() + "','" + t.getProbleme().getIdProbleme() + "',1) ";
        int nbrCommentaireP = t.getUser().getNbrCommentaireProbleme()+1;
      String req1 = "update User set nbrCommentaireProbleme='" +nbrCommentaireP+ "' "
                + "where ID= " + t.getUser().getId();
     
        Statement statement;
        try {
            statement = db.createStatement();
            statement.executeUpdate(req);
             statement.executeUpdate(req1);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean clean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommentaireProbleme> findAllByProbleme(int id) {
        String req = "select * from commentaireprobleme where idprobleme_cp= '" + id + "'";
        List<CommentaireProbleme> commentaireList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            CommentaireProbleme p = new CommentaireProbleme();
            UserDAO u = new UserDAO();
            while (result.next()) {
                p.setIdCommentaire(result.getInt("idCommentaire"));
                p.setContenue(result.getString("contenu"));
                p.setDateCommentaire(result.getString("dateCommentaire"));
                p.setNbrVote(result.getInt("nbrVote"));
                p.setValide(result.getInt("valide"));
                p.setProbleme(probleme.getById(result.getInt("idProbleme_cp")));
                p.setUser(u.getById(result.getInt("idUser_cp")));

                commentaireList.add(p);
                p = new CommentaireProbleme();

            }
            return commentaireList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return commentaireList;
    }

    @Override
    public boolean ajouter(CommentaireProbleme t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CommentaireProbleme getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean supprimerCommeataire(int id){
    String req1 = "Update VoteCommentaire set IdCommentaire_vc=null where idCommentaire_vc="+id;
     String req = "delete from commentaireProbleme where idCommentaire=" + id;
     
        Statement statement;

        try {
            statement = db.createStatement();
           
        
         statement.executeUpdate(req1);
         statement.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    
    }

    @Override
    public List<CommentaireProbleme> getByUser(User u) {
        List<CommentaireProbleme> commentaireList = new ArrayList<>();
        String query = "select * from commentaireprobleme where idUser_cp = ?";
        ResultSet result;
        PreparedStatement ps;
        Statement statement;
        CommentaireProbleme p;
        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, u.getId());
            result = ps.executeQuery();
            
            while (result.next()) {
                p = new CommentaireProbleme();
                p.setIdCommentaire(result.getInt("idCommentaire"));
                p.setContenue(result.getString("contenu"));
                p.setDateCommentaire(result.getString("dateCommentaire"));
                p.setNbrVote(result.getInt("nbrVote"));
                p.setValide(result.getInt("valide"));
                p.setProbleme(probleme.getById(result.getInt("idProbleme_cp")));
                System.out.println(p.getIdCommentaire());
                commentaireList.add(p);

            }
            return commentaireList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return commentaireList;
    
    }
    


}
