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
import mto.cr.DAO.Classe.AdministrateurDAO;
import mto.cr.DAO.Classe.CommentaireProblemeDAO;
import static mto.cr.GUI.AdminController.notifnum;
import static mto.cr.GUI.ProfilsController.selected;
import mto.cr.Model.CommentaireProbleme;
import mto.cr.Model.Probleme;

/**
 *
 * @author bouda
 */
public class AdminCommentaireController implements Initializable{

    @FXML
    private ListView<CommentaireProbleme> listCom;
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
    private TextField AjouterComTxt;
    @FXML
    private Button btnAjout;
    @FXML
    private AnchorPane navList1;
    @FXML
    private Pane menu1;
    @FXML
    private Text AccederProfils;
    @FXML
    private AnchorPane navList;
    @FXML
    private Text AccederProjets;
    @FXML
    private Pane menu;
    CommentaireProblemeDAO cpd = new CommentaireProblemeDAO();
    private ObservableList<CommentaireProbleme> data;

    
      public void afficherCommentaireProbleme(){
        AdministrateurDAO adminDAO = new AdministrateurDAO(); 

    List<CommentaireProbleme> commentaires = new ArrayList<>();
        commentaires = cpd.findAllByProbleme(AdminProblemeController.adminProbleme.getIdProbleme());
        data = FXCollections.observableArrayList();
        data.addAll(commentaires);
        listCom.setItems(data);
        
        try{
         listCom.setCellFactory(new Callback<ListView<CommentaireProbleme>, ListCell<CommentaireProbleme>>() {
            @Override
            public ListCell<CommentaireProbleme> call(ListView<CommentaireProbleme> ListViewProbleme) {
                ListCell<CommentaireProbleme> cell;
                cell = new ListCell<CommentaireProbleme>() {

                    @Override
                    protected void updateItem(CommentaireProbleme t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {

                            VBox vb = new VBox(10);
                             VBox vb4 = new VBox(10);
                            HBox hb = new HBox(20);
                            HBox hb1 = new HBox(50);
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
                            Label UserLabel = new Label(t.getUser().getNom().toUpperCase());
                            Text Contenu = new Text( t.getContenue());
                            
                            Label Date = new Label("Date : " + t.getDateCommentaire());
                            
                             Label nbrVotelbl = new Label("nbrVote : " + t.getNbrVote());
                             
                             Contenu.wrappingWidthProperty().set(350);
                            
                             Button suprrimer = new Button("Supprimer");
                             
                             
                             suprrimer.getStyleClass().add("buttonLogin");
                             suprrimer.getStyleClass().add("buttonLogin:hover");
                            UserLabel.setFont(Font.font ("System", 16));
                            
                            Date.setFont(Font.font ("System", 16));
                           
                           
                            nbrVotelbl.setFont(Font.font ("System", 16));
                        
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
                            
                             suprrimer.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                            try{
                                t.setIdCommentaire(AdminProblemeController.adminProbleme.getIdProbleme());
                                
                                cpd.supprimerCommeataire(t.getIdCommentaire());
                          afficherCommentaireProbleme();}
                            catch (Exception e){}
                                }
                            });
                            
                            vb4.getChildren().add(hb1);
                            vb.getChildren().addAll( imgv, UserLabel);
                            vb2.getChildren().add( Date);
                            vb3.getChildren().add(Contenu);
                            hb.getChildren().addAll(suprrimer,UserLabel,Date,Contenu);

                            setGraphic(hb);
                        }
                    }
                };
                return cell;
                
            }
        });
        }
        catch(Exception e){}
          
 
    }
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

afficherCommentaireProbleme();
    }
    
}
