/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import org.mazb.samplejavafx.common.CommonController;

import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import org.mazb.samplejavafx.component.MenuItemExtended;

/**
 *
 * @author bergasbimo
 */
public class PortalController extends CommonController{
    
    @FXML
    private MenuBar menuBar; 
    
    @FXML  
    private BorderPane root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Menu menuFile = new Menu("File");
        menuFile.getItems().add(new MenuItemExtended("Exit").setOnRedirectScene("login"));
        
        Menu menuUser = new Menu("User");
        menuUser.getItems().add(new MenuItemExtended("Show User").setOnRedirectContent("subcontent/usershow", root));
        menuUser.getItems().add(new MenuItemExtended("Add User").setOnRedirectContent("subcontent/useradd", root));
        
        Menu menuOther = new Menu("Other");
        menuOther.getItems().add(new MenuItemExtended("Kampret Ciganea").setOnRedirectContent("subcontent/kampretciganea", root));
        menuOther.getItems().add(new MenuItemExtended("Pler Ktkuk").setOnRedirectContent("subcontent/plerktkuk", root));
        
        menuBar.getMenus().addAll(menuFile, menuUser, menuOther);

    }
    
}
