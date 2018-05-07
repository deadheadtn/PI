/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author fedibigbo$$
 */
public class Reservationt {
         private int id_reservationt;
         private String type;
         private String depart;
         private String destination;
         private String date_depart;
         private String date_arrivee;
         private int nbr_voyageurs;
         private String etat;
         private int id_utilisateur;
         private int id_transport;

    public Reservationt(String type, String depart, String destination, String date_depart, String date_arrivee, int nbr_voyageurs, int id_utilisateur, int id_transport) {
        this.type = type;
        this.depart = depart;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
        this.nbr_voyageurs = nbr_voyageurs ;
        this.id_utilisateur = id_utilisateur;
        this.id_transport = id_transport;
    }

    public Reservationt(int aInt, int aInt0, String string, String string0, String string1, String string2, String string3, int aInt1, String string4) {
        
        this.id_reservationt=aInt;
        this.id_transport=aInt0;
        this.type=string;
        this.depart=string0;
        this.destination=string1;
        this.date_depart=string2;
        this.date_arrivee=string3;
        this.nbr_voyageurs=aInt1;
        this.etat=string4;
        
    }

    public Reservationt(int id_reservationt, String value) {
         this.id_reservationt = id_reservationt;
        this.etat = etat; ; //To change body of generated methods, choose Tools | Templates.
    }

    public Reservationt() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_transport() {
        return id_transport;
    }

    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }
    public int getId_reservationt() {
        return id_reservationt;
    }

    public void setId_reservationt(int id_reservationt) {
        this.id_reservationt = id_reservationt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public String getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(String date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public int getNbr_voyageurs() {
        return nbr_voyageurs;
    }

    public void setNbr_voyageurs(int nbr_voyageurs) {
        this.nbr_voyageurs = nbr_voyageurs;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Reservationt(String type, String depart, String destination, String date_depart, String date_arrivee, int nbr_voyageurs, String etat) {
        this.type = type;
        this.depart = depart;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
        this.nbr_voyageurs = nbr_voyageurs;
        this.etat = etat;
    }

    public Reservationt(int id_reservationt, String type, String depart, String destination, String date_depart, String date_arrivee, int nbr_voyageurs, String etat) {
        this.id_reservationt = id_reservationt;
        this.type = type;
        this.depart = depart;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
        this.nbr_voyageurs =nbr_voyageurs;
        this.etat = etat;
    }

    
}
