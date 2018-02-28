/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.Technique;

/**
 *
 * @author Chiheb
 */
public class ConfigurationJava {

    private static String OS = System.getProperty("os.name").toLowerCase();
    public static String profilsPath = "http://localhost/MTOCrowdRise/web/uploads/profils/";
    public static String projectsPath = "http://localhost/MTOCrowdRise/web/uploads/projects/";
    public static String localPath = "http://localhost";
    public static String jasperPath = "C:\\Users\\PC\\Desktop";
    public static String jasperGlobalPath = "C:\\xampp\\htdocs\\MTOCrowdRiseJava\\jasper\\";

    public String getProfilsPath() {
        return profilsPath;
    }

     public String getOS() {
     return OS;
    }
}
