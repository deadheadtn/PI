/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mto.cr.DAO.Classe.UserDAO;
import mto.cr.Model.User;

/**
 *
 * @author Chiheb
 */
public class LoginController implements Initializable {

    public static User logged;
    @FXML
    private Button buttonLogin;
    @FXML
    private TextField username;
    @FXML
    private Button buttonCree;
    @FXML
    private PasswordField password;
    @FXML
    private Button buttonError;
    @FXML
    private AnchorPane pswOublie;
    @FXML
    private Button mdpOublie;
    @FXML
    private ImageView logoImage;
    @FXML
    private ImageView logoText;

    @FXML
    private void loginAc(ActionEvent event) throws SQLException {
        Stage stage = null;
        Parent root = null;
        UserDAO userDAO = new UserDAO();
        User user = new User();
        ResultSet res;
        PreparedStatement ps;
        

        //***************** LOGIN ****************

        if (event.getSource() == buttonLogin) {
            stage = (Stage) buttonLogin.getScene().getWindow();
            //
            //user = userDAO.getByUsername(username.getText());

            user.setUsername_canonical(username.getText());
            user.setPassword(password.getText());

            System.out.println("returned value : " + userDAO.Login(user));
            //admin
            if (userDAO.Login(user) == 6) {
                try {
                    user.setLast_login(new Date());
                    userDAO.updateLastLogin(user);
                    logged = userDAO.getByUsername(user.getUsername_canonical());
                    root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Profils");
                    stage.setResizable(false);
                    stage.show();

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //agent
            else if (userDAO.Login(user) == 5) {
                try {
                    user.setLast_login(new Date());
                    userDAO.updateLastLogin(user);
                    logged = userDAO.getByUsername(user.getUsername_canonical());
                    root = FXMLLoader.load(getClass().getResource("Agent.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Profils");
                    stage.setResizable(false);
                    stage.show();

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            //user
            else if (userDAO.Login(user) == 0) {
                try {
                    user.setLast_login(new Date());
                    userDAO.updateLastLogin(user);
                    logged = userDAO.getByUsername(user.getUsername_canonical());
                    root = FXMLLoader.load(getClass().getResource("AcceuilUser.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Profils");
                    stage.setResizable(false);
                    stage.show();

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } 

            else if (userDAO.Login(user) == 2) {
                buttonError.setText("Username invalide");
                buttonError.setVisible(true);
                password.clear();
                username.clear();
                System.out.println("False");
            } else if (userDAO.Login(user) == 1) {
                buttonError.setText("Mot de passe invalide");
                buttonError.setVisible(true);
                password.clear();
                System.out.println("False");
            } else if (userDAO.Login(user) == 3) {

                buttonError.setText("Compte Expiré");
                buttonError.setVisible(true);
                password.clear();
                username.clear();
                System.out.println("False");

            } 
            else if (userDAO.Login(user) == 4) {
                buttonError.setText("Compte Bloqué");
                buttonError.setVisible(true);
                password.clear();
                username.clear();
                System.out.println("False");

            } 
            
            
            
            else {
                buttonError.setText("Compte Inéxistant");
                buttonError.setVisible(true);
                password.clear();
                username.clear();
                System.out.println("False");

            }
            
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonError.setVisible(false);
        Image imageLogo = new Image("mto/cr/images/logoCR.png");
        Image imageLogo2 = new Image("mto/cr/images/mtocrowdrise.png");
       // logoImage.setImage(imageLogo);
        //logoText.setImage(imageLogo2);
         mdpOublie.setOnMouseClicked((MouseEvent event) -> {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
             
             Stage stage = new Stage();
             Stage stageprev = (Stage) mdpOublie.getScene().getWindow();
             
             FXMLLoader loader = new FXMLLoader(getClass().getResource("MotDePasseOublie.fxml"));
             Parent parent = loader.load();
             
             Stage stagep = new Stage();
             Scene scene = new Scene(parent);
             stage.setScene(scene);
             stage.setResizable(false);
             stage.show();
             stageprev.close();
         } catch (IOException ex) {
             Logger.getLogger(MotDePasseOublieController.class.getName()).log(Level.SEVERE, null, ex);
         }
        });
    }

    @FXML
    private void disableAlert(MouseEvent event) {
        buttonError.setVisible(false);
    }

    @FXML
    private void CreeAc(ActionEvent event) {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == buttonCree) {
            stage = (Stage) buttonCree.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("Register.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Register");
            stage.show();
        }
    }

}
