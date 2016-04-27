/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 *
 * @author peedeeboy
 */
public class PageLoader {
    
    public static final String MAIN = "/fxml/Main.fxml";
    public static final String MENU    = "/fxml/Menu.fxml";
    public static final String CREATESCHEMA = "/fxml/CreateSchema.fxml";
    public static final String CREATEXML = "/fxml/CreateXml.fxml";
    public static final String SETTINGS = "/fxml/Settings.fxml";
    
    private static MainController mainController;
    
    
    public static void setMainController(MainController mainController) {
        PageLoader.mainController = mainController;
    }
    
    public static void loadPage(String fxml) {
        
        System.out.println(fxml);
        
        try {
            mainController.setContent(
                (Node) FXMLLoader.load(
                    PageLoader.class.getResource(
                        fxml
                    )
                )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
}
