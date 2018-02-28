/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.GUI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import jdk.nashorn.internal.runtime.JSType;
import mto.cr.DAO.Classe.AdministrateurDAO;
import mto.cr.DAO.Classe.JasperDAO;
import static mto.cr.GUI.AdminController.notifnum;

/**
 *
 * @author bouda
 */
public class AdminReglagesController implements Initializable {

    @FXML
    private Pane dropDownMenu;
    @FXML
    private Text varUsernameToolBar;
    @FXML
    private ImageView varPhotoProfilToolBar;
    @FXML
    private Text nombreNotification;
    @FXML
    private ImageView home;
    @FXML
    private Button ajouterExpbtn;
    @FXML
    private TextField ajoutexpTxt;
    @FXML
    private Button btnProjet;
    @FXML
    private Button btnuser;

    JasperDAO jdao = new JasperDAO();
    int t = 1;
    @FXML
    private TextField textProjet;
    @FXML
    private TextField userTxt;
    @FXML
    private Button btnProbleme;
    @FXML
    private TextField ProblemeTxt;
    @FXML
    private Button btnProbleme1;
    @FXML
    private Button btnuser1;
    @FXML
    private Button btnProjet1;

    public void projetTimer(int t) {
        jdao.jasperProjet();
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(2500),
                ae -> jdao.jasperProjet()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void problemeTimer(int t) {
        jdao.jasperProbleme();
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(10000 * t),
                ae -> jdao.jasperProbleme()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void userTimer(int t) {
        jdao.jaseperUser();
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(5000 * t),
                ae -> jdao.jaseperUser()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    

    public void problemeTxtTimer(int t) {

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(5000 * t),
                ae -> jdao.texProbleme()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void userTxtTimer(int t) {

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(5000 * t),
                ae -> {
                    try {
                        jdao.texUser();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(AdminReglagesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ProblemeTxt.setText("Entrer Nombre d'heure");
        textProjet.setText("Entrer un nombre d'heure");
        userTxt.setText("Entrer un Nombre d'heure");
        userTxt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                userTxt.setText("");
            }
        });

        textProjet.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                textProjet.setText("");
            }
        });
        ProblemeTxt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                ProblemeTxt.setText("");
            }
        });

        btnProjet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (JSType.isNumber(textProjet.getText())) {

                    int t = Integer.parseInt(textProjet.getText());
                    projetTimer(t);
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Vous devez Entrer un Numero");
                    a.show();

                }

            }
        });


        btnProjet1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (JSType.isNumber(textProjet.getText())) {

                    int t = Integer.parseInt(textProjet.getText());

                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Vous devez Entrer un Numero");
                    a.show();

                }

            }
        });
        
        btnProbleme.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (JSType.isNumber(ProblemeTxt.getText())) {

                    int t = Integer.parseInt(ProblemeTxt.getText());
                    problemeTimer(t);

                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Vous devez Entrer un Numero");
                    a.show();

                }

            }
        });
        
        btnProbleme1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (JSType.isNumber(ProblemeTxt.getText())) {

                    int t = Integer.parseInt(ProblemeTxt.getText());
                    problemeTxtTimer(t);

                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Vous devez Entrer un Numero");
                    a.show();

                }

            }
        });
        btnuser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (JSType.isNumber(userTxt.getText())) {

                    int t = Integer.parseInt(userTxt.getText());
                    userTimer(t);

                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Vous devez Entrer un Numero");
                    a.show();

                }

            }
        });
        home.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) home.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
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
        btnuser1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (JSType.isNumber(userTxt.getText())) {

                    int t = Integer.parseInt(userTxt.getText());
                    userTxtTimer(t);

                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Vous devez Entrer un Numero");
                    a.show();

                }

            }
        });

    }

}
