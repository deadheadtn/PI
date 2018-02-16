/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.sql.SQLException;
import utils.DataSource;
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
    
    public news(){}
    public news(int id_news,int id_cooperation, String title, String TYPE_N, String MOT_CLES, String text, String image) {
        this.id_news=id_news;
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
    
}
