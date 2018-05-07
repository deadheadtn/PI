/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.uikit.materialscreens;

import com.codename1.components.ToastBar;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Transport;
import com.mycompany.gui.Affichage;
import com.mycompany.gui.AffichageHotel;
import com.mycompany.gui.AffichageTransport;
import com.mycompany.gui.Affichageappreciation;
import com.mycompany.gui.Affichageequipe;
import com.mycompany.gui.Affichagejoueur;
import com.mycompany.gui.AjouterReclamation;
import com.mycompany.gui.Statistic;
import com.mycompany.gui.TicketForm;

/**
 * Common code that can setup the side menu
 *
 * @author Shai Almog
 */
public abstract class SideMenuBaseForm extends Form {

    public SideMenuBaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBaseForm(String title) {
        super(title);
    }

    public SideMenuBaseForm() {
    }

    public SideMenuBaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label("  Jennifer Wilson", profilePic, "SideMenuTitle");
        profilePicLabel.setMask(mask.createMask());
            Transport t =new Transport();
        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
        getToolbar().addMaterialCommandToSideMenu("  Joueurs", FontImage.MATERIAL_DASHBOARD,  e -> new Affichagejoueur(res).getF().show());
      //  getToolbar().addMaterialCommandToSideMenu("  Statistiques", FontImage.MATERIAL_DASHBOARD, e -> new Statistic(res).getF().show());
      
        getToolbar().addMaterialCommandToSideMenu("Statistique", FontImage.MATERIAL_DASHBOARD,new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
//                   ChartDemosForm demos = new ChartDemosForm();
//        current = demos;
//        demos.show();  
        Statistic c= new Statistic();
        c.createPieChartForm().show();
            }

            
        });
                  
        getToolbar().addComponentToSideMenu(sidemenuTop);
        getToolbar().addMaterialCommandToSideMenu("  Accueil", FontImage.MATERIAL_DASHBOARD,  e -> showOtherForm(res));
        getToolbar().addMaterialCommandToSideMenu("  Actualités", FontImage.MATERIAL_TRENDING_UP,  e -> new Affichage(res).getF().show());
        getToolbar().addMaterialCommandToSideMenu("  Reservation Hotel", FontImage.MATERIAL_ACCESS_TIME,  e -> new AffichageHotel(res).getF().show());
        getToolbar().addMaterialCommandToSideMenu("  Reservation Transport", FontImage.MATERIAL_ACCESS_TIME,  e ->new AffichageTransport(t, res).getF().show());
        getToolbar().addMaterialCommandToSideMenu("  Equipes", FontImage.MATERIAL_EXIT_TO_APP,  e -> new Affichageequipe(res).getF().show());
        getToolbar().addMaterialCommandToSideMenu("  FeedBack", FontImage.MATERIAL_EXIT_TO_APP,  e -> new Affichageappreciation(res).getF().show());
        getToolbar().addMaterialCommandToSideMenu("Tickets", FontImage.MATERIAL_SMARTPHONE,  e -> new TicketForm(res).getF().show() );
        getToolbar().addMaterialCommandToSideMenu("  Reclamation", FontImage.MATERIAL_EXIT_TO_APP,  e -> new AjouterReclamation(res).getF().show());
    }
    
    protected abstract void showOtherForm(Resources res);
}
