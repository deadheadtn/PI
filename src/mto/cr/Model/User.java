/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Chiheb
 */
public class User {

    private int id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private int enabled;
    private Date last_login;
    private int locked;
    private int expired;
    private Date expires_at;
    private String password;
    private int credentials_expired;
    //private String confirmation_token;
    //private Date password_requested_at;
    //private String roles;
    //private int credentials_expired;
    //private Date credentials_expire_at;
    private String nom;
    private String prenom;
    private Date datenaissance;
    private String situationprof;
    private String secteur;
    private int experiencetot;
    private int solde;
    private String paysnatal;
    private String role;
    private String etat;
    private String sexe;
    private String Roles;
    private int nbrProbleme;
    private int nbrCommentaireProbleme;
    //private int facebook_id;
    //private int facebook_access_token;
    //private int google_id;
    //private int google_access_token;
    //private String name;
    private String path;
    private String salt;
    private int nbrfinancement;
    private int nbrVote;
    private int nbrcommentaire;
    private int nbrprojetssuivis;
   

    public User() {
        this.password = "";
        this.username = "";
        this.username_canonical = "";
        this.email = "";
        this.email_canonical = "";
        this.enabled = 1;
        this.locked = 0;
        this.expired = 0;
        this.expires_at = new Date();
        this.nom = "";
        this.prenom = "";
        this.datenaissance = new Date();
        this.situationprof = "";
        this.secteur = "";
        this.experiencetot = 0;
        this.solde = 0;
        this.paysnatal = "";
        this.role = "";
        this.etat = "";
        this.sexe = "";
        this.path = "user.png";
        this.nbrfinancement = 0;
        this.nbrVote = 0;
        this.nbrcommentaire = 0;
        this.nbrprojetssuivis = 0;
        
        this.Roles = "";
        this.salt = "";
    }
    
    

    public User(String username, String username_canonical, String email, String email_canonical, int enabled, int locked, int expired, Date expires_at,String password, String nom, String prenom, Date datenaissance, String situationprof, String secteur, int experiencetot, int solde, String paysnatal, String role, String etat, String sexe, String path, int nbrfinancement, int nbrVote, int nbrcommentaire, int nbrprojetssuivis) {
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.locked = locked;
        this.expired = expired;
        this.expires_at = expires_at;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.situationprof = situationprof;
        this.secteur = secteur;
        this.experiencetot = experiencetot;
        this.solde = solde;
        this.paysnatal = paysnatal;
        this.role = role;
        this.etat = etat;
        this.sexe = sexe;
        this.path = path;
        this.nbrfinancement = nbrfinancement;
        this.nbrVote = nbrVote;
        this.nbrcommentaire = nbrcommentaire;
        this.nbrprojetssuivis = nbrprojetssuivis;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String Roles) {
        this.Roles = Roles;
    }

    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getExpired() {
        return expired;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getSituationprof() {
        return situationprof;
    }

    public void setSituationprof(String situationprof) {
        this.situationprof = situationprof;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public int getExperiencetot() {
        return experiencetot;
    }

    public void setExperiencetot(int experiencetot) {
        this.experiencetot = experiencetot;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getPaysnatal() {
        return paysnatal;
    }

    public void setPaysnatal(String paysnatal) {
        this.paysnatal = paysnatal;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNbrfinancement() {
        return nbrfinancement;
    }

    public void setNbrfinancement(int nbrfinancement) {
        this.nbrfinancement = nbrfinancement;
    }

    public int getNbrVote() {
        return nbrVote;
    }

    public void setNbrVote(int nbrVote) {
        this.nbrVote = nbrVote;
    }

    public int getNbrcommentaire() {
        return nbrcommentaire;
    }

    public void setNbrcommentaire(int nbrcommentaire) {
        this.nbrcommentaire = nbrcommentaire;
    }

    public int getNbrprojetssuivis() {
        return nbrprojetssuivis;
    }

    public void setNbrprojetssuivis(int nbrprojetssuivis) {
        this.nbrprojetssuivis = nbrprojetssuivis;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username_canonical, other.username_canonical)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredentials_expired() {
        return credentials_expired;
    }

    public void setCredentials_expired(int credentials_expired) {
        this.credentials_expired = credentials_expired;
    }
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + "path="+ path +", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", last_login=" + last_login + ", locked=" + locked + ", expired=" + expired + ", expires_at=" + expires_at + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", datenaissance=" + datenaissance + ", situationprof=" + situationprof + ", secteur=" + secteur + ", experiencetot=" + experiencetot + ", solde=" + solde + ", paysnatal=" + paysnatal + ", sexe=" + sexe + ", nbrfinancement=" + nbrfinancement + ", nbrVote=" + nbrVote + ", nbrcommentaire=" + nbrcommentaire + ", nbrprojetssuivis=" + nbrprojetssuivis + '}';
    }

    public int getNbrProbleme() {
        return nbrProbleme;
    }

    public void setNbrProbleme(int nbrProbleme) {
        this.nbrProbleme = nbrProbleme;
    }

    public int getNbrCommentaireProbleme() {
        return nbrCommentaireProbleme;
    }

    public void setNbrCommentaireProbleme(int nbrCommentaireProbleme) {
        this.nbrCommentaireProbleme = nbrCommentaireProbleme;
    }
    
    
    
    
}
