/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import static com.codename1.ui.TextArea.EMAILADDR;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.GroupConstraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.codename1.uikit.materialscreens.StatsForm;
import com.mycompagny.Service.ServiceMatch;
import com.mycompagny.Service.ServiceTicket;
import com.mycompany.Entite.Match;
import com.mycompany.Entite.Tickets;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author mahdi
 */
public class TicketForm extends SideMenuBaseForm {

    Form f;

    TextField tprix;
    TextField ttype;
    TextField temail;
    Button btnajout, btnaff, btnchetat;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TicketForm(Resources res) {
        f = new Form("Tickets");
        Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label lmatch = new Label("Match:");
        Picker stringPicker = new Picker();
        ComboBox c = new ComboBox();
        c.getAllStyles().setBgColor(0xFF0000);
        stringPicker.setType(Display.PICKER_TYPE_STRINGS);
         AutoCompleteTextField ac = new AutoCompleteTextField();
        
        ServiceMatch sm = new ServiceMatch() ; 
        sm.getList() ; 
        List l = new ArrayList();
        for(Match m : sm.getList()){
               
               c.addItem(m.getDuel());
        };
       // System.out.println(l.toString());
        Label lprix = new Label("prix:");
        Label ltype = new Label("Type");
        Label lemail = new Label("Email:");
        tprix = new TextField();
        tprix.setHint("Prix");
       tprix.getAllStyles().setFgColor(0xFF0000);
     
        //tprix.set

        ttype = new TextField();
        ttype.setHint("Type");
        
        ttype.getAllStyles().setFgColor(0xFF0000);
        temail = new TextField();
        temail.setHint("Email");
        temail.setConstraint(CENTER);
        
      temail.getAllStyles().setFgColor(0xFF0000);
   //   temail.getParent().repaint();
        btnajout = new Button("ajouter une ticket A vendre");
        btnaff = new Button("Affichage des tickets ");
        
      //  btnaff.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D);
       
       btnajout.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D);
       btnaff.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D);
        C1.add(lprix);
        C2.add(ltype);
        C3.add(lemail);
        C1.add(tprix);

        C2.add(ttype);
        C3.add(temail);
        C4.add(lmatch);
        C4.add(c);
        f.add(C4);
        f.add(C1);
        f.add(C2);
        f.add(C3);
       
        f.add(btnajout);
        f.add(btnaff);
       
        Validator val = new Validator();
        val.setShowErrorMessageForFocusedComponent(true);
        val.addConstraint(ttype, 
                new GroupConstraint(
                      
                        new RegexConstraint("^([a-zA-Z ]*)$", "utiliser des caracteres svp"))).
                addSubmitButtons(btnajout);
          Validator val2 = new Validator();
        val2.setShowErrorMessageForFocusedComponent(true);
        val2.addConstraint(tprix, 
                new GroupConstraint(
                 
                        new RegexConstraint("^([0-9 ]*)$", "utiliser des nombres pour le prix svp"))).
                addSubmitButtons(btnajout);
         Validator val3 = new Validator();
        val3.setShowErrorMessageForFocusedComponent(true);
        val3.addConstraint(temail, 
                new GroupConstraint(
                       
                        new RegexConstraint("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n" +
"\n" +
"            + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$", "entrer un format mail"))).
                addSubmitButtons(btnajout);


        btnajout.addActionListener((e) -> {
           
            ServiceTicket ser = new ServiceTicket();
            Double tt = Double.parseDouble(tprix.getText()) ;
            
            Tickets t = new Tickets(0, ttype.getText(),tt, temail.getText());
            if(tt<0){
                Dialog.show("erreur", "veuillez entrer", "OK", null);
            }
            
           try{
               ServiceMatch serm = new ServiceMatch();
               
               ArrayList m = serm.getduel(c.getSelectedItem().toString());
               Match match = (Match) m.get(0);
               t.setId_match(match.getId_match());
         //      System.out.println(match.getDuel());
            ser.ajoutTicket(t) ;
            Dialog.show("Succes", "Ticket ajouté avec succes", "OK", null);
            
           }catch(Exception ex){
                Dialog.show("Erreur", "erreur survenue lors de l'ajout", "OK", null);
            
                }
            
           
           

        });
          btnaff.addActionListener((e)->{
        Affichagetickets a=new Affichagetickets(res);
        a.getF().show();
        });

    }

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();     
    }

}
