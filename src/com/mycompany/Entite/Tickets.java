/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author mahdi
 */
public class Tickets {
     private int id_user;
    private int id_ticket;
        private int id_match;
    private String type;
    private String prix;
    private String email;
    private String etat_ticket;
    private Date date_ajout;
     public Tickets() {
    }
     public Tickets(int id_user,int id_ticket,String type,double prix,String email, String etat_ticket, Date date_ajout) {
       this.id_user= id_user;
        this.id_ticket= id_ticket;
        this.type = type;
        this.prix = Double.toString(prix);
        this.email=email;
        this.etat_ticket = etat_ticket;
        this.date_ajout=date_ajout;
      
    }

    public Tickets(int id_ticket, String type,double prix , String email) {
         this.id_ticket= id_ticket;
        this.type = type;
        this.prix = Double.toString(prix);
        this.email=email;
    }
     public Tickets(int id_user,int id_match,int id_ticket,String type,double prix,String email, String etat_ticket, Date date_ajout) {
       this.id_user= id_user;
       this.id_match=id_match;
        this.id_ticket= id_ticket;
        this.type = type;
        this.prix = Double.toString(prix);
        this.email=email;
        this.etat_ticket = etat_ticket;
        this.date_ajout=date_ajout;
      
    }

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public Tickets(int id_ticket, String type, String email) {
        this.id_ticket=id_ticket;
        this.type= type;
        this.email=email;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Tickets{" + "id_user=" + id_user + ", id_ticket=" + id_ticket + ", type=" + type + ", prix=" + prix + ", email=" + email + ", etat_ticket=" + etat_ticket + ", date_ajout=" + date_ajout + '}';
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = Double.toString(prix);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEtat_ticket() {
        return etat_ticket;
    }

    public void setEtat_ticket(String etat_ticket) {
        this.etat_ticket = etat_ticket;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }
    
    
    
}
