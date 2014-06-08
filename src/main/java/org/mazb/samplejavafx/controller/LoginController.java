package org.mazb.samplejavafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.mazb.samplejavafx.app.Context;
import org.mazb.samplejavafx.common.CommonConstant;
import org.mazb.samplejavafx.common.CommonController;
import org.mazb.samplejavafx.model.User;

/**
 * @author bimo
 */
public class LoginController extends CommonController {
    
    @FXML
    private Text actiontarget;
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML 
    protected void handleSubmitButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String pass = passwordField.getText();
        User user = new User(username, pass);
        user = getUser(user); //(User) getRestClient().postFormData(user, CommonConstant.RestOperationPath.VALIDATE_USER);
        if(user==null){
            actiontarget.setText("forbidden");
        }else{
            try {
                Context.getInstance().addContextObject("loggedInUser", user);
                setScene("home");
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private User getUser(User user){
        user.setCreatedBy("SYSTEM");
        user.setCreatedOn(new Date().getTime());
        user.setEmail(user.getUserName() + "@email.com");
        user.setId(1);
        user.setRealName(user.getUserName() + "'s real name");
        return user;
    }
    
}
