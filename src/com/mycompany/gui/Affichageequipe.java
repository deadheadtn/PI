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
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.mycompagny.Service.ServiceEquipe;
import com.mycompany.Entite.equipe;
import java.util.ArrayList;

/**
 *
 * @author Nesrine
 */
public class Affichageequipe {
      Form f;
    SpanLabel lb;
    String url="";
        private Resources theme =UIManager.initFirstTheme("/theme");
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
    
    public Affichageequipe(Resources res) {
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);

        f = new Form();
        lb = new SpanLabel("");
        //f.add(lb);
        
        ServiceEquipe serviceTask=new ServiceEquipe();
        ArrayList<equipe> lis=serviceTask.getList2();
        for(equipe e :lis){
            url="http://localhost/PIa/image/equipes/"+e.getLOGO();
            System.out.println("path = "+url);
            imgEncodedImage = EncodedImage.createFromImage(theme.getImage("round.png"),false);
            urlImage = URLImage.createToStorage(imgEncodedImage, url, url);
            imageViewer = new ImageViewer(urlImage);
            fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
            Label nom=new Label();
            Label groupe=new Label();
            nom.setText(e.getNOM_EQUIPE());
            nom.getUnselectedStyle().setFont(mediumBoldSystemFont);
            groupe.setText(e.getGROUPE());
            Button Viewb = new Button("View more");
            fselect.add(nom);
            fselect.add(groupe);
            fselect.add(Viewb);
            fselect.add(imageViewer);
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
