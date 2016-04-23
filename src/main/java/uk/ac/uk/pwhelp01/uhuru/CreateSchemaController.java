/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
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
    
    InnerProject innerProject = new InnerProject();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Bindings
        schemaTxt.textProperty().bind(Bindings.when(innerProject.schemaFile.isNotNull())
                .then(innerProject.schemaFileProperty().asString())
                .otherwise(""));
        
        dataTxt.textProperty().bind(Bindings.when(innerProject.dataFile.isNotNull())
                .then(innerProject.dataFileProperty().asString())
                .otherwise(""));
   
        codeTxt.textProperty().bind(Bindings.when(innerProject.codeFile.isNotNull())
                .then(innerProject.codeFileProperty().asString())
                .otherwise(""));
        
        bindingsTxt.textProperty().bind(Bindings.when(innerProject.bindingsFile.isNotNull())
                .then(innerProject.bindingsFileProperty().asString())
                .otherwise(""));
        
        serverTxt.textProperty().bindBidirectional(innerProject.serverProperty());
        databaseTxt.textProperty().bindBidirectional(innerProject.databaseProperty());
        usernameTxt.textProperty().bindBidirectional(innerProject.usernameProperty());
        passwordTxt.textProperty().bindBidirectional(innerProject.passwordProperty());
        
    }
    
    
    @FXML
    private void schemaBrowseBtnAction(ActionEvent event) {
        
        String title = "Open Schema File";
        ExtensionFilter filter = new ExtensionFilter("XML Schema Files", "*.xsd");
        innerProject.setSchemaFile(chooseFile(title, filter));
        
    }
    
    @FXML
    private void dataBrowseBtnAction(ActionEvent event) {
        
        String title = "Open Data File";
        ExtensionFilter filter = new ExtensionFilter("XML Schema Files", "*.xsd");
        innerProject.setDataFile(chooseFile(title, filter));
        
    }
    
    @FXML
    private void codeBrowseBtnAction(ActionEvent event) {
        
        String title = "Open Code File";
        ExtensionFilter filter = new ExtensionFilter("XML Schema Files", "*.xsd");
        innerProject.setCodeFile(chooseFile(title, filter));
        
    }
    
    @FXML
    private void bindingsBrowseBtnAction(ActionEvent event) {
        
        String title = "Open Bindings File";
        ExtensionFilter filter = new ExtensionFilter("JAXB Bindings Files", "*.xjb");
        innerProject.setBindingsFile(chooseFile(title, filter));
    }
    
    
    @FXML
    private void processBtnAction(ActionEvent event) {
        
        int prog = 0;
        
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        
        try {
            
            // Set status
            status.set("Processing");
            prog += 0.2;
            progressPrg.setProgress(prog);
            
            // Disable buttons so user doesn't exit during build process
            disableButtons();
            
            // Clean out the innerproject resources folder
            status.set("Deleting old files");
            prog += 0.2;
            progressPrg.setProgress(prog);
            innerProject.deleteFiles();
            
            // Copy files needed to build project
            status.set("Copying .XSD and .XJB files");
            prog += 0.2;
            progressPrg.setProgress(prog);
            innerProject.copyFiles();
            
            // Build inner project
            status.set("Building inner project");
            prog += 0.2;
            progressPrg.setProgress(prog);
            innerProject.invokeMaven();
            
            
            // Get root element of Schema file
            status.set("Calculating root element of schema");
            prog += 0.2;
            progressPrg.setProgress(prog);
            System.out.println();innerProject.getSchemaRoot();
            
            
            // Create schema
            status.set("Creating database schema");
            prog += 0.2;
            progressPrg.setProgress(prog);
            innerProject.createSchema();
            
            // All done!
            status.set("Success!");
            prog += 0.2;
            progressPrg.setProgress(prog);
            
        }
        catch(Exception e) {
            status.set("Error: " + e.getLocalizedMessage() + " : " + e.getMessage());
            e.printStackTrace();
            System.out.println("GOT HERE");
        }
        finally {
            // Re-enable Process and Back buttons
            enableButtons();
        }
    }
    
    
    @FXML
    private void backBtnAction(ActionEvent event) {
        try {    
            PageLoader.loadPage(PageLoader.MENU);
        }
        catch (Exception e){}
    }
    
    
    // Helper methods
    private File chooseFile(String title, ExtensionFilter filter) {
        FileChooser fileDialog = new FileChooser();
        fileDialog.setTitle(title);
        fileDialog.getExtensionFilters().addAll(filter);
        return fileDialog.showOpenDialog(null);
    }

    
    private void disableButtons() {
        processBtn.setDisable(true);
        backBtn.setDisable(true);
    }
    
    private void enableButtons() {
        processBtn.setDisable(false);
        backBtn.setDisable(false);
    }
    
}
