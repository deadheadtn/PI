package com.mycompany.Entite;

import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fedibigbo$$
 */
public class Transport {
    private int ID_transport;
    private String type;
    private String depart;
    private String Destination;
private String date_depart;
    private String date_arrivee;
    private int nbr_voyageurs;
   
    //sdfDate.format(tdate);
    SimpleDateFormat    SimDf = new SimpleDateFormat("yyyy-mm-dd");
    public Transport(String type) {
        this.type = type;
    }
    

    public Transport(int ID_transport, String type, String depart, String Destination, String date_depart, String date_arrivee, int nbr_voyageurs) {
        this.ID_transport = ID_transport;
        this.type = type;
        this.depart = depart;
        this.Destination = Destination;
         this.date_depart =date_depart;
        this.date_arrivee =date_arrivee;
        this.nbr_voyageurs = nbr_voyageurs;
    }

    public Transport(String type, String depart, String Destination, String date_depart, String date_arrivee, int nbr_voyageurs) {
        this.type = type;
        this.depart = depart;
        this.Destination = Destination;
        this.date_depart = date_depart;
        this.date_arrivee =date_arrivee;
        this.nbr_voyageurs = nbr_voyageurs;
    }

    public Transport(int parseInt, String typet) {
        this.ID_transport=ID_transport;
        this.type=typet;
        //To change body of generated methods, choose Tools | Templates.
    }

   

    public Transport(String typet, String departt, String destinationt) {
        this.type=typet;
                this.depart=departt;
                this.Destination=destinationt;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public Transport(int parseInt, String typet, String departt, String destinationtt) {
                this.ID_transport= ID_transport;
                this.type=typet;
                this.depart=departt;
                this.Destination=destinationtt;
    }

//    public Transport(String typet, String departt, String destinationt, Date a, Date d) {
//          this.type=typet;
//                this.depart=departt;
//                this.Destination=destinationt;
//                this.date_depart=a;
//                this.date_arrivee=d;
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

    public Transport() {
         //To change body of generated methods, choose Tools | Templates.
    }



    public int getID_transport() {
        return ID_transport;
    }

    public void setID_transport(int ID_transport) {
        this.ID_transport = ID_transport;
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
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

   
    public int getNbr_voyageurs() {
        return nbr_voyageurs;
    }

    public void setNbr_voyageurs(int nbr_voyageurs) {
        this.nbr_voyageurs = nbr_voyageurs;
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


    
    
}
