/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.GUI;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import mto.cr.DAO.Classe.UserDAO;
import mto.cr.Technique.ConfigurationJava;

/**
 *
 * @author Chiheb
 */
public class AcceuilController implements Initializable {

    @FXML
    private Pane MonProfilMenu;
    @FXML
    private Button buttonAccederMonProfil;
    @FXML
    private Button deconnexion;
    @FXML
    private Pane dropDownMenu;
    @FXML
    private ImageView PhotoProfilMonProfil;
    @FXML
    private Text nomPrenomMonProfil;
    @FXML
    private Text emailMonProfil;
    @FXML
    private Text soldeMonProfil;
    @FXML
    private Text varUsernameToolBar;
    @FXML
    private ImageView varPhotoProfilToolBar;
    @FXML
    private ImageView home;
    @FXML
    private ImageView AccederProjets;
    @FXML
    private ImageView AccederProfils;
    @FXML
    private ImageView AccederForum;
    @FXML
    private ImageView photoCrowdFunding;
    @FXML
    private ImageView photoCrowdSourcing;
    @FXML
    private Pane paneProfils;
    @FXML
    private ImageView photoCrowdProfils;
    @FXML
    private Pane paneCrowdFunding;
    @FXML
    private Pane paneCrowdSourcing;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    //**************************************** Navigation ************************************************   
        paneCrowdFunding.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) paneCrowdFunding.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherProjetEnFinancement.fxml"));
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
        paneCrowdSourcing.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) paneCrowdSourcing.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("forum.fxml"));
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
        paneProfils.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) paneProfils.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Profils.fxml"));
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
        buttonAccederMonProfil.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) buttonAccederMonProfil.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("MonProfil.fxml"));
                    Parent parent = loader.load();

                    Stage stagep = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                    Logger.getLogger(MonProfilController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        deconnexion.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
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
                    stage.setResizable(false);
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                    Logger.getLogger(MonProfilController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    //**************************************** Effects ************************************************
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
        photoCrowdFunding.setOnMouseEntered((MouseEvent event4) -> {
            TranslateTransition transTransition = TranslateTransitionBuilder.create()
                    .duration(new Duration(150))
                    .node(photoCrowdFunding)
                    .toY(-10)
                    .interpolator(Interpolator.LINEAR)
                    .cycleCount(1).
                    onFinished(e -> {
                        TranslateTransition transTransition2 = TranslateTransitionBuilder.create()
                        .duration(new Duration(150))
                        .node(photoCrowdFunding)
                        .toY(10)
                        .interpolator(Interpolator.LINEAR)
                        .cycleCount(1)
                        .build();
                        transTransition2.play();
                    })
                    .build();
            transTransition.play();
        }); 
        photoCrowdSourcing.setOnMouseEntered((MouseEvent event4) -> {
            TranslateTransition transTransition = TranslateTransitionBuilder.create()
                    .duration(new Duration(150))
                    .node(photoCrowdSourcing)
                    .toY(-10)
                    .interpolator(Interpolator.LINEAR)
                    .cycleCount(1).
                    onFinished(e -> {
                        TranslateTransition transTransition2 = TranslateTransitionBuilder.create()
                        .duration(new Duration(150))
                        .node(photoCrowdSourcing)
                        .toY(10)
                        .interpolator(Interpolator.LINEAR)
                        .cycleCount(1)
                        .build();
                        transTransition2.play();
                    })
                    .build();
            transTransition.play();
        });  
        photoCrowdProfils.setOnMouseEntered((MouseEvent event4) -> {
            TranslateTransition transTransition = TranslateTransitionBuilder.create()
                    .duration(new Duration(150))
                    .node(photoCrowdProfils)
                    .toY(-10)
                    .interpolator(Interpolator.LINEAR)
                    .cycleCount(1).
                    onFinished(e -> {
                        TranslateTransition transTransition2 = TranslateTransitionBuilder.create()
                        .duration(new Duration(150))
                        .node(photoCrowdProfils)
                        .toY(10)
                        .interpolator(Interpolator.LINEAR)
                        .cycleCount(1)
                        .build();
                        transTransition2.play();
                    })
                    .build();
            transTransition.play();
        });  
        
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
        //vars
        nomPrenomMonProfil.setText(LoginController.logged.getNom().toUpperCase() + " " + LoginController.logged.getPrenom());
        emailMonProfil.setText(LoginController.logged.getEmail_canonical());
        varUsernameToolBar.setText(LoginController.logged.getUsername_canonical());

        ImageView imgVi = new ImageView();
        String mm = "";

        if (LoginController.logged.getPath().startsWith("https://")) {
            mm = LoginController.logged.getPath().trim();
        } else {
            mm = (ConfigurationJava.profilsPath + LoginController.logged.getPath()).trim();
        }

        Image image1;
        image1 = new Image(mm);
        PhotoProfilMonProfil.setImage(image1);
        varPhotoProfilToolBar.setImage(image1);
        
        
    } //init

}
