/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceTransport;
import com.mycompany.Entite.Hotel;
import com.mycompany.Entite.Reservationt;
import com.mycompany.Entite.Transport;

/**
 *
 * @author fedibigbo$$
 */
public class TransportForm {
        Form f,f3,f4 ;
    Transport t ;
    Button Viewb,btnmap;

    public TransportForm(Transport t , Resources res) {
        
        this.t = t;
        Container fselect;

        f=new Form("Detail Du Transport",new BoxLayout(BoxLayout.Y_AXIS));
        Toolbar tb=f.getToolbar();
        fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
        
      Label titre=new Label();
 
     Label  Labelnom =new Label("Type Du Transport : "+t.getType()) ;
     Label  Labelnbr =new Label("Depart  : "+t.getDepart()) ;
     Label  Labeldes =new Label("Destination : "+t.getDestination()) ;
     Label  Labeladr =new Label("DateDepart : "+t.getDate_depart()) ;
     Label  Labelser =new Label("DateArrivee : "+t.getDate_arrivee()) ;
    Label  Labelville =new Label("Nombre Voyageurs : "+t.getNbr_voyageurs()) ;
     
       fselect.addComponent(Labelnom);
       fselect.addComponent(Labelnbr);
       fselect.addComponent(Labeldes);
       fselect.addComponent(Labeladr);
       fselect.addComponent(Labelser);
      fselect.addComponent(Labelville);
btnmap= new Button("Enregistrer");

  f3 = new Form("Confirmation",new BoxLayout(BoxLayout.Y_AXIS));
  //f4 = new Form("aa",new BoxLayout(BoxLayout.Y_AXIS));

       f.add(fselect).add(btnmap);
       fselect.add(titre);
       fselect.setLeadComponent(titre);
       
        btnmap.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
      if (Dialog.show("Feliciatation", "la demande a ete enregistrer avec succee", "Voir La Confirmation", null)){

     Label  Labelnom =new Label("Type Du Transport : "+t.getType()) ;
     Label  Labelnbr =new Label("Depart  : "+t.getDepart()) ;
     Label  Labeldes =new Label("Destination : "+t.getDestination()) ;
     Label  Labeladr =new Label("DateDepart : "+t.getDate_depart()) ;
     Label  Labelser =new Label("DateArrivee : "+t.getDate_arrivee()) ;
     Label  Labelville =new Label("Nombre Voyageurs : "+t.getNbr_voyageurs()) ;
     Labelnom.setText("Le type est  : "+t.getType());
     Labelnbr.setText("Depart : "+t.getDepart());
     Labeldes.setText("Arrivee : "+t.getDestination());
                Labeladr.setText("La Date D'arrivee est : "+t.getDate_arrivee());
                Labelser.setText("La Date Du depart est : "+t.getDate_depart());
                Labelville.setText("Nombre de Nuit  :"+t.getNbr_voyageurs());                    
 f3.add(Labelnom);
        f3.add(Labelnbr);
        f3.add(Labeldes);
        f3.add(Labeladr);
        f3.add(Labelser);
        f3.add(Labelville);
     

        Reservationt r =new Reservationt();
       r.setType(t.getType());
       r.setDepart(t.getDepart());
       r.setDestination(t.getDestination());
       r.setDate_depart(t.getDate_depart());
       r.setDate_arrivee(t.getDate_arrivee());
       r.setNbr_voyageurs(t.getNbr_voyageurs());
       r.setId_transport(t.getID_transport());
        ServiceTransport aa=new ServiceTransport();
        aa.ajoutTask(r);
        f3.show();
       
     }
       else{
          Dialog.show("ERREUR", "Verifier Les Information","Essayer une autre fois",null);
      }
            }
             });
 
    }
      public Form getF() {
        return f;
    }
}
