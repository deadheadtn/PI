/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import mto.cr.Model.Upload;
import mto.cr.DAO.Classe.UserDAO;
import static mto.cr.GUI.LoginController.logged;
import mto.cr.Model.User;
import mto.cr.Technique.ConfigurationJava;

/**
 *
 * @author Chiheb
 */
public class ModifierProfilController implements Initializable{
    @FXML
    private Pane MonProfilMenu;
    @FXML
    private Button buttonAccederMonProfil;
    @FXML
    private ImageView PhotoProfilMonProfil;
    @FXML
    private Text emailMonProfil;
    @FXML
    private Text soldeMonProfil;
    @FXML
    private Pane dropDownMenu;
    @FXML
    private Text varUsernameToolBar;
    @FXML
    private ImageView varPhotoProfilToolBar;
    @FXML
    private ImageView home;
    @FXML
    private AnchorPane navList;
    @FXML
    private Pane menu;
    @FXML
    private Text AccederProjets;
    @FXML
    private AnchorPane navList1;
    @FXML
    private Pane menu1;
    @FXML
    private Text AccederProfils;
    @FXML
    private AnchorPane navList2;
    @FXML
    private Pane menu2;
    @FXML
    private Text AccederForum;
    @FXML
    private RadioButton sexeMen;
    @FXML
    private MenuButton secteur;
    @FXML
    private MenuButton pays;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField sitProf;
    private TextField username;
    @FXML
    private DatePicker dateNaissance;
    User u = new User();
    UserDAO userDAO = new UserDAO();
    @FXML
    private ToggleGroup sexeGroupe;
    @FXML
    private RadioButton sexeWoman;
    @FXML
    private MenuItem informatiqueMenuId;
    @FXML
    private Button buttonEnregistrer;
    @FXML
    private Button photoProfil;
    @FXML
    private Button deconnexion;
    
    private FileChooser.ExtensionFilter extFilterJPG;
    private FileChooser.ExtensionFilter extFilterjpg;
    private FileChooser.ExtensionFilter extFilterJPEG;
    private FileChooser.ExtensionFilter extFilterjpeg;
    private FileChooser.ExtensionFilter extFilterPNG;
    private FileChooser.ExtensionFilter extFilterpng;
    private Upload up;
    private File file = new File("");
    @FXML
    private Text nomPrenomMonProfil;
    
    
    @FXML
    private void EnterPanierAc(ActionEvent event) {
    }

    @FXML
    private void EnterSoldeAc(ActionEvent event) {
    }

    @FXML
    private void EnterExperienceAc(ActionEvent event) {
    }

    @FXML
    private void EnterCommentairesAc(ActionEvent event) {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        java.util.Date input = new Date();
        input = LoginController.logged.getDatenaissance();
        //LocalDate localD = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localD1 = Instant.ofEpochMilli(input.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        
        dateNaissance.setValue(LocalDate.of(localD1.getYear(), localD1.getMonthValue(), localD1.getDayOfMonth()));
        nom.setText(LoginController.logged.getNom());
        prenom.setText(LoginController.logged.getPrenom());
        sitProf.setText(LoginController.logged.getSituationprof());
        
        sexeMen.setSelected(true);
        nomPrenomMonProfil.setText(LoginController.logged.getNom().toUpperCase() + " " + LoginController.logged.getPrenom());
        emailMonProfil.setText(LoginController.logged.getEmail_canonical());
        soldeMonProfil.setText(Integer.toString(LoginController.logged.getSolde()));
        varUsernameToolBar.setText(LoginController.logged.getUsername_canonical());
        //upload
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
                    .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
            up = new Upload();
            file = fileChooser.showOpenDialog(null);
            
        });
        //end upload
        
        Image image2;
        String mm = "";

        if (LoginController.logged.getPath().startsWith("https://")) {
            mm = LoginController.logged.getPath().trim();
        } else {
            mm = (ConfigurationJava.profilsPath + LoginController.logged.getPath()).trim();
        }
            image2 = new Image(mm);
            varPhotoProfilToolBar.setImage(image2);
            PhotoProfilMonProfil.setImage(image2);

            String sexeToSet = "";
            if (sexeMen.isSelected())
                u.setSexe("male");
            else 
                u.setSexe("Femelle");
    //*************************************************Navigation*************************************************    
     AccederProfils.setOnMouseClicked((MouseEvent event) -> {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
             
             Stage stage = new Stage();
             Stage stageprev = (Stage) AccederProfils.getScene().getWindow();
             
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Profils.fxml"));
             Parent parent = loader.load();
             
             Stage stagep = new Stage();
             Scene scene = new Scene(parent);
             stage.setScene(scene);
             stage.show();
             stageprev.close();
         } catch (IOException ex) {
             Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
         }
        });
          AccederForum.setOnMouseClicked((MouseEvent event) -> {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
             
             Stage stage = new Stage();
             Stage stageprev = (Stage) AccederForum.getScene().getWindow();
             
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Profils.fxml"));
             Parent parent = loader.load();
             
             Stage stagep = new Stage();
             Scene scene = new Scene(parent);
             stage.setScene(scene);
             stage.show();
             stageprev.close();
         } catch (IOException ex) {
             Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
         }
        });
        AccederProjets.setOnMouseClicked((MouseEvent event) -> {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            try {
                
                Stage stage = new Stage();
                Stage stageprev = (Stage) AccederProjets.getScene().getWindow();
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherProjetEnFinancement.fxml"));
                Parent parent = loader.load();
                
                Stage stagep = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
                stageprev.close();
            } catch (IOException ex) {
            }
        });
        buttonAccederMonProfil.setOnMouseClicked((MouseEvent event) -> {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    try {
                        
                        Stage stage = new Stage();
                        Stage stageprev = (Stage) buttonAccederMonProfil.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("MonProfil.fxml"));
                        Parent parent = loader.load();
                        
                        Stage stagep = new Stage();
                        Scene scene = new Scene(parent);
                        stage.setScene(scene);
                        stage.show();
                        stageprev.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MonProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });
        deconnexion.setOnMouseClicked((MouseEvent event) -> {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    try {
                        UserDAO userDAO = new UserDAO();
                        userDAO.userDecoonnecte(LoginController.logged);
                        Stage stage = new Stage();
                        Stage stageprev = (Stage) deconnexion.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
                        Parent parent = loader.load();
                        
                        Stage stagep = new Stage();
                        Scene scene = new Scene(parent);
                        stage.setScene(scene);
                        stage.show();
                        stageprev.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MonProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });
    //*********************************************End Navigation*************************************************
    
//**********************************************Effects ******************************************************
                navList.setOnMouseEntered((MouseEvent event1) -> {
            TranslateTransition openNav = new TranslateTransition(new Duration(350), navList);
            openNav.setToX(0);
            openNav.play();
        });

        navList.setOnMouseExited((MouseEvent event1) -> {
            TranslateTransition closeNav = new TranslateTransition(new Duration(350), navList);
            closeNav.setToX(-(navList.getWidth()) + 78);
            closeNav.play();
        });
        //init
        TranslateTransition openNav1 = new TranslateTransition(new Duration(350), navList1);
        TranslateTransition closeNav1 = new TranslateTransition(new Duration(350), navList1);
        TranslateTransition openNav2 = new TranslateTransition(new Duration(350), navList2);
        TranslateTransition closeNav2 = new TranslateTransition(new Duration(350), navList2);
        closeNav2.setToX(0);
        //closeNav2.play();
        closeNav1.setToX(0);
        //closeNav1.play();

        navList2.setOnMouseEntered((MouseEvent event2) -> {

            openNav2.setToX(0);
            openNav2.play();
        });

        navList2.setOnMouseExited((MouseEvent event2) -> {

            closeNav2.setToX(-(navList2.getWidth()) + 78);
            closeNav2.play();
        });

        navList1.setOnMouseEntered((MouseEvent event3) -> {

            //TranslateTransition openNav1 = new TranslateTransition(new Duration(350), navList1);
            openNav1.setToX(0);
            openNav1.play();
        });

        navList1.setOnMouseExited((MouseEvent event3) -> {

            closeNav1.setToX(-(navList1.getWidth()) + 79);
            closeNav1.play();
        });

        home.setOnMouseEntered((MouseEvent event4) -> {
            TranslateTransition transTransition = TranslateTransitionBuilder.create()
                    .duration(new Duration(140))
                    .node(home)
                    .toY(-3)
                    .interpolator(Interpolator.LINEAR)
                    .cycleCount(1).
                    onFinished(e -> {
                        TranslateTransition transTransition2 = TranslateTransitionBuilder.create()
                        .duration(new Duration(140))
                        .node(home)
                        .toY(3)
                        .interpolator(Interpolator.LINEAR)
                        .cycleCount(1)
                        .build();
                        transTransition2.play();
                    })
                    .build();
            transTransition.play();
        });
        home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) home.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AcceuilUser.fxml"));
                    Parent parent = loader.load();
                    Stage stagep = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                    Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //
        MonProfilMenu.setLayoutY(90);
        TranslateTransition openNavi = new TranslateTransition(new Duration(450), MonProfilMenu);
        TranslateTransition closeNavi = new TranslateTransition(new Duration(450), MonProfilMenu);
        //closeNavi.setToY(0);
        closeNavi.play();
        //closeNav1.play();
        dropDownMenu.setOnMouseClicked((MouseEvent event60) -> {
            openNavi.setToY(0);
            openNavi.play();
        });

        MonProfilMenu.setOnMouseExited((MouseEvent event60) -> {

            closeNavi.setToY(-(MonProfilMenu.getHeight()));
            closeNavi.play();
        });

    //*******************************************End Effects ******************************************************
    }

    @FXML
    private void registerAction(ActionEvent event) throws IOException {

        u.setEmail_canonical(LoginController.logged.getEmail_canonical());
        u.setNom(nom.getText());
        u.setPrenom(prenom.getText());
        u.setSituationprof(sitProf.getText());
        //date
        java.util.Date date = new Date();
        LocalDate localDate;
        Instant instant;
        //date picker
        localDate = dateNaissance.getValue();
            if (localDate != null ) {
            instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            date = Date.from(instant);
        }
        u.setSecteur(secteur.getText());
        u.setPaysnatal(pays.getText());
        u.setDatenaissance(date);
        LoginController.logged.setDatenaissance(date);
        //end date
        if (file.isFile()){
            up.upload(file,"profils");
            u.setPath(file.getName());
        }
        userDAO.update(u);
//        LoginController.logged.setNom(nom.getText());
//        LoginController.logged.setPrenom(prenom.getText());
//        LoginController.logged.setSituationprof(sitProf.getText());
        logged = userDAO.getByUsername(logged.getUsername_canonical());

        
        
        
        
        try {
        Stage stage = new Stage();
        Stage stageprev = (Stage) buttonAccederMonProfil.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MonProfil.fxml"));
        Parent parent = loader.load();
        Stage stagep = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
        stageprev.close();
        } catch (IOException ex) {
        Logger.getLogger(MonProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void secteurMenu(ActionEvent event) {
    }

    @FXML
    private void paysMenu(ActionEvent event) {
    }


}
