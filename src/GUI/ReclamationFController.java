/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import entite.Reclamation;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javax.mail.MessagingException;
import service.Gestion_reclamation;
import utils.MailService;
/**
 * FXML Controller class
 *
 * @author deadhead
 */
public class ReclamationFController implements Initializable {
    @FXML
    Button add;
    @FXML
    TextField sujet;
    @FXML
    TextArea desc;
    @FXML
    TextField email;
    /**
     * Initializes the controller class.
     */
    @FXML
    Button News= new Button();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    private void News(ActionEvent event) throws IOException{
            Parent home_page_parent =FXMLLoader.load(getClass().getResource("FrontNews.fxml")) ;
            Scene home_page_scene = new Scene (home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
    }
    public void envoyer() throws MessagingException{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Reclamation r= new Reclamation(email.getText(),sujet.getText(),desc.getText(),cal.getTime().toString());
        MailService m = new MailService();
        
        Gestion_reclamation g = new Gestion_reclamation();        
        try{
        if(g.addReclamation(r)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Success");
            alert.setContentText("La reclamation a été enregistrer avec succes");
            m.confirmationReclamation(r.getEmail(),r.getDESCRIPTION_REC());
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Erreur");
            alert.setContentText("Une erreur est survenu lors de l'envoie");

            alert.showAndWait();
        }
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Erreur");
            alert.setContentText("Une erreur est survenu lors de l'envoie");

            alert.showAndWait();
            System.err.println(e);
        }
    }
    public void NewsButton(ActionEvent event) throws IOException{
        Parent reclamationview = FXMLLoader.load(getClass().getResource("FrontNews.fxml"));
        Scene news_scene= new Scene(reclamationview);
        Stage newsStage;
        newsStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newsStage.hide();
        newsStage.setScene(news_scene);
        newsStage.show();
        
    }
}
