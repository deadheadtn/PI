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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.String;

/**
 *
 * @author mahdi
 */
public class ServiceMatch {
    
     public ArrayList<Match> getList() {
       ConnectionRequest con = new ConnectionRequest();

        ArrayList<Match> listMatchs = new ArrayList<>();
        con.setUrl("http://127.0.0.1/Russia2018Symfony/web/app_dev.php/mobile/match");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> matchs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(matchs);
                   System.out.println(matchs.size());
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) matchs.get("root");
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        Match match = new Match();
                         float id = Float.parseFloat(obj.get("idMatch").toString());
                        match.setId_match((int)id);
                        match.setDate(obj.get("dateMatch").toString());
                        match.setHeure_match(obj.get("heureMatch").toString());
                        match.setDuel(obj.get("duel").toString());
                        match.setStade(obj.get("stade").toString());
                           
                        match.setGroupe(obj.get("groupe").toString());
                        listMatchs.add(match);

                    }
                } catch (IOException ex) {
                }
        

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listMatchs;
    }
        public ArrayList<Match> getduel(String m) {
       ConnectionRequest con = new ConnectionRequest();

        ArrayList<Match> listMatchs = new ArrayList<>();
        
        con.setUrl("http://127.0.0.1/russia2018symfony5/web/mobile/findmatch2/"+m);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> matchs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(matchs);
                   System.out.println(matchs.size());
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) matchs.get("root");
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        Match match = new Match();
                         float id = Float.parseFloat(obj.get("idMatch").toString());
                        match.setId_match((int)id);
                        match.setDate(obj.get("dateMatch").toString());
                        match.setHeure_match(obj.get("heureMatch").toString());
                        match.setDuel(obj.get("duel").toString());
                        match.setStade(obj.get("stade").toString());
                           
                        match.setGroupe(obj.get("groupe").toString());
                        listMatchs.add(match);

                    }
                } catch (IOException ex) {
                }
        

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listMatchs;
    }
     public Object[] getList2() {
       ConnectionRequest con = new ConnectionRequest();

        ArrayList<Match> listMatchs = new ArrayList<>();
        con.setUrl("http://127.0.0.1/russia2018symfony5/web/mobile/match");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> matchs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(matchs);
                   System.out.println(matchs.size());
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) matchs.get("root");
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        Match match = new Match();
                       
                        match.setDuel(obj.get("duel").toString());
                           
                     
                        listMatchs.add(match);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listMatchs.toArray();
    }
   
}
