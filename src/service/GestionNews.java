/*
 * To change n license header, choose License Headers in Project Properties.
 * To change n template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.news;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DataSource;
import entite.news;
/**
 *
 * @author deadhead
 */
public class GestionNews {
    private ResultSet rs;
    public GestionNews(){}
    public boolean addNews(news n) throws SQLException{
        
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement p= connection.prepareStatement("INSERT INTO news (ID_COOPERATION,TITRE_N,TYPE_N,MOT_CLES,TEXTE_N,IMAGE_N) VALUES (?,?,?,?,?,?);");
        p.setInt(1, n.getId_cooperation());
        p.setString(2, n.getTitle());
        p.setString(3, n.getTYPE_N());
        p.setString(4, n.getMOT_CLES());
        p.setString(5,n.getText());
        p.setString(6,n.getImage());
        int check=p.executeUpdate();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) from news");
        rs.next();
        int count = rs.getInt(1);
        n.setId_news(count);
        return check != 0;
    }
    public boolean DeleteNews(news n) throws SQLException{
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement p= connection.prepareStatement("delete from news where ID_NEWS=?;");
        p.setInt(1, n.getId_news());
        return p.executeUpdate() != 0;
    }
    public boolean modifynews(news n) throws SQLException{
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement p;
        p = connection.prepareStatement("Select * from news where ID_NEWS=?;");
        p.setInt(1, n.getId_news());
        rs =p.executeQuery();
        rs.next();
        //System.err.println(rs.getInt("ID_COOPERATION"));
        news modified = new news(0,rs.getInt("ID_COOPERATION"),rs.getString("TITRE_N"),rs.getString("TYPE_N"),rs.getString("MOT_CLES"),rs.getString("TEXTE_N"),rs.getString("IMAGE_N"));
        if(n.equals(modified)){
            return false;
        }
        else{
            PreparedStatement mod= connection.prepareStatement("UPDATE news SET ID_COOPERATION=?,TITRE_N=?,TYPE_N=?,MOT_CLES=?,TEXTE_N=?,IMAGE_N=? where ID_NEWS=?;");
            mod.setInt(1, n.getId_cooperation());
            mod.setString(2, n.getTitle());
            mod.setString(3, n.getTYPE_N());
            mod.setString(4, n.getMOT_CLES());
            mod.setString(5,n.getText());
            mod.setString(6,n.getImage());
            mod.setInt(7,n.getId_news());
            int check=mod.executeUpdate();
            return check!=0;
        }
    }
    public news Listenews(int id) throws SQLException{
        ArrayList<news> Liste = null;
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement p= connection.prepareStatement("Select * from news where ID_NEWS=?;");
        p.setInt(1, id);
        rs =p.executeQuery();
        rs.next();
        news modified = new news(0,rs.getInt("ID_COOPERATION"),rs.getString("TITRE_N"),rs.getString("TYPE_N"),rs.getString("MOT_CLES"),rs.getString("TEXTE_N"),rs.getString("IMAGE_N"));
        return modified;
    }
}
