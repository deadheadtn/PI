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
public class appreciation {
    
    private int ID_APPRECIATION; 
  private String SUJET_APP;
  private String DESCRIPTION_APP;

  public appreciation() {
    }
  
    public appreciation(int ID_APPRECIATION, String SUJET_APP, String DESCRIPTION_APP) {
        this.ID_APPRECIATION = ID_APPRECIATION;
        this.SUJET_APP = SUJET_APP;
        this.DESCRIPTION_APP = DESCRIPTION_APP;
    }

    public appreciation(String SUJET_APP, String DESCRIPTION_APP) {
        this.SUJET_APP = SUJET_APP;
        this.DESCRIPTION_APP = DESCRIPTION_APP;
    }

    public int getID_APPRECIATION() {
        return ID_APPRECIATION;
    }

    public void setID_APPRECIATION(int ID_APPRECIATION) {
        this.ID_APPRECIATION = ID_APPRECIATION;
    }

    public String getSUJET_APP() {
        return SUJET_APP;
    }

    public void setSUJET_APP(String SUJET_APP) {
        this.SUJET_APP = SUJET_APP;
    }

    public String getDESCRIPTION_APP() {
        return DESCRIPTION_APP;
    }

    public void setDESCRIPTION_APP(String DESCRIPTION_APP) {
        this.DESCRIPTION_APP = DESCRIPTION_APP;
    }

    @Override
    public String toString() {
        return "appreciation{" + "ID_APPRECIATION=" + ID_APPRECIATION + ", SUJET_APP=" + SUJET_APP + ", DESCRIPTION_APP=" + DESCRIPTION_APP + '}';
    }
  
  
}
