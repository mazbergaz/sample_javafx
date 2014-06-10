/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.component;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.mazb.samplejavafx.model.User;

/**
 *
 * @author bergasbimo
 */
public class TableUserProperties {
    
    private IntegerProperty id;
    private StringProperty userName;
    private StringProperty realName;
    private StringProperty email;
    private StringProperty password;
    
    public TableUserProperties(){
        this("", "");
    }
    
    public TableUserProperties(String userName, String password){
        this(new User(userName, password));
    }
    
    public TableUserProperties(User user){
        this.id = new SimpleIntegerProperty(user.getId());
        this.userName = new SimpleStringProperty(user.getUserName());
        this.realName = new SimpleStringProperty(user.getRealName());
        this.email = new SimpleStringProperty(user.getEmail());
        this.password = new SimpleStringProperty(user.getPassword());
    }

    public int getId() {
        return id.get();
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(StringProperty userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName.get();
    }

    public void setRealName(StringProperty realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(StringProperty email) {
        this.email = email;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(StringProperty password) {
        this.password = password;
    }
    
}
