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
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.mycompagny.Service.ServiceReclamation;
import com.mycompany.Entite.Reclamation;
import com.mycompany.Entite.news;
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
    Button Viewb;
    Label titre;
    Label Texte;
    Label etat;
    Label Sujet;
    Label Desc;
    Label EtAt;
    public AfficherReclamation(Resources res){
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        f= new Form("Mes Reclamations");
        int user_id=1;
        ServiceReclamation r = new ServiceReclamation();
        ArrayList<Reclamation> lis=r.getList2(user_id);
        for(int i=0; i<lis.size();i++){
            fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
            fdesc  = new Container (new BoxLayout(BoxLayout.X_AXIS));
            fetat  = new Container (new BoxLayout(BoxLayout.X_AXIS));
            ftitre  = new Container (new BoxLayout(BoxLayout.X_AXIS));
            titre=new Label();
            Texte=new Label();
            etat= new Label();
            Sujet=new Label("Sujet:");
            Desc=new Label("Description:");
            EtAt= new Label("Etat:");
            titre.setText(lis.get(i).getSUJET_REC());
            Texte.setText(lis.get(i).getDESCRIPTION_REC());
            titre.getUnselectedStyle().setFont(mediumBoldSystemFont);
            if(lis.get(i).getETAT_REC().equals("0"))
                etat.setText("Non-Resolu");
            else
                etat.setText("Resolu");
            ftitre.add(Sujet);
            ftitre.add(titre);
            fdesc.add(Desc);
            fdesc.add(Texte);
            fetat.add(EtAt);
            fetat.add(etat);
            fselect.add(ftitre);
            fselect.add(fetat);
            fselect.add(fdesc);
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
