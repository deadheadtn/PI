/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

import mto.cr.DAO.Classe.UserDAO;
import static mto.cr.GUI.ProfilsController.selected;
import mto.cr.Model.CommentaireProbleme;
import mto.cr.Model.User;
import mto.cr.Technique.ConfigurationJava;

/**
 *
 * @author Chiheb
 */
public class ProfilExterieurController implements Initializable {


    @FXML
    private Label varNomPrenom;
    @FXML
    private Label varDataNaissance;
    @FXML
    private Label varSituationProfessionnel;
    @FXML
    private Label varExpTot;
    @FXML
    private Label varSecteurActivite;
    @FXML
    private Label varDomaine;
    @FXML
    private Label varSecteurGeograph;
    @FXML
    private Label varNbrVotes;
    @FXML
    private Label varNbrProjetsSuivis;
    @FXML
    private Label varNbrCommentaires;
    @FXML
    private Label varNbrFinancement;
    @FXML
    private Label varEmailHaut;
    @FXML
    private Label varNomHaut;
    @FXML
    private AnchorPane GlobalAnchorID;
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
    private AnchorPane navList1;
    @FXML
    private Pane menu1;
    @FXML
    private AnchorPane navList2;
    @FXML
    private Pane menu2;
    @FXML
    private Text AccederProjets;
    @FXML
    private Text AccederProfils;
    @FXML
    private Text AccederForum;
    @FXML
    private Text nbrVotePageExp;
    @FXML
    private Text nbrProjSuivisPageExp;
    @FXML
    private Text nbeCommPageExp;
    @FXML
    private Text nbrFinancementPageExp;
    @FXML
    private ImageView photoProfilPageExp;
    @FXML
    private Text nomPrenomPageExp;
    @FXML
    private Text emailPageExp;

    @FXML
    private Button erreurExperience;
    @FXML
    private ListView<CommentaireProbleme> listCommentaires;
    @FXML
    private Button deconnexion;
    @FXML
    private Text nomPrenomMonProfil;
    @FXML
    private ImageView photoProfil;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        int selection = ProfilsController.selected;
        User user = new User();
        UserDAO userDAO = new UserDAO();
        User userProfil = userDAO.getById(selection);
      
        erreurExperience.setVisible(false);
//*************************************************Remplissage de la liste ***********************************
        erreurExperience.setOnMouseClicked(new EventHandler<MouseEvent>() {
            String erreur = "";

            public void handle(MouseEvent event) {
                erreurExperience.setVisible(false);

            }
        });
//*************************************************Navigation*************************************************
        AccederProfils.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
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
            }
        });
        
                AccederForum.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
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
            }
        });
        AccederProjets.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
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
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                    Logger.getLogger(MonProfilController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

//*************************************************End Navigation*************************************************
        String ss = "";

        Image image;
            if (userProfil.getPath().startsWith("https://")) {
                image = new Image(userProfil.getPath());
            } else {
                ss = (ConfigurationJava.profilsPath + userProfil.getPath()).trim();
                image = new Image(ss);
            }

            photoProfil.setImage(image);


        String mm = "";
        
        if (LoginController.logged.getPath().startsWith("https://")) {
            mm = LoginController.logged.getPath().trim();
        } else {
            mm = (ConfigurationJava.profilsPath + LoginController.logged.getPath()).trim();
        }
            Image image2 = new Image(mm);
            varPhotoProfilToolBar.setImage(image2);
            PhotoProfilMonProfil.setImage(image2);


        varNomPrenom.setText(userProfil.getNom().toUpperCase().trim() + " " + userProfil.getPrenom().trim());
        String domaine = "";
      
        varDomaine.setText(domaine);

        // date
        Calendar c = Calendar.getInstance();
        java.util.Date d = c.getTime();
        java.sql.Date dd;
        if (userProfil.getDatenaissance() != null) {
            dd = (Date) userProfil.getDatenaissance();
            // end date
            varDataNaissance.setText(dd.toString());
        }

        varSituationProfessionnel.setText(userProfil.getSituationprof());
        varExpTot.setText(Integer.toString(userProfil.getExperiencetot()));
        varSecteurActivite.setText(userProfil.getSecteur());
        // page experiences
        nbrVotePageExp.setText(Integer.toString(userProfil.getNbrVote()));
        nbrProjSuivisPageExp.setText(Integer.toString(userProfil.getNbrprojetssuivis()));
        nbeCommPageExp.setText(Integer.toString(userProfil.getNbrcommentaire()));
        nbrFinancementPageExp.setText(Integer.toString(userProfil.getNbrfinancement()));

        nomPrenomPageExp.setText(userProfil.getNom().toUpperCase() + " " + userProfil.getPrenom());
        emailPageExp.setText(userProfil.getEmail_canonical());
        mm = "";

        Image image3;

            if (userProfil.getPath().startsWith("https://")) {
                image3 = new Image(userProfil.getPath());
            } else {
                ss = (ConfigurationJava.profilsPath + userProfil.getPath()).trim();
                
                image3 = new Image(ss);
            }

            photoProfilPageExp.setImage(image3);


        // end page experiences
        String init = "";
     
        varSecteurGeograph.setText(userProfil.getPaysnatal());

        varNbrVotes.setText(Integer.toString(userProfil.getNbrVote()));
        varNbrProjetsSuivis.setText(Integer.toString(userProfil.getNbrprojetssuivis()));
        varNbrFinancement.setText(Integer.toString(userProfil.getNbrfinancement()));
        varNbrCommentaires.setText(Integer.toString(userProfil.getNbrcommentaire()));

        varEmailHaut.setText(userProfil.getEmail_canonical());
        emailPageExp.setText(userProfil.getEmail_canonical());
        varNomHaut.setText(userProfil.getNom().toUpperCase() + " " + userProfil.getPrenom());

        nomPrenomMonProfil.setText(LoginController.logged.getNom().toUpperCase() + " " + LoginController.logged.getPrenom());

        emailMonProfil.setText(LoginController.logged.getEmail_canonical());
        soldeMonProfil.setText(Integer.toString(LoginController.logged.getSolde()));

        varUsernameToolBar.setText(LoginController.logged.getUsername_canonical());
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

    }

    @FXML
    private void EnterProfileAc(ActionEvent event) {
    }

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

}
