/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DataSource;

/**
 *
 * @author deadhead
 */
public class Gestion_reclamation {
    Reclamation r= new Reclamation();
    public boolean addReclamation(Reclamation rec) throws SQLException{
            try{
            Connection connection = DataSource.getInstance().getConnection();
            Statement p1= connection.createStatement();
            ResultSet rs1=p1.executeQuery("select ID_UTILISATEUR AS ID from utilisateur where email like '%"+rec.getEmail()+"%';");
            rs1.next();
            //rs1.close();
            int id=rs1.getInt(1);
            System.out.println(id);
            PreparedStatement p= connection.prepareStatement("insert into reclamation (ID_FOLLOWUP,ID_UTILISATEUR,SUJET_REC,DESCRIPTION_REC,DATE_REC,ETAT_REC) values (1,?,?,?,NOW(),0);");
            p.setInt(1, id);
            p.setString(2, rec.getSUJET_REC());
            p.setString(3, rec.getDESCRIPTION_REC());
            //p.setString(4, "0");
            int check=p.executeUpdate();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from reclamation");
            rs.next();
            int count = rs.getInt(1);
            rec.setId_reclamation(count);
            
            return check != 0;
            }
            
            catch(SQLException e){
                System.err.println(e);
            }
        return false;
            
            
        
    }
     public boolean modifyrecencours(String email) throws SQLException{
        Connection connection = DataSource.getInstance().getConnection();
            System.err.println(email);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select r.ID_RECLAMATION as id from reclamation r INNER join utilisateur u on r.ID_UTILISATEUR=u.ID_UTILISATEUR where u.email like '%"+email+"%'");
            rs.next();
            int id = rs.getInt("id");
             
            PreparedStatement mod= connection.prepareStatement("UPDATE reclamation SET ETAT_REC=1 where ID_RECLAMATION=?;");
            mod.setInt(1, id);
            int check=mod.executeUpdate();
            return check!=0;
    }
          public boolean modifyrecresolu(String email) throws SQLException{
            Connection connection = DataSource.getInstance().getConnection();
            //System.err.println(email);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select r.ID_RECLAMATION as id from reclamation r INNER join utilisateur u on r.ID_UTILISATEUR=u.ID_UTILISATEUR where u.email like '%"+email+"%'");
            rs.next();
            int id = rs.getInt("id");
             
            PreparedStatement mod= connection.prepareStatement("UPDATE reclamation SET ETAT_REC=2 where ID_RECLAMATION=?;");
            mod.setInt(1, id);
            int check=mod.executeUpdate();
            return check!=0;
    }
}
