/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.controller.subpage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import org.mazb.samplejavafx.common.CommonController;
import org.mazb.samplejavafx.component.TableUserProperties;
import org.mazb.samplejavafx.model.User;

/**
 *
 * @author bergasbimo
 */
public class UserShowController extends CommonController{
    
    @FXML
    private Label labelPageName;
    
    @FXML
    private TableView tableUser;
    
    private ObservableList<TableUserProperties> userList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelPageName.setText("user show page");
        setUserList(getUsers());
    }
    
    private void setUserList(List<TableUserProperties> users){
        userList = FXCollections.observableArrayList();
        userList.addAll(users);
        tableUser.setItems(userList);
        
    }
    
    /**
     * sementara users ngambil di sini dulu, nantinya ngambil dari backend
     * @return 
     */
    private List<TableUserProperties> getUsers(){
        List<TableUserProperties> users = new ArrayList<TableUserProperties>();
        for(int i=0; i<5; i++){
            users.add(new TableUserProperties("user"+i, "pass"+i));
        }
        return users;
    }
    
}
