package uk.ac.uk.pwhelp01.uhuru;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
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
    
    private String propertiesFile = "/data/uhuru.properties";
    private Properties props = new Properties();
    
    public void Settings() {
        
        // Load Properties
        try {
            props.load(getClass().getResourceAsStream(propertiesFile));
            uhuruDir.set(props.getProperty("uhuruDir"));
            innerProjectDir.set(props.getProperty("innerProjectDir"));
            mavenDir.set(props.getProperty("mavenDir"));
        }
        catch (IOException ignored) {}
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
    
    
    public void save() throws IOException {

        props.setProperty("uhuruDir", uhuruDir.get());
        props.setProperty("innerProjectDir", innerProjectDir.get());
        props.setProperty("mavenDir", mavenDir.get());
                
        File target = new File(propertiesFile);
        props.store(getClass().getResourceAsStream(propertiesFile),  "UHURU Application Properties");
        
        BufferedWriter = new BufferedWriter(getClass(getClass().getResourceAsStream(propertiesFile));
    }
}
