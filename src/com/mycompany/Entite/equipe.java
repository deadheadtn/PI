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
public class equipe {
private int ID_EQUIPE;
private String NOM_EQUIPE;
private String GROUPE ;
private String PAYS;
private String LOGO;
private int CLASSEMENT;

    

    public equipe(int ID_EQUIPE, String NOM_EQUIPE, String GROUPE, String PAYS, String LOGO, int CLASSEMENT) {
        this.ID_EQUIPE = ID_EQUIPE;
        this.NOM_EQUIPE = NOM_EQUIPE;
        this.GROUPE = GROUPE;
        this.PAYS = PAYS;
        this.LOGO = LOGO;
        this.CLASSEMENT = CLASSEMENT;
    }

    public equipe() {
    }

    public equipe(String NOM_EQUIPE) {
        this.NOM_EQUIPE = NOM_EQUIPE;
    }
    

    public equipe(String NOM_EQUIPE, String GROUPE, String PAYS, String LOGO, int CLASSEMENT) {
        this.NOM_EQUIPE = NOM_EQUIPE;
        this.GROUPE = GROUPE;
        this.LOGO = LOGO;
        this.CLASSEMENT = CLASSEMENT;
    }

    public int getID_EQUIPE() {
        return ID_EQUIPE;
    }

    public void setID_EQUIPE(int ID_EQUIPE) {
        this.ID_EQUIPE = ID_EQUIPE;
    }

    public String getNOM_EQUIPE() {
        return NOM_EQUIPE;
    }

    public void setNOM_EQUIPE(String NOM_EQUIPE) {
        this.NOM_EQUIPE = NOM_EQUIPE;
    }

    public String getGROUPE() {
        return GROUPE;
    }

    public void setGROUPE(String GROUPE) {
        this.GROUPE = GROUPE;
    }

    public String getPAYS() {
        return PAYS;
    }

    public void setPAYS(String PAYS) {
        this.PAYS = PAYS;
    }

    public String getLOGO() {
        return LOGO;
    }

    public void setLOGO(String LOGO) {
        this.LOGO = LOGO;
    }

    public int getCLASSEMENT() {
        return CLASSEMENT;
    }

    public void setCLASSEMENT(int CLASSEMENT) {
        this.CLASSEMENT = CLASSEMENT;
    }

    @Override
    public String toString() {
        return "equipe{" + "NOM_EQUIPE=" + NOM_EQUIPE + ", GROUPE=" + GROUPE + ", PAYS=" + PAYS + ", LOGO=" + LOGO + ", CLASSEMENT=" + CLASSEMENT + '}';
    }

    


    
}
