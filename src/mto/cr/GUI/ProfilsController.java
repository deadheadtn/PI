/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import mto.cr.DAO.Classe.UserDAO;
import mto.cr.Model.User;
import mto.cr.Technique.ConfigurationJava;

/**
 *
 * @author Chiheb
 */
public class ProfilsController implements Initializable {
    
    public static int selected;
    @FXML
    private Pane menu;
    @FXML
    private AnchorPane navList;

    @FXML
    private ListView<User> listProfils;

    private ObservableList<User> data;
    @FXML
    private ImageView home;
    @FXML
    private Pane menu1;
    @FXML
    private AnchorPane navList1;
    @FXML
    private Pane menu2;
    @FXML
    private AnchorPane navList2;
    @FXML
    private Pane dropDownMenu;
    @FXML
    private Pane MonProfilMenu;
    @FXML
    private Button buttonAccederMonProfil;
    @FXML
    private ImageView PhotoProfilMonProfil;
    @FXML
    private Text emailMonProfil;
 
    @FXML
    private Text varUsernameToolBar;
    @FXML
    private ImageView varPhotoProfilToolBar;
    @FXML
    private Text AccederProjets;
    @FXML
    private Text AccederProfils;
    @FXML
    private Text AccederForum;
    @FXML
    private Button deconnexion;
    @FXML
    private ScrollPane scrolP;
    @FXML
    private Text nomPrenomMonProfil;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // prepareSlideMenuAnimation();

        List<User> users = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        users = userDAO.getAll();
        data = FXCollections.observableArrayList();
        data.addAll(users);
        listProfils.setItems(data);
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
                    stage.setResizable(false);
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
                    stage.setResizable(false);
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                }
            }
        });
        
        AccederForum.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) AccederForum.getScene().getWindow();
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
        //deconnexion
        deconnexion.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {
                    UserDAO userDAO = new UserDAO();
                    userDAO.userDecoonnecte(LoginController.logged);
                    Stage stage = new Stage();
                    Stage stageprev = (Stage) deconnexion.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Logi"
                            + "ml"));
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
        
        

//*************************************************End Navigation*************************************************
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
        imgVi.setFitHeight(200);
        imgVi.setFitWidth(220);
        imgVi.setStyle(".imageBackGroung");
        PhotoProfilMonProfil.setImage(image1);
        varPhotoProfilToolBar.setImage(image1);
        imgVi.setImage(image1);
        //
        listProfils.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> ListViewProfils) {
                ListCell<User> cell;
                cell = new ListCell<User>() {

                    @Override
                    protected void updateItem(User t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {

                            VBox vb = new VBox(10);
                            HBox hb = new HBox(20);
                            VBox vb1 = new VBox(20);
                            VBox vb3 = new VBox(20);
                            vb1.getChildren().add(new Label("               "));
                            hb.setStyle("-fx-border-color: #C8C8C8 ;");
                            vb.setAlignment(Pos.CENTER);
                            VBox vb2 = new VBox(20);
                            vb.setAlignment(Pos.CENTER);
                            //vb.setStyle("-fx-background-radius: 10;");
                            vb2.setAlignment(Pos.BASELINE_LEFT);

                            //vb2.setStyle("-fx-background-radius: 10;");
                            Label username = new Label(t.getUsername_canonical().toUpperCase());
                            Label email = new Label("Email : " + t.getEmail());

                            Label nom = new Label("Nom " + t.getNom());
                            Label prenom = new Label("Prenom : " + t.getPrenom());
                            Label pays = new Label("Pays : " + t.getPaysnatal());
                            Label secteur = new Label("Secteur : " + t.getSecteur());
                            Label sitProf = new Label("Situation Professionel : " + t.getSituationprof());

                            email.setFont(Font.font("System", 16));
                            username.setFont(Font.font("System", 16));
                            nom.setFont(Font.font("System", 16));
                            prenom.setFont(Font.font("System", 16));
                            secteur.setFont(Font.font("System", 16));
                            sitProf.setFont(Font.font("System", 16));
                            pays.setFont(Font.font("System", 16));

                            ImageView imgv = new ImageView();
                            imgv.setId(Integer.toString(t.getId()));
                            imgv.setStyle("-fx-padding: 10px;");

                            Image image;

                            String ss = "";

                            if (t.getPath().startsWith("https://")) {
                                ss = t.getPath().trim();
                            } else {
                                ss = (ConfigurationJava.profilsPath + t.getPath()).trim();

                            }
                            image = new Image(ss);
                            imgv.setFitHeight(110);
                            imgv.setFitWidth(110);
                            imgv.setStyle(".imageBackGroung");

                            imgv.setImage(image);

                            imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                public void handle(MouseEvent event) {
                                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                    try {
                                        selected = Integer.parseInt(imgv.getId());
                                        Stage stage = new Stage();
                                        Stage stageprev = (Stage) imgv.getScene().getWindow();

                                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilExterieur.fxml"));
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
                            vb.getChildren().addAll(imgv, username);
                            vb2.getChildren().addAll(email, nom, prenom);
                            vb3.getChildren().addAll(pays, sitProf, secteur);
                            hb.getChildren().addAll(vb1, vb, vb2, vb3);

                            setGraphic(hb);
                        }
                    }
                };
                return cell;
            }
        });

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
    private void EnterProfileAc(MouseEvent event) throws IOException {

    }

}
