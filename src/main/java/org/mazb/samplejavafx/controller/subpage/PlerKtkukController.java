/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.controller.subpage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.mazb.samplejavafx.common.CommonController;

/**
 *
 * @author bergasbimo
 */
public class PlerKtkukController extends CommonController {
    
    @FXML
    private Label labelPageName;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelPageName.setText("pler ktkuk page");
    }
    
}
