/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond.pwhelp01.uhuru;

import uk.ac.richmond.pwhelp01.uhuru.controller.MainController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 * Handles the loading of the pages (FXML files) into the main application
 * 
 * <p>Based on the Miniframework by Jewelsea https://gist.github.com/jewelsea/6460130
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
    
    /**
     * Stores a reference to the maincontroller of the application as a global (static) variable
     * 
     * @param mainController The controller for the main scene of the application
     */
    public static void setMainController(MainController mainController) {
        PageLoader.mainController = mainController;
    }
    
    /**
     * Loads an FXML file into the content pane of the main application
     * 
     * @param fxml Constant relating to the page to be loaded 
     */
    public static void loadPage(String fxml) {
        
        // Attempt to load the FXML file
        try {
            mainController.setContent(
                (Node) FXMLLoader.load(PageLoader.class.getResource(fxml))
            );
        } 
        // An error occured when trying to load the page
        catch (IOException e) {
            e.printStackTrace();
        }
    }
   
}
