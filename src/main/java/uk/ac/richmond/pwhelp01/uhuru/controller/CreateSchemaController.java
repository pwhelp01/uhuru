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
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import uk.ac.richmond.pwhelp01.uhuru.model.InnerProject;
import uk.ac.richmond.pwhelp01.uhuru.PageLoader;

/**
 * FXML Controller class
 *
 * <p> Handles user input for the CreateSchema view
 * @author peedeeboy
 */
public class CreateSchemaController implements Initializable {
    
    @FXML Button browseSchemaBtn;
    @FXML Button browseDataBtn;
    @FXML Button browseCodeBtn;
    @FXML Button processBtn;
    @FXML Button backBtn;
    @FXML Button browseBindingsBtn;
    @FXML TextField schemaTxt;
    @FXML TextField dataTxt;
    @FXML TextField codeTxt;
    @FXML TextField bindingsTxt;
    @FXML TextField serverTxt;
    @FXML TextField databaseTxt;
    @FXML TextField usernameTxt;
    @FXML TextField passwordTxt;
    @FXML Label statusLbl;
    @FXML ProgressBar progressPrg;
    
    StringProperty status = new SimpleStringProperty("Ready");
    DoubleProperty progress = new SimpleDoubleProperty(0);
    
    // Model class
    InnerProject innerProject = new InnerProject();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Bindings
        schemaTxt.textProperty().bind(Bindings.when(innerProject.schemaFileProperty().isNotNull())
                .then(innerProject.schemaFileProperty().asString())
                .otherwise(""));
        
        dataTxt.textProperty().bind(Bindings.when(innerProject.dataFileProperty().isNotNull())
                .then(innerProject.dataFileProperty().asString())
                .otherwise(""));
   
        codeTxt.textProperty().bind(Bindings.when(innerProject.codeFileProperty().isNotNull())
                .then(innerProject.codeFileProperty().asString())
                .otherwise(""));
        
        bindingsTxt.textProperty().bind(Bindings.when(innerProject.bindingsFileProperty().isNotNull())
                .then(innerProject.bindingsFileProperty().asString())
                .otherwise(""));
        
        serverTxt.textProperty().bindBidirectional(innerProject.serverProperty());
        databaseTxt.textProperty().bindBidirectional(innerProject.databaseProperty());
        usernameTxt.textProperty().bindBidirectional(innerProject.usernameProperty());
        passwordTxt.textProperty().bindBidirectional(innerProject.passwordProperty());
        
        statusLbl.textProperty().bind(innerProject.statusProperty());
        progressPrg.progressProperty().bind(innerProject.progressProperty());
        
    }
    
    /**
     * Browse for the main schema .xsd file
     * @param event Button click event
     */
    @FXML
    private void schemaBrowseBtnAction(ActionEvent event) {
        
        String title = "Open Schema File";
        ExtensionFilter filter = new ExtensionFilter("XML Schema Files", "*.xsd");
        File selectedFile  = chooseFile(title, filter);
        if(selectedFile != null) {
            innerProject.setSchemaFile(selectedFile);
        }
        
    }
    
    /**
     * Browse for the data file .xsd file
     * @param event Button click event
     */
    @FXML
    private void dataBrowseBtnAction(ActionEvent event) {
        
        String title = "Open Data File";
        ExtensionFilter filter = new ExtensionFilter("XML Schema Files", "*.xsd");
        File selectedFile = chooseFile(title, filter);
        if(selectedFile != null) {
            innerProject.setDataFile(selectedFile);
        }
        
    }
    
    /**
     * Browse for the code file .xsd file
     * @param event Button click event
     */
    @FXML
    private void codeBrowseBtnAction(ActionEvent event) {
        
        String title = "Open Code File";
        ExtensionFilter filter = new ExtensionFilter("XML Schema Files", "*.xsd");
        File selectedFile = chooseFile(title, filter);
        if(selectedFile != null) {
            innerProject.setCodeFile(selectedFile);
        }
        
    }
    
    /**
     * Browse for the .xjb bindings file
     * @param event Button click event
     */
    @FXML
    private void bindingsBrowseBtnAction(ActionEvent event) {
        
        String title = "Open Bindings File";
        ExtensionFilter filter = new ExtensionFilter("JAXB Bindings Files", "*.xjb");
        File selectedFile = chooseFile(title, filter);
        innerProject.setBindingsFile(selectedFile);
        
    }
    
    /**
     * Instruct the InnerProject model class to build the relational schema
     * 
     * @param event Button click event
     */
    @FXML
    private void processBtnAction(ActionEvent event) {
        
        // Create a new task to run the schema generation in
        Task<Void> task = new Task<Void>(){
            
            // Overide the call() method with the action to take
            @Override
            public Void call(){

                try {
                    // Disable buttons so user doesn't exit during build process
                    disableButtons();

                    // Generate relational schema
                    innerProject.process();
                }
                catch(Exception e) {
                    // And error has occured - stop processing and inform the user
                    innerProject.errorStatus("Error: " + e.getMessage());
                    e.printStackTrace();
                }
                finally {
                    // Re-enable buttons so user can continue using application
                    enableButtons();
                }
                return null;
            }
        };
        
        // Create and new thread and execute the task
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        
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
        catch (Exception e){
            innerProject.statusProperty().set("Error: Cannot load Main Menu");
        }
    }
    
    
    // Helper methods
    /**
     * Open a new File Chooser dialog
     * @param title Title to display on File Chooser
     * @param filter File extention filter
     * @return File selected
     */
    private File chooseFile(String title, ExtensionFilter filter) {
        FileChooser fileDialog = new FileChooser();
        fileDialog.setTitle(title);
        fileDialog.getExtensionFilters().addAll(filter);
        return fileDialog.showOpenDialog(null);
    }

    /**
     * Disable Process and Back buttons to prevent user from interrupting
     * the build process
     */
    private void disableButtons() {
        processBtn.setDisable(true);
        backBtn.setDisable(true);
    }
    
    /**
     * Re-enable Process and Back buttons
     */
    private void enableButtons() {
        processBtn.setDisable(false);
        backBtn.setDisable(false);
    }
    
}
