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
    @FXML TextField schemaTxt;
    @FXML TextField dataTxt;
    @FXML TextField codeTxt;
    
    
    ObjectProperty<File> schemaFile = new SimpleObjectProperty(new File(""));
    ObjectProperty<File> dataFile = new SimpleObjectProperty();
    
    InnerProject innerProject = new InnerProject();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Bindings
        schemaTxt.textProperty().bind(schemaFile.asString());
        
        codeTxt.textProperty().bind(innerProject.codeFile.asString());
        
    }
    
    
    @FXML
    private void schemaBrowseBtnAction(ActionEvent event) {
        
        schemaFile.set(chooseFile());
        
    }
    
    @FXML
    private void dataBrowseBtnAction(ActionEvent event) {
        
        dataFile.set(chooseFile());
        
    }
    
    @FXML
    private void codeBrowseBtnAction(ActionEvent event) {
        
        innerProject.setCodeFile(chooseFile());
        
    }
    
    private File chooseFile() {
        FileChooser fileDialog = new FileChooser();
        fileDialog.setTitle("Open File");
        fileDialog.getExtensionFilters().addAll(new ExtensionFilter("XML Schema Files", "*.xsd"));
        return fileDialog.showOpenDialog(null);
    }
}
