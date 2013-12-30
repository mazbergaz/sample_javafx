package org.mazb.samplejavafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.mazb.samplejavafx.common.CommonController;
import org.mazb.samplejavafx.common.Context;
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

}
