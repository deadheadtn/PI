/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.DAO.Classe;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mto.cr.DAO.Interface.IDAOUser;
import mto.cr.Model.User;
import mto.cr.Technique.DataBase;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author Chiheb
 */
public class UserDAO implements IDAOUser {
    private String password;
    private String candidate;
    private static MessageDigest digester;


    @Override
    public User getById(int id) {
        User user = new User();
        try {
            String query = "SELECT * FROM user WHERE id = ?";
            ResultSet res;
            PreparedStatement ps;
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, id);
            res = ps.executeQuery();
            if (res.next()) {
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setUsername_canonical(res.getString("username_canonical"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setEmail(res.getString("email"));
                user.setEmail_canonical(res.getString("email_canonical"));
                user.setPassword(res.getString("password"));
                user.setEnabled(res.getInt("enabled"));
                user.setLocked(res.getInt("locked"));
                user.setSalt(res.getString("salt"));
                user.setPath(res.getString("path"));
                user.setPaysnatal(res.getString("paysNatal"));
                user.setSituationprof(res.getString("situationprof"));
                user.setSecteur(res.getString("secteur"));
                user.setSolde(res.getInt("solde"));
                user.setRole(res.getString("role"));
                user.setRoles(res.getString("roles"));
                user.setDatenaissance(res.getDate("dateNaissance"));
                user.setNbrVote(res.getInt("nbrVote"));
                user.setNbrcommentaire(res.getInt("nbrcommentaire"));
                user.setNbrprojetssuivis(res.getInt("nbrprojetssuivis"));
                user.setNbrfinancement(res.getInt("nbrfinancement"));
                
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;

    }

    @Override
    public User getByUsername(String username) {
        //BCrypt b = new BCrypt();
        User user = new User();
            String query = "SELECT * FROM user WHERE username_canonical = ?";
            ResultSet res;
            PreparedStatement ps;
        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, username);
            res = ps.executeQuery();
            if (res.next()) {
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setUsername_canonical(res.getString("username_canonical"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setEmail(res.getString("email"));
                user.setEmail_canonical(res.getString("email_canonical"));
                user.setPassword(res.getString("password"));
                user.setEnabled(res.getInt("enabled"));
                user.setLocked(res.getInt("locked"));
                user.setSalt(res.getString("salt"));
                user.setPath(res.getString("path"));
                user.setPaysnatal(res.getString("paysNatal"));
                user.setSituationprof(res.getString("situationprof"));
                user.setSecteur(res.getString("secteur"));
                user.setSolde(res.getInt("solde"));
                user.setRole(res.getString("role"));
                user.setRoles(res.getString("roles"));
                user.setDatenaissance(res.getDate("dateNaissance"));
                user.setNbrVote(res.getInt("nbrVote"));
                user.setNbrcommentaire(res.getInt("nbrcommentaire"));
                user.setNbrprojetssuivis(res.getInt("nbrprojetssuivis"));
                user.setNbrfinancement(res.getInt("nbrfinancement"));
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        ResultSet res;
        PreparedStatement ps;
        User user;
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";

        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            System.out.println("get All users");
            res = ps.executeQuery();
            while (res.next()) {
                user = new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setUsername_canonical(res.getString("username_canonical"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setEmail(res.getString("email"));
                user.setEmail_canonical(res.getString("email_canonical"));
                user.setPassword(res.getString("password"));
                user.setEnabled(res.getInt("enabled"));
                user.setLocked(res.getInt("locked"));
                user.setSalt(res.getString("salt"));
                user.setPath(res.getString("path"));
                user.setPaysnatal(res.getString("paysNatal"));
                user.setSituationprof(res.getString("situationprof"));
                user.setSecteur(res.getString("secteur"));
                user.setSolde(res.getInt("solde"));
                user.setRole(res.getString("role"));
                user.setRoles(res.getString("roles"));
                user.setDatenaissance(res.getDate("dateNaissance"));
                user.setNbrVote(res.getInt("nbrVote"));
                user.setNbrcommentaire(res.getInt("nbrcommentaire"));
                user.setNbrprojetssuivis(res.getInt("nbrprojetssuivis"));
                user.setNbrfinancement(res.getInt("nbrfinancement"));
                
                users.add(user);
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
        
    }


////////////////BCrypt//////////////
//        String pwd = "kkk";//U1.getPassword();
//        byte[] uniqueKey = pwd.getBytes();
//        byte[] hash      = null;
//
//        try
//        {
//            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
//        }
//        catch (NoSuchAlgorithmException e)
//        {
//            throw new Error("No MD5 support in this VM.");
//        }
//
//        StringBuilder hashString = new StringBuilder();
//        for (int i = 0; i < hash.length; i++)
//        {
//            String hex = Integer.toHexString(hash[i]);
//            if (hex.length() == 1)
//            {
//                hashString.append('0');
//                hashString.append(hex.charAt(hex.length() - 1));
//            }
//            else
//                hashString.append(hex.substring(hex.length() - 2));
//        }
//        System.out.println("first method  md5 ====> " + hashString.toString());
//        
//        //2nd method
//String plaintext = "kkk";
//MessageDigest m;
//        try {
//            m = MessageDigest.getInstance("MD5");
//            m.reset();
//m.update(plaintext.getBytes());
//byte[] digest = m.digest();
//BigInteger bigInt = new BigInteger(1,digest);
//String hashtext = bigInt.toString(16);
//// Now we need to zero pad it if you actually want the full 32 chars.
//while(hashtext.length() < 32 ){
//  hashtext = "0"+hashtext;
//}
//            System.out.println(" 2nd mehod crypted md5=====>" +hashtext);
//        
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        //3rd method
//          MessageDigest md = null;
//        try {
//            md = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//  byte[] thedigest;
//        try {
//            thedigest = md.digest(U1.getPassword().getBytes("UTF-8"));
//              StringBuilder hexString = new StringBuilder();
//
//  for (int i = 0; i < thedigest.length; i++)
//  {
//      String hex = Integer.toHexString(0xFF & thedigest[i]);
//      if (hex.length() == 1)
//          hexString.append('0');
//
//      hexString.append(hex);
//  }
//
//        System.out.println("3rd method ===== > "+hexString);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
// last one 
//
//++++++++++++++++++MD5
//        System.out.println("=====>"+BCrypt.hashpw("nnn", BCrypt.gensalt(13)));
//        byte[] chaine = "nnn".getBytes();
//        System.out.println("md5 ====> "+Md5Crypt.md5Crypt(chaine));
//        System.out.println("md5 22 (nnn) ====> "+ Md5Crypt.md5Crypt(chaine, null, ""));
//        System.out.println("md5 22  (nnn)====> "+ Md5Crypt.apr1Crypt("nnn"));
//        System.out.println("apr1  (nnn)====> "+ Md5Crypt.md5Crypt(chaine, null, ""));
//        byte[] aa = generateHash().getBytes();
//        System.out.println(" string hashed sha512 ====>" + generateHash().toString() );
    @Override
    public int Login(User U1) {
        User U2 = new User();
        UserDAO userDAO = new UserDAO();
        U2 = getByUsername(U1.getUsername_canonical());
        if (U2.getRoles().contains("ROLE_ADMIN")) {
            userDAO.userConnecte(U2);
            return 6; //expired
        } 
        if (U2.getRoles().contains("ROLE_AGENT")) {
            userDAO.userConnecte(U2);
            return 5; //expired
        } 
        
        if (U2.getExpired() == 1) {
            return 3; //expired
        } 
        else if (U2.getLocked() == 1) {
            return 4; //locked
        } 
        
        else if (U1.equals(U2)) {
            System.out.println("---------------->"+U2.getId());
            userDAO.userConnecte(U2);
            return 0; //jawou behi
        } 
        else if (U1.getUsername_canonical().equals(U2.getUsername_canonical())) {
            return 1; //email faux
        } 
        else if (U1.getEmail_canonical().equals(U2.getEmail_canonical())) {
            return 2; //username faux
        } 

        else {
            return 9;
        }


    }

    public String generateHash() {
    String toHash = "test";
    MessageDigest md = null;
    byte[] hash = null;
    try {
        md = MessageDigest.getInstance("SHA-512");
        hash = md.digest(toHash.getBytes("UTF-8"));
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return convertToHex(hash);
}
 
/**
* Converts the given byte[] to a hex string.
* @param raw the byte[] to convert
* @return the string the given byte[] represents
*/
private String convertToHex(byte[] raw) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < raw.length; i++) {
        sb.append(Integer.toString((raw[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
}

    @Override
    public boolean ajouter(User U) {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet res;
        PreparedStatement ps;
        Calendar c = Calendar.getInstance();
        java.util.Date d = U.getDatenaissance();
        java.sql.Date dd= new Date (d.getTime()); 
        
        String query ="insert into User ("
                        + "email,"
                        + "email_canonical,"
                        + "username,"
                        + "username_canonical,"
                        + "enabled,"
                        + "password,"
                        + "locked,"
                        + "expired,"
                        + "role,"
                        + "nom,"
                        + "prenom,"
                        + "dateNaissance,"
                        + "situationProf,"
                        + "path,"
                        + "secteur,"
                        + "experienceTot,"
                        + "solde,"
                        + "paysNatal,"
                        + "etat,"
                        + "sexe,"
                        + "nbrfinancement,"
                        + "nbrVote,"
                        + "nbrcommentaire,"
                        + "nbrprojetssuivis, "
                        + "salt ,"
                        + "roles,"
                        + "last_login,"
                        + "Credentials_expired )"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            ps.setString(1,U.getEmail());
            ps.setString(2,U.getEmail_canonical());
            ps.setString(3,U.getUsername());
            ps.setString(4,U.getUsername_canonical());
            
            ps.setInt(5,U.getEnabled());
            ps.setString(6,U.getPassword());
            ps.setInt(7,U.getLocked());
            
            ps.setInt(8,U.getExpired());
            ps.setString(9,U.getRole());
            ps.setString(10,U.getNom());
            ps.setString(11,U.getPrenom());
            //date

            ps.setDate(12, dd); 
            //date end
            ps.setString(13,U.getSituationprof());
            ps.setString(14,U.getPath());
            ps.setString(15,U.getSecteur());
            ps.setInt(16,U.getExperiencetot());
            ps.setInt(17,U.getSolde());
            ps.setString(18,U.getPaysnatal());
            
            ps.setString(19,U.getEtat());
            ps.setString(20,U.getSexe());
            
            ps.setInt(21,U.getNbrfinancement());
            ps.setInt(22,U.getNbrVote());
            ps.setInt(23,U.getNbrcommentaire());
            ps.setInt(24,U.getNbrprojetssuivis());
            ps.setString(25,U.getSalt());
            ps.setString(26, "a:0:{}");
            //date
            Calendar cc = Calendar.getInstance();
            java.util.Date dat = new java.util.Date();
            java.sql.Date dat1 = new Date (d.getTime()); 
            ps.setDate(27, dd); 
            //date end
            
            ps.setInt(28,0);
            //execute Update
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public boolean update(User U) {
        ResultSet res;
        PreparedStatement ps;
        Calendar c = Calendar.getInstance();
        java.util.Date d = U.getDatenaissance();
        java.sql.Date dd= new Date (d.getTime()); 
        String query ="update user "
                        + "SET  nom = ?, prenom = ?, dateNaissance = ?,"
                        + " situationProf = ?, path = ?, secteur = ?, paysNatal = ?, sexe = ? "
                        + "where email_canonical = ?";
        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            ps.setString(1,U.getNom());
            ps.setString(2,U.getPrenom());
            //date

            ps.setDate(3, dd); 
            //date end
            ps.setString(4,U.getSituationprof());
            ps.setString(5,U.getPath());
            ps.setString(6,U.getSecteur());
            ps.setString(7,U.getPaysnatal());
            ps.setString(8,U.getSexe());
            ps.setString(9,U.getEmail_canonical());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public void updatePassword(User U) {
        ResultSet res;
        PreparedStatement ps;
        String query ="update user "
                        + "SET  password = ? where email_canonical = ?"; 
        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            ps.setString(1,U.getPassword());
            ps.setString(2, U.getEmail_canonical());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User getByEmail(String email) {

        //BCrypt b = new BCrypt();
        User user = new User();
            String query = "SELECT * FROM user WHERE email_canonical = ?";
            ResultSet res;
            PreparedStatement ps;
        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, email);
            res = ps.executeQuery();
            if (res.next()) {
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setUsername_canonical(res.getString("username_canonical"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setEmail(res.getString("email"));
                user.setEmail_canonical(res.getString("email_canonical"));
                user.setPassword(res.getString("password"));
                user.setEnabled(res.getInt("enabled"));
                user.setLocked(res.getInt("locked"));
                user.setSalt(res.getString("salt"));
                user.setPath(res.getString("path"));
                user.setPaysnatal(res.getString("paysNatal"));
                user.setSituationprof(res.getString("situationprof"));
                user.setSecteur(res.getString("secteur"));
                user.setSolde(res.getInt("solde"));
                user.setRole(res.getString("role"));
                user.setRoles(res.getString("roles"));
                user.setDatenaissance(res.getDate("dateNaissance"));
                user.setNbrVote(res.getInt("nbrVote"));
                user.setNbrcommentaire(res.getInt("nbrcommentaire"));
                user.setNbrprojetssuivis(res.getInt("nbrprojetssuivis"));
                user.setNbrfinancement(res.getInt("nbrfinancement"));
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public void updateLastLogin(User U) {
            ResultSet res;
        PreparedStatement ps;
        String query ="update user "
                        + "SET  last_login = ? where email_canonical = ?"; 
        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            Calendar c = Calendar.getInstance();
            java.util.Date d = U.getLast_login();
            java.sql.Date dd= new Date (d.getTime()); 
            ps.setDate(1, dd); 
            ps.setString(2, U.getEmail_canonical());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void updateSolde(double s,User u) {
        
        try { 
        String req="update user set solde= solde + ? where id=?"; 
        
        PreparedStatement ps= DataBase.getInstance().getConnection().prepareStatement(req); 
     
            ps.setDouble(1,s);
            ps.setInt(2, u.getId());
            
            ps.executeUpdate(); 
           
                  
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<User> findAllOrderBy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public boolean insert(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean clean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //**************************************
    
    public List<User> getAllAgent() {
        ResultSet res;
        PreparedStatement ps;
        User user;
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";

        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            System.out.println("get All users");
            res = ps.executeQuery();
            while (res.next()) {
                user = new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setUsername_canonical(res.getString("username_canonical"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("password"));
                user.setEnabled(res.getInt("enabled"));
                user.setLocked(res.getInt("locked"));
                user.setSalt(res.getString("salt"));
                user.setPath(res.getString("path"));
                user.setPaysnatal(res.getString("paysNatal"));
                user.setSituationprof(res.getString("situationprof"));
                user.setSecteur(res.getString("secteur"));
                user.setSolde(res.getInt("solde"));
                user.setRole(res.getString("role"));
                user.setRoles(res.getString("roles"));
                user.setDatenaissance(res.getDate("dateNaissance"));
                
                
                user.setExperiencetot(res.getInt("experienceTot"));
                user.setNbrVote(res.getInt("nbrVote"));
                user.setNbrfinancement(res.getInt("nbrfinancement"));
                user.setNbrcommentaire(res.getInt("nbrCommentaire"));
                user.setNbrprojetssuivis(res.getInt("nbrprojetssuivis"));
                //firas
                
                users.add(user);
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
        
    }
         
     public User getStatAllAgent(int id) {
        ResultSet res;
        PreparedStatement ps;
               User u= new User();

        
        String query = "SELECT * FROM user where id="+id;

        try {
            ps = DataBase.getInstance().getConnection().prepareStatement(query);
            System.out.println("get All users");
            res = ps.executeQuery();
            while (res.next()) {
                
                u.setExperiencetot(res.getInt("experienceTot"));
                u.setNbrVote(res.getInt("nbrVote"));
                u.setNbrfinancement(res.getInt("nbrfinancement"));
                u.setNbrcommentaire(res.getInt("nbrCommentaire"));
                u.setNbrprojetssuivis(res.getInt("nbrprojetssuivis"));
                
                
                
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
        
    }
     
     //admin
    @Override
    public void userConnecte(User u){
    
    
       String req = "update User set name='c' where ID= " + u.getId();
       Statement statement;

        try {
            statement = DataBase.getInstance().getConnection().prepareStatement(req);
            int result = statement.executeUpdate(req);

            
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    @Override
    public void userDecoonnecte(User u){
    
    
       String req = "update User set name='d' where ID= " + u.getId();
       Statement statement;

        try {
            statement = DataBase.getInstance().getConnection().prepareStatement(req);
            int result = statement.executeUpdate(req);

            
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }


}
