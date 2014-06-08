/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.model;

import java.util.List;

/**
 *
 * @author bergasbimo
 */
public class Menu {

    private String title;
    private List<Item> items;
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
