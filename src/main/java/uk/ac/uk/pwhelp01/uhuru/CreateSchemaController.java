/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML TextField schemaTxt;
    @FXML TextField dataTxt;
    @FXML TextField codeTxt;
    
    InnerProject innerProject = new InnerProject();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Bindings
        schemaTxt.textProperty().bind(innerProject.schemaFile.asString());
        dataTxt.textProperty().bind(innerProject.dataFile.asString());
        codeTxt.textProperty().bind(innerProject.codeFile.asString());
        
    }
    
    
    @FXML
    private void schemaBrowseBtnAction(ActionEvent event) {
        
        innerProject.setSchemaFile(chooseFile());
        
    }
    
    @FXML
    private void dataBrowseBtnAction(ActionEvent event) {
        
        innerProject.setDataFile(chooseFile());
        
    }
    
    @FXML
    private void codeBrowseBtnAction(ActionEvent event) {
        
        innerProject.setCodeFile(chooseFile());
        
    }
    
    @FXML
    private void processBtnAction(ActionEvent event) {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        
        try {
            innerProject.build();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void backBtnAction(ActionEvent event) {
        try {    
            PageLoader.loadPage(PageLoader.MENU);
        }
        catch (Exception e){}
    }
    
    private File chooseFile() {
        FileChooser fileDialog = new FileChooser();
        fileDialog.setTitle("Open File");
        fileDialog.getExtensionFilters().addAll(new ExtensionFilter("XML Schema Files", "*.xsd"));
        return fileDialog.showOpenDialog(null);
    }
    
}
