/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sana
 */
public class DataSource {

    private static DataSource data;
    private Connection con;
    String username = "deadhead";
    String password = "123123";
    String url = "jdbc:mysql://localhost:3306/russia2018";

    private DataSource() {
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("connexion");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public static DataSource getInstance() {
        if (data == null) {
            data = new DataSource();
        }
        return data;

    }
}
