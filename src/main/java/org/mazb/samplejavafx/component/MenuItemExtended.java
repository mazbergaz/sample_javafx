/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.component;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import org.mazb.samplejavafx.common.CommonController;

/**
 *
 * @author bergasbimo
 */
public class MenuItemExtended extends MenuItem {
    
    public MenuItemExtended(String name){
        super(name);
    }
    
    public MenuItemExtended setOnActionSuper(EventHandler<ActionEvent> eh){
        super.setOnAction(eh);
        return this;
    }
    
    public MenuItemExtended setOnAction(final String textLabel, final Label label){
        super.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                label.setText(textLabel +" is selected");
            }
        });
        return this;
    }
    
    public MenuItemExtended setOnRedirectScene(final String redirectPage){
        super.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                try {
                    CommonController.setScene(redirectPage);
                } catch (IOException ex) {
                    Logger.getLogger(MenuItemExtended.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return this;
    }
    
    public MenuItemExtended setOnRedirectContent(final String redirectContent){
        super.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                try {
                    CommonController.setScene(redirectContent);
                } catch (IOException ex) {
                    Logger.getLogger(MenuItemExtended.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return this;
    }
    
    public MenuItemExtended setOnQuit(){
        System.exit(0);
        return this;
    }
    
}
