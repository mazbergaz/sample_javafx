/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.util.model;

/**
 *
 * @author bergasbimo
 */
public class Item {

    private String itemTitle;
    private String action;

    public Item() {
    }

    public Item(String itemTitle, String action) {
        this.itemTitle = itemTitle;
        this.action = action;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
