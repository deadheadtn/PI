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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
import mto.cr.DAO.Classe.AdministrateurDAO;
import mto.cr.DAO.Classe.UserDAO;
import static mto.cr.GUI.AdminController.notifnum;
import static mto.cr.GUI.ProfilsController.selected;

import mto.cr.Model.User;

/**
 *
 * @author bouda
 */
public class AdminUserController implements Initializable {

    @FXML
    private ListView<User> listProfils;
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
    private Text connecte;
    @FXML
    private AnchorPane navList1;
    @FXML
    private Pane menu1;
    @FXML
    private Text deconncte;
    private AnchorPane navList2;

    private ObservableList<User> data;
    AdministrateurDAO adminDAO = new AdministrateurDAO();
   
    @FXML
    private TextField searchText;
    @FXML
    private Pane searchButton;
    @FXML
    private Text notificationNumber;

    public void afficherTout() {
        AdministrateurDAO adminDAO = new AdministrateurDAO();
        List<User> users = new ArrayList<>();
        UserDAO u = new UserDAO();
        users = u.getAll();
        data = FXCollections.observableArrayList();
        data.addAll(users);
        listProfils.setItems(data);
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
                            Label stat = new Label("prob " + "PF  " + t.getNbrfinancement() + " PS " + t.getNbrprojetssuivis() + "PV " + t.getNbrVote());
                            Button desactiver = new Button();
                            Button activer = new Button();
                            Button supprimer = new Button("X");

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

                            Image Locked = new Image("mto/cr/images/lock2.png");
                            ImageView locker = new ImageView(Locked);
                            locker.setFitHeight(20);
                            locker.setFitWidth(20);
                            desactiver.setGraphic(locker);

                            Image UnLocked = new Image("mto/cr/images/unlock2.png");
                            ImageView Unlocker = new ImageView(UnLocked);
                            Unlocker.setFitHeight(20);
                            Unlocker.setFitWidth(20);
                            activer.setGraphic(Unlocker);
                            activer.getStyleClass().add("buttonLogin");
                            activer.getStyleClass().add("buttonLogin:hover");
                            desactiver.getStyleClass().add("buttonLogin");
                            desactiver.getStyleClass().add("buttonLogin:hover");
                            supprimer.getStyleClass().add("buttonLogin");
                            supprimer.getStyleClass().add("buttonLogin:hover");

                            supprimer.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        adminDAO.deleteById(t);
                                        afficherTout();
                                    } catch (Exception e) {
                                    }

                                }
                            });
                            desactiver.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {

                                        adminDAO.desactivation(t);

                                        afficherTout();
                                    } catch (Exception e) {
                                    }

                                }
                            });
                            activer.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {

                                        adminDAO.activation(t);
                                        afficherTout();
                                    } catch (Exception e) {
                                    }
                                }
                            });
                            Image image;
                            try {
                                String ss = "";

                                if (t.getPath().startsWith("https://")) {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/user.png").trim();
                                    image = new Image(t.getPath());
                                } else {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + t.getPath()).trim();
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
                            HBox hb2 = new HBox(20);
                            if (t.getLocked() == 1 && t.getEnabled() == 0) {
                                desactiver.setVisible(false);
                                activer.setVisible(true);
                                hb2.getChildren().add(activer);
                                hb2.getChildren().remove(desactiver);
                            } else {
                                activer.setVisible(false);
                                desactiver.setVisible(true);
                                hb2.getChildren().add(desactiver);
                                hb2.getChildren().remove(activer);

                            }
                            hb2.getChildren().add(supprimer);
                            vb.getChildren().addAll(imgv, username, hb2);
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

    }

    public void afficherConnecte() {
        AdministrateurDAO adminDAO = new AdministrateurDAO();
        notificationNumber.setText(notifnum + "");
        List<User> users = new ArrayList<>();

        users = adminDAO.userConnecte();
        data = FXCollections.observableArrayList();
        data.addAll(users);
        listProfils.setItems(data);
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
                            Label stat = new Label("prob " + "Cp :" + "PF  " + t.getNbrfinancement() + " PS " + t.getNbrprojetssuivis() + "PV " + t.getNbrVote());
                            Button desactiver = new Button();
                            Button activer = new Button();
                            Button supprimer = new Button("X");

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

                            Image Locked = new Image("mto/cr/images/lock2.png");
                            ImageView locker = new ImageView(Locked);
                            locker.setFitHeight(20);
                            locker.setFitWidth(20);
                            desactiver.setGraphic(locker);

                            Image UnLocked = new Image("mto/cr/images/unlock2.png");
                            ImageView Unlocker = new ImageView(UnLocked);
                            Unlocker.setFitHeight(20);
                            Unlocker.setFitWidth(20);
                            activer.setGraphic(Unlocker);
                            activer.getStyleClass().add("buttonLogin");
                            activer.getStyleClass().add("buttonLogin:hover");
                            desactiver.getStyleClass().add("buttonLogin");
                            desactiver.getStyleClass().add("buttonLogin:hover");
                            supprimer.getStyleClass().add("buttonLogin");
                            supprimer.getStyleClass().add("buttonLogin:hover");

                            supprimer.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        adminDAO.deleteById(t);
                                        afficherConnecte();
                                    } catch (Exception e) {
                                        Alert a = new Alert(Alert.AlertType.ERROR, "Ce utilisateur a des projets ");
                                        a.show();
                                    }

                                }
                            });
                            desactiver.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {

                                        adminDAO.desactivation(t);

                                        afficherConnecte();
                                    } catch (Exception e) {
                                    }

                                }
                            });
                            activer.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {

                                        adminDAO.activation(t);
                                        afficherConnecte();
                                    } catch (Exception e) {
                                    }
                                }
                            });
                            Image image;
                            try {
                                String ss = "";

                                if (t.getPath().startsWith("https://")) {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/user.png").trim();
                                    image = new Image(t.getPath());
                                } else {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + t.getPath()).trim();
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
                            HBox hb2 = new HBox(20);
                            if (t.getLocked() == 1 && t.getEnabled() == 0) {
                                desactiver.setVisible(false);
                                activer.setVisible(true);
                                hb2.getChildren().add(activer);
                                hb2.getChildren().remove(desactiver);
                            } else {
                                activer.setVisible(false);
                                desactiver.setVisible(true);
                                hb2.getChildren().add(desactiver);
                                hb2.getChildren().remove(activer);

                            }
                            hb2.getChildren().add(supprimer);
                            vb.getChildren().addAll(imgv, username, hb2);
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

    }

    public void ExperienceUser() {
        List<User> users = new ArrayList<>();

        UserDAO u = new UserDAO();
        users = u.getAll();
        data = FXCollections.observableArrayList();
        data.addAll(users);
        listProfils.setItems(data);
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

                            Button Promote = new Button("Promote");
                            Button unPromote = new Button("Unpromote");
                            Text experience = new Text();

                           
                            experience.setFont(Font.font("System", 16));

                            ImageView imgv = new ImageView();
                            imgv.setId(Integer.toString(t.getId()));
                            imgv.setStyle("-fx-padding: 10px;");

                            Promote.getStyleClass().add("buttonLogin");
                            Promote.getStyleClass().add("buttonLogin:hover");
                            unPromote.getStyleClass().add("buttonLogin");
                            unPromote.getStyleClass().add("buttonLogin:hover");

                            Promote.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        adminDAO.Promote(t);
                                        afficherConnecte();
                                    } catch (Exception e) {
                                        Alert a = new Alert(Alert.AlertType.ERROR, "Ce utilisateur a des projets ");
                                        a.show();
                                    }

                                }
                            });
                            unPromote.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        adminDAO.UnPromote(t);
                                        afficherConnecte();
                                    } catch (Exception e) {
                                        Alert a = new Alert(Alert.AlertType.ERROR, "Ce utilisateur a des projets ");
                                        a.show();
                                    }

                                }
                            });

                            Image image;
                            try {
                                String ss = "";

                                if (t.getPath().startsWith("https://")) {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/user.png").trim();
                                    image = new Image(t.getPath());
                                } else {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + t.getPath()).trim();
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
                            HBox hb2 = new HBox(20);
                            if (t.getRoles().equals("a:0:{}")) {
                                Promote.setVisible(true);
                                unPromote.setVisible(false);
                                hb2.getChildren().remove(unPromote);
                                hb2.getChildren().add(Promote);
                            } else if (t.getRoles().equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}")) {
                                Promote.setVisible(false);
                                unPromote.setVisible(true);
                                hb2.getChildren().remove(Promote);
                                hb2.getChildren().add(unPromote);
                            } else {
                                hb2.getChildren().removeAll(Promote, unPromote);
                            }

                            vb.getChildren().addAll(imgv, username, hb2);
                            vb2.getChildren().addAll(experience);

                            hb.getChildren().addAll(vb1, vb, vb2);

                            setGraphic(hb);
                        }
                    }
                };
                return cell;
            }
        });

    }

    public void afficherDeconnecte() {
        AdministrateurDAO adminDAO = new AdministrateurDAO();
        List<User> users = new ArrayList<>();

        users = adminDAO.userdeConnecte();
        data = FXCollections.observableArrayList();
        data.addAll(users);
        listProfils.setItems(data);
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
                            Label stat = new Label("prob " + "Cp :" + "PF  " + t.getNbrfinancement() + " PS " + t.getNbrprojetssuivis() + "PV " + t.getNbrVote());
                            Button desactiver = new Button();
                            Button activer = new Button();
                            Button supprimer = new Button("X");

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

                            Image Locked = new Image("mto/cr/images/lock2.png");
                            ImageView locker = new ImageView(Locked);
                            locker.setFitHeight(20);
                            locker.setFitWidth(20);
                            desactiver.setGraphic(locker);

                            Image UnLocked = new Image("mto/cr/images/unlock2.png");
                            ImageView Unlocker = new ImageView(UnLocked);
                            Unlocker.setFitHeight(20);
                            Unlocker.setFitWidth(20);
                            activer.setGraphic(Unlocker);
                            activer.getStyleClass().add("buttonLogin");
                            activer.getStyleClass().add("buttonLogin:hover");
                            desactiver.getStyleClass().add("buttonLogin");
                            desactiver.getStyleClass().add("buttonLogin:hover");
                            supprimer.getStyleClass().add("buttonLogin");
                            supprimer.getStyleClass().add("buttonLogin:hover");

                            supprimer.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        adminDAO.deleteById(t);
                                        afficherDeconnecte();
                                    } catch (Exception e) {
                                        Alert a = new Alert(Alert.AlertType.ERROR, "Ce utilisateur a des projets ");
                                        a.show();
                                    }

                                }
                            });
                            desactiver.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {

                                        adminDAO.desactivation(t);

                                        afficherDeconnecte();
                                    } catch (Exception e) {
                                    }

                                }
                            });
                            activer.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {

                                        adminDAO.activation(t);
                                        afficherDeconnecte();
                                    } catch (Exception e) {
                                    }
                                }
                            });
                            Image image;
                            try {
                                String ss = "";

                                if (t.getPath().startsWith("https://")) {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/user.png").trim();
                                    image = new Image(t.getPath());
                                } else {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + t.getPath()).trim();
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
                            HBox hb2 = new HBox(20);
                            if (t.getLocked() == 1 && t.getEnabled() == 0) {
                                desactiver.setVisible(false);
                                activer.setVisible(true);
                                hb2.getChildren().add(activer);
                                hb2.getChildren().remove(desactiver);
                            } else {
                                activer.setVisible(false);
                                desactiver.setVisible(true);
                                hb2.getChildren().add(desactiver);
                                hb2.getChildren().remove(activer);

                            }
                            hb2.getChildren().add(supprimer);
                            vb.getChildren().addAll(imgv, username, hb2);
                            vb2.getChildren().addAll(email, nom, prenom);
                            vb3.getChildren().addAll(pays, sitProf, secteur, stat);
                            hb.getChildren().addAll(vb1, vb, vb2, vb3);

                            setGraphic(hb);
                        }
                    }
                };
                return cell;
            }
        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ExperienceUser();
        menu1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                afficherDeconnecte();

            }
        });

        menu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                afficherConnecte();

            }
        });

        //init
        TranslateTransition openNav1 = new TranslateTransition(new Duration(350), navList1);
        TranslateTransition closeNav1 = new TranslateTransition(new Duration(350), navList1);
        TranslateTransition openNav = new TranslateTransition(new Duration(350), navList);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), navList);
        TranslateTransition openNav2 = new TranslateTransition(new Duration(350), navList2);
        TranslateTransition closeNav2 = new TranslateTransition(new Duration(350), navList2);
        closeNav2.setToX(0);
        //closeNav2.play();
        closeNav1.setToX(0);
        closeNav.setToX(0);
        //closeNav1.play();
        navList.setOnMouseEntered((MouseEvent event1) -> {

            openNav.setToX(0);
            openNav.play();
        });

        navList.setOnMouseExited((MouseEvent event1) -> {

            closeNav.setToX(-(navList.getWidth()) + 78);
            closeNav.play();
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
            @Override
            public void handle(MouseEvent event) {

                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) menu.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
                    Parent parent = loader.load();

                    Stage stagep = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.getIcons().add(new Image("/mto/cr/images/startup.png"));
                    scene.getStylesheets().add("/mto/cr/GUI/newCascadeStyleSheet.css");
                    scene.getStylesheets().add("/mto/cr/GUI/MTOCrowdRise.css");
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                }

            }
        });
       
    }

    @FXML
    private void rechercherUser(MouseEvent event) {
        List<User> users = new ArrayList<>();
        UserDAO u = new UserDAO();

        users.add(u.getByUsername(searchText.getText()));
        data = FXCollections.observableArrayList();
        data.addAll(users);
        listProfils.setItems(data);
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
                            Label stat = new Label("prob " + "Cp :" + t.getNbrfinancement() + " PS " + t.getNbrprojetssuivis() + "PV " + t.getNbrVote());
                            Button desactiver = new Button();
                            Button activer = new Button();
                            Button supprimer = new Button("X");

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

                            Image Locked = new Image("mto/cr/images/lock2.png");
                            ImageView locker = new ImageView(Locked);
                            locker.setFitHeight(20);
                            locker.setFitWidth(20);
                            desactiver.setGraphic(locker);

                            Image UnLocked = new Image("mto/cr/images/unlock2.png");
                            ImageView Unlocker = new ImageView(UnLocked);
                            Unlocker.setFitHeight(20);
                            Unlocker.setFitWidth(20);
                            activer.setGraphic(Unlocker);
                            activer.getStyleClass().add("buttonLogin");
                            activer.getStyleClass().add("buttonLogin:hover");
                            desactiver.getStyleClass().add("buttonLogin");
                            desactiver.getStyleClass().add("buttonLogin:hover");
                            supprimer.getStyleClass().add("buttonLogin");
                            supprimer.getStyleClass().add("buttonLogin:hover");

                            supprimer.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        adminDAO.deleteById(t);

                                        afficherTout();
                                    } catch (Exception e) {
                                        Alert a = new Alert(Alert.AlertType.ERROR, "Ce utilisateur a des projets ");
                                        a.show();

                                    }

                                }
                            });
                            desactiver.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {

                                        adminDAO.desactivation(t);

                                        afficherTout();
                                    } catch (Exception e) {
                                    }

                                }
                            });
                            activer.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {

                                        adminDAO.activation(t);
                                        afficherTout();
                                    } catch (Exception e) {
                                    }
                                }
                            });
                            Image image;
                            try {
                                String ss = "";

                                if (t.getPath().startsWith("https://")) {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/user.png").trim();
                                    image = new Image(t.getPath());
                                } else {
                                    ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + t.getPath()).trim();
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
                            HBox hb2 = new HBox(20);
                            if (t.getLocked() == 1 && t.getEnabled() == 0) {
                                desactiver.setVisible(false);
                                activer.setVisible(true);
                                hb2.getChildren().add(activer);
                                hb2.getChildren().remove(desactiver);
                            } else {
                                activer.setVisible(false);
                                desactiver.setVisible(true);
                                hb2.getChildren().add(desactiver);
                                hb2.getChildren().remove(activer);

                            }
                            hb2.getChildren().add(supprimer);
                            vb.getChildren().addAll(imgv, username, hb2);
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

    }

}
