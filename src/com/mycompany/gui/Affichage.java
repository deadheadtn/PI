/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.services.ImageDownloadService;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.mycompagny.Service.ServiceNews;
import com.mycompany.Entite.news;
import java.util.ArrayList;

/**
 *
 * @author sana
 */
public class Affichage extends SideMenuBaseForm {

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
    public Affichage(Resources res) {
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);

        f = new Form();
        lb = new SpanLabel("");
        //f.add(lb);
        
        ServiceNews serviceTask=new ServiceNews();
        ArrayList<news> lis=serviceTask.getList2();
        for(int i=0; i<lis.size();i++){
            fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
            Label titre=new Label();
            Label texte=new Label();
            titre.setText(lis.get(i).getTitle());
            titre.getUnselectedStyle().setFont(mediumBoldSystemFont);
            texte.setText(lis.get(i).getText());
            Button Viewb = new Button("View more");
            fselect.add(titre);
            fselect.add(texte);
            fselect.add(Viewb);
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

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();    
    }

}
