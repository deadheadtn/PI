/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.company.utils.Local;
import com.mycompagny.Service.ServiceReclamation;
import com.mycompany.Entite.User;
import java.util.Random;
import com.codename1.io.ConnectionRequest;

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
    Button Valider,listRec;
    Container fselect;
    Label captcha;
    TextField Captcha;
    ImageViewer imv;
    Image img;
    public AjouterReclamation(Resources res){
        
        /*EncodedImage encoded = EncodedImage.create("/icon.png"); 
        img = URLImage.createToStorage(encoded, "https://cdn.pixabay.com/photo/2013/04/06/11/50/image-editing-101040_960_720.jpg", "https://cdn.pixabay.com/photo/2013/04/06/11/50/image-editing-101040_960_720.jpg");
        imv = new ImageViewer(img);*/
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        f = new Form("ajout");
        //fselect.add(imv);
        fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
        sujetLabel= new Label(" Sujet:");
        DescLabel= new Label("Description: ");
        User u = new Local().getUser();
        System.out.println(u.getId());
        Random R= new Random();
        Random R1= new Random();
        int nombreAleatoire1 = R.nextInt(12);
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
        listRec= new Button("Mes reclamation");
        fselect.add(sujetLabel);
        fselect.add(Sujet);
        fselect.add(DescLabel);
        fselect.add(Description);
        fselect.add(captcha);
        fselect.add(Captcha);
        fselect.add(Valider);
        fselect.add(listRec);
        f.add(fselect);
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{ProfileForm h=new ProfileForm(res);
          h.show();
          });
        listRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AfficherReclamation r = new AfficherReclamation(res);
                r.getF().show();
            }
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
                    ConnectionRequest con = new ConnectionRequest();
            String httpMethod="GET";
            con.setHttpMethod(httpMethod);
            con.setUrl("http://127.0.0.1/Russia2018Symfony/mobile.php?num=+216"+u.getNum()+"&message="+Description.getText());
            con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
            }
        });
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
