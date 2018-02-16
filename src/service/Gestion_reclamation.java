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
        if(rec.getId_followup()==0){
            return false;
        }
        else
        {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement p= connection.prepareStatement("insert into reclamation (ID_FOLLOWUP,ID_UTILISATEUR,SUJET_REC,DESCRIPTION_REC,DATE_REC,ETAT_REC) values (?,?,?,?,?,?);");
            PreparedStatement followup= connection.prepareStatement("insert into follow_up (DATE_FOLLOW,STATUT_FOLLOW) values (NOW(),?);");
            followup.setInt(1, 0);
            followup.executeUpdate();
            p.setInt(1,rec.getId_followup());
            p.setInt(2, rec.getId_utilisateur());
            p.setString(3, rec.getSUJET_REC());
            p.setString(4, rec.getDESCRIPTION_REC());
            p.setString(5, rec.getDATE_REC());
            p.setString(6, rec.getETAT_REC());
            int check=p.executeUpdate();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from reclamation");
            rs.next();
            int count = rs.getInt(1);
            rec.setId_reclamation(count);
            return check != 0;
        }
    }
}
