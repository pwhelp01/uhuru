/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond.pwhelp01.uhuru.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import uk.ac.richmond.pwhelp01.uhuru.PageLoader;
import uk.ac.richmond.pwhelp01.uhuru.model.XmlGenerator;

/**
 * FXML Controller class
 *
 * <p>Handles user input for the CreateXML view
 * @author peedeeboy
 */
public class CreateXmlController implements Initializable {
    
    @FXML ComboBox schemaCmb;
    @FXML TextField usernameTxt;
    @FXML TextField passwordTxt;
    @FXML TextField fileTxt;
    @FXML Button browseBtn;
    @FXML Button processBtn;
    @FXML Button backBtn;
    @FXML Label statusLbl;
    @FXML ProgressBar progressPrg;
    
    // Model class
    XmlGenerator xmlGenerator;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Load list of schema from local database and populate dropdown
        try {
            xmlGenerator = new XmlGenerator();
            schemaCmb.getItems().addAll(xmlGenerator.getSchemas());
            
            // Bindings
            fileTxt.textProperty().bind(Bindings.when(xmlGenerator.xmlFileProperty().isNotNull())
                .then(xmlGenerator.xmlFileProperty().asString())
                .otherwise(""));
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            statusLbl.textProperty().set("Error: Could not load data from Local Database");   
        }
    }
    
    /**
     * Select the file location to save the generated XML
     * @param event Button click event
     */
    @FXML
    public void browseBtnAction(ActionEvent event) {
        
        // Create file chooser
        FileChooser fileDialog = new FileChooser();
        fileDialog.setTitle("Save XML File");
        
        // Display file chooser and get user input
        fileDialog.getExtensionFilters().addAll(
                new ExtensionFilter("XML Files", "*.xml"));
        File selectedFile = fileDialog.showSaveDialog(((Node)event.getTarget()).getScene().getWindow());
        
        // Check user has selected a file
        if (selectedFile != null) {
           xmlGenerator.xmlFileProperty().set(selectedFile);
        }
        
    }
    
    /**
     * Generate the XML file
     * 
     * @param event Button click event
     */
    @FXML
    public void processBtnAction(ActionEvent event) {
        
    }
    
    /**
     * Navigate back to the main menu
     * @param event Button click event
     */
    @FXML
    public void backBtnAction(ActionEvent event) {
        try {    
            PageLoader.loadPage(PageLoader.MENU);
        }
        catch (Exception e){
            statusLbl.textProperty().set("Error: Cannot load Main Menu");
        }
    }
    
}
