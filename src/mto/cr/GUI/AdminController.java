/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import mto.cr.DAO.Classe.AdministrateurDAO;
import mto.cr.DAO.Classe.ProblemeDAO;

import static mto.cr.GUI.ProfilsController.selected;
import mto.cr.Model.Probleme;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author bouda
 */
public class AdminController implements Initializable {

    @FXML
    private Pane dropDownMenu;
    @FXML
    private Text varUsernameToolBar;
    @FXML
    private ImageView varPhotoProfilToolBar;
    @FXML
    private ImageView AccueilAdmin;
    @FXML
    private AnchorPane navList;
    @FXML
    private Pane menu;
    @FXML
    private Text AdminProjets;
    @FXML
    private AnchorPane navList1;
    @FXML
    private Pane menu1;
    @FXML
    private Text AdminProblemes;
    @FXML
    private AnchorPane navList2;
    @FXML
    private Pane menu2;
    @FXML
    private Text AdminUsers;
    @FXML
    private ListView<Probleme> listProbleme;
    @FXML

    int notification = 0;
    int notificationProjet = 0;
    ProblemeDAO problemeDAO = new ProblemeDAO();
    AdministrateurDAO adminDAO = new AdministrateurDAO();
    private ObservableList<Probleme> data;
    @FXML
    private Tab forumTab;
    @FXML
    private Tab projetTab;
    @FXML
    private TabPane tabNotification;
    final Image star1 = new Image("mto/cr/images/FilledStar.png");
    final Image starv = new Image("mto/cr/images/Star.png");
    final Image semiStar = new Image("mto/cr/images/semiStar.png");
    @FXML
    private Text notificationNumber;
    static int notifnum = 0;
    @FXML
    private AnchorPane navList3;
    @FXML
    private Pane menu3;
    @FXML
    private Text AdminExperience;

    public void afficherProbleme() {
        List<Probleme> problemes = new ArrayList<>();
        problemes = adminDAO.notificationProbleme();
        data = FXCollections.observableArrayList();
        data.addAll(problemes);
        listProbleme.setItems(data);

        try {
            listProbleme.setCellFactory(new Callback<ListView<Probleme>, ListCell<Probleme>>() {
                @Override
                public ListCell<Probleme> call(ListView<Probleme> ListViewProbleme) {
                    ListCell<Probleme> cell;
                    cell = new ListCell<Probleme>() {

                        @Override
                        protected void updateItem(Probleme t, boolean bln) {
                            super.updateItem(t, bln);
                            if (t != null) {

                                VBox vb = new VBox(10);
                                VBox vb4 = new VBox(10);
                                HBox hb = new HBox(20);
                                HBox hb1 = new HBox(5);
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
                                Label Titre = new Label(t.getTitre().toUpperCase());
                                Label Secteur = new Label("Secteur : " + t.getSecteur());

                                Label Date = new Label("Date : " + t.getDateProblem());
                                Label Etat = new Label("Etat : " + t.getEtatProbleme());
                                Label User = new Label(t.getUser().getUsername());
                                Text Conetenu = new Text("Contenue  : " + t.getContenu());
                                Conetenu.wrappingWidthProperty().set(350);
                                Button valider = new Button("Valider");
                                Button suprrimer = new Button("Supprimer");
                                valider.getStyleClass().add("buttonLogin");
                                getStyleClass().add("buttonLogin:hover");
                                suprrimer.getStyleClass().add("buttonLogin");
                                suprrimer.getStyleClass().add("buttonLogin:hover");
                                Titre.setFont(Font.font("System", 16));
                                Secteur.setFont(Font.font("System", 16));
                                Date.setFont(Font.font("System", 16));
                                Etat.setFont(Font.font("System", 16));
                             
                                User.setFont(Font.font("System", 16));

                                ImageView imgv = new ImageView();
                                imgv.setId(Integer.toString(t.getUser().getId()));
                                imgv.setStyle("-fx-padding: 10px;");

                                Image image;
                                try {
                                    String ss = "";

                                    if (t.getUser().getPath().startsWith("https://")) {
                                        ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/user.png").trim();
                                        image = new Image(t.getUser().getPath());
                                    } else {
                                        ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + t.getUser().getPath()).trim();
                                        File file = new File(ss);
                                        image = new Image(file.toURI().toURL().toString());
                                    }

                                    imgv.setFitHeight(110);
                                    imgv.setFitWidth(110);
                                    imgv.setStyle(".imageBackGroung");

                                    imgv.setImage(image);
                                } catch (MalformedURLException ex) {
                                    Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                suprrimer.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        problemeDAO.delete(t.getIdProbleme());
                                        afficherProbleme();
                                    }
                                });
                                
                               
                                valider.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        adminDAO.valider(t);

                                        afficherProbleme();
                                    }
                                });
                                if (t.getValide() == 1) {
                                    valider.setVisible(false);

                                }

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
                                hb1.getChildren().addAll(valider, suprrimer);
                                vb4.getChildren().addAll(Titre, hb1);
                                vb.getChildren().addAll(imgv, User);
                                vb2.getChildren().addAll(Secteur, Date);
                                vb3.getChildren().addAll(Etat, Conetenu);
                                hb.getChildren().addAll(vb1, vb, vb4, vb2, vb3);

                                setGraphic(hb);
                            }
                        }
                    };
                    return cell;

                }
            });
        } catch (Exception e) {
        }

    }

   

   
   



    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        afficherProbleme();
        notification = data.size();
        navList.setOnMouseEntered((MouseEvent event1) -> {
            TranslateTransition openNav = new TranslateTransition(new Duration(350), navList);
            openNav.setToX(175);
            openNav.play();
        });

        navList.setOnMouseExited((MouseEvent event1) -> {
            TranslateTransition closeNav = new TranslateTransition(new Duration(350), navList);
            closeNav.setToX(-1);
            closeNav.play();
        });
        //init
        TranslateTransition openNav1 = new TranslateTransition(new Duration(350), navList1);
        TranslateTransition closeNav1 = new TranslateTransition(new Duration(350), navList1);
        
        TranslateTransition openNav2 = new TranslateTransition(new Duration(350), navList2);
        TranslateTransition closeNav2 = new TranslateTransition(new Duration(350), navList2);
        
        TranslateTransition openNav3 = new TranslateTransition(new Duration(350), navList3);
        TranslateTransition closeNav3 = new TranslateTransition(new Duration(350), navList3);
        closeNav2.setToX(0);
        //closeNav2.play();
        closeNav1.setToX(0);
        //closeNav1.play();
        closeNav3.setToX(0);
        //closeNav2.play();


        navList2.setOnMouseEntered((MouseEvent event2) -> {

            openNav2.setToX(150);
            openNav2.play();
        });

        navList2.setOnMouseExited((MouseEvent event2) -> {

            closeNav2.setToX(-1);
            closeNav2.play();
        });

        navList1.setOnMouseEntered((MouseEvent event3) -> {

            //TranslateTransition openNav1 = new TranslateTransition(new Duration(350), navList1);
            openNav1.setToX(200);
            openNav1.play();
        });

        navList1.setOnMouseExited((MouseEvent event3) -> {

            closeNav1.setToX(-1);
            closeNav1.play();
        });
        //exp
        navList3.setOnMouseEntered((MouseEvent event1) -> {
            openNav3.setToX(200);
            openNav3.play();
        });

        navList3.setOnMouseExited((MouseEvent event1) -> {
            closeNav3.setToX(-(navList3.getWidth()) + 263);
            closeNav3.play();
        });
        
        menu3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) menu3.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_experience.fxml"));
                    Parent parent = loader.load();

                    Stage stagep = new Stage();
                    Scene scene = new Scene(parent);
                    stage.getIcons().add(new Image("/mto/cr/images/startup.png"));
                    scene.getStylesheets().add("/mto/cr/GUI/newCascadeStyleSheet.css");
                    scene.getStylesheets().add("/mto/cr/GUI/MTOCrowdRise.css");
                    stage.setScene(scene);
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                }
            }
        }
        );
        //end exp
        AccueilAdmin.setOnMouseEntered((MouseEvent event4) -> {
            TranslateTransition transTransition = TranslateTransitionBuilder.create()
                    .duration(new Duration(140))
                    .node(AccueilAdmin)
                    .toY(-3)
                    .interpolator(Interpolator.LINEAR)
                    .cycleCount(1).
                    onFinished(e -> {
                        TranslateTransition transTransition2 = TranslateTransitionBuilder.create()
                        .duration(new Duration(140))
                        .node(AccueilAdmin)
                        .toY(3)
                        .interpolator(Interpolator.LINEAR)
                        .cycleCount(1)
                        .build();
                        transTransition2.play();
                    })
                    .build();
            transTransition.play();
        });
        menu2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) menu2.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_user.fxml"));
                    Parent parent = loader.load();

                    Stage stagep = new Stage();
                    Scene scene = new Scene(parent);
                    stage.getIcons().add(new Image("/mto/cr/images/startup.png"));
                    scene.getStylesheets().add("/mto/cr/GUI/newCascadeStyleSheet.css");
                    scene.getStylesheets().add("/mto/cr/GUI/MTOCrowdRise.css");
                    stage.setScene(scene);
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                }
            }
        }
        );
        menu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) menu.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_projet.fxml"));
                    Parent parent = loader.load();

                    Stage stagep = new Stage();
                    Scene scene = new Scene(parent);
                    stage.getIcons().add(new Image("/mto/cr/images/startup.png"));
                    scene.getStylesheets().add("/mto/cr/GUI/newCascadeStyleSheet.css");
                    scene.getStylesheets().add("/mto/cr/GUI/MTOCrowdRise.css");
                    stage.setScene(scene);
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                }
            }
        }
        );

        menu1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) menu1.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_probleme.fxml"));
                    Parent parent = loader.load();

                    Stage stagep = new Stage();
                    Scene scene = new Scene(parent);
                    stage.getIcons().add(new Image("/mto/cr/images/startup.png"));
                    scene.getStylesheets().add("/mto/cr/GUI/newCascadeStyleSheet.css");
                    scene.getStylesheets().add("/mto/cr/GUI/MTOCrowdRise.css");
                    stage.setScene(scene);
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                }
            }
        }
        );

    }

}
