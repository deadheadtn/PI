package com.mycompany.Entite;

import com.codename1.ui.spinner.Picker;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fedibigbo$$
 */
public class Reservation {

    public Reservation(int i, int i0, int i1, Picker datePicker, Picker datePicker2, int i2, Picker stringPicker, int i3, int i4) {
    }

    public String getNbr_nuit() {
        return nbr_nuit;
    }

    public void setNbr_nuit(int nbr_nuit) {
        this.nbr_nuit = Integer.toString(nbr_nuit);
    }

    public String getNbr_chambre() {
        return nbr_chambre;
    }

    public void setNbr_chambre(int nbr_chambre) {
        this.nbr_chambre = Integer.toString(nbr_chambre);
    }

    public String getNbr_personne() {
        return nbr_personne;
    }

    public void setNbr_personne(int nbr_personne) {
        this.nbr_personne = Integer.toString(nbr_personne);
    }

     private int id_reservation;
     private int id_utilisateur;
     private String date_arrivee;
     private String date_depart;
     private String nbr_nuit;
     private String type;
     private String nbr_chambre;
     private String etat;

     private String nbr_personne;
    private int id_hotel;

    public Reservation(int aInt, int aInt0,int aInt20, String date, String date0, int aInt1, String string, int aInt2, int aInt3, String string0) {
        this.id_reservation=aInt;
        this.id_hotel=aInt0;
        this.id_utilisateur=aInt20;
        this.date_arrivee=date;
        this.date_depart=date0;
        this.nbr_nuit=Integer.toString(aInt1);
        this.type=string;
        this.nbr_chambre=Integer.toString(aInt2);
        this.nbr_personne=Integer.toString(aInt3);
        this.etat=string0;
    }

    
    public Reservation(int id_reservation, String Etat) {
        this.id_reservation = id_reservation;
        this.etat = Etat;
    }

    public Reservation() {
        //To change body of generated methods, choose Tools | Templates.
    }

//    }
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
  

    public int getId_hotel() {
        return id_hotel;
    }

//    public Reservation(int parseInt, String nbr1, String nbr3, String nbr2) {
//                this.id_reservation = id_reservation;
//               // this.nbr_nuit=nbr1;
//
    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

//
//    }
  

    public String getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(String date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

//    public Reservation(String value, String da, String daa) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    

   
    

    

   

   

    

    public String getType (){
        return type;
    }

    public void setType(String option) {
        this.type = option;
    }

 
    public Reservation(int id_reservation, String date_arrivee, String date_depart, int nbr_nuit, String type, int nbr_chambre, int nbr_personne,String etat) {
        this.id_reservation = id_reservation;
   
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nbr_nuit = Integer.toString(nbr_nuit);
        this.type = type;
        this.nbr_chambre = Integer.toString(nbr_chambre);
        this.nbr_personne = Integer.toString(nbr_personne);
        this.etat=etat;
    }
    public Reservation(int id_reservation, String date_arrivee, String date_depart, int nbr_nuit, String type, int nbr_chambre, int nbr_personne) {
        this.id_reservation = id_reservation;
   
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nbr_nuit = Integer.toString(nbr_nuit);
        this.type = type;
        this.nbr_chambre =Integer.toString(nbr_chambre);
        this.nbr_personne = Integer.toString(nbr_personne);
    }

    public Reservation( String date_arrivee, String date_depart, int nbr_nuit, String type, int nbr_chambre, int nbr_personne,int id_hotel) {
        
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nbr_nuit =Integer.toString( nbr_nuit);
        this.type = type;
        this.nbr_chambre = Integer.toString(nbr_chambre);
        this.nbr_personne = Integer.toString(nbr_personne);
        this.id_hotel = id_hotel;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Reservation(String date_arrivee, String date_depart, int nbr_nuit, String type, int nbr_chambre, int nbr_personne) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.nbr_nuit = Integer.toString(nbr_nuit);
        this.type = type;
        this.nbr_chambre =Integer.toString( nbr_chambre);
        this.nbr_personne = Integer.toString(nbr_personne);
    }

   



    
   
    
    }
    
    
 