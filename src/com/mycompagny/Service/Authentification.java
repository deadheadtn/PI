    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.mycompany.Entite.User;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


/**
 *
 * @author Odil
 */
public class Authentification {
    
    public static Authentification instance;
    public static User user;
    
    
    public Authentification()
    {
    user=null;
    }
    
    
    public static Authentification getSession()
    {if(instance==null)
    instance=new Authentification();
    return instance;
    }
           
    public User login(int id){
     try {
         String url ="http://127.0.0.1/Russia2018Symfony/getuser.php?id="+id;
                ConnectionRequest request = new ConnectionRequest(url);
                request.setPost(false);
                NetworkManager.getInstance().addToQueueAndWait(request);
                Map<String,Object> result= new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(request.getResponseData()), "UTF-8"));
                Map<String,String> userjson=(Map<String,String>) result.get("user");
                user=new User();
                user.setId(Integer.parseInt(userjson.get("id")));
                        user.setUsername(userjson.get("username"));
                        user.setEmail(userjson.get("email"));
                        user.setNom(userjson.get("nom"));
                        user.setPrenom(userjson.get("prenom"));
                        user.setPassword(userjson.get("password"));
                        user.setNum(userjson.get("num_tel"));
                        user.setEnabled(Integer.parseInt(userjson.get("enabled")));
                        user.setCode(userjson.get("confirmation_token"));
                        
                System.out.println(user);
            } catch (IOException ex) {
                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } 
     return user ; 
    }
    
    
    
     public void ajoutBet(User u,String conf) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1:8000/adduser/" + u.getNom() + "/" + u.getPrenom()+"/"+u.getUsername()+ "/" +u.getUsername_canonical() +"/" +u.getEmail()+ "/" +u.getEmail_canonical()+ "/" +u.getPassword()+ "/" +conf+ "/" +u.getNum()+ "/" +u.getNationalite();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        
         InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
          
        con.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     
     
     
     public void updateUser(User u) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1:8000/valideU/" + u.getId() ;
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        
         InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
          
        con.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     
 
       
    public boolean connected(){
        return user!=null;
    }
    
    public void logout(){
        user=null;
    }
    
    public User getUser(){
        if (connected()) return user;
        return null;
    }
}
