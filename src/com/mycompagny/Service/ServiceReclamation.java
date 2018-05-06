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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Reclamation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sana
 */
public class ServiceReclamation {

    public void ajouterReclamation(int iduser,String sujet,String Description) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/Russia2018Symfony/web/app_dev.php/admin/manage/reclamation/addjson?id_user="+iduser+"&sujet="+sujet+"&Description="+Description;
        
        con.setUrl(Url);
        con.setPost(false);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.err.println(str);
            if (str.contains("success")) {
                Dialog.show("Sucess", "Reclamation envoyer", "ok", null);
            }
            else{
            Dialog.show("error", "Connection failed", "ok", null);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    

    public ArrayList<Reclamation> getList2(int id) {
        ArrayList<Reclamation> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String httpMethod="GET";
        con.setHttpMethod(httpMethod);
        con.setUrl("http://127.0.0.1/Russia2018Symfony/web/app_dev.php/admin/manage/reclamation/json?id="+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> Recl = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(news);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Recl.get("Root");
                    
                    for (Map<String, Object> obj : list) {
                        Reclamation Rec = new Reclamation();
                        Rec.setSUJET_REC(obj.get("sujet_rec").toString());
                        Rec.setDESCRIPTION_REC(obj.get("description_rec").toString());
                        Rec.setETAT_REC(obj.get("description_rec").toString());
                  listTasks.add(Rec);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

}
