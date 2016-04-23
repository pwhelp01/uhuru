/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

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
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void browseUhuruBtnAction(ActionEvent event) {
        String title = "Open UHURU Installation Directory";
        File test = chooseDirectory(title);
    }
    
    @FXML
    private void browseInnerProjectBtnAction(ActionEvent event) {
        String title = "Open Inner Project Installation Directory";
        File test = chooseDirectory(title);
    }
    
    @FXML
    private void browseMavenBtnAction(ActionEvent event) {
        String title = "Open Maven Installation Directory";
        File test = chooseDirectory(title);
    }
    
    @FXML
    private void backBtnAction(ActionEvent event) {
        try {    
            PageLoader.loadPage(PageLoader.MENU);
        }
        catch (Exception e){}
    }
    
    // Helper methods
    private File chooseDirectory(String title) {
        DirectoryChooser directoryDialog = new DirectoryChooser();
        directoryDialog.setTitle(title);
        return directoryDialog.showDialog(null);
    }
}
