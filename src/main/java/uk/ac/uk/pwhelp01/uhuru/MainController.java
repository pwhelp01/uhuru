/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author peedeeboy
 */
public class MainController implements Initializable {
    
    @FXML
    StackPane contentStc;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Load the menu into the content pane
        
        try {
            // contentStc.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml")));
            
                    
        }
        catch (Exception e){}
        
    }
    
    
    public void setContent(Node node) {
        contentStc.getChildren().setAll(node);
    }
    
   
    
    
}
