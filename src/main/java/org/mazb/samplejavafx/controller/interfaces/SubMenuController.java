/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.controller.interfaces;

import java.net.URL;
import javafx.beans.property.ReadOnlyObjectProperty;

/**
 *
 * @author bergasbimo
 */
public interface SubMenuController {
    
    public ReadOnlyObjectProperty<URL> selectedViewProperty();
    public URL getSelectedView();
    
}
