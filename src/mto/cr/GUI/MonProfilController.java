package mto.cr.GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
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
import mto.cr.DAO.Classe.CommentaireProblemeDAO;
import mto.cr.DAO.Classe.UserDAO;
import static mto.cr.GUI.ProfilsController.selected;
import mto.cr.Model.CommentaireProbleme;
import mto.cr.Model.Probleme;
import mto.cr.Model.User;
import mto.cr.Technique.ConfigurationJava;

/**
 *
 * @author Chiheb
 */
public class MonProfilController implements Initializable {

    @FXML
    private ImageView photoProfil;
    @FXML
    private Label varNomPrenom;
    @FXML
    private Label varDataNaissance;
    @FXML
    private Label varSituationProfessionnel;
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

    private ObservableList<CommentaireProbleme> dataComm;
    @FXML
    private Button buttonModifierMonIdentite;
    @FXML
    private Button buttonChangerPSW;
    @FXML
     private Label secteurprofil;

  

    Probleme p;
    User user = new User();
   
    //DAOs
    UserDAO userDAO = new UserDAO();
   
        //------>CommentaireProblemeDAO attrExpDAO = new AttributeExperienceDAO();
    //Lists
    
    List<CommentaireProbleme> comms = new ArrayList<>();
    //data Experiences
    @FXML
    private ListView<CommentaireProbleme> listViewCommentaire;
    @FXML
  
    private AnchorPane GlobalAnchorID1;
    @FXML
    private Label varEmailHaut1;
    @FXML
    private Label varNomHaut1;
    @FXML
    private ImageView photoProfil1;
       @FXML
    private Button deconnexion;
    @FXML
    private Text nomPrenomMonProfil;

    @FXML
    private Label sexeprofil;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Class
        varNomHaut1.setText(LoginController.logged.getNom() +" "+LoginController.logged.getPrenom());
       varEmailHaut1.setText(LoginController.logged.getEmail());
       secteurprofil.setText(LoginController.logged.getSecteur());
       sexeprofil.setText(LoginController.logged.getSexe());
       varSituationProfessionnel.setText(LoginController.logged.getSituationprof());
       varDataNaissance.setText(String.valueOf(LoginController.logged.getDatenaissance()));

        //data Mon Panier
        refrechCommentaire();

//************

//*************************************************Remplissage de liste Commentaires*************************************
        listViewCommentaire.setCellFactory(new Callback<ListView<CommentaireProbleme>, ListCell<CommentaireProbleme>>() {
            @Override
            public ListCell<CommentaireProbleme> call(ListView<CommentaireProbleme> ListViewCommentaires) {
                ListCell<CommentaireProbleme> cell;
                cell = new ListCell<CommentaireProbleme>() {

                    @Override
                    protected void updateItem(CommentaireProbleme t, boolean bln) {
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
                            Label username = new Label(t.getProbleme().getTitre());
                            Label email = new Label("Commentaire : " + t.getContenue());

                            Label nom = new Label("Nombre de Vote " + t.getNbrVote());
                            Label probleme = new Label("Probléme : " + t.getProbleme().getContenu().toString());
                            Label secteur = new Label("Secteur : " + t.getProbleme().getSecteur());
                            
                            email.setFont(Font.font("System", 16));
                            username.setFont(Font.font("System", 16));
                            nom.setFont(Font.font("System", 16));
                            probleme.setFont(Font.font("System", 16));
                            secteur.setFont(Font.font("System", 16));
                            
                            ImageView imgv = new ImageView();
                            //imgv.setId(Integer.toString(t.getId()));
                            imgv.setStyle("-fx-padding: 10px;");
                            Button butt = new Button("acceder problème");
                            //butt.setId(Integer.toString(t.getProbleme().getIdProbleme()));
                            p = new Probleme();
                            p = t.getProbleme();
                            butt.getStyleClass().add("buttonLogin");
                            butt.getStyleClass().add("buttonLogin:hover");
                            butt.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                
                            public void handle(MouseEvent event) {
                                try {
                                    ForumController.probleme = p;
                                    Stage stage = new Stage();
                                    Stage stageprev = (Stage) AccederProfils.getScene().getWindow();
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("probleme.fxml"));
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

                            vb.getChildren().addAll(imgv, username);
                            vb2.getChildren().addAll(email, nom, probleme);
                            vb3.getChildren().addAll(secteur,butt);
                            hb.getChildren().addAll(vb1, vb, vb2, vb3);

                            setGraphic(hb);
                        }
                    }
                };
                return cell;
            }
        });
//*************************************************Remplissage de la liste Experienced ***********************************

//*************************************************Remplissage de la liste mon panier ***********************************       

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

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("forum.fxml"));
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

        buttonChangerPSW.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) buttonChangerPSW.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierPassword.fxml"));
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
        //buttonChangerPSW;
        buttonModifierMonIdentite.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) AccederProjets.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierProfil.fxml"));
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
                }
            }
        });

//*************************************************End Navigation*************************************************
       
      
//$$$$$$            
       
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

        //****************************************** end Mon Profil ******************************************
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



  
   
    
   
    private void refrechCommentaire(){
        List<CommentaireProbleme> comms = new ArrayList<>();
        CommentaireProblemeDAO commDAO = new CommentaireProblemeDAO();
        comms = commDAO.getByUser(LoginController.logged);
        dataComm = FXCollections.observableArrayList();
        dataComm.addAll(comms);
        listViewCommentaire.setItems(dataComm);
    }

}
