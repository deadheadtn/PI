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
import com.mycompany.Entite.Match;
import com.mycompany.Entite.Tickets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mahdi
 */
public class ServiceTicket {
     public void ajoutTicket(Tickets T) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/Russia2018Symfony/web/app_dev.php/mobile/new?" + "type="+T.getType() + "&email=" +T.getEmail()+"&prix="+T.getPrix()+"&duel="+T.getId_match();
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
    public ArrayList<Tickets> getList() {
       ConnectionRequest con = new ConnectionRequest();

        ArrayList<Tickets> listTickets = new ArrayList<>();
        con.setUrl("http://127.0.0.1/Russia2018Symfony/web/app_dev.php/tasks/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tickets = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                  //  System.out.println(tickets);
                  // System.out.println(tickets.size());
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tickets.get("root");
                    for (Map<String, Object> obj : list) {
                    //    System.out.println(obj);
                        Tickets ticket = new Tickets();
                         float id = Float.parseFloat(obj.get("idTicket").toString());
                        ticket.setId_ticket((int)id);
                        ticket.setType(obj.get("type").toString());
                       float prix =Float.parseFloat(obj.get("prix").toString());
                      ticket.setPrix((double)prix);
                        ticket.setEtat_ticket(obj.get("etatTicket").toString());
                        ticket.setEmail(obj.get("email").toString());

                        listTickets.add(ticket);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTickets;
    }
}
