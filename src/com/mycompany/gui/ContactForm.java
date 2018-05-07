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
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.mycompagny.Service.ServiceMail;
import com.mycompagny.Service.ServiceTicket;
import com.mycompany.Entite.Tickets;

/**
 *
 * @author mahdi
 */
public class ContactForm extends SideMenuBaseForm{
     Form f;
  private Form home;
    TextField tprix;
    TextField ttype;
      TextField tfrom;
    Label temail;
   
    Button btncontact;
     private Resources theme;
     
        public ContactForm(String t,Resources res) {
            f = new Form();
        home = new Form("Contacter Vendeur");
          Toolbar tb=f.getToolbar();
        
        Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
          Label mail = new Label("Email du vendeur:");
           Label sujet = new Label("sujet:");
           Label contenu= new Label("contenu:");
          Label tmail= new Label(t);
              TextField tsujet= new TextField();
           tsujet.setHint("Sujet");
           tsujet.getAllStyles().setFgColor(000000);
           TextArea tcontenu = new TextArea();
           tcontenu.setHint("contenu");
           tmail.getAllStyles().setFgColor(0xFF0000);
           String maill= tmail.getText();
           String contentt= tcontenu.getText();
           String sujett= tsujet.getText();
                btncontact= new Button(" envoyer message");
                btncontact.setAlignment(CENTER);
                TextField tfrom=  new TextField();
                Label from = new Label("From");
                
           btncontact.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D);
           C5.add(btncontact);
           C4.add(from);
           C4.add(tfrom);
           C1.add(mail);
           C1.add(tmail);
           C2.add(sujet);
           C2.add(tsujet);
           C3.add(contenu);
           C3.add(tcontenu);
           f.add(C1);
           f.add(C2);
          f.add(C3);
          f.add(C4);
          f.add(C5);
        
             btncontact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             
                 ServiceMail sm=new ServiceMail();
                 sm.SendMail(maill, tcontenu.getText(),tsujet.getText(),tfrom.getText());
      
            }
        });

     tb.addCommandToRightBar("back", null, (ev)->{Affichagetickets s=new Affichagetickets(res);
               s.getF().showBack();

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
               new StatsForm(res).show();    //To change body of generated methods, choose Tools | Templates.
    }
}
 