/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author deadhead
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        news a = new news(1,"aaaa","aaaa","aaaa","aaaa","aaaa");
        //a.addNews();
        //System.err.println(a);
        //a.DeleteNews();
        Gestion_reclamation r= new Gestion_reclamation();
        Reclamation rec= new Reclamation(1,1,"aaaa","aaaa","aaaa","aaaa");
        r.addReclamation(rec);
    }
    
}
