/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.Permissions;
import com.foodieesoft.beans.UserPermissions;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface PermissionsDAO {
        public ArrayList<Permissions> getAssignedPermissions(int user_cat_id);
    public ArrayList<Permissions> getUnassignedPermissions(int user_cat_id);
    public int savePermission(UserPermissions userPermissions );
    public int deletePermission(UserPermissions userPermissions );
    public ArrayList<Permissions>getUserPermissionName(int user_cat_id);
    
}
