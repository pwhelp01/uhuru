package uk.ac.uk.pwhelp01.uhuru;


import java.io.File;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peedeeboy
 */
public class Settings {
    
    private StringProperty uhuruDir = new SimpleStringProperty("");
    private StringProperty innerProjectDir = new SimpleStringProperty("");
    private StringProperty mavenDir = new SimpleStringProperty("");
    
    private Preferences prefs = Preferences.userRoot().node("uk/ac/pwhelp01/uhuru");
    
    
    public Settings() {
            
            // Get settings from user preferences
            uhuruDir.set(prefs.get("uhuruDir", ""));
            innerProjectDir.set(prefs.get("innerProjectDir", ""));
            mavenDir.set(prefs.get("mavenDir", ""));
            
    }
    
    // Getters and Setters
    public String getUhuruDir() {
        return uhuruDir.get();
    }
    public void setUhuruDir(String uhuruDir) {
        this.uhuruDir.set(uhuruDir);
    }
    public StringProperty uhuruDirProperty() {
        return uhuruDir;
    }
    
    public String getInnerProjectDir() {
        return innerProjectDir.get();
    }
    public void setInnerProjectDir(String innerProjectDir) {
        this.innerProjectDir.set(innerProjectDir);
    }
    public StringProperty innerProjectDirProperty() {
        return innerProjectDir;
    }
    
    public String getMavenDir() {
        return mavenDir.get();
    }
    public void setMavenDir(String mavenDir) {
        this.mavenDir.set(mavenDir);
    }
    public StringProperty mavenDirPropety() {
        return mavenDir;
    }
    
    
    // Logic
    public boolean validate() {
        
        // Get directories from properties file
        File uhuruFile = new File(uhuruDir.get());
        File innerProjectFile = new File(innerProjectDir.get());
        File mavenFile  = new File(mavenDir.get());
        
        // Check if directories exist
        boolean validProps = true;
        if(!uhuruFile.isDirectory()) {
            validProps = false;
        }
        if(!innerProjectFile.isDirectory()) {
            validProps = false;
        }
        if(!mavenFile.isDirectory()) {
            validProps = false;
        }
        
        return validProps;
    }
    
    
    public void save() throws BackingStoreException {
        
        // Save preferences
        prefs.put("uhuruDir", uhuruDir.get());
        prefs.put("innerProjectDir", innerProjectDir.get());
        prefs.put("mavenDir", mavenDir.get());
        
        // Flush changes
        prefs.flush();
        
    }
}
