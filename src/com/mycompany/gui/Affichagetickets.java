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
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.StatsForm;
import com.mycompagny.Service.ServiceTicket;
import com.mycompany.Entite.Tickets;
import java.util.ArrayList;

/**
 *
 * @author mahdi
 */
public class Affichagetickets {
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

      public Affichagetickets(Resources res ) {
        Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);

        f = new Form(" tickets",BoxLayout.y());
     
        lb = new SpanLabel("");
        Toolbar tb=f.getToolbar();

        //f.add(lb);
        
          ServiceTicket serviceTicket=new ServiceTicket();
        ArrayList<Tickets> lis= serviceTicket.getList();
       home = new Form("Liste Des tickets",BoxLayout.y());

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
              DetailForm df = new DetailForm(lis.get(i), res) ;
                   
                f.add(fselect);
               Viewb.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                  df.getF().show();
                     
          }
         
        
         
    });
               
                 
        
}
        tb.addCommandToRightBar("back", null, (ev)->{TicketForm s=new TicketForm(res);
               s.getF().showBack();

        
    
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

