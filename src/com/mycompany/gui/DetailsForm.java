/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.googlemaps.MapContainer;
import com.codename1.maps.Coord;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.mycompany.Entite.Hotel;
import java.io.IOException;

/**
 *
 * @author fedibigbo$$
 */
public class DetailsForm {
    Form f,f3 ;
    Hotel h ;
    Button Viewb,btnmap;

    public DetailsForm(Hotel h , Resources res) {
        
        this.h = h;
        Container fselect;

        f=new Form("Detail Du Hotel",new BoxLayout(BoxLayout.Y_AXIS));
        Toolbar tb=f.getToolbar();
        fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
        
      Label titre=new Label();
 
     Label  Labelnom =new Label("Nom Hotel : "+h.getNom_hotel()) ;
     Label  Labelnbr =new Label("Nombre Etoile : "+h.getNbr_etoile()) ;
     Label  Labeldes =new Label("Destination : "+h.getDescription()) ;
     Label  Labeladr =new Label("Adresse : "+h.getAdresse()) ;
     Label  Labelser =new Label("Service : "+h.getService()) ;
     Label  Labelville =new Label("Ville : "+h.getVille()) ;
     
       fselect.addComponent(Labelnom);
       fselect.addComponent(Labelnbr);
       fselect.addComponent(Labeldes);
       fselect.addComponent(Labeladr);
       fselect.addComponent(Labelser);
       fselect.addComponent(Labelville);
      Button Viewb = new Button("RESERVER");
        btnmap= new Button("Voir Dans La Map");


       f.add(fselect).add(btnmap);
       fselect.add(titre);
       fselect.add(Viewb);
       fselect.setLeadComponent(titre);
       ReservationHotel rh =new ReservationHotel(h);

           titre.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                     rh.getF().show();
          }
           

        
         
    });
        tb.addCommandToRightBar("back", null, (ev)->{ProfileForm s=new ProfileForm(res);
               s.showBack();
    });
        
         f3 = new Form("MAP",new BoxLayout(BoxLayout.Y_AXIS));
         btnmap.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 final MapContainer map = new MapContainer();
                               //  Coord cor=new Coord(36.848869, 10.184749);
                               // Coord cor=new Coord(36.898392, 10.189732);
                             Coord cor=new Coord(55.725440, 37.414231);

                            //map.setCameraPosition(new Coord(36.848869, 10.184749));
                        //   map.setCameraPosition(new Coord(36.848869, 10.184749));
                          //  map.setCameraPosition(new Coord(36.898392, 10.189732));
                            map.setCameraPosition(new Coord(55.725440, 37.414231));


                 map.setCameraPosition(cor);
                 map.zoom(cor, 4);
              
 EncodedImage enc = null;
    Image imgs;
    ImageViewer imgv;


    String url = "http://localhost/img/nader.jpg";

   

   
                try {
                    enc = EncodedImage.create("/map.png");
                } catch (IOException ex) {
                }
      
        imgs = URLImage.createToStorage(enc, url, url,URLImage.RESIZE_SCALE);
        imgv = new ImageViewer(imgs);
        Form hi = new Form();
        hi.add(imgv);
        hi.show();
       map.addMarker(new MapContainer.MarkerOptions(cor,EncodedImage.createFromImage(imgs, true).scaledEncoded(10, 10) ));
       f3.add(map);
              f3.show();

    }

   


            
        });



        
                }

    public Form getF() {
        return f;
    }
    
    
}
