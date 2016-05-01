/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond.pwhelp01.uhuru.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author peedeeboy
 */
public class MainController implements Initializable {
    
    @FXML Label titleLbl;
    @FXML StackPane contentStc;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Load the custom font
        try {
            final Font finalFrontier = Font.loadFont(getClass().getResourceAsStream("/fonts/FINALOLD.TTF"), 32.0);
            titleLbl.setFont(finalFrontier);
        }
        catch (Exception e){}
        
    }
    
    
    public void setContent(Node node) {
        contentStc.getChildren().setAll(node);
    }
    
   
    
    
}
