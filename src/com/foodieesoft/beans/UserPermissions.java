/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.beans;

/**
 *
 * @author Vksoni
 */
public class UserPermissions {
    private int user_cat_id;
    private int permission_id;

    public UserPermissions() {
    }

    public UserPermissions(int user_cat_id, int permission_id) {
        this.user_cat_id = user_cat_id;
        this.permission_id = permission_id;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public int getUser_cat_id() {
        return user_cat_id;
    }

    public void setUser_cat_id(int user_cat_id) {
        this.user_cat_id = user_cat_id;
    }
    
    
}
