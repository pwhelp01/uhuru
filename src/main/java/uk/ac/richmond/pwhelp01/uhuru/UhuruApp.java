package uk.ac.richmond.pwhelp01.uhuru;

import uk.ac.richmond.pwhelp01.uhuru.controller.MainController;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Universal HESA and Unistats Return Utility (UHURU)
 * 
 * <p>Converts HESA XML schema files into a relational schema in SQL Server 
 * and marshals data back into XML
 * 
 * @author peedeeboy
 */
public class UhuruApp extends Application {

    /**
     * Launch the UHURU application
     * @param stage Main stage
     * @throws Exception Error occurred whilst initialising the application
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        // Create a new FXMLLoader and get the view for the main application
        FXMLLoader loader = new FXMLLoader();
        URL fxmlURL = getClass().getResource("/fxml/Main.fxml");
        
        // Load the main view and assign its controller
        loader.setLocation(fxmlURL);
        Parent root = loader.load();
        MainController mainController = loader.getController();

        // Load the main menu view into the content section of the main view
        PageLoader.setMainController(mainController);
        PageLoader.loadPage(PageLoader.MENU);

        // Set the scene and apply custom .css
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        // Set application title and icon and make the app visisble
        stage.setTitle("Universal HESA and Unistats Returns Utility");
        stage.getIcons().add(new Image("/icons/icon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
                      
    }
    
    /**
     * Main method
     * 
     * <p> Launches the UHURU application
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
