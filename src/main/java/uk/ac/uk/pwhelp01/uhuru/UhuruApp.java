package uk.ac.uk.pwhelp01.uhuru;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class UhuruApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        URL fxmlURL = getClass().getResource("/fxml/Main.fxml");
        
        System.out.println (fxmlURL);
        
        loader.setLocation(fxmlURL);
        Parent root = loader.load();
        MainController mainController = loader.getController();

        PageLoader.setMainController(mainController);
        PageLoader.loadPage(PageLoader.MENU);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Universal HESA and Unistats Returns Utility");
        stage.setScene(scene);
        stage.show();
                      
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }

}
