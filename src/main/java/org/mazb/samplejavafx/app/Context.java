package org.mazb.samplejavafx.app;

import java.util.HashMap;
import java.util.Map;
import javafx.stage.Stage;

/**
 * @author mazbergaz@gmail.com
 */
public class Context {
    
    private static Context instance;
    
    public static Context getInstance(){
        return instance == null ? new Context() : instance;
    }
    
    private static Map<String, Object> contextObjects = new HashMap<String, Object>();
    private static Stage currentStage;
    
    public Map<String, Object> getContextObjects(){
        return contextObjects;
    }
    
    public Object getContextObject(String key){
        return contextObjects.get(key);
    }
    
    public Object removeContextObject(String key){
        return contextObjects.remove(key);
    }
    
    public void addContextObject(String key, Object value){
        contextObjects.put(key, value);
    }
    
    public void clearContextObjects(){
        contextObjects.clear();
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(Stage stage) {
        currentStage = stage;
    }
    
}
