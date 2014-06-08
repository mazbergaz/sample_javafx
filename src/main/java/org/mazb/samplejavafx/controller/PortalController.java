/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import org.apache.commons.lang.StringUtils;
import org.mazb.samplejavafx.common.CommonController;
import org.mazb.samplejavafx.component.MenuItemExtended;
import org.mazb.samplejavafx.model.Item;
import org.mazb.samplejavafx.model.Menus;

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
        
        setMenu();
        
    }
    
    private void setMenu(){
        Menus menus = (Menus) readJsonPropertiesReader("/setup/menu.json", Menus.class);
        List<org.mazb.samplejavafx.model.Menu> listmenu = menus.getMenus();
        Pattern pattern = Pattern.compile("=");
        for(org.mazb.samplejavafx.model.Menu objMenu : listmenu){
            Menu menu = new Menu(objMenu.getTitle());
            List<Item> items = objMenu.getItems();
            for(Item item : items){
                String[] action = pattern.split(item.getAction());
                MenuItemExtended menuitem = new MenuItemExtended(item.getItemTitle());
                if(StringUtils.equals(action[0], "redirect-scene")){
                    menuitem.setOnRedirectScene(action[1]);
                }else if(StringUtils.equals(action[0], "redirect-content")){
                    menuitem.setOnRedirectContent(action[1], root);
                }
                menu.getItems().add(menuitem);
            }
            menuBar.getMenus().add(menu);
        }
    }
    
}
