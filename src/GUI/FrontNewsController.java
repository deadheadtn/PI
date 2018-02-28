/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.scene.image.Image ;
import javafx.scene.control.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.DataSource;
/**
 * FXML Controller class
 *
 * @author deadhead
 */
public class FrontNewsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button ReclamationB= new Button();
    @FXML
    Button NewsB= new Button();
    @FXML
    ImageView image1= new ImageView();
    @FXML
    ImageView image2= new ImageView();
            
    @FXML
    ImageView image3= new ImageView();
    @FXML
    ImageView image4= new ImageView();
    @FXML
    ImageView image5= new ImageView();
    @FXML
    ImageView image6= new ImageView();
    @FXML
    Label Title1 = new Label("Your long text here");
    @FXML
    Label Title2 = new Label("Your long text here");
    @FXML
    Label Title3 = new Label("Your long text here");
    @FXML
    Label Title4 = new Label("Your long text here");
    @FXML
    Label Title5 = new Label("Your long text here");
    @FXML
    Label Title6 = new Label("Your long text here");
    @FXML
    Text t1 = new Text();
    
    @FXML
    Text t2 = new Text();

    @FXML
    Text t3 = new Text();
    @FXML
    Text t4 = new Text();
    @FXML
    Text t5 = new Text();
    @FXML
    Text t6 = new Text();

    
    PreparedStatement prst= null;
    ResultSet rs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
        // TODO
    }    
    public void afficher(){
        String strOut = null;
        String query="Select * from news order by ID_NEWS desc limit 6;";
        try{
            Connection cnx= DataSource.getInstance().getConnection();
            prst= cnx.prepareStatement(query);
            rs= prst.executeQuery();
            int count=0;
            while(rs.next()){
                count=count+1;
                switch (count) {
                    case 1:
                        Title1.setText(rs.getString("TITRE_N"));
                        //String text=rs.getString("TEXTE_N");
                        t1.setWrappingWidth(200);
                        //
                        if(rs.getString("TEXTE_N").length() > 100)
                            strOut = rs.getString("TEXTE_N").substring(0,100) + "...";
                        t1.setText(strOut);
                        Image image11 = new Image(rs.getString("IMAGE_N"));
                        image1.setImage(image11);
                        break;
                    case 2:
                        Title2.setText(rs.getString("TITRE_N"));
                        t2.setWrappingWidth(200);
                        if(rs.getString("TEXTE_N").length() > 100)
                            strOut = rs.getString("TEXTE_N").substring(0,100) + "...";
                        t2.setText(strOut);
                        Image image22 = new Image(rs.getString("IMAGE_N"));
                        image2.setImage(image22);
                        break;
                    case 3:
                        Title3.setText(rs.getString("TITRE_N"));
                        t3.setWrappingWidth(200);
                        if(rs.getString("TEXTE_N").length() > 100)
                            strOut = rs.getString("TEXTE_N").substring(0,100) + "...";
                        t3.setText(strOut);
                        Image image33 = new Image(rs.getString("IMAGE_N"));
                        image3.setImage(image33);
                        break;
                    case 4:
                        Title4.setText(rs.getString("TITRE_N"));
                        t4.setWrappingWidth(200);
                        if(rs.getString("TEXTE_N").length() > 100)
                            strOut = rs.getString("TEXTE_N").substring(0,100) + "...";
                        t4.setText(strOut);
                        Image image44 = new Image(rs.getString("IMAGE_N"));
                        image4.setImage(image44);
                        break;
                    case 5:
                        Title5.setText(rs.getString("TITRE_N"));
                        t5.setWrappingWidth(200);
                        if(rs.getString("TEXTE_N").length() > 100)
                            strOut = rs.getString("TEXTE_N").substring(0,100) + "...";
                        t5.setText(strOut);
                        Image image55 = new Image(rs.getString("IMAGE_N"));
                        image5.setImage(image55);
                        break;
                    case 6:
                        Title6.setText(rs.getString("TITRE_N"));
                        t6.setWrappingWidth(200);
                        if(rs.getString("TEXTE_N").length() > 100)
                            strOut = rs.getString("TEXTE_N").substring(0,100) + "...";
                        t6.setText(strOut);
                        Image image66 = new Image(rs.getString("IMAGE_N"));
                        image6.setImage(image66);
                        break;
                    default:
                        break;
                }
            }

            prst.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }

        @FXML
        private void Reclamation(ActionEvent event) throws IOException{
            Parent home_page_parent =FXMLLoader.load(getClass().getResource("ReclamationF.fxml")) ;
            Scene home_page_scene = new Scene (home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
    }
}
