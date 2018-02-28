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
public class CommentaireProbleme {
   private int idCommentaire;
   private String dateCommentaire;

   
   private String contenue;

   
   private int nbrVote;
   private int valide;
   private int notif;
   private User user;
   private Probleme probleme;

    public int getIdCommentaire() {
        return idCommentaire;
    }
 public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Probleme getProbleme() {
        return probleme;
    }

    public void setProbleme(Probleme probleme) {
        this.probleme = probleme;
    }
   
   
   
   

    public String getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(String dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public int getNbrVote() {
        return nbrVote;
    }

    public void setNbrVote(int nbrVote) {
        this.nbrVote = nbrVote;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    public int getNotif() {
        return notif;
    }

    public void setNotif(int notif) {
        this.notif = notif;
    }
    @Override
    public String toString() {
        return "CommentaireProbleme{" + "idCommentaire=" + idCommentaire + ", dateCommentaire=" + dateCommentaire + ", contenue=" + contenue + ", nbrVote=" + nbrVote + ", valide=" + valide + ", notif=" + notif + ", user=" + user + ", probleme=" + probleme + '}';
    }
   
    
}
