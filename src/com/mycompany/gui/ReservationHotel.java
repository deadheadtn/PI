/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.OnOffSwitch;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.codename1.ui.validation.GroupConstraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.company.utils.Local;
import com.mycompagny.Service.ServiceHotel;
import com.mycompany.Entite.Hotel;
import com.mycompany.Entite.Reservation;
import com.mycompany.Entite.Task;
import java.util.Date;


/**
 *
 * @author fedibigbo$$
 */
public class ReservationHotel {
    Form f ;
    Reservation r;
    Form f1, f2;
    private Resources theme;
    UIBuilder uib;
    Picker pkDate;
    OnOffSwitch swGender;
    CheckBox chSport;
    CheckBox chmusic;
    CheckBox chlecture;  
    Label lbtype,lbnbr_nuit,lbnbr_cham,lb_nbrperso;
    Label lbDate,lbDate2,lbDate3;
    TextField type,nbr_nuit,nbr_cham,nbr_perso;
  Button btnajout;

    public ReservationHotel(Hotel h) {

        this.r = r;
        Container fselect;
        
        f=new Form("Page Du Reservation",new BoxLayout(BoxLayout.Y_AXIS));
        Toolbar tb=f.getToolbar();
        fselect  = new Container (new BoxLayout(BoxLayout.Y_AXIS));
              
        
       type=new TextField(null,"type");
      type.getAllStyles().setFgColor(0xFF0000);
    
      nbr_nuit=new TextField(null,"nbr_nuit");
      nbr_nuit.getAllStyles().setFgColor(0xFF0000);
//     int nbr_nuit = Integer.parseInt(nbr_nuit);
//     
//                        Reservation.set((int) nbr_nuit);
      nbr_cham=new TextField(null,"nbr_cham");
      nbr_cham.getAllStyles().setFgColor(0xFF0000);

     nbr_perso=new TextField(null,"nbr_perso");
      nbr_perso.getAllStyles().setFgColor(0xFF0000);

       Picker datePicker = new Picker();
       datePicker.setType(Display.PICKER_TYPE_DATE);
       datePicker.getAllStyles().setFgColor(0xFF0000);
      
         Picker datePicker2 = new Picker();
       datePicker2.setType(Display.PICKER_TYPE_DATE);
       datePicker2.getAllStyles().setFgColor(0xFF0000);

       Picker stringPicker = new Picker();
       stringPicker.setType(Display.PICKER_TYPE_STRINGS);
       stringPicker.getAllStyles().setFgColor(0xFF0000);

       datePicker.setDate(new Date());
       
      
       stringPicker.setStrings("INCLUSIVE", "ALL_INCLUSIVE");
       stringPicker.setSelectedString("INCLUSIVE");
btnajout= new Button("enregistrer");

        f.add(datePicker).add(datePicker2).add(stringPicker).add(btnajout).add(nbr_nuit).add(nbr_cham).add(nbr_perso);
         f.show();
  f2 = new Form("Confirmation",new BoxLayout(BoxLayout.Y_AXIS));

        
        lbDate = new Label("");
        lbDate2 = new Label("");
        lbnbr_nuit = new Label("");
        lbnbr_cham = new Label("");
        lb_nbrperso = new Label("");
        lbDate3 = new Label("");


        
        f2.add(lbnbr_nuit);
        f2.add(lbnbr_cham);
        f2.add(lb_nbrperso);
        f2.add(lbDate);
        f2.add(lbDate2);
        f2.add(lbDate3);
Validator val = new Validator();
        val.setShowErrorMessageForFocusedComponent(true);
        val.addConstraint(nbr_nuit, 
                new GroupConstraint(
                        new RegexConstraint("^([1-9 ]*)$", "Please only use numbers "))).
                addSubmitButtons(btnajout);
        
        val.setShowErrorMessageForFocusedComponent(true);
        val.addConstraint(nbr_cham, 
                new GroupConstraint(
                        new RegexConstraint("^([1-9 ]*)$", "Please only use numbers "))).
                addSubmitButtons(btnajout);
       
        val.setShowErrorMessageForFocusedComponent(true);
        val.addConstraint(nbr_perso, 
                new GroupConstraint(
                        new RegexConstraint("^([1-9 ]*)$", "Please only use numbers "))).
                addSubmitButtons(btnajout);
      btnajout.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (Dialog.show("Feliciatation", "la demande a ete enregistrer avec succee", "Voir La Confirmation", null)){
                lbnbr_nuit.setText("Nombre de Nuit : "+nbr_nuit.getText());
                lbnbr_cham.setText("Nombrede Chambre : "+nbr_cham.getText());
                lb_nbrperso.setText("Nombre de Personne : "+nbr_perso.getText());

                lbDate.setText("La Date D'arrivee est : "+datePicker.getText());
                lbDate2.setText("La Date Du depart est : "+datePicker2.getText());
                lbDate3.setText("Le Type est :"+stringPicker.getText());
                Reservation r =new Reservation();

                r.setDate_arrivee(datePicker.getText());
                r.setDate_depart(datePicker2.getText());
                Integer a = Integer.parseInt(nbr_nuit.getText());
                r.setNbr_nuit(a);
                Integer b = Integer.parseInt(nbr_cham.getText());
                r.setNbr_chambre(b);
                Integer c = Integer.parseInt(nbr_perso.getText());
                r.setNbr_personne(c);
                r.setType(stringPicker.getText());
                r.setId_hotel(h.getID_hotel());
                System.out.println(r.getId_hotel());
                ServiceHotel aa =new ServiceHotel();
             //   Reservation tt=new Reservation(0, 0,0, datePicker, datePicker2, 0, stringPicker, 0, 0);
                aa.ajoutTask(r);
                    f2.show();
                }
            else{
          Dialog.show("ERREUR", "Verifier Les Information","Essayer une autre fois",null);
      }
         
                  
        }});
 
    }

 

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
