/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author mahdi
 */
public class Match {

    private int id_match;
    // private equipe equipe1;
    //private equipe equipe2;

    private String heure_match;
    private String duel;
    private String groupe;
    private String stade;
    private String nbr_ticket;
    private String date;

    public Match(String date, String heure_match, String duel, String groupe, String stade, int nbr_ticket) {
        this.date = date;
        this.heure_match = heure_match;
        this.duel = duel;
        this.groupe = groupe;
        this.stade = stade;
        this.nbr_ticket = Integer.toString(nbr_ticket);

    }

    public Match() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public Match(int id_match, String date1, String heure_match1, String duel1, String groupe1, String stade1, int nbr_ticket1) {
        this.id_match = id_match;
        this.date = date1;
        this.heure_match = heure_match1;
        this.duel = duel1;
        this.groupe = groupe1;
        this.stade = stade1;
        this.nbr_ticket = Integer.toString(nbr_ticket1);
        
    }

    public Match(int id_match) {
        this.id_match = id_match;
        //To change body of generated methods, choose Tools | Templates.
    }
    public Match(String Groupe2) {
        this.groupe=Groupe2;
        //To change body of generated methods, choose Tools | Templates.
    }


    //    return equipe1;
    //}
    // public void setEquipe1(equipe equipe1) {
    // this.equipe1 = equipe1;
    // }
//
    //  public equipe getEquipe2() {
    //  return equipe2;
    //   }
    //public void setEquipe2(equipe equipe2) {
    //this.equipe2 = equipe2;
    // }
    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public String getDuel() {
        return duel;
    }

    public void setDuel(String duel) {
        this.duel = duel;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getStade() {
        return stade;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }

    public String getNbr_ticket() {
        return nbr_ticket;
    }

    public void setNbr_ticket(int nbr_ticket) {
        this.nbr_ticket = Integer.toString(nbr_ticket);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure_match() {
        return heure_match;
    }

    public void setHeure_match(String heure_match) {
        this.heure_match = heure_match;
    }

}
