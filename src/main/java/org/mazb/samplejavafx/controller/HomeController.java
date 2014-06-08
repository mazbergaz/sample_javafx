package org.mazb.samplejavafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.mazb.samplejavafx.app.Context;
import org.mazb.samplejavafx.common.CommonController;
import org.mazb.samplejavafx.model.User;

/**
 * @author mazbergaz@gmail.com
 */
public class HomeController extends CommonController {
    
    private User user;
    
    @FXML
    private Text welcomeText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = (User) Context.getInstance().getContextObject("loggedInUser");
        welcomeText.setText("Welcome, "+user.getRealName());
    }
    
    @FXML 
    protected void handleLetsgoButtonAction(ActionEvent event) {
        try {
            setScene("portal");
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

}
