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
import com.mycompany.Entite.equipe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nesrine
 */
public class ServiceEquipe {
    public ArrayList<equipe> getList2() {
        ArrayList<equipe> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String httpMethod="GET";
        con.setHttpMethod(httpMethod);
        con.setUrl("http://127.0.0.1/Russia2018Symfony/web/app_dev.php/client/afficheEquipe");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> equipe = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(news);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) equipe.get("root");
                    for (Map<String, Object> obj : list) {
                        equipe EQUIPE = new equipe();
                        float id = Float.parseFloat(obj.get("idEquipe").toString());
                        float classement = Float.parseFloat(obj.get("classement").toString());
                        EQUIPE.setID_EQUIPE((int) id);
                        EQUIPE.setNOM_EQUIPE(obj.get("nomEquipe").toString());
                        EQUIPE.setGROUPE(obj.get("groupe").toString());
                        EQUIPE.setPAYS(obj.get("pays").toString());
                        EQUIPE.setLOGO(obj.get("logo").toString());
                        EQUIPE.setCLASSEMENT((int) classement);
                       
                        listTasks.add(EQUIPE);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
}
}
