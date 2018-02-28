/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.GUI;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;
import mto.cr.Model.Mail;
import mto.cr.DAO.Classe.UserDAO;
import mto.cr.Model.User;
import mto.cr.Technique.ConfigurationJava;

/**
 *
 * @author Chiheb
 */
public class ModifierPasswordController implements Initializable {

    @FXML
    private Button buttonValiderChangePassword;
    @FXML
    private PasswordField rePsw;
    @FXML
    private PasswordField psw;
    @FXML
    private Button errorVerifPsw;
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
    private Button deconnexion;
    @FXML
    private PasswordField oldPasswordVal;
    @FXML
    private Text nomPrenomMonProfil;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorVerifPsw.setVisible(false);
        psw.setOnMouseClicked((MouseEvent event1) -> {
            psw.setStyle("-fx-text-box-border: transparent;");
            rePsw.setStyle("-fx-text-box-border: transparent;");
            oldPasswordVal.setStyle("-fx-text-box-border: transparent;");
            psw.clear();
            rePsw.clear();
        });
        ImageView imgVi = new ImageView();
        String mm = "";

        if (LoginController.logged.getPath().startsWith("https://")) {
            mm = (LoginController.logged.getPath()).trim();
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
        
        AccederForum.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try {

                    Stage stage = new Stage();
                    Stage stageprev = (Stage) AccederForum.getScene().getWindow();

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
                    stage.show();
                    stageprev.close();
                } catch (IOException ex) {
                    Logger.getLogger(MonProfilController.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(MonProfilController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

            
//*************************************************End Navigation*************************************************
        
//****************************************** Mon Profil **********************************************************

        nomPrenomMonProfil.setText(LoginController.logged.getNom().toUpperCase() + " " + LoginController.logged.getPrenom());

        emailMonProfil.setText(LoginController.logged.getEmail_canonical());

        varUsernameToolBar.setText(LoginController.logged.getUsername_canonical());
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
    private void validerChangePasword(ActionEvent event) throws UnsupportedEncodingException, MessagingException {
        User u = new User();
        UserDAO userDAO = new UserDAO();
        u.setPassword(psw.getText());
        u.setEmail_canonical(LoginController.logged.getEmail_canonical());
        
        if (psw.getText().equals(rePsw.getText()) &&  oldPasswordVal.getText().equals(LoginController.logged.getPassword())) {
            userDAO.updatePassword(u);
            Mail m = new Mail();
            String s = "";
            if (LoginController.logged.getSexe().equals("male")) {
                s = "Mr ";
            } else {
                s = "Mme ";
            }
//            m.Send(LoginController.logged.getEmail_canonical(), 
//                    "</br></br>Bonjour" + s + LoginController.logged.getNom() + ",</br></br>" +
//                    
//                    "Votre Mot de Passe a été mise à jour \n votre nouveau mot de passe est" + psw.getText()
//                   +"</br> &nbsp;* si vous avez besoin d'aide nous somme toujours à votre disponibilité:"
//                   +"</br> &nbsp;&nbsp; facebook : https://apps.facebook.com/mtocrowdrise/?ref=ts&fref=ts"
//                   +"</br> &nbsp;&nbsp; Tél : +216.12.345.678" 
//            );
            m.Send(LoginController.logged.getEmail_canonical(), "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
                    + "\n"
                    + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                    + "<head>\n"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
                    + "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                    + "	<title>[SUBJECT]</title>\n"
                    + "	<style type=\"text/css\">\n"
                    + "\n"
                    + "@media screen and (max-width: 600px) {\n"
                    + "    table[class=\"container\"] {\n"
                    + "        width: 95% !important;\n"
                    + "    }\n"
                    + "}\n"
                    + "\n"
                    + "	#outlook a {padding:0;}\n"
                    + "		body{width:100% !important; -webkit-text-size-adjust:100%; -ms-text-size-adjust:100%; margin:0; padding:0;}\n"
                    + "		.ExternalClass {width:100%;}\n"
                    + "		.ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div {line-height: 100%;}\n"
                    + "		#backgroundTable {margin:0; padding:0; width:100% !important; line-height: 100% !important;}\n"
                    + "		img {outline:none; text-decoration:none; -ms-interpolation-mode: bicubic;}\n"
                    + "		a img {border:none;}\n"
                    + "		.image_fix {display:block;}\n"
                    + "		p {margin: 1em 0;}\n"
                    + "		h1, h2, h3, h4, h5, h6 {color: black !important;}\n"
                    + "\n"
                    + "		h1 a, h2 a, h3 a, h4 a, h5 a, h6 a {color: blue !important;}\n"
                    + "\n"
                    + "		h1 a:active, h2 a:active,  h3 a:active, h4 a:active, h5 a:active, h6 a:active {\n"
                    + "			color: red !important; \n"
                    + "		 }\n"
                    + "\n"
                    + "		h1 a:visited, h2 a:visited,  h3 a:visited, h4 a:visited, h5 a:visited, h6 a:visited {\n"
                    + "			color: purple !important; \n"
                    + "		}\n"
                    + "\n"
                    + "		table td {border-collapse: collapse;}\n"
                    + "\n"
                    + "		table { border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt; }\n"
                    + "\n"
                    + "		a {color: #000;}\n"
                    + "\n"
                    + "		@media only screen and (max-device-width: 480px) {\n"
                    + "\n"
                    + "			a[href^=\"tel\"], a[href^=\"sms\"] {\n"
                    + "						text-decoration: none;\n"
                    + "						color: black; /* or whatever your want */\n"
                    + "						pointer-events: none;\n"
                    + "						cursor: default;\n"
                    + "					}\n"
                    + "\n"
                    + "			.mobile_link a[href^=\"tel\"], .mobile_link a[href^=\"sms\"] {\n"
                    + "						text-decoration: default;\n"
                    + "						color: orange !important; /* or whatever your want */\n"
                    + "						pointer-events: auto;\n"
                    + "						cursor: default;\n"
                    + "					}\n"
                    + "		}\n"
                    + "\n"
                    + "\n"
                    + "		@media only screen and (min-device-width: 768px) and (max-device-width: 1024px) {\n"
                    + "			a[href^=\"tel\"], a[href^=\"sms\"] {\n"
                    + "						text-decoration: none;\n"
                    + "						color: blue; /* or whatever your want */\n"
                    + "						pointer-events: none;\n"
                    + "						cursor: default;\n"
                    + "					}\n"
                    + "\n"
                    + "			.mobile_link a[href^=\"tel\"], .mobile_link a[href^=\"sms\"] {\n"
                    + "						text-decoration: default;\n"
                    + "						color: orange !important;\n"
                    + "						pointer-events: auto;\n"
                    + "						cursor: default;\n"
                    + "					}\n"
                    + "		}\n"
                    + "\n"
                    + "		@media only screen and (-webkit-min-device-pixel-ratio: 2) {\n"
                    + "			/* Put your iPhone 4g styles in here */\n"
                    + "		}\n"
                    + "\n"
                    + "		@media only screen and (-webkit-device-pixel-ratio:.75){\n"
                    + "			/* Put CSS for low density (ldpi) Android layouts in here */\n"
                    + "		}\n"
                    + "		@media only screen and (-webkit-device-pixel-ratio:1){\n"
                    + "			/* Put CSS for medium density (mdpi) Android layouts in here */\n"
                    + "		}\n"
                    + "		@media only screen and (-webkit-device-pixel-ratio:1.5){\n"
                    + "			/* Put CSS for high density (hdpi) Android layouts in here */\n"
                    + "		}\n"
                    + "		/* end Android targeting */\n"
                    + "		h2{\n"
                    + "			color:#181818;\n"
                    + "			font-family:Helvetica, Arial, sans-serif;\n"
                    + "			font-size:22px;\n"
                    + "			line-height: 22px;\n"
                    + "			font-weight: normal;\n"
                    + "		}\n"
                    + "		a.link1{\n"
                    + "\n"
                    + "		}\n"
                    + "		a.link2{\n"
                    + "			color:#fff;\n"
                    + "			text-decoration:none;\n"
                    + "			font-family:Helvetica, Arial, sans-serif;\n"
                    + "			font-size:16px;\n"
                    + "			color:#fff;border-radius:4px;\n"
                    + "		}\n"
                    + "		p{\n"
                    + "			color:#555;\n"
                    + "			font-family:Helvetica, Arial, sans-serif;\n"
                    + "			font-size:16px;\n"
                    + "			line-height:160%;\n"
                    + "		}\n"
                    + "	</style>\n"
                    + "\n"
                    + "<script type=\"colorScheme\" class=\"swatch active\">\n"
                    + "  {\n"
                    + "    \"name\":\"Default\",\n"
                    + "    \"bgBody\":\"ffffff\",\n"
                    + "    \"link\":\"fff\",\n"
                    + "    \"color\":\"555555\",\n"
                    + "    \"bgItem\":\"ffffff\",\n"
                    + "    \"title\":\"181818\"\n"
                    + "  }\n"
                    + "</script>\n"
                    + "\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "	<!-- Wrapper/Container Table: Use a wrapper table to control the width and the background color consistently of your email. Use this approach instead of setting attributes on the body tag. -->\n"
                    + "	<table cellpadding=\"0\" width=\"100%\" cellspacing=\"0\" border=\"0\" id=\"backgroundTable\" class='bgBody'>\n"
                    + "	<tr>\n"
                    + "		<td>\n"
                    + "	<table cellpadding=\"0\" width=\"620\" class=\"container\" align=\"center\" cellspacing=\"0\" border=\"0\">\n"
                    + "	<tr>\n"
                    + "		<td>\n"
                    + "		<!-- Tables are the most common way to format your email consistently. Set your table widths inside cells and in most cases reset cellpadding, cellspacing, and border to zero. Use nested tables as a way to space effectively in your message. -->\n"
                    + "		\n"
                    + "\n"
                    + "		<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" class=\"container\">\n"
                    + "			<tr>\n"
                    + "				<td class='movableContentContainer bgItem'>\n"
                    + "\n"
                    + "					<div class='movableContent'>\n"
                    + "						<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" class=\"container\">\n"
                    + "							<tr height=\"40\">\n"
                    + "								<td width=\"200\">&nbsp;</td>\n"
                    + "								<td width=\"200\">&nbsp;</td>\n"
                    + "								<td width=\"200\">&nbsp;</td>\n"
                    + "							</tr>\n"
                    + "							<tr>\n"
                    + "								<td width=\"200\" valign=\"top\">&nbsp;</td>\n"
                    + "								<td width=\"200\" valign=\"top\" align=\"center\">\n"
                    + "									<div class=\"contentEditableContainer contentImageEditable\">\n"
                    + "					                	<div class=\"contentEditable\" align='center' >\n"
                    + "					                  		<img src=\"http://img15.hostingpics.net/pics/857093logoAll.png\" width=\"155\" height=\"155\"  alt='Logo'  data-default=\"placeholder\" />\n"
                    + "					                	</div>\n"
                    + "					              	</div>\n"
                    + "								</td>\n"
                    + "								<td width=\"200\" valign=\"top\">&nbsp;</td>\n"
                    + "							</tr>\n"
                    + "							<tr height=\"25\">\n"
                    + "								<td width=\"200\">&nbsp;</td>\n"
                    + "								<td width=\"200\">&nbsp;</td>\n"
                    + "								<td width=\"200\">&nbsp;</td>\n"
                    + "							</tr>\n"
                    + "						</table>\n"
                    + "					</div>\n"
                    + "\n"
                    + "					<div class='movableContent'>\n"
                    + "						<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" class=\"container\">\n"
                    + "							<tr>\n"
                    + "								<td width=\"100%\" colspan=\"3\" align=\"center\" style=\"padding-bottom:10px;padding-top:25px;\">\n"
                    + "									<div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "					                	<div class=\"contentEditable\" align='center' >\n"
                    + "					                  		<h2 >MTOCrowdRise Service</h2>\n"
                    + "					                	</div>\n"
                    + "					              	</div>\n"
                    + "								</td>\n"
                    + "							</tr>\n"
                    + "							<tr>\n"
                    + "								<td width=\"100\">&nbsp;</td>\n"
                    + "								<td width=\"400\" align=\"center\">\n"
                    + "									<div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "					                	<div class=\"contentEditable\" align='left' >\n"
                    + "					                  		<p >Bonjour " + s + " " + LoginController.logged.getNom() + ",\n"
                    + "					                  			<br/>\n"
                    + "					                  			<br/>\n"
                    + "												Votre mot de passe est maintenant mise a jour.<br/>\n votre nouveau mot de passe est <span style=\"color:rgb(80,80,80);\">" + psw.getText() + "</span></p>\n"
                    + "					                	</div>\n"
                    + "					              	</div>\n"
                    + "								</td>\n"
                    + "								<td width=\"100\">&nbsp;</td>\n"
                    + "							</tr>\n"
                    + "						</table>\n"
                    + "						<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" class=\"container\">\n"
                    + "							<tr>\n"
                    + "								<td width=\"200\">&nbsp;</td>\n"
                    + "								<td width=\"200\" align=\"center\" style=\"padding-top:25px;\">\n"
                    + "									<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"200\" height=\"50\">\n"
                    + "										<tr>\n"
                    + "											<td bgcolor=\"#ED006F\" align=\"center\" style=\"border-radius:4px;\" width=\"200\" height=\"50\">\n"
                    + "												<div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "								                	<div class=\"contentEditable\" align='center' >\n"
                    + "								                  		<a target='_blank' href=\""+ ConfigurationJava.localPath+"/MTOCrowdRise/web/app_dev.php/login\" class='link2'>Visiter notre site</a>\n"
                    //+ "								                  		<a target='_blank' href=\"http://localhost:8888/MTOCrowdRise/web/app_dev.php/login\" class='link2'>Visiter notre site</a>\n"
                    
                    + "								                	</div>\n"
                    + "								              	</div>\n"
                    + "											</td>\n"
                    + "										</tr>\n"
                    + "									</table>\n"
                    + "								</td>\n"
                    + "								<td width=\"200\">&nbsp;</td>\n"
                    + "							</tr>\n"
                    + "						</table>\n"
                    + "					</div>\n"
                    + "\n"
                    + "\n"
                    + "					<div class='movableContent'>\n"
                    + "						<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" class=\"container\">\n"
                    + "							<tr>\n"
                    + "								<td width=\"100%\" colspan=\"2\" style=\"padding-top:65px;\">\n"
                    + "									<hr style=\"height:1px;border:none;color:#333;background-color:#ddd;\" />\n"
                    + "								</td>\n"
                    + "							</tr>\n"
                    + "							<tr>\n"
                    + "								<td width=\"60%\" height=\"70\" valign=\"middle\" style=\"padding-bottom:20px;\">\n"
                    + "									<div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "					                	<div class=\"contentEditable\" align='left' >\n"
                    + "					                  		<span style=\"font-size:13px;color:#181818;font-family:Helvetica, Arial, sans-serif;line-height:200%;\">Sent to " + LoginController.logged.getEmail_canonical() + " by MTOCrowdRise Service</span>\n"
                    + "											<br/>\n"
                    + "											<span style=\"font-size:11px;color:#555;font-family:Helvetica, Arial, sans-serif;line-height:200%;\"> Ariana Soghra Tunis | +216.12.345.678</span>\n"
                    + "											<br/>\n"
                    + "											<br/>\n"
                    + "					                	</div>\n"
                    + "					              	</div>\n"
                    + "								</td>\n"
                    + "								<td width=\"40%\" height=\"70\" align=\"right\" valign=\"top\" align='right' style=\"padding-bottom:20px;\">\n"
                    + "									<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align='right'>\n"
                    + "										<tr>\n"
                    + "											<td width='57%'></td>\n"
                    + "											<td valign=\"top\" width='34'>\n"
                    + "												<div class=\"contentEditableContainer contentFacebookEditable\" style='display:inline;'>\n"
                    + "							                        <div class=\"contentEditable\" >\n"
                    + "							                            <img src=\"http://www.theboatsafe.com/wp-content/uploads/shopp/Facebook.Circle.png\" data-default=\"placeholder\" data-max-width='30' data-customIcon=\"true\" width='30' height='30' alt='facebook' style='margin-right:40x;'>\n"
                    + "							                        </div>\n"
                    + "							                    </div>\n"
                    + "											</td>\n"
                    + "											<td valign=\"top\" width='34'>\n"
                    + "												<div class=\"contentEditableContainer contentTwitterEditable\" style='display:inline;'>\n"
                    + "							                      <div class=\"contentEditable\" >\n"
                    + "							                        <img src=\"http://icons.iconarchive.com/icons/sicons/basic-round-social/512/twitter-icon.png\" data-default=\"placeholder\" data-max-width='30' data-customIcon=\"true\" width='30' height='30' alt='twitter' style='margin-right:40x;'>\n"
                    + "							                      </div>\n"
                    + "							                    </div>\n"
                    + "											</td>\n"
                    + "											<td valign=\"top\" width='34'>\n"
                    + "												<div class=\"contentEditableContainer contentImageEditable\" style='display:inline;'>\n"
                    + "							                      <div class=\"contentEditable\" >\n"
                    + "														<img src=\"http://kizeeva.com/images/deliciousladies_google.png\" width=\"30\" height=\"30\" data-max-width=\"30\" alt='pinterest' style='margin-right:40x;' />\n"
                    + "							                      </div>\n"
                    + "							                    </div>\n"
                    + "											</td>\n"
                    + "										</tr>\n"
                    + "									</table>\n"
                    + "								</td>\n"
                    + "							</tr>\n"
                    + "						</table>\n"
                    + "					</div>\n"
                    + "\n"
                    + "\n"
                    + "				</td>\n"
                    + "			</tr>\n"
                    + "		</table>\n"
                    + "\n"
                    + "		\n"
                    + "		\n"
                    + "\n"
                    + "	</td></tr></table>\n"
                    + "	\n"
                    + "		</td>\n"
                    + "	</tr>\n"
                    + "	</table>\n"
                    + "	<!-- End of wrapper table -->\n"
                    + "\n"
                    + "<!--Default Zone\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"image\">\n"
                    + "        <div class=\"movableContent\">\n"
                    + "        	<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\">        		\n"
                    + "				<tr><td colspan='3' height='30'></td></tr>\n"
                    + "				<tr>\n"
                    + "					<td width=\"50\">&nbsp;</td>\n"
                    + "					<td width=\"500\" colspan=\"3\" align=\"center\" style=\"padding-bottom:10px;padding-top:25px;\">\n"
                    + "						<div class=\"contentEditableContainer contentImageEditable\">\n"
                    + "			                <div class=\"contentEditable\">\n"
                    + "			                   <img src=\"/applications/Mail_Interface/3_3/modules/User_Interface/core/v31_campaigns/images/neweditor/default/temp_img_1.png\" data-default=\"placeholder\" data-max-width=\"500\">\n"
                    + "			                </div>\n"
                    + "			            </div>\n"
                    + "					</td>\n"
                    + "					<td width=\"50\">&nbsp;</td>\n"
                    + "				</tr>\n"
                    + "			</table>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"text\">\n"
                    + "        <div class='movableContent'>\n"
                    + "			<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\">\n"
                    + "				<tr><td colspan='3' height='30'></td></tr>\n"
                    + "				<tr>\n"
                    + "					<td width=\"50\">&nbsp;</td>\n"
                    + "					<td width=\"500\"  align=\"center\" style=\"padding-bottom:10px;padding-top:25px;\">\n"
                    + "						<div class=\"contentEditableContainer contentTextEditable\" >\n"
                    + "	                        <div class=\"contentEditable\" >\n"
                    + "	                            \n"
                    + "								<h2 >Make sure you’re recognizable</h2>\n"
                    + "	                        </div>\n"
                    + "	                    </div>\n"
                    + "					</td>\n"
                    + "					<td width=\"50\">&nbsp;</td>\n"
                    + "				</tr>\n"
                    + "				<tr>\n"
                    + "					<td width=\"50\">&nbsp;</td>\n"
                    + "					<td width=\"500\" align=\"center\">\n"
                    + "						<div class=\"contentEditableContainer contentTextEditable\" >\n"
                    + "	                        <div class=\"contentEditable\" >\n"
                    + "	                            <p >\n"
                    + "								<p>Include both the name of the person who’s sending the email as well as the name of the company, and even better: send using your own domain.</p>\n"
                    + "								</p>\n"
                    + "	                        </div>\n"
                    + "	                    </div>\n"
                    + "						\n"
                    + "					</td>\n"
                    + "					<td width=\"50\">&nbsp;</td>\n"
                    + "				</tr>\n"
                    + "				<tr><td colspan=\"3\" height='30'></td></tr>\n"
                    + "				<tr>\n"
                    + "					<td width=\"50\">&nbsp;</td>\n"
                    + "					<td width=\"500\" align=\"center\" >\n"
                    + "						<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"400\" height=\"50\">\n"
                    + "							<tr>\n"
                    + "								<td bgcolor=\"#ED006F\" align=\"center\" style=\"border-radius:4px;\" width=\"400\" height=\"50\">\n"
                    + "									<div class=\"contentEditableContainer contentTextEditable\" >\n"
                    + "				                        <div class=\"contentEditable\" style='text-align:center;'>\n"
                    + "				                            <a target='_blank' href=\"[CLIENTS.WEBSITE]\" class='link2'>Read the 3 rules of email marketing sender etiquette</a>\n"
                    + "				                        </div>\n"
                    + "				                    </div>\n"
                    + "								</td>\n"
                    + "							</tr>\n"
                    + "\n"
                    + "						</table>\n"
                    + "					</td>\n"
                    + "					<td width=\"50\">&nbsp;</td>\n"
                    + "				</tr>\n"
                    + "				<tr><td height=\"10\" colspan=\"3\"></td></tr>\n"
                    + "			</table>\n"
                    + "		</div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"imageText\">\n"
                    + "        <div class=\"movableContent\">\n"
                    + "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width='600'>\n"
                    + "            	<tr><td colspan=\"5\" height='30'></td></tr>\n"
                    + "                <tr>\n"
                    + "                	<td width='50'></td>\n"
                    + "                    <td valign=\"top\" width='150'>\n"
                    + "                        <div class=\"contentEditableContainer contentImageEditable\">\n"
                    + "                            <div class=\"contentEditable\">\n"
                    + "                                <img src=\"/applications/Mail_Interface/3_3/modules/User_Interface/core/v31_campaigns/images/neweditor/default/temp_img_1.png\" data-default=\"placeholder\" width='150' data-max-width=\"150\">\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='20'></td>\n"
                    + "                    <td valign=\"top\"  width='250'>\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2 >This is a subtitle</h2>\n"
                    + "                                <p style=\"text-align:left;\">Etiam bibendum nunc in lacus bibendum porta. Vestibulum nec nulla et eros ornare condimentum. Proin facilisis, dui in mollis blandit. Sed non dui magna, quis tincidunt enim. Morbi vehicula pharetra lacinia.</p>\n"
                    + "                                <p style=\"text-align:right;\"><a target='_blank' href=\"\">Read more</a></p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='50'></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"Textimage\">\n"
                    + "        <div class=\"movableContent\">\n"
                    + "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width='600'>\n"
                    + "            	<tr><td colspan=\"5\" height='30'></td></tr>\n"
                    + "                <tr>\n"
                    + "                	<td width='50'></td>\n"
                    + "                    <td valign=\"top\" width='230'>\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2 >This is a subtitle</h2>\n"
                    + "                                <p style=\"text-align:left;\">Etiam bibendum nunc in lacus bibendum porta. Vestibulum nec nulla et eros ornare condimentum. Proin facilisis, dui in mollis blandit. Sed non dui magna, quis tincidunt enim. Morbi vehicula pharetra lacinia. </p>\n"
                    + "                                <p style=\"text-align:right;\"><a target='_blank' href=\"\">Read more</a></p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='20'></td>\n"
                    + "                    <td valign=\"top\" width='150'>\n"
                    + "                        <div class=\"contentEditableContainer contentImageEditable\">\n"
                    + "                            <div class=\"contentEditable\">\n"
                    + "                                <img src=\"/applications/Mail_Interface/3_3/modules/User_Interface/core/v31_campaigns/images/neweditor/default/temp_img_1.png\" data-default=\"placeholder\" width='150' data-max-width=\"150\">\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='50'></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"textText\">\n"
                    + "        <div class=\"movableContent\">\n"
                    + "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width='600'>\n"
                    + "            	<tr><td height='30' colspan='5'></td></tr>\n"
                    + "                <tr>\n"
                    + "                	<td width='50'></td>\n"
                    + "                    <td valign=\"top\" width=\"230\">\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2 >This is a subtitle</h2>\n"
                    + "                                <p >Etiam bibendum nunc in lacus bibendum porta. Vestibulum nec nulla et eros ornare condimentum. Proin facilisis, dui in mollis blandit. Sed non dui magna, quis tincidunt enim.</p>\n"
                    + "                                <p style=\"text-align:right;\"><a target='_blank' href=\"\">Read more</a></p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='40'></td>\n"
                    + "                    <td valign=\"top\" width='230'>\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2 >This is a subtitle</h2>\n"
                    + "                                <p style=\"text-align:left;\">Etiam bibendum nunc in lacus bibendum porta. Vestibulum nec nulla et eros ornare condimentum. Proin facilisis, dui in mollis blandit. Sed non dui magna, quis tincidunt enim.</p>\n"
                    + "                                <p style=\"text-align:right;\"><a target='_blank' href=\"\">Read more</a></p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='50'></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"qrcode\">\n"
                    + "        <div class=\"movableContent\">\n"
                    + "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width='600'>\n"
                    + "            	<tr><td height='30' colspan='5'></td></tr>\n"
                    + "                <tr>\n"
                    + "                	<td width='50'></td>\n"
                    + "                    <td valign=\"top\" >\n"
                    + "                        <div class=\"contentQrcodeEditable contentEditableContainer\">\n"
                    + "                            <div class=\"contentEditable\">\n"
                    + "                                <img src=\"/applications/Mail_Interface/3_3/modules/User_Interface/core/v31_campaigns/images/neweditor/default/qr_code.png\" width=\"75\" height=\"75\" data-default=\"placeholder\">\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='20'></td>\n"
                    + "                    <td valign=\"top\">\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2 >This is a subtitle</h2>\n"
                    + "                                <p style=\"text-align:left;\">Etiam bibendum nunc in lacus bibendum porta. Vestibulum nec nulla et eros ornare condimentum. Proin facilisis, dui in mollis blandit. Sed non dui magna, quis tincidunt enim. Morbi vehicula pharetra lacinia. Cras tincidunt, justo at fermentum feugiat, eros orci accumsan dolor, eu ultricies eros dolor quis sapien. Curabitur in turpis sem, a sodales purus. Pellentesque et risus at mauris aliquet gravida.</p>\n"
                    + "                                <p style=\"text-align:left;\">Integer in elit in tortor posuere molestie non a velit. Pellentesque consectetur, nisi a euismod scelerisque.</p>\n"
                    + "                                <p style=\"text-align:right;\"><a target='_blank' href=\"\">Read more</a></p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='50'></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"social\">\n"
                    + "        <div class=\"movableContent\" align='center'>\n"
                    + "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width='600'>\n"
                    + "            	<tr><td height='30' colspan='5'></td></tr>\n"
                    + "                <tr>\n"
                    + "                	<td width='50'></td>\n"
                    + "                    <td valign=\"top\" width=\"230\" align='center'>\n"
                    + "                        <div class=\"contentEditableContainer contentFacebookEditable\">\n"
                    + "                            <div class=\"contentEditable\">\n"
                    + "                                <img data-default=\"placeholder\" src=\"images/facebook.png\" data-max-width='60' data-customIcon=\"true\" data-noText=\"true\" width='60' height='60'>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2 >Facebook</h2>\n"
                    + "                                <p>Like us on Facebook to keep up with our news, updates and other discussions.</p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='40'></td>\n"
                    + "                    <td valign=\"top\" width=\"230\" align='center'>\n"
                    + "                        <div class=\"contentEditableContainer contentTwitterEditable\">\n"
                    + "                            <div class=\"contentEditable\">\n"
                    + "                                <img data-default=\"placeholder\" src=\"images/twitter.png\" data-max-width='60' data-customIcon=\"true\" data-noText=\"true\" width='60' height='60'>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2 >Twitter</h2>\n"
                    + "                                <p>Follow us on twitter to stay up to date with company news and other information.</p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='50'></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"twitter\">\n"
                    + "        <div class=\"movableContent\" align='center'>\n"
                    + "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width='600'>\n"
                    + "            	<tr><td height='30' colspan='3'></td></tr>\n"
                    + "                <tr>\n"
                    + "                	<td width='50'></td>\n"
                    + "                    <td valign=\"top\" align='center'>\n"
                    + "                        <div class=\"contentEditableContainer contentTwitterEditable\">\n"
                    + "                            <div class=\"contentEditable\">\n"
                    + "                                <img data-default=\"placeholder\" src=\"images/twitter.png\" data-max-width='60' data-customIcon=\"true\" data-noText=\"true\" width='60' height='60'>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2 >Twitter</h2>\n"
                    + "                                <p>Follow us on twitter to stay up to date with company news and other information.</p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='50'></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </div>\n"
                    + "   </div>\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"facebook\" >\n"
                    + "        <div class=\"movableContent\" align='center'>\n"
                    + "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width='600'>\n"
                    + "            	<tr><td height='30' colspan='3'></td></tr>\n"
                    + "                <tr>\n"
                    + "                	<td width='50'></td>\n"
                    + "                    <td valign=\"top\" align='center'>\n"
                    + "                        <div class=\"contentEditableContainer contentFacebookEditable\">\n"
                    + "                            <div class=\"contentEditable\">\n"
                    + "                                <img data-default=\"placeholder\" src=\"images/facebook.png\" data-max-width='60' data-customIcon=\"true\" data-noText=\"true\" width='60' height='60'>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2>Facebook</h2>\n"
                    + "                                <p>Like us on Facebook to keep up with our news, updates and other discussions.</p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='50'></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"customZone\" data-type=\"gmap\">\n"
                    + "        <div class=\"movableContent\">\n"
                    + "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width='600'>\n"
                    + "                <tr><td height='30' colspan='5'></td></tr>\n"
                    + "                <tr>\n"
                    + "                	<td width='50'></td>\n"
                    + "                    <td valign=\"top\" >\n"
                    + "                        <div class=\"contentGmapEditable contentEditableContainer\">\n"
                    + "                            <div class=\"contentEditable\">\n"
                    + "                                <img src=\"/applications/Mail_Interface/3_3/modules/User_Interface/core/v31_campaigns/images/neweditor/default/gmap_example.png\" width=\"75\" data-default=\"placeholder\">\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='20'></td>\n"
                    + "                    <td valign=\"top\">\n"
                    + "                        <div class=\"contentEditableContainer contentTextEditable\">\n"
                    + "                            <div class=\"contentEditable\" style=\"color:#555;font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;\">\n"
                    + "                                <h2 >This is a subtitle</h2>\n"
                    + "                                <p style=\"text-align:left;\">Etiam bibendum nunc in lacus bibendum porta. Vestibulum nec nulla et eros ornare condimentum. Proin facilisis, dui in mollis blandit. Sed non dui magna, quis tincidunt enim. Morbi vehicula pharetra lacinia. Cras tincidunt, justo at fermentum feugiat, eros orci accumsan dolor, eu ultricies eros dolor quis sapien. Curabitur in turpis sem, a sodales purus. Pellentesque et risus at mauris aliquet gravida.</p>\n"
                    + "                                <p style=\"text-align:left;\">Integer in elit in tortor posuere molestie non a velit. Pellentesque consectetur, nisi a euismod scelerisque.</p>\n"
                    + "                                <p style=\"text-align:right;\"><a target='_blank' href=\"\">Read more</a></p>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </td>\n"
                    + "                    <td width='50'></td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "\n"
                    + "	 <div class=\"customZone\" data-type=\"colums1v2\"><div class='movableContent'>\n"
                    + "          	<table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" >\n"
                    + "	            <tr><td height=\"30\" colspan='3'>&nbsp;</td></tr>\n"
                    + "	            <tr>\n"
                    + "	            	<td width='50'></td>\n"
                    + "	              	<td width='500' align=\"center\" valign=\"top\" class=\"newcontent\">\n"
                    + "	                \n"
                    + "	              	</td>\n"
                    + "	              	<td width='50'></td>\n"
                    + "	            </tr>\n"
                    + "          	</table>\n"
                    + "    	</div>\n"
                    + "      </div>\n"
                    + "\n"
                    + "      <div class=\"customZone\" data-type=\"colums2v2\"><div class='movableContent'>\n"
                    + "          <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" >\n"
                    + "	            <tr><td height=\"30\" colspan='3'>&nbsp;</td></tr>\n"
                    + "	            <tr>\n"
                    + "	            	<td width='50'></td>\n"
                    + "	              	<td width='235' align=\"center\" valign=\"top\" class=\"newcontent\">\n"
                    + "	                \n"
                    + "	              	</td>\n"
                    + "					<td width='30'></td>\n"
                    + "	              	<td width='235' align=\"center\" valign=\"top\" class=\"newcontent\">\n"
                    + "	                \n"
                    + "	              	</td>\n"
                    + "	              	<td width='50'></td>\n"
                    + "	            </tr>\n"
                    + "          	</table>\n"
                    + "    	</div>\n"
                    + "      </div>\n"
                    + "\n"
                    + "      <div class=\"customZone\" data-type=\"colums3v2\"><div class='movableContent'>\n"
                    + "         <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" >\n"
                    + "	            <tr><td height=\"30\" colspan='3'>&nbsp;</td></tr>\n"
                    + "	            <tr>\n"
                    + "	            	<td width='50'></td>\n"
                    + "	              	<td width='158' align=\"center\" valign=\"top\" class=\"newcontent\">\n"
                    + "	                \n"
                    + "	              	</td>\n"
                    + "					<td width='12'></td>\n"
                    + "	              	<td width='158' align=\"center\" valign=\"top\" class=\"newcontent\">\n"
                    + "	                \n"
                    + "	              	</td>\n"
                    + "					<td width='12'></td>\n"
                    + "	              	<td width='158' align=\"center\" valign=\"top\" class=\"newcontent\">\n"
                    + "	                \n"
                    + "	              	</td>\n"
                    + "	              	<td width='50'></td>\n"
                    + "	            </tr>\n"
                    + "          	</table>\n"
                    + "    	</div>\n"
                    + "      </div>\n"
                    + "\n"
                    + "      <div class=\"customZone\" data-type=\"textv2\">\n"
                    + "		<div class=\"contentEditableContainer contentTextEditable\" >\n"
                    + "            <div class=\"contentEditable\" >\n"
                    + "                \n"
                    + "				<h2 >Make sure you’re recognizable</h2>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "		<div class=\"contentEditableContainer contentTextEditable\" >\n"
                    + "            <div class=\"contentEditable\" >\n"
                    + "				<p>Include both the name of the person who’s sending the email as well as the name of the company, and even better: send using your own domain.</p>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "		<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"79%\" height=\"50\">\n"
                    + "			<tr>\n"
                    + "				<td bgcolor=\"#ED006F\" align=\"center\" style=\"border-radius:4px;\" width=\"100%\" height=\"50\">\n"
                    + "					<div class=\"contentEditableContainer contentTextEditable\" >\n"
                    + "                        <div class=\"contentEditable\" style='text-align:center;'>\n"
                    + "                            <a target='_blank' href=\"[CLIENTS.WEBSITE]\" class='link2'>Read the 3 rules of email marketing sender etiquette</a>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "				</td>\n"
                    + "			</tr>\n"
                    + "		</table>\n"
                    + "      </div>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "-->\n"
                    + "<!--Default Zone End-->\n"
                    + "\n"
                    + "</body>\n"
                    + "</html>");

            try {
                Stage stage = new Stage();
                Stage stageprev = (Stage) buttonAccederMonProfil.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MonProfil.fxml"));
                Parent parent = loader.load();
                Stage stagep = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
                stageprev.close();
            } catch (IOException ex) {
                Logger.getLogger(MonProfilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ( !(oldPasswordVal.getText().equals(LoginController.logged.getPassword()))  ) {
            
            errorVerifPsw.setText("Veuillez verifier votre nouveau mot de passe");
            errorVerifPsw.setVisible(true);
            oldPasswordVal.setStyle("-fx-text-box-border: #f44336;");
            psw.setStyle("-fx-text-box-border: transparent;");
            rePsw.setStyle("-fx-text-box-border: transparent;");

        }
        else {
            
            errorVerifPsw.setText("Veuillez verifier votre ancien mot de passe");
            errorVerifPsw.setVisible(true);
            oldPasswordVal.setStyle("-fx-text-box-border: transparent;");
            psw.setStyle("-fx-text-box-border: #f44336;");
            rePsw.setStyle("-fx-text-box-border: #f44336;");
            
        }
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
