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
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mto.cr.DAO.Interface.IAdministrateurDAO;
import mto.cr.GUI.ForumController;
import mto.cr.Model.CommentaireProbleme;
import mto.cr.Model.Probleme;
import mto.cr.Model.User;

/**
 *
 * @author bouda
 */
public class AdministrateurDAO implements IAdministrateurDAO {

    private Connection db;

    public AdministrateurDAO() {
        db = DataBase.getInstance().getConnection();
    }

    
    public List<User> userConnecte(){
    
    
    
      ResultSet res;
        PreparedStatement ps;
        User user;
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user where name=c";

        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
    
            res = ps.executeQuery();
            while (res.next()) {
                user = new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setUsername_canonical(res.getString("username_canonical"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setEmail(res.getString("email"));
                user.setEmail_canonical(res.getString("email_canonical"));
                user.setPassword(res.getString("password"));
                user.setEnabled(res.getInt("enabled"));
                user.setLocked(res.getInt("locked"));
                user.setSalt(res.getString("salt"));
                user.setPath(res.getString("path"));
                user.setPaysnatal(res.getString("paysNatal"));
                user.setSituationprof(res.getString("situationprof"));
                user.setSecteur(res.getString("secteur"));
                user.setSolde(res.getInt("solde"));
                user.setRole(res.getString("role"));
                user.setRoles(res.getString("roles"));
                user.setDatenaissance(res.getDate("dateNaissance"));
                user.setNbrVote(res.getInt("nbrVote"));
                user.setNbrcommentaire(res.getInt("nbrcommentaire"));
                user.setNbrprojetssuivis(res.getInt("nbrprojetssuivis"));
                user.setNbrfinancement(res.getInt("nbrfinancement"));
                user.setNbrProbleme(res.getInt("nbrProbleme"));
                user.setNbrCommentaireProbleme(res.getInt("nbrCommentaireProbleme"));
                
                users.add(user);
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
        
    
    
    }
    public List<User> userdeConnecte(){
    
    
    
      ResultSet res;
        PreparedStatement ps;
        User user;
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user where name=b";

        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
    
            res = ps.executeQuery();
            while (res.next()) {
                user = new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setUsername_canonical(res.getString("username_canonical"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setEmail(res.getString("email"));
                user.setEmail_canonical(res.getString("email_canonical"));
                user.setPassword(res.getString("password"));
                user.setEnabled(res.getInt("enabled"));
                user.setLocked(res.getInt("locked"));
                user.setSalt(res.getString("salt"));
                user.setPath(res.getString("path"));
                user.setPaysnatal(res.getString("paysNatal"));
                user.setSituationprof(res.getString("situationprof"));
                user.setSecteur(res.getString("secteur"));
                user.setSolde(res.getInt("solde"));
                user.setRole(res.getString("role"));
                user.setRoles(res.getString("roles"));
                user.setDatenaissance(res.getDate("dateNaissance"));
                user.setNbrVote(res.getInt("nbrVote"));
                user.setNbrcommentaire(res.getInt("nbrcommentaire"));
                user.setNbrprojetssuivis(res.getInt("nbrprojetssuivis"));
                user.setNbrfinancement(res.getInt("nbrfinancement"));
                user.setNbrProbleme(res.getInt("nbrProbleme"));
                user.setNbrCommentaireProbleme(res.getInt("nbrCommentaireProbleme"));
                
                users.add(user);
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
        
    
    
    }
   

    @Override
    public List<User> findAllOrderBy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findByEmail(String email) {
        String req = "select * from user where EMAIL='" + email + "' ";
        Statement statement;
                    User u = new User();

        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            while (result.next()) {
                u.setEmail(result.getString("email"));
                u.setUsername(result.getString("username"));
                u.setExpired(result.getInt("expired"));
                u.setLocked(result.getInt("locked"));
                u.setNbrprojetssuivis(result.getInt("nbrprojetssuivis"));
                u.setNbrVote(result.getInt("nbrVote"));
                u.setNbrcommentaire(result.getInt("nbrcommentaire"));
                u.setNbrfinancement(result.getInt("nbrfinancement"));
                u.setRole(result.getString("roles"));
                //a = new Administrator(result.getInt("ID"), result.getString("FIRSTNAME"), result.getString("LASTNAME"), result.getString("email"), result.getString("password"));
                u.setRole(result.getString("ROLE"));
            }
            return u;
        } catch (SQLException ex) {
        }
        return null;
    }

   
    @Override
    public boolean delete(String val) {
        String req = "delete from user where email=" + val;
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
      
    public boolean deleteById(User user) {
        String req = "delete from user where id=" + user.getId();
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean clean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean activation(User user) {
        String req = "update User set locked=0,enabled=1 where ID= " + user.getId();
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean desactivation(User user) {
        String req = "update User set locked=1 , enabled =0 where ID= " + user.getId();
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

  
    @Override
    public User getById(int id) {
String req = "select * from user where id='" + id + "' ";
        Statement statement;
                    User u = new User();

        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            while (result.next()) {
                u.setId(id);
                u.setEmail(result.getString("email"));
                u.setUsername(result.getString("username"));
                u.setExpired(result.getInt("expired"));
                u.setLocked(result.getInt("locked"));
                u.setNbrprojetssuivis(result.getInt("nbrprojetssuivis"));
                u.setNbrVote(result.getInt("nbrVote"));
                u.setNbrcommentaire(result.getInt("nbrcommentaire"));
                u.setNbrfinancement(result.getInt("nbrfinancement"));
                u.setRole(result.getString("roles"));
                //a = new Administrator(result.getInt("ID"), result.getString("FIRSTNAME"), result.getString("LASTNAME"), result.getString("email"), result.getString("password"));
                u.setRole(result.getString("ROLE"));
            }
            return u;
        } catch (SQLException ex) {
        }
        return u;    }

    @Override
    public boolean ajouter(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public void notificationVu(List<Probleme> ps){
    
        for (Probleme p : ps) {
              String req = "update Probleme set notificationadmin=0 where IDPROBLEME="+ p.getIdProbleme();
         
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);
  


  
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
            
        }
    
    }
      public void notificatiVuCommentaire(List<CommentaireProbleme> ps){
    
        for (CommentaireProbleme p : ps) {
              String req = "update commentaireprobleme set notificationadmin=0 where idCommentaire="+ p.getIdCommentaire();
         
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);
  


  
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
            
        }
    
    }
      public boolean valider(Probleme p){
      
         String req = "update Probleme set valide=1 where IDPROBLEME="+ p.getIdProbleme();
         
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);
  


  
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
      return true;
      }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
           public List<Probleme> notificationProbleme() {
   String req = "select * from probleme where notificationadmin=1 ";

        List<Probleme> problemeList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            ProblemeDAO pd = new ProblemeDAO();
            Probleme p = new Probleme();
            while (result.next()) {
                
               
                p.setIdProbleme(result.getInt(1));
                 p.setSecteur(result.getString(6));
                p.setDateProblem(result.getString(5));
                p.setNbrCommentaireProbleme(result.getInt(10));
                p.setEtatProbleme(result.getString(4));
                p.setTitre(result.getString(2));
               p.setContenu(result.getString(8));
                p.setNiveauRequis(result.getInt(3));
                                p.setUser(pd.findbyId(result.getInt(11)));

                problemeList.add(p);
                   p = new Probleme();
            }
                           return problemeList;
} catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;  

    }

    public List<CommentaireProbleme> notificationCommentaireProbleme() {
String req = "select * from commentaireprobleme where notificationadmin=1";
        List<CommentaireProbleme> commentaireList = new ArrayList<>();
        ProblemeDAO probleme = new ProblemeDAO();
        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            CommentaireProbleme p = new CommentaireProbleme();
            while (result.next()) {
                
                p.setIdCommentaire(result.getInt(1));
                p.setContenue(result.getString(3));
                p.setDateCommentaire(result.getString(2));
                p.setNbrVote(result.getInt(4));
                p.setValide(result.getInt(5));
                //p.setProbleme(probleme.findbyId(result.getInt(7)));
                p.setUser(probleme.findbyId( result.getInt(8)));
                
                commentaireList.add(p);
                   p = new CommentaireProbleme();
                  
            }
         return commentaireList;} catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return commentaireList;


    }
  
    public boolean notifierProbleme(Probleme p){
       String req = "update Probleme set notificationadmin=0 where IDPROBLEME="+ p.getIdProbleme();
         
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);
  


  
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
      return true;
    
    
    }

public boolean Promote(User p){
       String req = "update User set  roles='a:1:{i:0;s:10:\"ROLE_ADMIN\";}' where id="+ p.getId();
         
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);
  


  
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
      return true;
    
    
    }
public boolean UnPromote(User p){
       String req = "update User set  roles='a:0:{}' where id="+ p.getId();
         
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);
  


  
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
      return true;
    
    
    }


}
