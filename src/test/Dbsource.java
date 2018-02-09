/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author deadhead
 */
public class Dbsource {
    private static Dbsource data;
    private Connection con;
    String username= "deadhead";
    String password= "123123";
    String url="jdbc:mysql://127.0.0.1/russia2018";
    Dbsource(){
        try{
             con= DriverManager.getConnection(url,username,password);
        }
        catch(SQLException m){
            System.err.println(m);
        }
    }
    Connection getConnection(){
        return con;
    }
    public static Dbsource getInstance(){
        if(data == null){
            data= new Dbsource();
        }
        return data;
    }
    
}
