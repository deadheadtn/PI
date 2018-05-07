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
import com.mycompany.Entite.Hotel;
import com.mycompany.Entite.Reservation;
import com.mycompany.Entite.Task;
import com.mycompany.Entite.news;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fedibigbo$$
 */
public class ServiceHotel {
     public void ajoutTask(Reservation ta) {
        ConnectionRequest con = new ConnectionRequest();
        //String Url = "http://127.0.0.1/Russia2018Symfony/web/app_dev.php/mobilereservation?" +"idHotel="+ta.getId_hotel()+"&type="+ta.getType() + "&dateArrivee="+ta.getDate_arrivee()+"&dateDepart="+ta.getDate_depart()+"&nbrNuit="+ta.getNbr_nuit()+"&nbrChambre="+ta.getNbr_chambre()+"&nbrPersonne="+ta.getNbr_personne();
        String Url = "http://127.0.0.1/Russia2018Symfony/web/app_dev.php/client/mobilereservation?" +"idHotel="+ta.getId_hotel()+"&type="+ta.getType() + "&dateArrivee="+ta.getDate_arrivee()+"&dateDepart="+ta.getDate_depart()+"&nbrNuit="+ta.getNbr_nuit()+"&nbrChambre="+ta.getNbr_chambre()+"&nbrPersonne="+ta.getNbr_personne();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     public ArrayList<Hotel> getList2() {
        ArrayList<Hotel> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String httpMethod="GET";
        con.setHttpMethod(httpMethod);
        con.setUrl("http://localhost/Russia2018Symfony/web/app_dev.php/client/webservice");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> news = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(news);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) news.get("root");
                    for (Map<String, Object> obj : list) {
                        Hotel hotel = new Hotel();
                        float id = Float.parseFloat(obj.get("idHotel").toString());
                        
                        hotel.setID_hotel((int) id);
                        hotel.setNom_hotel(obj.get("nomHotel").toString());
                        float nbr = Float.parseFloat(obj.get("nbrEtoile").toString());

                        hotel.setNbr_etoile((int) nbr);
                        hotel.setVille(obj.get("ville").toString());
                        hotel.setDescription(obj.get("description").toString());
                        hotel.setService(obj.get("service").toString());
                        hotel.setAdresse(obj.get("adresse").toString());
                        listTasks.add(hotel);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

}


