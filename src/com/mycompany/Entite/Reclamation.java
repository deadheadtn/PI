/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;


/**
 *
 * @author deadhead
 */
public class Reclamation {
    private int id_reclamation;
    private int id_utilisateur;
    private int id_followup=0;
    private String email;
    private String SUJET_REC;
    private String DESCRIPTION_REC;
    private String DATE_REC;
    private int ETAT_REC;

    public Reclamation(String email, String SUJET_REC, String DESCRIPTION_REC, String DATE_REC) {
        //this.id_utilisateur = id_utilisateur;
        this.email=email;
        //this.id_followup = id_followup;
        this.SUJET_REC = SUJET_REC;
        this.DESCRIPTION_REC = DESCRIPTION_REC;
        this.DATE_REC = DATE_REC;
        //this.ETAT_REC = ETAT_REC;
    }

    public Reclamation() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_followup() {
        return id_followup;
    }

    public void setId_followup(int id_followup) {
        this.id_followup = id_followup;
    }

    public String getSUJET_REC() {
        return SUJET_REC;
    }

    public void setSUJET_REC(String SUJET_REC) {
        this.SUJET_REC = SUJET_REC;
    }

    public String getDESCRIPTION_REC() {
        return DESCRIPTION_REC;
    }

    public void setDESCRIPTION_REC(String DESCRIPTION_REC) {
        this.DESCRIPTION_REC = DESCRIPTION_REC;
    }

    public String getDATE_REC() {
        return DATE_REC;
    }

    public void setDATE_REC(String DATE_REC) {
        this.DATE_REC = DATE_REC;
    }

    public int getETAT_REC() {
        return ETAT_REC;
    }

    public void setETAT_REC(int ETAT_REC) {
        this.ETAT_REC = ETAT_REC;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", id_utilisateur=" + id_utilisateur + ", id_followup=" + id_followup + ", SUJET_REC=" + SUJET_REC + ", DESCRIPTION_REC=" + DESCRIPTION_REC + ", DATE_REC=" + DATE_REC + ", ETAT_REC=" + ETAT_REC + '}';
    }
    
}
