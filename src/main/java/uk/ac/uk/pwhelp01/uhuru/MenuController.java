/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

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

/**
 * FXML Controller class
 *
 * @author peedeeboy
 */
public class MenuController implements Initializable {

    @FXML Button createSchemaBtn;
    @FXML Button createXmlBtn;
    @FXML Button exitBtn;
    @FXML StackPane contentStc;
    
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
    
    
    @FXML
    private void createSchemaBtnAction(ActionEvent event) {
        try {
            System.out.println("Got here!");
            
            PageLoader.loadPage(PageLoader.CREATESCHEMA);
            
        }
        catch (Exception e){}
    }
    
    @FXML
    private void settingsBtnAction(ActionEvent event) {
        try {
            System.out.println("Got here!");
            
            PageLoader.loadPage(PageLoader.SETTINGS);
            
        }
        catch (Exception e){}
    }
    
    @FXML
    private void exitBtnAction(ActionEvent event) {
        Platform.exit();
    }
    
    
    // Helper methods
    public void setContentStc(StackPane contentStc) {
        this.contentStc = contentStc;
    }
     
}
