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
import java.util.List;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
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
import mto.cr.DAO.Classe.ProblemeDAO;
import mto.cr.DAO.Classe.UserDAO;
import mto.cr.Model.Probleme;
import mto.cr.Technique.ConfigurationJava;

/**
 * FXML Controller class
 *
 * @author Sàl Mà
 */
public class ForumController implements Initializable {

    @FXML
    Text titreprobleme;
    @FXML
    TextArea contenuprobleme;
    @FXML
    Text titreprobleme1;
    @FXML
    TextArea contenuprobleme1;
    @FXML
    Pane pane;
    VBox vgen;
    @FXML
    VBox vbox;
    @FXML
    VBox vbox1;
    @FXML
    MenuItem informatique;
    @FXML
    MenuItem agriculture;
    @FXML
    Button consulter;
    @FXML
    Button consulter2;
    @FXML
    Button rech_ok;
    @FXML
    TextArea rech_txt;
    @FXML
    Button poser;
    @FXML
    MenuItem encours;
    @FXML
    MenuItem resolu;

    public static Probleme probleme = new Probleme();
    Probleme prob1 = new Probleme();
    Probleme prob2 = new Probleme();
    int size = 0;
    public static int a = 0;
    @FXML
    VBox v1;
    static int t = 0;

    ProblemeDAO pd = new ProblemeDAO();
    List<Probleme> lp;

    Pagination pag = new Pagination();
    Pagination pag2 = new Pagination();
    Pagination pag3 = new Pagination();
    Pagination pagOr = new Pagination();
    Pagination pagOrC = new Pagination();
    int j = 0;
    VBox vs = new VBox();
    @FXML
    private Label userCommentaire;
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
    private Label userCommentaire1;
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
    private ImageView photoCommentaire;
    @FXML
    private ImageView photoCommentaire1;
    @FXML
    private Button deconnexion;
    @FXML
    private VBox v;
    @FXML
    private Text nomPrenomMonProfil;

    @FXML
    public void switchscene(ActionEvent event) throws IOException {

        probleme = prob1;
        try {

            Stage stage = new Stage();
            Stage stageprev = (Stage) consulter.getScene().getWindow();
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

    @FXML
    public void switchscene2(ActionEvent event) throws IOException {

        probleme = prob2;
        try {

            Stage stage = new Stage();
            Stage stageprev = (Stage) consulter2.getScene().getWindow();
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

    @FXML
    public void switchscene3(ActionEvent event) throws IOException {

        a = 1;
        Stage stage = (Stage) poser.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mto/cr/GUI/poserProbleme.fxml"));
        Scene scene = new Scene(root);
        stage.resizableProperty().setValue(Boolean.FALSE);

        stage.setScene(scene);

        stage.show();

    }

    @FXML
    public void recherche(ActionEvent event) throws IOException {
        String result;
        result = rech_txt.getText();

        pane.getChildren().remove(pagOrC);
        pagOrC = new Pagination();
        pd = new ProblemeDAO();
        pagOrC.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);


        lp = pd.findByTitre(result);
        size = lp.size();
        pagOrC.setCurrentPageIndex(j);
        if (lp.size() % 2 == 0) {
            pagOrC.setPageCount(lp.size() / 2);
        } else {
            pagOrC.setPageCount((lp.size() + 1) / 2);
        }
        pagOrC.setPageFactory(new Callback<Integer, Node>() {

            public Node call(Integer pageIndex) {

                vs = new VBox();

                for (int i = 0; i < lp.size(); i++) {
                    if (lp.size() % 2 == 0) {

                        pagOrC.setPageCount(lp.size() / 2);
                    } else {
                        pagOrC.setPageCount((lp.size() + 1) / 2);
                    }
                    lp = pd.findByTitre(result);
                    size = lp.size();

                    vs = new VBox();
                    size = (1 + pagOrC.getCurrentPageIndex()) * 2;
                    if (lp.size() - size >= 0) {
                        titreprobleme.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getUsername_canonical());

                        String ss = "";
                        Image image;
                        try {
                            if (lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image = new Image(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        probleme = lp.get(pagOrC.getCurrentPageIndex() * 2);
                        titreprobleme1.setText(lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getTitre());
                        contenuprobleme1.setText(lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getContenu());
                        userCommentaire1.setText(lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getUser().getUsername_canonical());
                        ss = "";
                        Image image1;
                        try {
                            if (lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire1.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        titreprobleme.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        String ss = "";
                        Image image1;
                        try {
                            if (lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (lp.size() - size >= 0) {
                        vs.getChildren().add(vbox);
                        vs.getChildren().add(vbox1);
                    } else {
                        vs.getChildren().add(vbox);
                        pane.getChildren().remove(vbox1);
                    }
                }
                return vs;

            }

        });

        pane.getChildren().add(pagOrC);
        pane.getChildren().remove(pag);
        pane.getChildren().remove(pagOr);
        pane.getChildren().remove(pag2);
        pane.getChildren().remove(pag3);
        pag = new Pagination();
        pag2 = new Pagination();
        pag3 = new Pagination();
        pagOr = new Pagination();

    } 

    public void afficherOrdreCom(ActionEvent event) {
        pane.getChildren().remove(pagOrC);
        pagOrC = new Pagination();
        pd = new ProblemeDAO();
        pagOr.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

        lp = pd.findOrderByCom();
        size = lp.size();
        pagOrC.setCurrentPageIndex(j);
        if (lp.size() % 2 == 0) {
            pagOrC.setPageCount(lp.size() / 2);
        } else {
            pagOrC.setPageCount((lp.size() + 1) / 2);
        }
        pagOrC.setPageFactory(new Callback<Integer, Node>() {

            public Node call(Integer pageIndex) {

                vs = new VBox();

                for (int i = 0; i < lp.size(); i++) {
                    if (lp.size() % 2 == 0) {

                        pagOrC.setPageCount(lp.size() / 2);
                    } else {
                        pagOrC.setPageCount((lp.size() + 1) / 2);
                    }
                    lp = pd.findOrderByCom();
                    size = lp.size();

                    vs = new VBox();
                    size = (1 + pagOrC.getCurrentPageIndex()) * 2;
                    if (lp.size() - size >= 0) {
                        titreprobleme.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        probleme = lp.get(pagOrC.getCurrentPageIndex() * 2);
                        titreprobleme1.setText(lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getTitre());
                        contenuprobleme1.setText(lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getContenu());
                        userCommentaire1.setText(lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getUser().getUsername_canonical());

                        String ss = "";
                        Image image;
                        try {
                            if (lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image = new Image(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ss = "";
                        Image image1;
                        try {
                            if (lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire1.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        titreprobleme.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        String ss = "";
                        Image image;
                        try {
                            if (lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image = new Image(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/" + lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (lp.size() - size >= 0) {
                        vs.getChildren().add(vbox);
                        vs.getChildren().add(vbox1);
                    } else {
                        vs.getChildren().add(vbox);
                        pane.getChildren().remove(vbox1);
                    }
                }
                return vs;

            }

        });

        pane.getChildren().add(pagOrC);
        pane.getChildren().remove(pag);
        pane.getChildren().remove(pagOr);
        pane.getChildren().remove(pag2);
        pane.getChildren().remove(pag3);
        pag = new Pagination();
        pag2 = new Pagination();
        pag3 = new Pagination();
        pagOr = new Pagination();

    }

    @FXML
    public void afficherOrdre(ActionEvent event) {
        pane.getChildren().remove(pagOr);
        pagOr = new Pagination();
        pd = new ProblemeDAO();
        pagOr.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

        lp = pd.findAllOrderBy();
        size = lp.size();
        pagOr.setCurrentPageIndex(j);
        if (lp.size() % 2 == 0) {
            pagOr.setPageCount(lp.size() / 2);
        } else {
            pagOr.setPageCount((lp.size() + 1) / 2);
        }
        pagOr.setPageFactory(new Callback<Integer, Node>() {

            public Node call(Integer pageIndex) {

                vs = new VBox();

                for (int i = 0; i < lp.size(); i++) {
                    if (lp.size() % 2 == 0) {

                        pagOr.setPageCount(lp.size() / 2);
                    } else {
                        pagOr.setPageCount((lp.size() + 1) / 2);
                    }
                    lp = pd.findAllOrderBy();
                    size = lp.size();

                    vs = new VBox();
                    size = (1 + pagOr.getCurrentPageIndex()) * 2;
                    if (lp.size() - size >= 0) {
                        titreprobleme.setText(lp.get(pagOr.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pagOr.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pagOr.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        titreprobleme1.setText(lp.get(pagOr.getCurrentPageIndex() * 2 + 1).getTitre());
                        contenuprobleme1.setText(lp.get(pagOr.getCurrentPageIndex() * 2 + 1).getContenu());
                        userCommentaire1.setText(lp.get(pagOr.getCurrentPageIndex() * 2 + 1).getUser().getUsername_canonical());
                        String ss = "";
                        Image image;
                        try {
                            if (lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image = new Image(lp.get(pagOrC.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pagOr.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ss = "";
                        Image image1;
                        try {
                            if (lp.get(pagOrC.getCurrentPageIndex() * 2 + 1).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pagOr.getCurrentPageIndex() * 2 + 1).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pagOr.getCurrentPageIndex() * 2 + 1).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        titreprobleme.setText(lp.get(pagOr.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pagOr.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pagOr.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                    }

                    if (lp.size() - size >= 0) {
                        vs.getChildren().add(vbox);
                        vs.getChildren().add(vbox1);
                    } else {
                        vs.getChildren().add(vbox);
                        pane.getChildren().remove(vbox1);
                    }
                }
                return vs;

            }

        });

        pane.getChildren().add(pagOr);
        pane.getChildren().remove(pag);
        pane.getChildren().remove(pag2);
        pane.getChildren().remove(pag3);
        pane.getChildren().remove(pagOrC);
        pag = new Pagination();
        pag2 = new Pagination();
        pag3 = new Pagination();
        pagOrC = new Pagination();

    }

    @FXML
    public void afficherAgri(ActionEvent event) {
        pane.getChildren().remove(pag3);
        pag3 = new Pagination();
        pd = new ProblemeDAO();
        pag3.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

        lp = pd.findBySecteur(agriculture.getText());
        size = lp.size();
        pag3.setCurrentPageIndex(j);
        if (lp.size() % 2 == 0) {
            pag3.setPageCount(lp.size() / 2);
        } else {
            pag3.setPageCount((lp.size() + 1) / 2);
        }
        pag3.setPageFactory(new Callback<Integer, Node>() {

            public Node call(Integer pageIndex) {

                vs = new VBox();

                for (int i = 0; i < lp.size(); i++) {
                    if (lp.size() % 2 == 0) {

                        pag3.setPageCount(lp.size() / 2);
                    } else {
                        pag3.setPageCount((lp.size() + 1) / 2);
                    }
                    lp = pd.findBySecteur(agriculture.getText());
                    size = lp.size();

                    vs = new VBox();
                    size = (1 + pag3.getCurrentPageIndex()) * 2;
                    if (lp.size() - size >= 0) {
                        titreprobleme.setText(lp.get(pag3.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag3.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag3.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        String ss = "";
                        Image image;
                        try {
                            if (lp.get(pag3.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image = new Image(lp.get(pag3.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag3.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        titreprobleme1.setText(lp.get(pag3.getCurrentPageIndex() * 2 + 1).getTitre());
                        contenuprobleme1.setText(lp.get(pag3.getCurrentPageIndex() * 2 + 1).getContenu());
                        userCommentaire1.setText(lp.get(pag3.getCurrentPageIndex() * 2 + 1).getUser().getUsername_canonical());

                        ss = "";
                        Image image1;
                        try {
                            if (lp.get(pag3.getCurrentPageIndex() * 2 + 1).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pag3.getCurrentPageIndex() * 2 + 1).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag3.getCurrentPageIndex() * 2 + 1).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire1.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        titreprobleme.setText(lp.get(pag3.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag3.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag3.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                    }

                    if (lp.size() - size >= 0) {
                        vs.getChildren().add(vbox);
                        vs.getChildren().add(vbox1);
                    } else {
                        vs.getChildren().add(vbox);
                        pane.getChildren().remove(vbox1);
                    }
                }
                return vs;

            }

        });

        pane.getChildren().add(pag3);
        pane.getChildren().remove(pag);
        pane.getChildren().remove(pag2);
        pane.getChildren().remove(pagOr);
        pane.getChildren().remove(pagOrC);
        pag = new Pagination();
        pag2 = new Pagination();
        pagOrC = new Pagination();
        pagOr = new Pagination();

    }

    @FXML
    public void afficherInfo(ActionEvent event) {
        pane.getChildren().remove(pag2);
        pag2 = new Pagination();
        pd = new ProblemeDAO();
        pag2.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

        lp = pd.findBySecteur(informatique.getText());
        size = lp.size();
        pag2.setCurrentPageIndex(j);
        if (lp.size() % 2 == 0) {
            pag2.setPageCount(lp.size() / 2);
        } else {
            pag2.setPageCount((lp.size() + 1) / 2);
        }
        pag2.setPageFactory(new Callback<Integer, Node>() {

            public Node call(Integer pageIndex) {

                vs = new VBox();

                for (int i = 0; i < lp.size(); i++) {
                    if (lp.size() % 2 == 0) {

                        pag2.setPageCount(lp.size() / 2);
                    } else {
                        pag2.setPageCount((lp.size() + 1) / 2);
                    }
                    lp = pd.findBySecteur(informatique.getText());
                    size = lp.size();

                    vs = new VBox();
                    size = (1 + pag2.getCurrentPageIndex()) * 2;
                    if (lp.size() - size >= 0) {
                        titreprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        String ss = "";
                        Image image1;
                        try {
                            if (lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        titreprobleme1.setText(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getTitre());
                        contenuprobleme1.setText(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getContenu());
                        userCommentaire1.setText(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getUsername_canonical());
                        ss = "";
                        Image image;
                        try {
                            if (lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getPath().startsWith("https://")) {
                                image = new Image(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getPath()).trim();
                                File file = new File(ss);
                                image = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire1.setImage(image);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        titreprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        String ss = "";
                        Image image1;
                        try {
                            if (lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (lp.size() - size >= 0) {
                        vs.getChildren().add(vbox);
                        vs.getChildren().add(vbox1);
                    } else {
                        vs.getChildren().add(vbox);
                        pane.getChildren().remove(vbox1);
                    }
                }
                return vs;

            }

        });

        pane.getChildren().add(pag2);
        pane.getChildren().remove(pag);
        pane.getChildren().remove(pag3);
        pane.getChildren().remove(pagOr);
        pane.getChildren().remove(pagOrC);
        pag = new Pagination();
        pagOrC = new Pagination();
        pag3 = new Pagination();
        pagOr = new Pagination();

    }

    @FXML
    public void afficherEncours(ActionEvent event) {
        pane.getChildren().remove(pag2);
        pag2 = new Pagination();
        pd = new ProblemeDAO();
        pag2.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

        lp = pd.findByEtat(encours.getText());
        size = lp.size();
        pag2.setCurrentPageIndex(j);
        if (lp.size() % 2 == 0) {
            pag2.setPageCount(lp.size() / 2);
        } else {
            pag2.setPageCount((lp.size() + 1) / 2);
        }
        pag2.setPageFactory(new Callback<Integer, Node>() {

            public Node call(Integer pageIndex) {

                vs = new VBox();

                for (int i = 0; i < lp.size(); i++) {
                    if (lp.size() % 2 == 0) {

                        pag2.setPageCount(lp.size() / 2);
                    } else {
                        pag2.setPageCount((lp.size() + 1) / 2);
                    }
                    lp = pd.findByEtat("encours");
                    size = lp.size();

                    vs = new VBox();
                    size = (1 + pag2.getCurrentPageIndex()) * 2;
                    if (lp.size() - size >= 0) {
                        titreprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        String ss = "";
                        Image image1;
                        try {
                            if (lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        titreprobleme1.setText(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getTitre());
                        contenuprobleme1.setText(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getContenu());
                        userCommentaire1.setText(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getUsername_canonical());
                        ss = "";
                        Image image2;
                        try {
                            if (lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getPath().startsWith("https://")) {
                                image2 = new Image(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getPath()).trim();
                                File file = new File(ss);
                                image2 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire1.setImage(image2);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        titreprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        String ss = "";
                        Image image1;
                        try {
                            if (lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (lp.size() - size >= 0) {
                        vs.getChildren().add(vbox);
                        vs.getChildren().add(vbox1);
                    } else {
                        vs.getChildren().add(vbox);
                        pane.getChildren().remove(vbox1);
                    }
                }
                return vs;

            }

        });

        pane.getChildren().add(pag2);
        pane.getChildren().remove(pag);
        pane.getChildren().remove(pag3);
        pane.getChildren().remove(pagOr);
        pane.getChildren().remove(pagOrC);
        pag = new Pagination();
        pagOrC = new Pagination();
        pag3 = new Pagination();
        pagOr = new Pagination();

    }

    @FXML
    public void afficherResolu(ActionEvent event) {
        pane.getChildren().remove(pag2);
        pag2 = new Pagination();
        pd = new ProblemeDAO();
        pag2.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

        lp = pd.findByEtat(resolu.getText());
        size = lp.size();
        pag2.setCurrentPageIndex(j);
        if (lp.size() % 2 == 0) {
            pag2.setPageCount(lp.size() / 2);
        } else {
            pag2.setPageCount((lp.size() + 1) / 2);
        }
        pag2.setPageFactory(new Callback<Integer, Node>() {

            public Node call(Integer pageIndex) {

                vs = new VBox();

                for (int i = 0; i < lp.size(); i++) {
                    if (lp.size() % 2 == 0) {

                        pag2.setPageCount(lp.size() / 2);
                    } else {
                        pag2.setPageCount((lp.size() + 1) / 2);
                    }
                    lp = pd.findByEtat("resolu");
                    size = lp.size();

                    vs = new VBox();
                    size = (1 + pag2.getCurrentPageIndex()) * 2;
                    if (lp.size() - size >= 0) {
                        titreprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        String ss = "";
                        Image image1;
                        try {
                            if (lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        titreprobleme1.setText(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getTitre());
                        contenuprobleme1.setText(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getContenu());
                        userCommentaire1.setText(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getUsername_canonical());
                        ss = "";
                        Image image2;
                        try {
                            if (lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getPath().startsWith("https://")) {
                                image2 = new Image(lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag2.getCurrentPageIndex() * 2 + 1).getUser().getPath()).trim();
                                File file = new File(ss);
                                image2 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image2);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        titreprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag2.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        String ss = "";
                        Image image1;
                        try {
                            if (lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath().startsWith("https://")) {
                                image1 = new Image(lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath());
                            } else {
                                ss = ("/Applications/MAMP/htdocs/MTOCrowdRise/web/uploads/profils/"
                                        + lp.get(pag2.getCurrentPageIndex() * 2).getUser().getPath()).trim();
                                File file = new File(ss);
                                image1 = new Image(file.toURI().toURL().toString());
                            }

                            photoCommentaire.setImage(image1);

                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ProfilsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (lp.size() - size >= 0) {
                        vs.getChildren().add(vbox);
                        vs.getChildren().add(vbox1);
                    } else {
                        vs.getChildren().add(vbox);
                        pane.getChildren().remove(vbox1);
                    }
                }
                return vs;

            }

        });

        pane.getChildren().add(pag2);
        pane.getChildren().remove(pag);
        pane.getChildren().remove(pag3);
        pane.getChildren().remove(pagOr);
        pane.getChildren().remove(pagOrC);
        pag = new Pagination();
        pagOrC = new Pagination();
        pag3 = new Pagination();
        pagOr = new Pagination();

    }


    public void afficher() {

        pane.getChildren().remove(pag);
        pd = new ProblemeDAO();
        lp = pd.getAll();
        size = lp.size();
        pag.setCurrentPageIndex(j);
        pane.getStylesheets().add("MTOCrowdrise.css");
        pag.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);

        if (lp.size() % 2 == 0) {
            pag.setPageCount(lp.size() / 2);
        } else {
            pag.setPageCount((lp.size() + 1) / 2);
        }
        pag.setPageFactory(new Callback<Integer, Node>() {

            public Node call(Integer pageIndex) {

                vs = new VBox();

                for (int i = 0; i < lp.size(); i++) { /// ?????????????
                    if (lp.size() % 2 == 0) {

                        pag.setPageCount(lp.size() / 2);
                    } else {
                        pag.setPageCount((lp.size() + 1) / 2);
                    }
                    lp = pd.getAll();
                    size = lp.size();

                    vs = new VBox();
                    size = (1 + pag.getCurrentPageIndex()) * 2;
                    if (lp.size() - size >= 0) {
                        titreprobleme.setText(lp.get(pag.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        //photoCommentaire
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
                        //end PhotoCommentaire
                        titreprobleme1.setText(lp.get(pag.getCurrentPageIndex() * 2 + 1).getTitre());
                        contenuprobleme1.setText(lp.get(pag.getCurrentPageIndex() * 2 + 1).getContenu());
                        userCommentaire1.setText(lp.get(pag.getCurrentPageIndex() * 2 + 1).getUser().getUsername_canonical());

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

                        prob1 = lp.get(pag.getCurrentPageIndex() * 2);
                        prob2 = lp.get(pag.getCurrentPageIndex() * 2 + 1);

                    } else {
                        titreprobleme.setText(lp.get(pag.getCurrentPageIndex() * 2).getTitre());
                        contenuprobleme.setText(lp.get(pag.getCurrentPageIndex() * 2).getContenu());
                        userCommentaire.setText(lp.get(pag.getCurrentPageIndex() * 2).getUser().getUsername_canonical());
                        prob1 = lp.get(pag.getCurrentPageIndex() * 2);

                    }

                    if (lp.size() - size >= 0) {
                        vs.getChildren().add(vbox);
                        vs.getChildren().add(vbox1);
                    } else {
                        vs.getChildren().add(vbox);
                        pane.getChildren().remove(vbox1);
                    }
                }
                return vs;

            }

        });

        pane.getChildren().add(pag);
        pane.getChildren().remove(pag2);
        pane.getChildren().remove(pag3);
        pane.getChildren().remove(pagOr);
        pane.getChildren().remove(pagOrC);
        pagOrC = new Pagination();
        pag2 = new Pagination();
        pag3 = new Pagination();
        pagOr = new Pagination();

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

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
        contenuprobleme.setEditable(false);
        contenuprobleme1.setEditable(false);
                
        //*********************************** Navigation ***************************************
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

        
    //*********************************** End Navigation ***************************************   
        //*********************************** Effects **********************************************
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

        //*********************************** EndEffects *******************************************
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
