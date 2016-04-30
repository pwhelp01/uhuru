/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond.pwhelp01.uhuru.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import uk.ac.richmond.pwhelp01.uhuru.PageLoader;
import uk.ac.richmond.pwhelp01.uhuru.model.Settings;

/**
 * FXML Controller class
 *
 * <p> Handles user input on the main menu view
 * @author peedeeboy
 */
public class MenuController implements Initializable {

    @FXML Button createSchemaBtn;
    @FXML Button createXmlBtn;
    @FXML Button exitBtn;
    
    Settings settings = new Settings();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Disable buttons if directories not set (application not configured)
        if(!settings.validate()) {
            createSchemaBtn.setDisable(true);
            createXmlBtn.setDisable(true);
        }
    }    
    
    /**
     * Load the Create Schema view
     * @param event Button click event
     */
    @FXML
    private void createSchemaBtnAction(ActionEvent event) {
        try {
            PageLoader.loadPage(PageLoader.CREATESCHEMA);
        }
        catch (Exception e){}
    }
    
    /**
     * Load the Create XML view
     * @param event Button click event
     */
    @FXML
    private void createXmlBtnAction(ActionEvent event) {
        try {
            PageLoader.loadPage(PageLoader.CREATEXML); 
        }
        catch (Exception e){}
    }
    
    /**
     * Load the Settings view
     * @param event Button click event
     */
    @FXML
    private void settingsBtnAction(ActionEvent event) {
        try {
            PageLoader.loadPage(PageLoader.SETTINGS);  
        }
        catch (Exception e){}
    }
    
    /**
     * Close the UHURU application
     * @param event Button click event
     */
    @FXML
    private void exitBtnAction(ActionEvent event) {
        Platform.exit();
    }
     
}
