/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Reclamation;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author deadhead
 */
public class ReclamationController implements Initializable {

    ObservableList<Reclamation> data=FXCollections.observableArrayList();
    PreparedStatement prst= null;
    ResultSet rs;
    @FXML
    TableView<Reclamation> rec;
    @FXML
    private TableColumn<? , ?> DESCRIPTION_RECCol;
    @FXML
    private TableColumn<? , ?> emailCol;
    @FXML
    private TableColumn<? , ?> SUJET_RECCol;
    @FXML
    private TableColumn<? , ?> DATE_RECCol;
    Button RecTraite;
    Button RecNTraite;
    Button RecETraite;
    /**
     *
     * @param url
     * @param rb
     */
    @FXML
    //private TableColumn<? , ?> idCol;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DESCRIPTION_RECCol.setCellValueFactory(new PropertyValueFactory<>("DESCRIPTION_REC"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        SUJET_RECCol.setCellValueFactory(new PropertyValueFactory<>("SUJET_REC"));
        DATE_RECCol.setCellValueFactory(new PropertyValueFactory<>("DATE_REC"));
        
    }    
    public void loadReclamationtraiter(){
        for ( int i = 0; i<rec.getItems().size(); i++) {
            rec.getItems().clear();
        }
        String query="Select `SUJET_REC`,`DESCRIPTION_REC`,`DATE_REC`,`email` from reclamation r INNER JOIN utilisateur p ON r.ID_UTILISATEUR=p.ID_UTILISATEUR where r.ETAT_REC=1;";
        try{
            Connection cnx= DataSource.getInstance().getConnection();
            prst= cnx.prepareStatement(query);
            rs= prst.executeQuery();
            while(rs.next()){
                data.add(new Reclamation(rs.getString("email"),rs.getString("SUJET_REC"),rs.getString("DESCRIPTION_REC"),rs.getString("DATE_REC")));
            }
            rec.setItems(data);
            prst.close();
            rs.close();
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void loadReclamationNontraiter(){
        for ( int i = 0; i<rec.getItems().size(); i++) {
            rec.getItems().clear();
        }
        String query="Select `SUJET_REC`,`DESCRIPTION_REC`,`DATE_REC`,`email` from reclamation r INNER JOIN utilisateur p ON r.ID_UTILISATEUR=p.ID_UTILISATEUR where r.ETAT_REC=0;";
        try{
            Connection cnx= DataSource.getInstance().getConnection();
            prst= cnx.prepareStatement(query);
            rs= prst.executeQuery();
            while(rs.next()){
                data.add(new Reclamation(rs.getString("email"),rs.getString("SUJET_REC"),rs.getString("DESCRIPTION_REC"),rs.getString("DATE_REC")));
            }
            rec.setItems(data);
            prst.close();
            rs.close();
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void loadReclamationEnCoursdetraitement(){
        for ( int i = 0; i<rec.getItems().size(); i++) {
            rec.getItems().clear();
        }
        String query="Select `SUJET_REC`,`DESCRIPTION_REC`,`DATE_REC`,`email` from reclamation r INNER JOIN utilisateur p ON r.ID_UTILISATEUR=p.ID_UTILISATEUR where r.ETAT_REC=2;";
        try{
            Connection cnx= DataSource.getInstance().getConnection();
            prst= cnx.prepareStatement(query);
            rs= prst.executeQuery();
            while(rs.next()){
                data.add(new Reclamation(rs.getString("email"),rs.getString("SUJET_REC"),rs.getString("DESCRIPTION_REC"),rs.getString("DATE_REC")));
            }
            rec.setItems(data);
            prst.close();
            rs.close();
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
}
