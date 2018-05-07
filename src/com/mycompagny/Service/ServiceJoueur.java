/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.joueur;
import com.mycompany.gui.Statistic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nesrine
 */
public class ServiceJoueur {
    public ArrayList<joueur> getList2() {
        ArrayList<joueur> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String httpMethod="GET";
        con.setHttpMethod(httpMethod);
        con.setUrl("http://127.0.0.1/Russia2018Symfony/web/app_dev.php/client/afficheJoueur");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> joueur = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(news);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) joueur.get("root");
                    for (Map<String, Object> obj : list) {
                        joueur JOUEUR = new joueur();
                        float id = Float.parseFloat(obj.get("idJoueur").toString());
                        float age = Float.parseFloat(obj.get("ageJ").toString());
                        float numero = Float.parseFloat(obj.get("numeroJ").toString());
                        float nbbuts = Float.parseFloat(obj.get("nbbutsJ").toString());
                        
                        JOUEUR.setID_JOUEUR((int) id);
                        JOUEUR.setNOM_J(obj.get("nomJ").toString());
                        JOUEUR.setPRENOM_J(obj.get("prenomJ").toString());
                        JOUEUR.setAGE_J((int) age);
                        JOUEUR.setNOM_EQUIPE(obj.get("nomEquipe").toString());
                        JOUEUR.setNUMERO_J((int) numero);
                        JOUEUR.setNBBUTS_J((int) nbbuts);
                        JOUEUR.setEMPLACEMENT_J(obj.get("emplacementJ").toString());
                        JOUEUR.setPHOTO_J(obj.get("photoJ").toString());
                        JOUEUR.setAPPRECIATION_J(obj.get("appreciationJ").toString());
                        JOUEUR.setNATIONALITE_J(obj.get("nationaliteJ").toString());
                        listTasks.add(JOUEUR);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
}
    
//    public void afficherStat(){
//        Statistic c= new Statistic();
// int compteur=0; 
//              double[] tableau = new double[20]; 
//    }
}