/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.codename1.uikit.materialscreens.StatsForm;

/**
 *
 * @author deadhead
 */
public class AfficherReclamation extends SideMenuBaseForm {
    Form f;
    
    public AfficherReclamation(Resources res){
        
    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();    
    }
}
