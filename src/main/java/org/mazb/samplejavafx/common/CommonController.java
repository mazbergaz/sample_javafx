package org.mazb.samplejavafx.common;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.lang.StringUtils;
import org.mazb.samplejavafx.app.Context;
import org.mazb.samplejavafx.model.Menus;
import org.mazb.samplejavafx.util.RestClient;

/**
 * @author mazbergaz@gmail.com
 */
public abstract class CommonController implements Initializable {
    
    public final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    private static final String UI_BASE_LOCATION = "/pages/";
    private static final String FXML_PREFIX = ".fxml";
    
    private RestClient restClient = new RestClient();
    
    public static void setSceneStartup(Stage stage) throws IOException{
        Context.getInstance().setCurrentStage(stage);
        setScene("login");
    }
    
    public static Parent setScene(String pageName) throws IOException {
        Stage currentStage = Context.getInstance().getCurrentStage();
        Scene scene = currentStage.getScene();
        Parent page = getParent(pageName);
        if (scene == null) {
            scene = new Scene(page);
            currentStage.setScene(scene);
            currentStage.setTitle("Sample JavaFX Application");
        } else {
            currentStage.getScene().setRoot(page);
        }
        currentStage.setWidth(800);
        currentStage.setHeight(600);
        currentStage.centerOnScreen();
        currentStage.show();
        return page;
    }
    
    public static Parent getParent(String pageName) throws IOException{
        return (Parent) FXMLLoader.load(CommonController.class.getResource(UI_BASE_LOCATION + pageName + FXML_PREFIX));
    }
    
    public RestClient getRestClient(){
        return restClient;
    }
    
    public Object readJsonPropertiesReader(String fileName, Class clz){
        String fileLoc = getClass().getResource(fileName).getFile();
        return CommonParser.parseJsonToObject(new File(fileLoc), clz);
    }
    
}
