/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.Model;

import java.util.Date;

/**
 *
 * @author bouda
 */
public class Probleme {

    private int idProbleme;
    private String titre;
    private String contenu;
    private String etatProbleme;
    private String dateProblem;
    private int niveauRequis;
    private int valide;
    private String secteur;
    private int nbrCommentaireProbleme;
    private User user;

    public Probleme() {
        titre = "";
        contenu = "";
        etatProbleme = "";
        dateProblem = "";
        niveauRequis = 0;
        valide = 0;
        secteur = "";
        nbrCommentaireProbleme = 0;
        user = new User();
    }

    public int getIdProbleme() {
        return idProbleme;
    }

    public void setIdProbleme(int idProbleme) {
        this.idProbleme = idProbleme;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getEtatProbleme() {
        return etatProbleme;
    }

    public void setEtatProbleme(String etatProbleme) {
        this.etatProbleme = etatProbleme;
    }

    public String getDateProblem() {
        return dateProblem;
    }

    public void setDateProblem(String dateProblem) {
        this.dateProblem = dateProblem;
    }

    public int getNiveauRequis() {
        return niveauRequis;
    }

    public void setNiveauRequis(int niveauRequis) {
        this.niveauRequis = niveauRequis;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    public int getNbrCommentaireProbleme() {
        return nbrCommentaireProbleme;
    }

    public void setNbrCommentaireProbleme(int nbrCommentaireProbleme) {
        this.nbrCommentaireProbleme = nbrCommentaireProbleme;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Probleme{" + "titre=" + titre + ", contenu=" + contenu + ", etatProbleme=" + etatProbleme + ", dateProblem=" + dateProblem + ", niveauRequis=" + niveauRequis + ", valide=" + valide + ", secteur=" + secteur + ", nbrCommentaireProbleme=" + nbrCommentaireProbleme + ", user=" + user + '}';
    }

}
