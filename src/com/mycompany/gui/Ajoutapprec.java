/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompagny.Service.ServiceAppreciation;
import com.mycompany.Entite.appreciation;

/**
 *
 * @author Nesrine
 */
public class Ajoutapprec {
     Form f;

    TextField sujet;
    TextField description; 

    
    Button btnajout;

    public Ajoutapprec() {
        f = new Form("Ajout APPRECIATION",new BoxLayout(BoxLayout.Y_AXIS));
        sujet = new TextField();
       description=new TextField();
        
        ServiceAppreciation sp=new ServiceAppreciation();
      
       
      
        btnajout = new Button("ajouter");
       
        f.add(sujet);
        f.add(description);
        f.add(btnajout);
       
       btnajout.addActionListener((e) -> {
            if (sujet.getText().equals("")||description.getText().equals("")) {
                Dialog.show("Details", "Please Type What You Are Searching For", "Ok", null);
            } else {
            ServiceAppreciation sp1 = new ServiceAppreciation();
                appreciation p = new appreciation(0,sujet.getText(),description.getText());
            sp1.ajoutAppreciation(p);}
            
            Message m =new Message("test");
            Display.getInstance().sendMessage(new String[]{"nesrine.harrouch@esprit.tn"},"un feedBack a été ajouté", m);
        });
        
      f.show();
        
    
}
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
