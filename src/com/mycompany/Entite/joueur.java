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
public class joueur {
    private int ID_JOUEUR;
private String NOM_J;
private String PRENOM_J;
private int AGE_J;
private String NOM_EQUIPE;
private int NUMERO_J;
private int NBBUTS_J;
private String EMPLACEMENT_J;
private String PHOTO_J;
private String APPRECIATION_J;
private String NATIONALITE_J;

    public joueur(String NOM_J, String PRENOM_J, int AGE_J, String NOM_EQUIPE, int NUMERO_J, int NBBUTS_J, String EMPLACEMENT_J, String PHOTO_J, String APPRECIATION_J, String NATIONALITE_J) {
        this.NOM_J = NOM_J;
        this.PRENOM_J = PRENOM_J;
        this.AGE_J = AGE_J;
        this.NOM_EQUIPE = NOM_EQUIPE;
        this.NUMERO_J = NUMERO_J;
        this.NBBUTS_J = NBBUTS_J;
        this.EMPLACEMENT_J = EMPLACEMENT_J;
        this.PHOTO_J = PHOTO_J;
        this.APPRECIATION_J = APPRECIATION_J;
        this.NATIONALITE_J = NATIONALITE_J;
    }

    public joueur(int ID_JOUEUR, String NOM_J, String PRENOM_J, int AGE_J, String NOM_EQUIPE, int NUMERO_J, int NBBUTS_J, String EMPLACEMENT_J, String PHOTO_J, String APPRECIATION_J, String NATIONALITE_J) {
        this.ID_JOUEUR = ID_JOUEUR;
        this.NOM_J = NOM_J;
        this.PRENOM_J = PRENOM_J;
        this.AGE_J = AGE_J;
        this.NOM_EQUIPE = NOM_EQUIPE;
        this.NUMERO_J = NUMERO_J;
        this.NBBUTS_J = NBBUTS_J;
        this.EMPLACEMENT_J = EMPLACEMENT_J;
        this.PHOTO_J = PHOTO_J;
        this.APPRECIATION_J = APPRECIATION_J;
        this.NATIONALITE_J = NATIONALITE_J;
    }

    
    public joueur() {
        
    }

    public int getID_JOUEUR() {
        return ID_JOUEUR;
    }

    public void setID_JOUEUR(int ID_JOUEUR) {
        this.ID_JOUEUR = ID_JOUEUR;
    }

    public String getNOM_J() {
        return NOM_J;
    }

    public void setNOM_J(String NOM_J) {
        this.NOM_J = NOM_J;
    }

    public String getPRENOM_J() {
        return PRENOM_J;
    }

    public void setPRENOM_J(String PRENOM_J) {
        this.PRENOM_J = PRENOM_J;
    }

    public int getAGE_J() {
        return AGE_J;
    }

    public void setAGE_J(int AGE_J) {
        this.AGE_J = AGE_J;
    }

    public String getNOM_EQUIPE() {
        return NOM_EQUIPE;
    }

    public void setNOM_EQUIPE(String NOM_EQUIPE) {
        this.NOM_EQUIPE = NOM_EQUIPE;
    }

    public int getNUMERO_J() {
        return NUMERO_J;
    }

    public void setNUMERO_J(int NUMERO_J) {
        this.NUMERO_J = NUMERO_J;
    }

    public int getNBBUTS_J() {
        return NBBUTS_J;
    }

    public void setNBBUTS_J(int NBBUTS_J) {
        this.NBBUTS_J = NBBUTS_J;
    }

    public String getEMPLACEMENT_J() {
        return EMPLACEMENT_J;
    }

    public void setEMPLACEMENT_J(String EMPLACEMENT_J) {
        this.EMPLACEMENT_J = EMPLACEMENT_J;
    }

    public String getPHOTO_J() {
        return PHOTO_J;
    }

    public void setPHOTO_J(String PHOTO_J) {
        this.PHOTO_J = PHOTO_J;
    }

    public String getAPPRECIATION_J() {
        return APPRECIATION_J;
    }

    public void setAPPRECIATION_J(String APPRECIATION_J) {
        this.APPRECIATION_J = APPRECIATION_J;
    }

    public String getNATIONALITE_J() {
        return NATIONALITE_J;
    }

    public void setNATIONALITE_J(String NATIONALITE_J) {
        this.NATIONALITE_J = NATIONALITE_J;
    }

    @Override
    public String toString() {
        return "joueur{" + "NOM_J=" + NOM_J + ", PRENOM_J=" + PRENOM_J + ", AGE_J=" + AGE_J + ", NOM_EQUIPE=" + NOM_EQUIPE + ", NUMERO_J=" + NUMERO_J + ", NBBUTS_J=" + NBBUTS_J + ", EMPLACEMENT_J=" + EMPLACEMENT_J + ", PHOTO_J=" + PHOTO_J + ", APPRECIATION_J=" + APPRECIATION_J + ", NATIONALITE_J=" + NATIONALITE_J + '}';
    }

   

    


}
