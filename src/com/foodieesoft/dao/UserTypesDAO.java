/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.UserType;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface UserTypesDAO {
    public int saveUserType(UserType userType);
    public ArrayList<UserType> getAllUserTypes();
    public int modifyUserType(UserType userType);
    public int removeUserType(UserType userType);
    public String getUserType(int user_type_id);

}
