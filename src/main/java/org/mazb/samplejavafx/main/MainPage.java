package org.mazb.samplejavafx.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import org.mazb.samplejavafx.common.CommonController;

/**
 * @author bimo
 */
public class MainPage extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage){
        try {
            CommonController.setSceneContentStartup(stage);
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
