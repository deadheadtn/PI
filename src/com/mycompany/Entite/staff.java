/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;



/**
 *
 * @author Nesrine
 */
public class staff {
  private int ID_STAFF; 
  private String NOM_S;
  private String PRENOM_S;
  private String NOM_EQUIPE;
  private String FONCTION_S;
  private String PRESENCE_S;

    public staff(String NOM_S, String PRENOM_S, String NOM_EQUIPE, String FONCTION_S, String PRESENCE_S) {
        this.NOM_S = NOM_S;
        this.PRENOM_S = PRENOM_S;
        this.NOM_EQUIPE = NOM_EQUIPE;
        this.FONCTION_S = FONCTION_S;
        this.PRESENCE_S = PRESENCE_S;
    }

    public staff(int ID_STAFF, String NOM_S, String PRENOM_S, String NOM_EQUIPE, String FONCTION_S, String PRESENCE_S) {
        this.ID_STAFF = ID_STAFF;
        this.NOM_S = NOM_S;
        this.PRENOM_S = PRENOM_S;
        this.NOM_EQUIPE = NOM_EQUIPE;
        this.FONCTION_S = FONCTION_S;
        this.PRESENCE_S = PRESENCE_S;
    }

    public staff(int ID_STAFF) {
        this.ID_STAFF = ID_STAFF;
    }

    public staff() {
    }

    
    public int getID_STAFF() {
        return ID_STAFF;
    }

    public void setID_STAFF(int ID_STAFF) {
        this.ID_STAFF = ID_STAFF;
    }

    public String getNOM_S() {
        return NOM_S;
    }

    public void setNOM_S(String NOM_S) {
        this.NOM_S = NOM_S;
    }

    public String getPRENOM_S() {
        return PRENOM_S;
    }

    public void setPRENOM_S(String PRENOM_S) {
        this.PRENOM_S = PRENOM_S;
    }

    public String getNOM_EQUIPE() {
        return NOM_EQUIPE;
    }

    public void setNOM_EQUIPE(String NOM_EQUIPE) {
        this.NOM_EQUIPE = NOM_EQUIPE;
    }

    public String getFONCTION_S() {
        return FONCTION_S;
    }

    public void setFONCTION_S(String FONCTION_S) {
        this.FONCTION_S = FONCTION_S;
    }

    public String getPRESENCE_S() {
        return PRESENCE_S;
    }

    public void setPRESENCE_S(String PRESENCE_S) {
        this.PRESENCE_S = PRESENCE_S;
    }

   
    
  
}
