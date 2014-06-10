package org.mazb.samplejavafx.app;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
//            stage.initStyle(StageStyle.UNDECORATED);
            stage.setWidth(800);
            stage.setHeight(600);
            stage.centerOnScreen();
            CommonController.setSceneStartup(stage);
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
