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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.company.utils.Local;
import com.mycompagny.Service.ServiceReclamation;
import com.mycompany.Entite.Reclamation;
import com.mycompany.Entite.User;
import java.util.ArrayList;

/**
 *
 * @author deadhead
 */
public class AfficherReclamation extends SideMenuBaseForm {
    Form f;
    Container fselect;
    SpanLabel lb;
    private Resources res;
    Label label;
    Label Titre;
    Label texte;
    ImageViewer imageViewer;
    EncodedImage imgEncodedImage;
    URLImage urlImage;
    Container fimg,fdesc,ftitre,fetat;
    Image img;
    Button Viewb,changeretat;
    Label titre;
    Label Texte;
    Label etat;
    Label Sujet;
    Label Desc;
    Label EtAt;
    public AfficherReclamation(Resources res){
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        f= new Form("Mes Reclamations");
        User u = new Local().getUser();
        ServiceReclamation r = new ServiceReclamation();
        ArrayList<Reclamation> lis=r.getList2(u.getId());
        for(int i=0; i<lis.size();i++){
            fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
            fdesc  = new Container (new BoxLayout(BoxLayout.X_AXIS));
            fetat  = new Container (new BoxLayout(BoxLayout.X_AXIS));
            ftitre  = new Container (new BoxLayout(BoxLayout.X_AXIS));
            titre=new Label();
            Texte=new Label();
            etat= new Label();
            Sujet=new Label("Sujet:");
            changeretat = new Button("Changer etat");
            fetat.getAllStyles().setFgColor(255);
            fetat.getAllStyles().setBgTransparency(255);
            fetat.getAllStyles().setBackgroundType(BACKGROUND_NONE);
            fetat.getAllStyles().setBorder(Border.createEmpty());
            fetat.getAllStyles().setBgColor(0x99CCCC);
            fselect.getAllStyles().setFgColor(255);
            fselect.getAllStyles().setBgTransparency(255);
            fselect.getAllStyles().setBackgroundType(BACKGROUND_NONE);
            fselect.getAllStyles().setBorder(Border.createEmpty());
            fselect.getAllStyles().setBgColor(0xd1e2ff);
            Desc=new Label("Description:");
            EtAt= new Label("Etat:");
            titre.setText(lis.get(i).getSUJET_REC());
            Texte.setText(lis.get(i).getDESCRIPTION_REC());
            titre.getUnselectedStyle().setFont(mediumBoldSystemFont);
            if(lis.get(i).getETAT_REC()==0){
                etat.setText("Non-Resolu");
                fetat.getAllStyles().setBgColor(0xFF0000);
            }
            else if (lis.get(i).getETAT_REC()==1){
                etat.setText("En Cours");
                fetat.getAllStyles().setBgColor(0xfff400);
            }
            else
            {
                 etat.setText("Resolu");
                 fetat.getAllStyles().setBgColor(0xb2aa00);
            }
            ftitre.add(Sujet);
            ftitre.add(titre);
            fdesc.add(Desc);
            fdesc.add(Texte);
            fetat.add(EtAt);
            fetat.add(etat);
            fselect.add(ftitre);
            fselect.add(fdesc);
            fselect.add(fetat);
            changeretat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ServiceReclamation r = new ServiceReclamation();
                for(int i=0; i<lis.size();i++){
                    if(lis.get(i).getSUJET_REC().equals(titre.getText())){
                        r.setetat(lis.get(i).getId_reclamation());
                    }
                }
            }
        });
            fselect.add(changeretat);
            f.add(fselect);
            
        }
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{ProfileForm h=new ProfileForm(res);
          h.show();
          });
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
