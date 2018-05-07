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
import com.mycompany.Entite.appreciation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nesrine
 */
public class ServiceAppreciation {
    
   /* public void ajoutAppreciation(String sujet,String Description) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/Russia2018Symfony/web/app_dev.php/ajoutAppreciation" + sujet + "/" + Description;
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
    
    */public void ajoutAppreciation(appreciation p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Russia2018Symfony/web/app_dev.php/client/appreciations/new?sujetApp="+p.getSUJET_APP() + "&descriptionApp=" + p.getDESCRIPTION_APP();
        con.setUrl(Url);

        System.out.println("aaaaaaa");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    public ArrayList<appreciation> getList2() {
        ArrayList<appreciation> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String httpMethod="GET";
        con.setHttpMethod(httpMethod);
        con.setUrl("http://127.0.0.1/Russia2018Symfony/web/app_dev.php/client/afficheAppreciation");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> appreciation = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(news);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) appreciation.get("root");
                    for (Map<String, Object> obj : list) {
                        appreciation APPRECIATION = new appreciation();
                        float id = Float.parseFloat(obj.get("idAppreciation").toString());
                        APPRECIATION.setID_APPRECIATION((int) id);
                        APPRECIATION.setSUJET_APP(obj.get("sujetApp").toString());
                        APPRECIATION.setDESCRIPTION_APP(obj.get("descriptionApp").toString());
                        
                        listTasks.add(APPRECIATION);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
}
}
