/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Reclamation;
import entite.news;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GestionNews;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author deadhead
 */
public class NewsController implements Initializable {
    ObservableList<news> data=FXCollections.observableArrayList();
    ObservableList<news> data1=FXCollections.observableArrayList();
    ObservableList<news> data2=FXCollections.observableArrayList();
    PreparedStatement prst= null;
    ResultSet rs;
    @FXML
    TableView<news> table;
    @FXML
    TableView<news> table1;
    @FXML
    TableView<news> table2;
    @FXML
    private TextField titre;
    @FXML
    private TextArea texte;
    @FXML
    private TextField image;
    @FXML
    private TextField mot_cle;
    @FXML
    private TextField type;
    @FXML
    Button add;
    @FXML
    private TableColumn<?,?> idCol;
    @FXML
    private TableColumn<?,?> TitreCol;
    @FXML
    private TableColumn<?,?> typeCol;
    @FXML
    private TableColumn<?,?> MotCleCol;
    @FXML
    private TableColumn<?,?> TexteCol;
    @FXML
    private TableColumn<?,?> imageCol;
    @FXML
    private TableColumn<?,?> idCol1;
    @FXML
    private TableColumn<?,?> TitreCol1;
    @FXML
    private TableColumn<?,?> typeCol1;
    @FXML
    private TableColumn<?,?> MotCleCol1;
    @FXML
    private TableColumn<?,?> TexteCol1;
    @FXML
    private TableColumn<?,?> imageCol1;
    @FXML
    private TableColumn<?,?> idCol2;
    @FXML
    private TableColumn<?,?> TitreCol2;
    @FXML
    private TableColumn<?,?> typeCol2;
    @FXML
    private TableColumn<?,?> MotCleCol2;
    @FXML
    private TableColumn<?,?> TexteCol2;
    @FXML
    private TableColumn<?,?> imageCol2;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id_news"));
        TitreCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("TYPE_N"));
        MotCleCol.setCellValueFactory(new PropertyValueFactory<>("MOT_CLES"));
        TexteCol.setCellValueFactory(new PropertyValueFactory<>("text"));
        imageCol.setCellValueFactory(new PropertyValueFactory<>("image"));
        idCol1.setCellValueFactory(new PropertyValueFactory<>("id_news"));
        TitreCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeCol1.setCellValueFactory(new PropertyValueFactory<>("TYPE_N"));
        MotCleCol1.setCellValueFactory(new PropertyValueFactory<>("MOT_CLES"));
        TexteCol1.setCellValueFactory(new PropertyValueFactory<>("text"));
        imageCol1.setCellValueFactory(new PropertyValueFactory<>("image"));
        idCol2.setCellValueFactory(new PropertyValueFactory<>("id_news"));
        TitreCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeCol2.setCellValueFactory(new PropertyValueFactory<>("TYPE_N"));
        MotCleCol2.setCellValueFactory(new PropertyValueFactory<>("MOT_CLES"));
        TexteCol2.setCellValueFactory(new PropertyValueFactory<>("text"));
        imageCol2.setCellValueFactory(new PropertyValueFactory<>("image"));
        afficher();
        afficherT1();
        afficherT2();
        // TODO
    }    
    public void add() throws SQLException{
        news n=new news(1,1,titre.getText(),type.getText(),mot_cle.getText(),texte.getText(),image.getText());
        GestionNews g = new GestionNews();
        try{
        if(g.addNews(n)){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Success");
            alert.setContentText("L'article a été enregistrer avec succes");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Erreur");
            alert.setContentText("Une erreur est survenu lors de l'ajout");

            alert.showAndWait();
        }
        }
        catch(Exception e){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Erreur");
            alert.setContentText("Une erreur est survenu lors de l'ajout");

            alert.showAndWait();
            System.err.println(e);
        }
    }
    public void afficher(){
        for ( int i = 0; i<table.getItems().size(); i++) {
            table.getItems().clear();
        }
        String query="Select * from news;";
        try{
            Connection cnx= DataSource.getInstance().getConnection();
            prst= cnx.prepareStatement(query);
            rs= prst.executeQuery();
            while(rs.next()){
                data.add(new news(rs.getInt("ID_NEWS"),1,rs.getString("TITRE_N"),rs.getString("TYPE_N"),rs.getString("MOT_CLES"),rs.getString("TEXTE_N"),rs.getString("IMAGE_N")));
            }
            //System.err.println(data);
            table.setItems(data);
            prst.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public void afficherT1(){
        for ( int i = 0; i<table1.getItems().size(); i++) {
            table1.getItems().clear();
        }
        String query="Select * from news;";
        try{
            Connection cnx= DataSource.getInstance().getConnection();
            prst= cnx.prepareStatement(query);
            rs= prst.executeQuery();
            while(rs.next()){
                data1.add(new news(rs.getInt("ID_NEWS"),1,rs.getString("TITRE_N"),rs.getString("TYPE_N"),rs.getString("MOT_CLES"),rs.getString("TEXTE_N"),rs.getString("IMAGE_N")));
            }
            //System.err.println(data);
            table1.setItems(data1);
            prst.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public void afficherT2(){
        for ( int i = 0; i<table2.getItems().size(); i++) {
            table2.getItems().clear();
        }
        String query="Select * from news;";
        try{
            Connection cnx= DataSource.getInstance().getConnection();
            prst= cnx.prepareStatement(query);
            rs= prst.executeQuery();
            while(rs.next()){
                data2.add(new news(rs.getInt("ID_NEWS"),1,rs.getString("TITRE_N"),rs.getString("TYPE_N"),rs.getString("MOT_CLES"),rs.getString("TEXTE_N"),rs.getString("IMAGE_N")));
            }
            //System.err.println(data);
            table2.setItems(data2);
            prst.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public void modifier() throws SQLException{
        news modifier= new news();
        GestionNews g= new GestionNews();
        modifier.setId_cooperation(table1.getSelectionModel().getSelectedItem().getId_cooperation());
        modifier.setId_news(table1.getSelectionModel().getSelectedItem().getId_news());
        modifier.setImage(table1.getSelectionModel().getSelectedItem().getImage());
        modifier.setTYPE_N(table1.getSelectionModel().getSelectedItem().getTYPE_N());
        modifier.setMOT_CLES(table1.getSelectionModel().getSelectedItem().getMOT_CLES());
        modifier.setTitle(table1.getSelectionModel().getSelectedItem().getTitle());
        modifier.setText(table1.getSelectionModel().getSelectedItem().getText());
        TablePosition pos = table1.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        if(pos.getColumn()==0){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Erreur");
                alert.setContentText("Une erreur est survenu lors de la modification");
                alert.showAndWait();
            }
        // Item here is the table view type:
        news item = table1.getItems().get(row);

        TableColumn col = pos.getTableColumn();
        
        // this gives the value in the selected cell:
        
        String data = (String) col.getCellObservableValue(item).getValue();
        TextInputDialog dialog = new TextInputDialog(data.toString());
        dialog.setTitle("Modifier");
        dialog.setHeaderText("Fenetre de modification");
        dialog.setContentText("Modifier la cellule:");
        int Colo=pos.getColumn();
        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            
            if (Colo==1){
                modifier.setTitle(result.get());
                g.modifynews(modifier);
            }
            else if (Colo==2){
                modifier.setImage(result.get());
                g.modifynews(modifier);
            }
            else if (Colo==3){
                modifier.setText(result.get());
                g.modifynews(modifier);
            }
            else if (Colo==4){
                modifier.setMOT_CLES(result.get());
                g.modifynews(modifier);
            }
            else if (Colo==5){
                modifier.setTYPE_N(result.get());
                g.modifynews(modifier);
            }
            //result.get()
        }
        afficherT1();
        // The Java 8 way to get the response value (with lambda expression).
        //result.ifPresent(name -> System.out.println("Your name: " + name));
    }
    public void Supprimer() throws SQLException{
        news modifier= new news();
        GestionNews g= new GestionNews();
        int id=table2.getSelectionModel().getSelectedItem().getId_news();
        String selection = null;
        Alert alert = new Alert(AlertType.CONFIRMATION, "Delete " + selection + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        modifier.setId_news(id);
        
        if (alert.getResult() == ButtonType.YES) {
            g.DeleteNews(modifier);
        }

        afficherT2();
        // The Java 8 way to get the response value (with lambda expression).
        //result.ifPresent(name -> System.out.println("Your name: " + name));
    }
}
