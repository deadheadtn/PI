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
import com.mycompagny.Service.ServiceJoueur;
import com.mycompagny.Service.ServiceNews;
import com.mycompany.Entite.joueur;
import com.mycompany.Entite.news;
import java.util.ArrayList;

/**
 *
 * @author Nesrine
 */
public class Affichagejoueur {
    Form f;
    SpanLabel lb;
      //String url="";
    private Resources res;
      //private Resources theme =UIManager.initFirstTheme("/theme");
    Label label;
    Label Titre;
    Label texte;
    ImageViewer imageViewer;
    EncodedImage imgEncodedImage;
    URLImage urlImage;
    Container fimg,fdesc,fselect;
    Image img;
    //Button Viewb;
    
      
        
    
    public Affichagejoueur(Resources res) {
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);

        f = new Form();
        lb = new SpanLabel("");
        //f.add(lb);
        
        ServiceJoueur serviceTask=new ServiceJoueur();
        ArrayList<joueur> lis=serviceTask.getList2();
        for(int i=0; i<lis.size();i++){
            /*for(joueur e :lis){
            url="http://localhost/PIa/image/joueurs/"+e.getPHOTO_J();
            System.out.println("path = "+url);
            imgEncodedImage = EncodedImage.createFromImage(theme.getImage("round.png"),false);
            urlImage = URLImage.createToStorage(imgEncodedImage, url, url);
            imageViewer = new ImageViewer(urlImage);*/
            fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
            Label nom=new Label();
            Label prenom=new Label();
            Label nomequipe=new Label();
            Label appreciation=new Label();
            Label nationalite=new Label();
            nom.setText(lis.get(i).getNOM_J());
            nom.getUnselectedStyle().setFont(mediumBoldSystemFont);
            prenom.setText(lis.get(i).getPRENOM_J());
            prenom.getUnselectedStyle().setFont(mediumBoldSystemFont);
            nomequipe.setText(lis.get(i).getNOM_EQUIPE());
            appreciation.setText(lis.get(i).getAPPRECIATION_J());
            nationalite.setText(lis.get(i).getNATIONALITE_J());
            
            
            //Button Viewb = new Button("View more");
            fselect.add(nom);
            fselect.add(prenom);
            fselect.add(appreciation);
               fselect.add(nomequipe);
            //fselect.add(Viewb);
            //fselect.add(imageViewer);
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
