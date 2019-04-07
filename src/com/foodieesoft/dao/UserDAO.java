/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.User;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface UserDAO {

    public User userAuthentication(String username, String password);

    public int verifyUser(User user);

    public int resetPassword(int user_id, String password);

    public String retriveUsername(int user_id);

    public int saveUsers(User user);

    public ArrayList<User> getAllUsers();

    public int modifyUser(User user);

    public int removeUser(User user);

}
