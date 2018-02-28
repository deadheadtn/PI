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
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import mto.cr.DAO.Classe.CommentaireProblemeDAO;
import mto.cr.DAO.Classe.ProblemeDAO;
import mto.cr.DAO.Classe.UserDAO;

import mto.cr.Model.CommentaireProbleme;
import mto.cr.Model.Probleme;
import mto.cr.Technique.ConfigurationJava;

/**
 * FXML Controller class
 *
 * @author Sàl Mà
 */
public class ProblemeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    CommentaireProbleme c = new CommentaireProbleme();
    CommentaireProbleme c1 = new CommentaireProbleme();
    CommentaireProblemeDAO cd = new CommentaireProblemeDAO();
    @FXML
    private Label userNameP;
    @FXML
    private ImageView userImageP;
    @FXML
    private Text secteur;
    @FXML
    private TextArea contenue;
    @FXML
    private Pane supprimerPane;
    @FXML
    private Pane resoluePane;
    @FXML
    private Pane modifierPane;
    @FXML
    private Text ncom;
    @FXML
    private Text dateProbleme;
    @FXML
    private Pane pane;
    @FXML
    private VBox vbox1;
   
    
    
   
    @FXML
    private Label userName;
    @FXML
    private ImageView photoCommentaire;
    @FXML
    private TextArea com;
    @FXML
    private Pane modifierCommentairePane;
    @FXML
    private Pane supprimerCommentairePane;
    @FXML
    private Pane validermodification;
    @FXML
    private Text dateCommentaire;
    @FXML
    private VBox vbox11;
  
    
    @FXML
    private Label userName1;
    @FXML
    private ImageView photoCommentaire1;
    @FXML
    private TextArea com1;
    @FXML
    private Pane modifierCommentairePane1;
    @FXML
    private Pane supprimerCommentairePane1;
    @FXML
    private Pane validermodification1;
    @FXML
    private Text titre;
    @FXML
    private Button afficherCom;
    @FXML
    private TextArea commentaireText;
    @FXML
    private Button insererCommentaire;
    @FXML
    private Pane paneResolue1;
    @FXML
    private Pane MonProfilMenu;
    @FXML
    private Button buttonAccederMonProfil;
    @FXML
    private ImageView PhotoProfilMonProfil;
    @FXML
    private Text nomPrenomMonProfil;
    @FXML
    private Text emailMonProfil;
    
    @FXML
    private Button deconnexion;
    @FXML
    private Pane dropDownMenu;
    @FXML
    private Text varUsernameToolBar;
    @FXML
    private ImageView varPhotoProfilToolBar1;
    @FXML
    private ImageView home;
    @FXML
    private AnchorPane navList;
    @FXML
    private Text AccederProjets;
    @FXML
    private Pane menu;
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
    public static Probleme probleme = new Probleme();
    public static int b = 0;

    @FXML
    public void ajouterCom(ActionEvent event) {

        insererCommentaire.setVisible(true);
        commentaireText.setVisible(true);
        supprimerCommentairePane1.setVisible(false);
        supprimerCommentairePane.setVisible(false);
        modifierCommentairePane.setVisible(false);
        modifierCommentairePane1.setVisible(false);
        modifierPane.setVisible(false);
        //deconnexion
        deconnexion.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            public void handle(javafx.scene.input.MouseEvent event) {
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
        /*CommentaireProbleme c= new CommentaireProbleme();
         User u = new User();
         AdministrateurDAO a = new AdministrateurDAO();
         u=a.getById(probleme.getUser().getId());
         java.util.Date dt = new java.util.Date();

         java.text.SimpleDateFormat sdf = 
         new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

         String currentTime = sdf.format(dt);
         c.setDateCommentaire(currentTime);
         c.setNbrVote(0);
         c.setProbleme(probleme);
         c.setContenue(result.get());
         c.setNotif(0);
         c.setUser(LoginController.logged);
         c.setProbleme(probleme);
         cpd.insert(c);
         */

    }

    Pagination pag = new Pagination();
    TextInputDialog dialog = new TextInputDialog();

    CommentaireProblemeDAO cpd = new CommentaireProblemeDAO();
    List<CommentaireProbleme> lp = new ArrayList<>();
    int size = 0;

    public void insererCommentaire(ActionEvent event) throws IOException {

    }

    public void afficher() {
        pane.getChildren().remove(pag);
        probleme = ForumController.probleme;

        titre.setText(probleme.getTitre());
        contenue.setText(probleme.getContenu());
        dateProbleme.setText(probleme.getDateProblem());
        ncom.setText(": " + probleme.getNbrCommentaireProbleme());
        secteur.setText(probleme.getSecteur());

        userNameP.setText(probleme.getUser().getUsername_canonical());
        Image image1;
        image1 = new Image(ConfigurationJava.profilsPath + probleme.getUser().getPath());
        userImageP.setImage(image1);
        cpd = new CommentaireProblemeDAO();
        lp = cpd.findAllByProbleme(probleme.getIdProbleme());
        size = lp.size();
        if (lp.isEmpty()) {
            pane.setVisible(false);
        } else {
            pane.setVisible(true);
            pag.setCurrentPageIndex(0);
            pane.getStylesheets().add("MTOCrowdrise.css");
            pag.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

            if (lp.size() % 2 == 0) {
                pag.setPageCount(lp.size() / 2);
            } else {
                pag.setPageCount((lp.size() + 1) / 2);
            }
            pag.setPageFactory(new Callback<Integer, Node>() {

                public Node call(Integer pageIndex) {

                    VBox vs = new VBox();

                    for (int i = 0; i < 1; i++) {
                        if (lp.size() % 2 == 0) {

                            pag.setPageCount(lp.size() / 2);
                        } else {
                            pag.setPageCount((lp.size() + 1) / 2);
                        }
                        lp = cpd.findAllByProbleme(probleme.getIdProbleme());
                        size = lp.size();

                        vs = new VBox();
                        size = (1 + pag.getCurrentPageIndex()) * 2;
                        if (lp.size() - size >= 0) {
                            String ss = "";
                            Image image;
                            try {
                                if (lp.get(pag.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                    image = new Image(lp.get(pag.getCurrentPageIndex() * 2).getUser().getPath());
                                } else {
                                    ss = (ConfigurationJava.profilsPath
                                            + lp.get(pag.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                    File file = new File(ss);
                                    image = new Image(file.toURI().toURL().toString());
                                }

                                photoCommentaire.setImage(image);

                            } catch (MalformedURLException ex) {
                                Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            userName.setText(lp.get(pag.getCurrentPageIndex() * 2).getUser().getUsername());
                            com.setText(lp.get(pag.getCurrentPageIndex() * 2).getContenue());

                            if (lp.get(pag.getCurrentPageIndex() * 2).getUser().equals(LoginController.logged)) {
                                supprimerCommentairePane.setVisible(true);
                                modifierCommentairePane.setVisible(true);

                            } else {
                                modifierCommentairePane.setVisible(false);
                                supprimerCommentairePane.setVisible(false);
                            }
                            if (lp.get(pag.getCurrentPageIndex() * 2 + 1).getUser().equals(LoginController.logged)) {
                                supprimerCommentairePane1.setVisible(true);
                                modifierCommentairePane1.setVisible(true);
                            } else {
                                modifierCommentairePane1.setVisible(false);
                                supprimerCommentairePane1.setVisible(false);
                            }
                            supprimerCommentairePane.setOnMouseClicked(new EventHandler<Event>() {
                                @Override
                                public void handle(Event event) {

                                    try {

                                        cd.supprimerCommeataire(lp.get(pag.getCurrentPageIndex() * 2).getIdCommentaire());
                                        afficher();

                                    } catch (Exception e) {

                                    }

                                }
                            });
                            supprimerCommentairePane1.setOnMouseClicked(new EventHandler<Event>() {
                                @Override
                                public void handle(Event event) {

                                    try {

                                        cd.supprimerCommeataire(lp.get(pag.getCurrentPageIndex() * 2 + 1).getIdCommentaire());
                                        afficher();

                                    } catch (Exception e) {

                                    }

                                }
                            });

                            c = lp.get(pag.getCurrentPageIndex() * 2);
                            c1 = lp.get(pag.getCurrentPageIndex() * 2 + 1);

                           

                           
                            ss = "";
                            Image image1;
                            try {
                                if (lp.get(pag.getCurrentPageIndex() * 2 + 1).getUser().getPath().startsWith("https://")) {
                                    image1 = new Image(lp.get(pag.getCurrentPageIndex() * 2 + 1).getUser().getPath());
                                } else {
                                    ss = (ConfigurationJava.profilsPath
                                            + lp.get(pag.getCurrentPageIndex() * 2 + 1).getUser().getPath()).trim();
                                    File file1 = new File(ss);
                                    image1 = new Image(file1.toURI().toURL().toString());
                                }

                                photoCommentaire1.setImage(image1);

                            } catch (MalformedURLException ex) {
                                Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            userName1.setText(lp.get(pag.getCurrentPageIndex() * 2 + 1).getUser().getUsername());
                            com1.setText(lp.get(pag.getCurrentPageIndex() * 2 + 1).getContenue());

                            validermodification.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                                @Override
                                public void handle(javafx.scene.input.MouseEvent event) {
                                    try {
                                        cpd.update(lp.get(pag.getCurrentPageIndex() * 2));
                                        modifierCommentairePane.setVisible(true);
                                        validermodification.setVisible(false);
                                        afficher();
                                    } catch (Exception e) {
                                    }

                                }
                            }
                            );
                            

                        } else {
                            userName.setText(lp.get(pag.getCurrentPageIndex() * 2).getUser().getUsername());
                            com.setText(lp.get(pag.getCurrentPageIndex() * 2).getContenue());
                            validermodification1.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                                @Override
                                public void handle(javafx.scene.input.MouseEvent event) {
                                    try {
                                        cpd.update(lp.get(pag.getCurrentPageIndex() * 2));
                                        if (lp.get(pag.getCurrentPageIndex() * 2).getUser() == LoginController.logged) {
                                            modifierCommentairePane.setVisible(true);
                                        }
                                        if (lp.get(pag.getCurrentPageIndex() * 2 + 1).getUser() == LoginController.logged) {
                                            modifierCommentairePane1.setVisible(true);
                                        }

                                        validermodification1.setVisible(false);
                                        afficher();
                                    } catch (Exception e) {
                                    }

                                }
                            }
                            );
                        }

                        if (lp.size() - size >= 0) {
                            vs.getChildren().add(vbox1);
                            vs.getChildren().add(vbox11);
                        } else {
                            vs.getChildren().add(vbox1);
                            pane.getChildren().remove(vbox11);
                        }
                    }
                    return vs;

                }

            });

            pane.getChildren().add(pag);
        }
    }

    public void modifier(ActionEvent event) throws IOException {

        b = 1;
        Stage stage = (Stage) modifierPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mto/cr/GUI/AjouterProbleme.fxml"));
        Scene scene = new Scene(root);
        stage.resizableProperty().setValue(Boolean.FALSE);

        stage.setScene(scene);

        stage.show();

    }

    public void supprimer(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();

        //data dropDown
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
        varPhotoProfilToolBar1.setImage(image1);
        imgVi.setImage(image1);
        if (LoginController.logged.getId() != ForumController.probleme.getUser().getId()) {

            modifierPane.setVisible(false);
            supprimerPane.setVisible(false);
            resoluePane.setVisible(false);
        }

        if (ForumController.probleme.getEtatProbleme().equals("resolue")) {
            paneResolue1.setVisible(true);

        } else {
            paneResolue1.setVisible(false);

        }

        /* AccederProfils.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

         public void handle(javafx.scene.input.MouseEvent event) {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               
         }
         });*/
        AccederProjets.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            public void handle(javafx.scene.input.MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            }
        });
        buttonAccederMonProfil.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            public void handle(javafx.scene.input.MouseEvent event) {
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
                    Logger.getLogger(ProblemeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        navList.setOnMouseEntered((javafx.scene.input.MouseEvent event1) -> {
            TranslateTransition openNav = new TranslateTransition(new Duration(350), navList);
            openNav.setToX(0);
            openNav.play();
        });

        navList.setOnMouseExited((javafx.scene.input.MouseEvent event1) -> {
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

        navList2.setOnMouseEntered((javafx.scene.input.MouseEvent event2) -> {

            openNav2.setToX(0);
            openNav2.play();
        });

        navList2.setOnMouseExited((javafx.scene.input.MouseEvent event2) -> {

            closeNav2.setToX(-(navList2.getWidth()) + 78);
            closeNav2.play();
        });

        navList1.setOnMouseEntered((javafx.scene.input.MouseEvent event3) -> {

            //TranslateTransition openNav1 = new TranslateTransition(new Duration(350), navList1);
            openNav1.setToX(0);
            openNav1.play();
        });

        navList1.setOnMouseExited((javafx.scene.input.MouseEvent event3) -> {

            closeNav1.setToX(-(navList1.getWidth()) + 79);
            closeNav1.play();
        });

        home.setOnMouseEntered((javafx.scene.input.MouseEvent event4) -> {
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
        dropDownMenu.setOnMouseClicked((javafx.scene.input.MouseEvent event60) -> {
            openNavi.setToY(0);
            openNavi.play();
        });

        MonProfilMenu.setOnMouseExited((javafx.scene.input.MouseEvent event60) -> {

            closeNavi.setToY(-(MonProfilMenu.getHeight()));
            closeNavi.play();
        });

//*************************************************End Navigation*************************************************
        nomPrenomMonProfil.setText(LoginController.logged.getNom().toUpperCase() + " " + LoginController.logged.getPrenom());
        emailMonProfil.setText(LoginController.logged.getEmail_canonical());
        varUsernameToolBar.setText(LoginController.logged.getUsername_canonical());
        

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

    @FXML
    private void AccederProjetsAction(javafx.scene.input.MouseEvent event) {
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
            Logger.getLogger(ProblemeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AccederProfilsAction(javafx.scene.input.MouseEvent event) {

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
            Logger.getLogger(ProblemeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AccederForumAction(javafx.scene.input.MouseEvent event) {
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
            Logger.getLogger(ProblemeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void insererCom(ActionEvent event) {
        int i = 0;
      
            CommentaireProbleme c = new CommentaireProbleme();
            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf
                    = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String currentTime = sdf.format(dt);
            c.setDateCommentaire(currentTime);

            c.setProbleme(probleme);
            c.setContenue(commentaireText.getText());
            c.setNotif(0);
            c.setUser(LoginController.logged);
            c.setProbleme(probleme);
            cpd.insert(c);
            ProblemeDAO p = new ProblemeDAO();
            int nbrComm = probleme.getNbrCommentaireProbleme() + 1;
            probleme.setNbrCommentaireProbleme(nbrComm);
            p.ajoutCommentairenbr(probleme);
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Votre Commentaire a été ajouté avec Succés");
            a.show();
            afficher();

            insererCommentaire.setVisible(false);
            commentaireText.setVisible(false);

        
    }

    @FXML
    private void supprimerProb(javafx.scene.input.MouseEvent event) throws IOException {
        ProblemeDAO pd = new ProblemeDAO();

        Stage stage = (Stage) supprimerPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mto/cr/GUI/forum.fxml"));
        Scene scene = new Scene(root);
        stage.resizableProperty().setValue(Boolean.FALSE);

        stage.setScene(scene);

        stage.show();
        pd.delete(ForumController.probleme.getIdProbleme());
    }

    @FXML
    private void resoudreProb(javafx.scene.input.MouseEvent event) {
        ProblemeDAO pd = new ProblemeDAO();
        if (pd.resoudreProb(probleme)) {
            paneResolue1.setVisible(true);
        }
    }

    @FXML
    private void modifierProb(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void modifierCommentaire(javafx.scene.input.MouseEvent event) {
        com1.setEditable(true);
        modifierCommentairePane1.setVisible(false);
        modifierCommentairePane.setVisible(false);
        validermodification1.setVisible(true);
    }

    @FXML
    private void supprimerCommentaire(javafx.scene.input.MouseEvent event) {

    }

    @FXML
    private void validerModificationCommentaire(javafx.scene.input.MouseEvent event) {

    }

    @FXML
    private void modifierCommentaire1(javafx.scene.input.MouseEvent event) {

        com.setEditable(true);
        modifierCommentairePane.setVisible(false);
        validermodification.setVisible(true);
    }

    @FXML
    private void supprimerCommentaire1(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void validerModificationCommentaire1(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void voteplus(javafx.scene.input.MouseEvent event) {
    }

}
