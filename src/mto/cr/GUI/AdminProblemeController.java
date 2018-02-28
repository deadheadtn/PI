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
import javafx.event.Event;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
import mto.cr.DAO.Classe.ProblemeDAO;
import static mto.cr.GUI.AdminController.notifnum;
import static mto.cr.GUI.ProfilsController.selected;
import mto.cr.Model.Probleme;

/**
 *
 * @author bouda
 */
public class AdminProblemeController implements Initializable{

    @FXML
    private ListView<Probleme> listProbleme;
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
    private TextField searchText;
    @FXML
    private Pane searchButton;

  
    
    
    
    
    
    
       private ObservableList<Probleme> data;
    AdministrateurDAO adminDAO = new AdministrateurDAO();
    ProblemeDAO problemeDAO = new ProblemeDAO();
    @FXML
    private Text AccederResolus;
    @FXML
    private Text AccederTous;
  private  List<Probleme> problemes = new ArrayList<>();
    @FXML
    private MenuItem TitreMenuItem;
    @FXML
    private MenuItem SecteurMenuItem;
    @FXML
    private MenuItem UserMenuItem;
    @FXML
    private Text AccederNonResolus;
    @FXML
    private MenuButton RechercherMenuButton;
    @FXML
    private Text notificationNumber;
    public static Probleme adminProbleme;
    public void afficherToutProbleme(){
        AdministrateurDAO adminDAO = new AdministrateurDAO(); 

        
        problemes = problemeDAO.getAll();
        data = FXCollections.observableArrayList();
        data.addAll(problemes);
        listProbleme.setItems(data);
       afficherProbleme();
    
    
    }
    public void afficherProblemeResolu(){
        AdministrateurDAO adminDAO = new AdministrateurDAO(); 
        problemes = problemeDAO.findByEtat("resolu");
        data = FXCollections.observableArrayList();
        data.addAll(problemes);
        listProbleme.setItems(data);
       afficherProbleme();

}
     public void afficherProblemeNonResolu(){
        AdministrateurDAO adminDAO = new AdministrateurDAO(); 
        problemes = problemeDAO.findByEtat("encours");
        data = FXCollections.observableArrayList();
        data.addAll(problemes);
        
        listProbleme.setItems(data);
       afficherProbleme();

}
    
    
    public void afficherProbleme(){
        AdministrateurDAO adminDAO = new AdministrateurDAO(); 
     
   
        
        try{
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
                            HBox hb1 = new HBox(20);
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
                            Label NiveauRequis = new Label("Niveau : " + t.getNiveauRequis());
                            Label nbrCommentaire = new Label ("nbrCommentaire : " + t.getNbrCommentaireProbleme());
                            Label User = new Label( t.getUser().getUsername());
                             Text Conetenu = new Text("Contenue  : " + t.getContenu());
                             Conetenu.wrappingWidthProperty().set(350);
                             Button valider = new Button("V");
                             Button suprrimer = new Button("X");
                            //Button accederCommentaire = new Button("AC");
                             valider.getStyleClass().add("buttonLogin");
                             getStyleClass().add("buttonLogin:hover");
                             //accederCommentaire.getStyleClass().add("buttonLogin");
                             suprrimer.getStyleClass().add("buttonLogin");
                            Titre.setFont(Font.font ("System", 16));
                            Secteur.setFont(Font.font ("System", 16));
                            Date.setFont(Font.font ("System", 16));
                            Etat.setFont(Font.font ("System", 16));
                            NiveauRequis.setFont(Font.font ("System", 16));
                            nbrCommentaire.setFont(Font.font ("System", 16));
                            User.setFont(Font.font ("System", 16));
                        
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
                            if (t.getValide()==1){
                            valider.setVisible(false);
                            
                            }
                            
                           
                            hb1.getChildren().addAll(valider,suprrimer , new Label(""));
                            vb4.getChildren().addAll(Titre,hb1);
                            vb.getChildren().addAll( imgv, User);
                            vb2.getChildren().addAll(Secteur, Date, nbrCommentaire);
                            vb3.getChildren().addAll(Etat,NiveauRequis,Conetenu);
                            hb.getChildren().addAll(vb1, vb, vb4 , vb2,vb3);

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
       afficherToutProbleme();
        AccederTous.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            public void handle(javafx.scene.input.MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {
                    afficherProbleme();
                } catch (Exception ex) {
                    Logger.getLogger(ProblemeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        AccederResolus.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            public void handle(javafx.scene.input.MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              afficherProblemeResolu();
            }
        });
        AccederNonResolus.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            public void handle(javafx.scene.input.MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              afficherProblemeNonResolu();
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

            openNav2.setToX(-10);
            openNav2.play();
        });

        navList2.setOnMouseExited((javafx.scene.input.MouseEvent event2) -> {

            closeNav2.setToX(-(navList2.getWidth()) + 78);
            closeNav2.play();
        });

        navList1.setOnMouseEntered((javafx.scene.input.MouseEvent event3) -> {

            //TranslateTransition openNav1 = new TranslateTransition(new Duration(350), navList1);
            openNav1.setToX(30);
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
        //
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
    private void EnterProfileAc(MouseEvent event) {
    }

    @FXML
    private void searchProbleme(MouseEvent event) {
    }

    @FXML
    private void afficherTitre(ActionEvent event) {
        if(searchText.getText().isEmpty()){
         searchText.setStyle("-fx-text-box-border: #f44336 ;"); }
        else{
         problemes = problemeDAO.findByTitre(searchText.getText().toLowerCase().trim());
         if(problemes.isEmpty()){
             Alert a = new Alert(Alert.AlertType.ERROR, "Pas de Resultat");
             a.show();
         afficherToutProbleme();
         }
         else{data = FXCollections.observableArrayList();
        data.addAll(problemes);
        listProbleme.setItems(data);
       afficherProbleme();
         RechercherMenuButton.setText("Titre");
         }
    }
    }
    @FXML
    private void afficherSecteur(ActionEvent event) {
         if(searchText.getText().isEmpty()){
         searchText.setStyle("-fx-text-box-border: #f44336 ;"); }
         else{
           if(problemes.isEmpty()){
             Alert a = new Alert(Alert.AlertType.ERROR, "Pas de Resultat");
             a.show();
         afficherToutProbleme();
         }
           else {problemes = problemeDAO.findBySecteur(searchText.getText().trim());
        data = FXCollections.observableArrayList();
        data.addAll(problemes);
        listProbleme.setItems(data);
       afficherProbleme();
             RechercherMenuButton.setText("Secteur");
           
           }
    }}

    @FXML
    private void AfficherUser(ActionEvent event) {
         if(searchText.getText().isEmpty()){
         searchText.setStyle("-fx-text-box-border: #f44336 ;"); }
         else{
        List<Probleme> lp = new ArrayList<>();
        
         lp = problemeDAO.getAll();
         for (Probleme probleme : lp) {
            if(probleme.getUser().getUsername().equals(searchText)){
            problemes.removeAll(problemes);
            problemes.add(probleme);
            
            }
        }
            if(problemes.isEmpty()){
             Alert a = new Alert(Alert.AlertType.ERROR, "Pas de Resultat");
             a.show();
         afficherToutProbleme();
         }
            else {data = FXCollections.observableArrayList();
        data.addAll(problemes);
        listProbleme.setItems(data);
       afficherProbleme();
              RechercherMenuButton.setText("User");}
    }}
    
}
