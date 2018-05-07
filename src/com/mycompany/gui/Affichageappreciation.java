/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.mycompagny.Service.ServiceAppreciation;
import com.mycompany.Entite.appreciation;
import java.util.ArrayList;

/**
 *
 * @author Nesrine
 */
public class Affichageappreciation {
    Form f;
    SpanLabel lb;
    private Resources res;
    Label label;
    Label Titre;
    Label texte;
    ImageViewer imageViewer;
    EncodedImage imgEncodedImage;
    URLImage urlImage;
    Container fimg,fdesc,fselect;
    Image img;
    Button Viewb;
    Button ajouterapp;
    public Affichageappreciation(Resources res) {
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);

        f = new Form();
        lb = new SpanLabel("");
        ajouterapp=new Button("ajouter appreciation");
        f.add(ajouterapp);
        ajouterapp.addActionListener((e) -> {
            Ajoutapprec ajp=new Ajoutapprec();
            ajp.getF().show();
        });
        //f.add(lb);
        
        ServiceAppreciation serviceTask=new ServiceAppreciation();
        ArrayList<appreciation> lis=serviceTask.getList2();
        for(int i=0; i<lis.size();i++){
            fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
            Label nom=new Label();
            Label appreciation=new Label();
            nom.setText(lis.get(i).getSUJET_APP());
            nom.getUnselectedStyle().setFont(mediumBoldSystemFont);
            appreciation.setText(lis.get(i).getDESCRIPTION_APP());
            //Button Viewb = new Button("View more");
            fselect.add(nom);
            fselect.add(appreciation);
            fselect.add(Viewb);
            f.add(fselect);
        }
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{ProfileForm h=new ProfileForm(res);
          h.show();
          });
          f.show();
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
