/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.mycompagny.Service.ServiceReclamation;
import java.util.Random;
/**
 *
 * @author deadhead
 */
public class AjouterReclamation extends SideMenuBaseForm{
    Form f;
    Label sujetLabel;
    Label DescLabel;
    TextField Sujet;
    TextField Description;
    Button Valider;
    Container fselect;
    Label captcha;
    TextField Captcha;
    public AjouterReclamation(Resources res){
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        f = new Form("ajout");
        fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
        sujetLabel= new Label(" Sujet:");
        DescLabel= new Label("Description: ");
        int Max=10,Min=2;
        Random R= new Random();
        Random R1= new Random();
        int nombreAleatoire1 = R.nextInt(10);
        int nombreAleatoire = R1.nextInt(10);
        int Somme= nombreAleatoire1+nombreAleatoire;
        captcha = new Label("Captcha: "+nombreAleatoire1+"+"+nombreAleatoire+"=");
        Sujet = new TextField();
        Description= new TextField();
        Captcha =new TextField();
        Captcha.getAllStyles().setFgColor(255);
        Sujet.getAllStyles().setFgColor(255);
        Description.getAllStyles().setFgColor(255);
        Description.getAllStyles().setFont(mediumBoldSystemFont);
        Valider= new Button("Envoyer");
        fselect.add(sujetLabel);
        fselect.add(Sujet);
        fselect.add(DescLabel);
        fselect.add(Description);
        fselect.add(captcha);
        fselect.add(Captcha);
        fselect.add(Valider);
        f.add(fselect);
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{ProfileForm h=new ProfileForm(res);
          h.show();
          });
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{AfficherReclamation h=new AfficherReclamation(res);
          h.show();
          });
        Valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(Description.getText().length()<5 && Sujet.getText().length()<5){
                    Dialog.show("error", "Veiller etre plus precis", "ok", null);
                }
                else if(Description.getText().length()>5 && Sujet.getText().length()>5 && Captcha.getText().equals(Integer.toString(Somme))){
                    ServiceReclamation s= new ServiceReclamation();
                    s.ajouterReclamation(1, Sujet.getText(), Description.getText());
                }
                else{
                    Dialog.show("error", "Captcha Error", "ok", null);
                }
                
            }
        });
   }
        public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();    
    }
}
