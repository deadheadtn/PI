/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.sql.SQLException;

import java.util.Objects;

/**
 *
 * @author deadhead
 */
public class news {
    private int id_news;
    private int id_cooperation;
    private String title;
    private String TYPE_N;
    private String MOT_CLES;
    private String text;
    private String image;
    private ResultSet rs;

    public news(int id_cooperation, String title, String TYPE_N, String MOT_CLES, String text, String image) {
        this.id_cooperation = id_cooperation;
        this.title = title;
        this.TYPE_N = TYPE_N;
        this.MOT_CLES = MOT_CLES;
        this.text = text;
        this.image = image;
    }

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }
    
    public int getId_cooperation() {
        return id_cooperation;
    }

    public void setId_cooperation(int id_cooperation) {
        this.id_cooperation = id_cooperation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTYPE_N() {
        return TYPE_N;
    }

    public void setTYPE_N(String TYPE_N) {
        this.TYPE_N = TYPE_N;
    }

    public String getMOT_CLES() {
        return MOT_CLES;
    }

    public void setMOT_CLES(String MOT_CLES) {
        this.MOT_CLES = MOT_CLES;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "news{id_news="+ id_news+", id_cooperation=" + id_cooperation + ", title=" + title + ", TYPE_N=" + TYPE_N + ", MOT_CLES=" + MOT_CLES + ", text=" + text + ", image=" + image + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id_cooperation;
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + Objects.hashCode(this.TYPE_N);
        hash = 59 * hash + Objects.hashCode(this.MOT_CLES);
        hash = 59 * hash + Objects.hashCode(this.text);
        hash = 59 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final news other = (news) obj;
        if (this.id_cooperation != other.id_cooperation) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.TYPE_N, other.TYPE_N)) {
            return false;
        }
        if (!Objects.equals(this.MOT_CLES, other.MOT_CLES)) {
            return false;
        }
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }
    public boolean addNews() throws SQLException{
        Connection connection = Dbsource.getInstance().getConnection();
        PreparedStatement p= connection.prepareStatement("INSERT INTO news (ID_COOPERATION,TITRE_N,TYPE_N,MOT_CLES,TEXTE_N,IMAGE_N) VALUES (?,?,?,?,?,?);");
        p.setInt(1, this.getId_cooperation());
        p.setString(2, this.getTitle());
        p.setString(3, this.getTYPE_N());
        p.setString(4, this.getMOT_CLES());
        p.setString(5,this.getText());
        p.setString(6,this.getImage());
        int check=p.executeUpdate();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) from news");
        rs.next();
        int count = rs.getInt(1);
        this.setId_news(count);
        return check != 0;
    }
    public boolean DeleteNews() throws SQLException{
        Connection connection = Dbsource.getInstance().getConnection();
        PreparedStatement p= connection.prepareStatement("delete from news where ID_NEWS=?;");
        p.setInt(1, this.getId_news());
        return p.executeUpdate() != 0;
    }
    public boolean modifynews() throws SQLException{
        Connection connection = Dbsource.getInstance().getConnection();
        PreparedStatement p= connection.prepareStatement("Select * from news where ID_NEWS=?;");
        p.setInt(1, this.getId_news());
        rs =p.executeQuery();
        rs.next();
        //System.err.println(rs.getInt("ID_COOPERATION"));
        news modified = new news(rs.getInt("ID_COOPERATION"),rs.getString("TITRE_N"),rs.getString("TYPE_N"),rs.getString("MOT_CLES"),rs.getString("TEXTE_N"),rs.getString("IMAGE_N"));
        if(this.equals(modified)){
            return false;
        }
        else{
            PreparedStatement mod= connection.prepareStatement("UPDATE news SET ID_COOPERATION=?,TITRE_N=?,TYPE_N=?,MOT_CLES=?,TEXTE_N=?,IMAGE_N=? where ID_NEWS=?;");
            mod.setInt(1, this.getId_cooperation());
            mod.setString(2, this.getTitle());
            mod.setString(3, this.getTYPE_N());
            mod.setString(4, this.getMOT_CLES());
            mod.setString(5,this.getText());
            mod.setString(6,this.getImage());
            mod.setInt(7,this.getId_news());
            int check=mod.executeUpdate();
            return check!=0;
        }
    }
    public news Listenews(int id) throws SQLException{
        ArrayList<news> Liste = null;
        Connection connection = Dbsource.getInstance().getConnection();
        PreparedStatement p= connection.prepareStatement("Select * from news where ID_NEWS=?;");
        p.setInt(1, id);
        rs =p.executeQuery();
        rs.next();
        news modified = new news(rs.getInt("ID_COOPERATION"),rs.getString("TITRE_N"),rs.getString("TYPE_N"),rs.getString("MOT_CLES"),rs.getString("TEXTE_N"),rs.getString("IMAGE_N"));
        return modified;
    }
}
