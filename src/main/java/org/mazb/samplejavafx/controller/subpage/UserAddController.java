/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.controller.subpage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.mazb.samplejavafx.app.Context;
import org.mazb.samplejavafx.common.CommonController;
import org.mazb.samplejavafx.model.User;

/**
 *
 * @author bergasbimo
 */
public class UserAddController extends CommonController {
    
    @FXML
    private Label labelResult;
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField passwordField;
    
    @FXML
    private TextField realnameField;
    
    @FXML
    private TextField emailField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML 
    protected void handleAddButtonAction(ActionEvent event) {
        User user = new User();
        user.setId(0);
        user.setUserName(usernameField.getText());
        user.setRealName(realnameField.getText());
        user.setPassword(passwordField.getText());
        user.setEmail(emailField.getText());
        user.setRoleDto(null);
        User loggedInUser = (User) Context.getInstance().getContextObject("loggedInUser");
        user.setCreatedBy(loggedInUser.getUserName());
        user.setCreatedOn(new Date().getTime());
        user.setModifiedBy("");
        user.setLastModified(0);
        if(getFileHandler().writeFile(user.toCsvString(), "user")){
            labelResult.setText("add user succeed!");
        }else{
            labelResult.setText("add user failed!");
        }
    }
    
}
