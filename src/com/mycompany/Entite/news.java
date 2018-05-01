/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;
//import java.sql.SQLException;

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
        return "news{title=" + title + "text=" + text + ", image=" + image + '}';
    }    
}
