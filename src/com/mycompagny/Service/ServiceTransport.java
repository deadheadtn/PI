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
import com.mycompany.Entite.Transport;

import com.mycompany.Entite.Reservation;
import com.mycompany.Entite.Reservationt;
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
public class ServiceTransport {
    
        public void ajoutTask(Reservationt ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/Russia2018Symfony/web/app_dev.php/client/mobilereservation2?" +"idTransport="+ta.getId_transport()+"&type="+ta.getType()+"&dateArrivee="+ta.getDate_arrivee()+"&dateDepart="+ta.getDate_depart()+"&depart="+ta.getDepart()+"&destination="+ta.getDestination()+"&nbrVoyageurs="+ta.getNbr_voyageurs() ;
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
        
     public ArrayList<Transport> getList2() {
        ArrayList<Transport> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String httpMethod="GET";
        con.setHttpMethod(httpMethod);
        con.setUrl("http://localhost/Russia2018Symfony/web/app_dev.php/client/mobiletransport");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> news = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(news);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) news.get("root");
                    for (Map<String, Object> obj : list) {
                       
                        Transport transport=new Transport();
                        
                        float id = Float.parseFloat(obj.get("idTransport").toString());
                        
                        transport.setID_transport((int) id);
                        transport.setType(obj.get("type").toString());
                        transport.setDepart(obj.get("depart").toString());
                        transport.setDestination(obj.get("destination").toString());
                        transport.setDate_depart(obj.get("dateDepart").toString());
                        transport.setDate_arrivee(obj.get("dateArrivee").toString());

                     
                        float nbr = Float.parseFloat(obj.get("nbrVoyageurs").toString());
                        
                        transport.setNbr_voyageurs((int) nbr);
                     
                        listTasks.add(transport);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

}


