/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.DAO.Classe;

import mto.cr.Technique.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mto.cr.DAO.Interface.IProblemeDAO;
import mto.cr.Model.CommentaireProbleme;
import mto.cr.Model.Probleme;
import mto.cr.Model.User;

/**
 *
 * @author bouda
 */
public class ProblemeDAO implements IProblemeDAO {

    private Connection db;

    public ProblemeDAO() {
        db = DataBase.getInstance().getConnection();
    }

    @Override
    public List<Probleme> getAll() {
        String req = "select * from probleme ";
        List<Probleme> problemeList = new ArrayList<>();
        UserDAO userDAO = new UserDAO();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);

            while (result.next()) {
                Probleme p = new Probleme();
                p.setIdProbleme(result.getInt(1));
                p.setSecteur(result.getString(6));
                p.setDateProblem(result.getString(5));
                p.setNbrCommentaireProbleme(result.getInt(9));
                p.setEtatProbleme(result.getString(4));
                p.setTitre(result.getString(2));
                p.setContenu(result.getString(8));
                p.setNiveauRequis(result.getInt(3));
                p.setUser(userDAO.getById(result.getInt(10)));
                

                problemeList.add(p);

            }
            return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;
    }
    
    public List<Probleme> getAllValider() {
        String req = "select * from probleme where valide=1";
        List<Probleme> problemeList = new ArrayList<>();
        UserDAO userDAO = new UserDAO();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);

            while (result.next()) {
                Probleme p = new Probleme();
                p.setIdProbleme(result.getInt(1));
                p.setSecteur(result.getString(6));
                p.setDateProblem(result.getString(5));
                p.setNbrCommentaireProbleme(result.getInt(9));
                p.setEtatProbleme(result.getString(4));
                p.setTitre(result.getString(2));
                p.setContenu(result.getString(8));
                p.setNiveauRequis(result.getInt(3));
                p.setUser(userDAO.getById(result.getInt(10)));
                

                problemeList.add(p);

            }
            return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;
    }

    @Override
    public List<Probleme> findAllOrderBy() {
        String req = "select * from Probleme where valide = 1 order By titre ASC";
        List<Probleme> problemeList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            Probleme p;
            while (result.next()) {
                p = new Probleme();
                p.setTitre(result.getString("titre"));
                p.setContenu(result.getString("contenu"));
                p.setDateProblem(result.getString("dateProbleme"));
                p.setEtatProbleme(result.getString("etatProbleme"));
                p.setNbrCommentaireProbleme(result.getInt("nbrcommentaireProbleme"));
                p.setNiveauRequis(result.getInt("niveaurequis"));
                p.setIdProbleme(result.getInt("idProbleme"));
                p.setUser(findbyId(result.getInt(10)));

                problemeList.add(p);
            }
            return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;

    }

    @Override
    public boolean insert(Probleme t) {

        String req = "insert into Probleme (contenu,dateProbleme,nbrcommentaireprobleme,titre,secteur,valide,niveaurequis,iduser_Prob,etatprobleme,notificationadmin) values ('" + t.getContenu() + "','" + t.getDateProblem() + "','" + t.getNbrCommentaireProbleme() + " ','" + t.getTitre() + "','" + t.getSecteur() + "','" + t.getValide() + "','" + t.getNiveauRequis() + "','" + t.getUser().getId() + "','" + t.getEtatProbleme() + "',1) ";
        Statement statement;
        int nbrProbleme = t.getUser().getNbrProbleme()+1;
        
        String req1 = "update User set nbrProbleme='" +nbrProbleme+ "' "
                + "where ID= " + t.getUser().getId();
        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);
                result = statement.executeUpdate(req1);
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
    public boolean delete(int val) {
        String req = "delete from Probleme where idprobleme=" + val;
         String req1 = "delete from commentaireProbleme where idprobleme_cp=" + val;
        Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req1);
            result=statement.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public List<Probleme> findbyUser(User u){
    
      String req = "select * from probleme where valide=1  and idUser_Prob='" + u.getId() + "' ";

        List<Probleme> problemeList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            Probleme p = new Probleme();
            while (result.next()) {

                p.setIdProbleme(result.getInt(1));
                p.setSecteur(result.getString(6));
                p.setDateProblem(result.getString(5));
                p.setNbrCommentaireProbleme(result.getInt(9));
                p.setEtatProbleme(result.getString(4));
                p.setTitre(result.getString(2));
                p.setContenu(result.getString(8));
                p.setNiveauRequis(result.getInt(3));
                p.setUser(findbyId(result.getInt(10)));

                problemeList.add(p);
                p = new Probleme();
            }
            return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;
    
    
    
    
    
    
    }

    @Override
    public List<Probleme> findBySecteur(String secteur) {
        String req = "select * from probleme where valide=1  and secteur='" + secteur + "' ";

        List<Probleme> problemeList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            Probleme p = new Probleme();
            while (result.next()) {

                p.setIdProbleme(result.getInt(1));
                p.setSecteur(result.getString(6));
                p.setDateProblem(result.getString(5));
                p.setNbrCommentaireProbleme(result.getInt(9));
                p.setEtatProbleme(result.getString(4));
                p.setTitre(result.getString(2));
                p.setContenu(result.getString(8));
                p.setNiveauRequis(result.getInt(3));
                p.setUser(findbyId(result.getInt(10)));

                problemeList.add(p);
                p = new Probleme();
            }
            return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;
    }

    @Override
    public boolean update(Probleme t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Probleme> findByEtat(String etat) {
        String req = "select * from probleme where etatProbleme='" + etat + "' ";

        List<Probleme> problemeList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            Probleme p = new Probleme();
            while (result.next()) {

                p.setIdProbleme(result.getInt(1));
                p.setSecteur(result.getString(6));
                p.setDateProblem(result.getString(5));
                p.setNbrCommentaireProbleme(result.getInt(9));
                p.setEtatProbleme(result.getString(4));
                p.setTitre(result.getString(2));
                p.setContenu(result.getString(8));
                p.setNiveauRequis(result.getInt(3));
                p.setUser(findbyId(result.getInt(10)));

                problemeList.add(p);
                p = new Probleme();
                
            }
        return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;
    }

    @Override
    public List<Probleme> orderByCommentaire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Probleme> findOrderByCom() {
        String req = "select * from Probleme where valide = 1  order By nbrcommentaireProbleme ASC";
        List<Probleme> problemeList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            Probleme p;
            while (result.next()) {
                p = new Probleme();
                p.setTitre(result.getString("titre"));
                p.setContenu(result.getString("contenu"));
                p.setDateProblem(result.getString("dateProbleme"));
                p.setEtatProbleme(result.getString("etatProbleme"));
                p.setNbrCommentaireProbleme(result.getInt("nbrcommentaireProbleme"));
                p.setNiveauRequis(result.getInt("niveaurequis"));
                p.setIdProbleme(result.getInt("idProbleme"));
                p.setUser(findbyId(result.getInt(10)));
                problemeList.add(p);
            }
            return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;
    }
     public List<Probleme> findByEtatValider(String etat) {
        String req = "select * from probleme where valide = 1 and EtatProbleme='" + etat + "' ";

        List<Probleme> problemeList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            Probleme p = new Probleme();
            while (result.next()) {

                p.setIdProbleme(result.getInt(1));
                p.setSecteur(result.getString(6));
                p.setDateProblem(result.getString(5));
                p.setNbrCommentaireProbleme(result.getInt(9));
                p.setEtatProbleme(result.getString(4));
                p.setTitre(result.getString(2));
                p.setContenu(result.getString(8));
                p.setNiveauRequis(result.getInt(3));
                p.setUser(findbyId(result.getInt(11)));

                problemeList.add(p);
                p = new Probleme();
                
            }
            return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;
    }

  

   
    public List<Probleme> findOrderByComValider() {
        String req = "select * from Probleme where valide=1 order By nbrcommentaireProbleme Desc";
        List<Probleme> problemeList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            Probleme p;
            while (result.next()) {
                p = new Probleme();
                p.setTitre(result.getString("titre"));
                p.setContenu(result.getString("contenu"));
                p.setDateProblem(result.getString("dateProbleme"));
                p.setEtatProbleme(result.getString("etatProbleme"));
                p.setNbrCommentaireProbleme(result.getInt("nbrcommentaireProbleme"));
                p.setNiveauRequis(result.getInt("niveaurequis"));
                p.setIdProbleme(result.getInt("idProbleme"));
                p.setUser(findbyId(result.getInt(11)));
                problemeList.add(p);
            }
            return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;
    }

    @Override
    public Probleme getById(int id) {

        String req = "select * from probleme where idProbleme='" + id + "' ";

        Probleme p = new Probleme();
        UserDAO userDAO = new UserDAO();
        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);

            while (result.next()) {

                p.setIdProbleme(result.getInt(1));
                p.setSecteur(result.getString(6));
                p.setDateProblem(result.getString(5));
                p.setNbrCommentaireProbleme(result.getInt(9));
                p.setEtatProbleme(result.getString(4));
                p.setTitre(result.getString(2));
                p.setContenu(result.getString(8));
                p.setNiveauRequis(result.getInt(3));
                p.setUser(userDAO.getById(result.getInt(11)));
                System.out.println("probleme User" +p.getUser().getUsername());

                return p;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }

    public List<Probleme> findByTitre(String titre) {

        String req = "select * from probleme where valide = 1 and titre='" + titre + "' ";

        List<Probleme> problemeList = new ArrayList<>();

        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
            Probleme p;
            while (result.next()) {
                p = new Probleme();
                p.setTitre(result.getString("titre"));
                p.setContenu(result.getString("contenu"));
                p.setDateProblem(result.getString("dateProbleme"));
                p.setEtatProbleme(result.getString("etatProbleme"));
                p.setNbrCommentaireProbleme(result.getInt("nbrcommentaireProbleme"));
                p.setNiveauRequis(result.getInt("niveaurequis"));
                p.setIdProbleme(result.getInt("idProbleme"));
                UserDAO userDAO = new UserDAO();
                p.setUser(userDAO.getById(result.getInt("idUser_prob")));
                problemeList.add(p);
            }
            return problemeList;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return problemeList;

    }

    public User findbyId(int id) {
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
        return u;
    }

    @Override
    public boolean ajouter(Probleme t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean ajoutCommentairenbr(Probleme p){
    
      String req = "update Probleme set nbrcommentaireProbleme='"+ p.getNbrCommentaireProbleme() + "' "
                + "where IDprobleme= " + p.getIdProbleme();
       Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean resoudreProb(Probleme p){
    String resolue = "resolu";
  String req = "update Probleme set etatProbleme='"+ resolue+ "' "
                + "where IDprobleme= " + p.getIdProbleme();
  
  Statement statement;

        try {
            statement = db.createStatement();
            int result = statement.executeUpdate(req);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Probleme findById(int id){
    
        
        String req = "select * from probleme where idProbleme='" + id + "' ";

        
    Probleme p = new Probleme();
        Statement statement;
        try {
            statement = db.createStatement();
            ResultSet result = statement.executeQuery(req);
        
            while (result.next()) {
                
               
                 
                p.setIdProbleme(result.getInt(1));
                 p.setSecteur(result.getString(6));
                p.setDateProblem(result.getString(5));
                p.setNbrCommentaireProbleme(result.getInt(10));
                p.setEtatProbleme(result.getString(4));
                p.setTitre(result.getString(2));
               p.setContenu(result.getString(8));
                p.setNiveauRequis(result.getInt(3));
                                p.setUser(findbyId(result.getInt(11)));

                
             return p;   
                   
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
return p;
          
    }
    public boolean votePlus(CommentaireProbleme c , User u) throws SQLException{
     String req="insert into VoteCommentaire (dateVote,idCommentaire_vc,idUser_vc) values(?,?,?)"; 
      PreparedStatement ps=db.prepareStatement(req);
         Calendar cal = Calendar.getInstance();
             Statement statement;
            java.util.Date d = cal.getTime();
           java.sql.Date dd= new Date (d.getTime()); 
            ps.setDate(1, dd); 
       ps.setInt(2,c.getIdCommentaire());
            ps.setInt(3, u.getId());
            int nbrVote=c.getNbrVote()+1;
           String req1="Update CommentaireProbleme set nbrVote='"+nbrVote+"'where idCommentaire='"+c.getIdCommentaire()+"'";
           
              try {
           ps.executeUpdate();
            statement = db.createStatement();
            int result = statement.executeUpdate(req1);

                  
           

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    
    }
     public boolean votemoins(CommentaireProbleme c , User u) throws SQLException{
     String req="insert into VoteCommentaire (dateVote,idCommentaire_vc,idUser_vc) values(?,?,?)"; 
      PreparedStatement ps=db.prepareStatement(req);
       Statement statement;
         Calendar cal = Calendar.getInstance();
            
            java.util.Date d = cal.getTime();
           java.sql.Date dd= new Date (d.getTime()); 
            ps.setDate(1, dd); 
       ps.setInt(2,c.getIdCommentaire());
            ps.setInt(3, u.getId());
            int nbrVote=c.getNbrVote()-1;
           String req1="Update CommentaireProbleme set nbrVote='"+nbrVote+"'where idCommentaire='"+c.getIdCommentaire()+"'";
           
              try {
           ps.executeUpdate();
            statement = db.createStatement();
            int result = statement.executeUpdate(req1);

                  
           

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

   
  
        
    
    }
 

    

}
