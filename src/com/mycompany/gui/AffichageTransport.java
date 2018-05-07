/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.Log;
import com.codename1.io.services.ImageDownloadService;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.ComponentAnimation;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.mycompagny.Service.ServiceHotel;
import com.mycompagny.Service.ServiceNews;
import com.mycompagny.Service.ServiceTransport;
import com.mycompany.Entite.Hotel;
import com.mycompany.Entite.Transport;
import com.mycompany.Entite.news;
import java.util.ArrayList;

/**
 *
 * @author sana
 */
public class AffichageTransport extends SideMenuBaseForm {

    Form f;
    SpanLabel lb;
    private Resources res;
    private Form home;
    Label label;
    Label Titre;
    Label texte;
    ImageViewer imageViewer;
    EncodedImage imgEncodedImage;
    URLImage urlImage;
    Container fimg,fdesc,fselect;
    Image img;
    Button Viewb;
    Form f2;
    private Resources theme;

    public AffichageTransport(Transport t ,Resources res ) {
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
       
        f = new Form();
        lb = new SpanLabel("");
        Toolbar tb=f.getToolbar();

        //f.add(lb);
        ServiceTransport serviceTask=new ServiceTransport();
        ArrayList<Transport>lis=serviceTask.getList2();
       home = new Form("Listes Des Transports",BoxLayout.y());

        for(int i=0; i<lis.size();i++){
            
            fselect  = new Container (new BoxLayout(BoxLayout.X_AXIS));
            Label titre=new Label();
            Label texte=new Label();
            titre.setText(lis.get(i).getType());
            titre.getUnselectedStyle().setFont(mediumBoldSystemFont);
            Button Viewb = new Button("View more");
            Viewb.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D);

            fselect.add(titre);
            fselect.add(texte);
            fselect.add(Viewb);
               fselect.setLeadComponent(Viewb);
               TransportForm df=new TransportForm(lis.get(i), res);
              
                f.add(fselect);
               Viewb.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                  df.getF().show();
                     
          }
           

        
         
    });
             
               
         home.show();
    
    }
        

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
