/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.DAO.Classe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.security.Policy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mto.cr.Model.Probleme;
import mto.cr.Model.User;
import mto.cr.Technique.ConfigurationJava;
import mto.cr.Technique.DataBase;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlConstants;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author bouda
 */
public class JasperDAO {

    private Connection db;

    public JasperDAO() {
        db = DataBase.getInstance().getConnection();
    }

    public void jasperProbleme() {
        try {
            System.out.println("aaaaaaaaa");
            JasperDesign jasperdesign = JRXmlLoader.load(ConfigurationJava.jasperGlobalPath+"Probleme.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperdesign);

            Map parameters = new HashMap();
            parameters.put("Titre", "a");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, db);

            JasperExportManager.exportReportToPdfFile(jasperPrint, ConfigurationJava.jasperPath+"probleme.pdf");
        } catch (JRException ex) {
            Logger.getLogger(JasperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void jasperProjet() {
        try {

            JasperDesign jasperdesign = JRXmlLoader.load(ConfigurationJava.jasperGlobalPath + "classic.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperdesign);

            Map parameters = new HashMap();
            parameters.put("Titre", "titre");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, db);

            JasperExportManager.exportReportToPdfFile(jasperPrint, ConfigurationJava.jasperPath + "Projet.pdf");
        } catch (JRException ex) {
            Logger.getLogger(JasperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void jaseperUser() {
        try {

            JasperDesign jasperdesign = JRXmlLoader.load(ConfigurationJava.jasperGlobalPath + "User.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperdesign);

            Map parameters = new HashMap();
            parameters.put("Titre", "titre");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, db);

            JasperExportManager.exportReportToPdfFile(jasperPrint, ConfigurationJava.jasperPath + "User.pdf");
        } catch (JRException ex) {
            Logger.getLogger(JasperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void texProbleme() {

        int n = 7;
        try {
            File fout = new File(ConfigurationJava.jasperPath + "outProbleme.txt");
            FileOutputStream fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    fos));

            List<Probleme> problemeList = new ArrayList<>();
            String req = "select * from probleme ";
            Statement statement;
            try {
                statement = db.createStatement();
                ResultSet result = statement.executeQuery(req);
                Probleme p = new Probleme();
                while (result.next()) {
                    UserDAO u = new UserDAO();
                    p.setIdProbleme(result.getInt(1));
                    p.setSecteur(result.getString(6));
                    p.setDateProblem(result.getString(5));
                    p.setNbrCommentaireProbleme(result.getInt(9));
                    p.setEtatProbleme(result.getString(4));
                    p.setTitre(result.getString(2));
                    p.setContenu(result.getString(8));
                    p.setNiveauRequis(result.getInt(3));
                    p.setUser(u.getById(result.getInt(10)));

                    problemeList.add(p);
                    p = new Probleme();

                }
            } catch (SQLException ex) {
                Logger.getLogger(ProblemeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (Probleme probleme : problemeList) {

                bw.write("MTO039488228   " + probleme.getTitre() + "    " + probleme.getSecteur() + "  " + probleme.getEtatProbleme() + "  " + probleme.getContenu() + "  " + probleme.getDateProblem());
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

   

    public void texUser() throws FileNotFoundException {
        List<User> users = new ArrayList();
        int n = 7;

        File fout = new File(ConfigurationJava.jasperPath + "outUser.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                fos));

        String req = "select * from User ";

        try {

            try {

                PreparedStatement ps = db.prepareStatement(req);
                ResultSet res = ps.executeQuery();
                while (res.next()) {

                    User user = new User();
                    user.setId(res.getInt("id"));
                    user.setUsername(res.getString("username"));
                    user.setUsername_canonical(res.getString("username_canonical"));
                    user.setNom(res.getString("nom"));
                    user.setPrenom(res.getString("prenom"));
                    user.setEmail(res.getString("email"));
                    user.setEmail_canonical(res.getString("email_canonical"));
                    user.setPassword(res.getString("password"));
                    user.setEnabled(res.getInt("enabled"));
                    user.setLocked(res.getInt("locked"));
                    user.setSalt(res.getString("salt"));
                    user.setPath(res.getString("path"));
                    user.setPaysnatal(res.getString("paysNatal"));
                    user.setSituationprof(res.getString("situationprof"));
                    user.setSecteur(res.getString("secteur"));
                    user.setSolde(res.getInt("solde"));
                    user.setRole(res.getString("role"));
                    user.setRoles(res.getString("roles"));
                    user.setDatenaissance(res.getDate("dateNaissance"));
                    user.setNbrVote(res.getInt("nbrVote"));
                    user.setNbrcommentaire(res.getInt("nbrcommentaire"));
                    user.setNbrprojetssuivis(res.getInt("nbrprojetssuivis"));
                    user.setNbrfinancement(res.getInt("nbrfinancement"));
                    user.setNbrProbleme(res.getInt("nbrProbleme"));
                    user.setNbrCommentaireProbleme(res.getInt("nbrCommentaireProbleme"));

                    users.add(user);

                }

            } catch (SQLException ex) {
            }

            for (User user : users) {

                bw.write("MTO039488228   " + user);
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
