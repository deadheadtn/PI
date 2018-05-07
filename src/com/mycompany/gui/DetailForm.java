/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.mycompany.Entite.Tickets;

/**
 *
 * @author mahdi
 */
public class DetailForm {
    Form f,f3 ;
    Tickets t ;
    Button Viewb,btnmap,viewc;

    public DetailForm(Tickets t , Resources res) {
        
        this.t = t;
        Container fselect;
        Container fbtn;

        f=new Form("Details",new BoxLayout(BoxLayout.Y_AXIS));
        Toolbar tb=f.getToolbar();
        fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
        fbtn= new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
      Label titre=new Label();
 
     Label  Labelnom =new Label("Type ticket : "+t.getType()) ;
     Label  Labelnbr =new Label("Prix : "+t.getPrix()) ;
     Label  Labeldes =new Label("Etat_Ticket : "+t.getEtat_ticket()) ;
     Label  Labelser =new Label("Email du vendeur : "+t.getEmail()) ;
     
     
       fselect.addComponent(Labelnom);
       fselect.addComponent(Labelnbr);
       fselect.addComponent(Labeldes);
    //   fselect.addComponent(Labeladr);
       fselect.addComponent(Labelser);
       
     //  fselect.addComponent(Labelville);
      
   Button viewc = new Button("Contacter");
      viewc.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);



      
       fselect.add(titre);
      // fselect.add(viewc);
       fselect.setLeadComponent(titre);
       fbtn.add(viewc);
        f.add(fselect);
        f.add(fbtn);
  
      /*    viewc.addActionListener((e)->{
          ContactForm a=new ContactForm(res);
        a.getF().show();
        });*/
          
          viewc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             
                 ContactForm a=new ContactForm(t.getEmail(),res);
        a.getF().show();
            }
        });
           

        
//         
//    });
        tb.addCommandToRightBar("back", null, (ev)->{Affichagetickets s=new Affichagetickets(res);
               s.getF().showBack();
    });
        
      
            
    
        
                }

    public Form getF() {
        return f;
    }
    
    
}
