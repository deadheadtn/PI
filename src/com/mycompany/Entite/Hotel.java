package com.mycompany.Entite;

import javafx.scene.control.TextField;


public class Hotel {
   public int ID_hotel ;
  public String nom_hotel;
  public String nbr_etoile;
  public String ville;
  public String description;
  public String service;
  public String adresse;
  
  public Hotel (){
      
  } 

  
    public int getID_hotel() {
        return ID_hotel;
    }

    public void setID_hotel(int ID_hotel) {
        this.ID_hotel = ID_hotel;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public String getNbr_etoile() {
        return nbr_etoile;
    }

    public void setNbr_etoile(int nbr_etoile) {
        this.nbr_etoile = Integer.toString(nbr_etoile);
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Hotel(String nom_hotel, int nbr_etoile, String ville, String description, String service, String adresse) {
        this.nom_hotel = nom_hotel;
        this.nbr_etoile = Integer.toString(nbr_etoile);
        this.ville = ville;
        this.description = description;
        this.service = service;
        this.adresse = adresse;
    }

    public Hotel(int ID_hotel, String nom_hotel, int nbr_etoile, String ville, String description, String service, String adresse) {
        this.ID_hotel = ID_hotel;
        this.nom_hotel = nom_hotel;
        this.nbr_etoile = Integer.toString(nbr_etoile);
        this.ville = ville;
        this.description = description;
        this.service = service;
        this.adresse = adresse;
    }
}