/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mto.cr.Model.Upload;
import mto.cr.DAO.Classe.UserDAO;
import mto.cr.Model.User;

/**
 *
 * @author Chiheb
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField email;
    private RadioButton sexe;
    @FXML
    private MenuButton secteur;
    @FXML
    private MenuButton pays;
    @FXML
    private Button buttonEnregistrer;
    @FXML
    private Button photoProfil;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField sitProf;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField rePassword;
    @FXML
    private DatePicker dateNaissance = null;
    @FXML
    private MenuItem informatiqueMenuId;
    @FXML
    private RadioButton sexeMen;
    @FXML
    private ToggleGroup sexeGroupe;
    @FXML
    private RadioButton sexeWoman;
    @FXML
    private Button buttonLogin;
    
    private FileChooser.ExtensionFilter extFilterJPG;
    private FileChooser.ExtensionFilter extFilterjpg;
    private FileChooser.ExtensionFilter extFilterJPEG;
    private FileChooser.ExtensionFilter extFilterjpeg;
    private FileChooser.ExtensionFilter extFilterPNG;
    private FileChooser.ExtensionFilter extFilterpng;
    private Upload up;
    private File file = new File("");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        photoProfil.setOnMouseClicked((MouseEvent event1) -> {
            FileChooser fileChooser = new FileChooser();
              
            //Set extension filter
            extFilterJPG = 
                    new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
            extFilterjpg = 
                    new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
            extFilterjpeg = 
                    new FileChooser.ExtensionFilter("jpg files (*.JPEG)", "*.JPEG");
            extFilterJPEG = 
                    new FileChooser.ExtensionFilter("jpg files (*.jpeg)", "*.jpeg");
            extFilterPNG = 
                    new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
            extFilterpng = 
                    new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
            
            fileChooser.getExtensionFilters()
                    .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng,extFilterjpeg,extFilterJPEG);
            up = new Upload();
            file = fileChooser.showOpenDialog(null);
            
        });
    }

    @FXML
    private void registerAction(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;
        String error;
        boolean verif;
        UserDAO userDAO = new UserDAO();
        User user = new User();
        ResultSet res;
        PreparedStatement ps;
        LocalDate localDate;
        Date date;
        Instant instant;
        String kk;
        sexeMen.setSelected(true);
        if (event.getSource() == buttonEnregistrer) {
            date = new Date();
            //date picker
            localDate = dateNaissance.getValue();
            if (localDate != null ) {
            instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            date = Date.from(instant);
            }

            //data to set
            if (sexeMen.isSelected())
                user.setSexe("Male");
            else 
                user.setSexe("Femelle");
            
            secteur.getText();
            user.setEmail(email.getText());
            user.setEmail_canonical(email.getText().toLowerCase().trim());
            user.setUsername(username.getText());
            user.setUsername_canonical(username.getText().toLowerCase().trim());
            user.setPassword(password.getText());
            user.setDatenaissance(date);
            user.setSituationprof(sitProf.getText());
            user.setNom(nom.getText());
            user.setPrenom(prenom.getText());
            user.setPaysnatal(pays.getText());
            user.setSecteur(secteur.getText());
            user.setSalt("");
            user.setNbrVote(0);
            user.setCredentials_expired(0);
            user.setNbrcommentaire(0);
            user.setNbrfinancement(0);
            user.setNbrprojetssuivis(0);
            user.setRole("user");
            user.setEtat("actif");
            // passage page

            
            //
            username.setOnMouseClicked((MouseEvent event1) -> {
                username.setStyle("-fx-text-box-border: transparent;");
                username.clear();
            });
            password.setOnMouseClicked((MouseEvent event1) -> {
                password.setStyle("-fx-text-box-border: transparent;");
                rePassword.setStyle("-fx-text-box-border: transparent;");
                password.clear();
                rePassword.clear();
            });
            email.setOnMouseClicked((MouseEvent event1) -> {
                email.setStyle("-fx-text-box-border: transparent;");
                email.clear();
            });
                // end effects

                if (        email.getText().isEmpty() 
                        || !email.getText().contains("@") 
                        || !email.getText().contains(".") 
                      //  || email.getText().indexOf("@", 0) > email.getText().indexOf(".", 0) 
                        || email.getText().indexOf("#", 0) >= 0
                        || email.getText().indexOf("&", 0) >= 0
                        || email.getText().indexOf("(", 0) >= 0
                        || email.getText().length() - email.getText().replace("@", "").length() > 1
                    //    || email.getText().length() - email.getText().replace(".", "").length() > 1
                        || email.getText().indexOf("§", 0) >= 0
                        || email.getText().indexOf("!", 0) >= 0
                        || email.getText().indexOf("ç", 0) >= 0
                        || email.getText().indexOf("à", 0) >= 0
                        || email.getText().indexOf("é", 0) >= 0
                        || email.getText().indexOf(")", 0) >= 0
                        || email.getText().indexOf("{", 0) >= 0
                        || email.getText().indexOf("}", 0) >= 0
                        || email.getText().indexOf("|", 0) >= 0
                        || email.getText().indexOf("$", 0) >= 0
                        || email.getText().indexOf("*", 0) >= 0
                        || email.getText().indexOf("€", 0) >= 0
                        || email.getText().indexOf("`", 0) >= 0
                        || email.getText().indexOf("\'", 0) >= 0
                        || email.getText().indexOf("\"", 0) >= 0
                        || email.getText().indexOf("%", 0) >= 0
                        || email.getText().indexOf("+", 0) >= 0
                        || email.getText().indexOf("=", 0) >= 0
                        || email.getText().indexOf("/", 0) >= 0
                        || email.getText().indexOf("\\", 0) >= 0
                        || email.getText().indexOf(":", 0) >= 0
                        || email.getText().indexOf(",", 0) >= 0
                        || email.getText().indexOf("?", 0) >= 0
                        || email.getText().indexOf(";", 0) >= 0
                        || email.getText().indexOf("°", 0) >= 0
                        || email.getText().indexOf("<", 0) >= 0
                        || email.getText().indexOf(">", 0) >= 0) 
                {
                    email.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
                else if (userDAO.getByUsername(username.getText().toLowerCase().trim()).getId() > 0 || username.getText().isEmpty()) {
                    username.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                } 
                else if (rePassword.getText().equals(password.getText()) == false || password.getText().isEmpty()) {
                    password.setStyle("-fx-text-box-border: #f44336;");
                    rePassword.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
                else if( nom.getText().isEmpty() ){
                    nom.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
                else if( prenom.getText().isEmpty() ){
                    prenom.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
                else if( sitProf.getText().isEmpty()){
                    sitProf.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
                else if( dateNaissance.getValue() == null ){
                    dateNaissance.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
//                else if ( file.exists() ){
//                    photoProfil.setStyle("-fx-text-box-border: #f44336;");
//                    verif = false;
//                }
                else {
                    if (file.isFile()){
                    up.upload(file,"profils");
                    user.setPath(file.getName());
                    }
                    userDAO.ajouter(user);
                    LoginController.logged = userDAO.getByUsername(user.getUsername_canonical());
                    System.out.println("++++++ user : " + LoginController.logged.getUsername_canonical() + " persisted ++++++");
                                    stage = (Stage) buttonEnregistrer.getScene().getWindow();
                try {
                    root = FXMLLoader.load(getClass().getResource("Profils.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Profils");
                    stage.setResizable(false);
                    stage.show();

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }    
                }
                
//****************************************** passage Profils ******************************************
                

        }
    }

    @FXML
    private void secteurMenu(ActionEvent event) {
    }

    @FXML
    private void paysMenu(ActionEvent event) {
    }

    @FXML
    private void informatiqueAc(ActionEvent event) {
        secteur.setText("informatique");
    }

    @FXML
    private void AgricultureAc(ActionEvent event) {
        secteur.setText("agriculture");
    }
    private void mecaniqueAc(ActionEvent event) {
        secteur.setText("Mecanique");
    }

    private void ArchitectureAc(ActionEvent event) {
        secteur.setText("architecture");
    }

    @FXML
    private void TunisieAc(ActionEvent event) {
        pays.setText("Tunisie");
    }

    @FXML
    private void FranceAc(ActionEvent event) {
        pays.setText("France");
    }

    @FXML
    private void AllemagneAc(ActionEvent event) {
        pays.setText("Allemagne");
    }

    @FXML
    private void commerceAc(ActionEvent event) {
        secteur.setText("Commerce");
    }

    @FXML
    private void marketingAc(ActionEvent event) {
        secteur.setText("Marketing");
        
    }

    @FXML
    private void gestionAc(ActionEvent event) {
        secteur.setText("Gestion");
    }

    @FXML
    private void usaAc(ActionEvent event) {
        pays.setText("USA");
    }

    @FXML
    private void RussieAc(ActionEvent event) {
    pays.setText("Russia");
    }

    @FXML
    private void LoginAc(MouseEvent event) {
                Stage stage = null;
        Parent root = null;
        if (event.getSource() == buttonLogin) {
            stage = (Stage) buttonLogin.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.setResizable(false);
            stage.show();
        }
    }


    
}
