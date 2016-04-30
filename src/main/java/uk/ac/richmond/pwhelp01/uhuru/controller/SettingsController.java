/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond.pwhelp01.uhuru.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import uk.ac.richmond.pwhelp01.uhuru.PageLoader;
import uk.ac.richmond.pwhelp01.uhuru.model.Settings;

/**
 * FXML Controller class
 *
 * Handles user input on the Settings view
 * @author peedeeboy
 */
public class SettingsController implements Initializable {

    @FXML TextField uhuruDirTxt;
    @FXML TextField innerProjectDirTxt;
    @FXML TextField mavenDirTxt;
    @FXML Button browseUhuruBtn;
    @FXML Button browseInnerProjectBtn;
    @FXML Button browseMavenBtn;
    @FXML Button saveBtn;
    @FXML Button backBtn;
    @FXML Label statusLbl;
    
    // Model class
    Settings settings = new Settings();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Bindings
        uhuruDirTxt.textProperty().bind(Bindings.when(settings.uhuruDirProperty().isNotNull())
                .then(settings.uhuruDirProperty())
                .otherwise(""));
        innerProjectDirTxt.textProperty().bind(Bindings.when(settings.innerProjectDirProperty().isNotNull())
                .then(settings.innerProjectDirProperty())
                .otherwise(""));
        mavenDirTxt.textProperty().bind(Bindings.when(settings.mavenDirPropety().isNotNull())
                .then(settings.mavenDirPropety())
                .otherwise(""));
        
    }    
    
    /**
     * Browse for UHURU installation directory
     * @param event Button click event
     */
    @FXML
    private void browseUhuruBtnAction(ActionEvent event) {
        String title = "Open UHURU Installation Directory";
        String selectedDir = chooseDirectory(title).toString();
        if(selectedDir != null) {
            settings.uhuruDirProperty().set(selectedDir);
        }
    }
    
    /**
     * Browse for Inner Project directory
     * @param event Button click event
     */
    @FXML
    private void browseInnerProjectBtnAction(ActionEvent event) {
        String title = "Open Inner Project Installation Directory";
        String selectedDir = chooseDirectory(title).toString();
        if(selectedDir != null) {
            settings.innerProjectDirProperty().set(selectedDir);
        }
    }
    
    /**
     * Browse for the Maven installation directory
     * @param event Button click event
     */
    @FXML
    private void browseMavenBtnAction(ActionEvent event) {
        String title = "Open Maven Installation Directory";
        String selectedDir = chooseDirectory(title).toString();
        if(selectedDir != null) {
            settings.mavenDirPropety().set(selectedDir);
        }
    }
    
    /**
     * Navigate back to the main menu
     * @param event Button click event
     */
    @FXML
    private void backBtnAction(ActionEvent event) {
        try {    
            PageLoader.loadPage(PageLoader.MENU);
        }
        catch (Exception e){}
    }
    
    /**
     * Save the settings to the user's persistance store
     * 
     * <p>On Windows platform, this will be the Windows registry
     * <p>On Linux platform, this will be be .Java folder in /home directory 
     * @param event 
     */
    @FXML
    private void saveBtnAction(ActionEvent event) {
        
        // Check settings are valid
        if(settings.validate()) {
            // Settings are valid, so save to user preferences store
            try {
                settings.save();
                statusLbl.textProperty().set("Settings saved");
            }
            // If an error occurs whilst saving, inform user
            catch(BackingStoreException e) {
                statusLbl.textProperty().set("Error saving settings");
                e.printStackTrace();
            }
        }
        // Validation failed - inform user
        else {
            statusLbl.textProperty().set("Invalid directory locations");
        }
    }
    
    // Helper methods
    /**
     * Open a new directory chooser and get user choice
     * @param title Title to display at top of Directory Chooser
     * @return User's choosen directory
     */
    private File chooseDirectory(String title) {
        DirectoryChooser directoryDialog = new DirectoryChooser();
        directoryDialog.setTitle(title);
        return directoryDialog.showDialog(null);
    }
}
