/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

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

/**
 * FXML Controller class
 *
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
    
    
    @FXML
    private void browseUhuruBtnAction(ActionEvent event) {
        String title = "Open UHURU Installation Directory";
        settings.uhuruDirProperty().set(chooseDirectory(title).toString());
    }
    
    @FXML
    private void browseInnerProjectBtnAction(ActionEvent event) {
        String title = "Open Inner Project Installation Directory";
        settings.innerProjectDirProperty().set(chooseDirectory(title).toString());
    }
    
    @FXML
    private void browseMavenBtnAction(ActionEvent event) {
        String title = "Open Maven Installation Directory";
        settings.mavenDirPropety().set(chooseDirectory(title).toString());
    }
    
    @FXML
    private void backBtnAction(ActionEvent event) {
        try {    
            PageLoader.loadPage(PageLoader.MENU);
        }
        catch (Exception e){}
    }
    
    @FXML
    private void saveBtnAction(ActionEvent event) {
        if(settings.validate()) {
            try {
                settings.save();
                statusLbl.textProperty().set("Settings saved");
            }
            catch(BackingStoreException e) {
                statusLbl.textProperty().set("Error saving settings");
                e.printStackTrace();
            }
        }
        else {
            statusLbl.textProperty().set("Invalid directory locations");
        }
    }
    
    // Helper methods
    private File chooseDirectory(String title) {
        DirectoryChooser directoryDialog = new DirectoryChooser();
        directoryDialog.setTitle(title);
        return directoryDialog.showDialog(null);
    }
}
