/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author peedeeboy
 */
public class MenuController implements Initializable {

    @FXML Button exitBtn;
    @FXML StackPane contentStc;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
     public void setContentStc(StackPane contentStc) {
        this.contentStc = contentStc;
    }
}
