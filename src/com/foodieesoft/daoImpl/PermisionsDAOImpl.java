/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.Permissions;
import com.foodieesoft.beans.UserPermissions;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.PermissionsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class PermisionsDAOImpl implements PermissionsDAO {

    @Override
    public ArrayList<Permissions> getAssignedPermissions(int user_cat_id) {

        ArrayList<Permissions> assgined_permissions_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT permission_id,NAME FROM `user_type` INNER JOIN `user_permission` USING (`user_cat_id`) INNER JOIN `permission` USING (`permission_id`) WHERE user_cat_id=" + user_cat_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int permission_id = rs.getInt("permission_id");
                String user_assignedPermissions = rs.getString("name");
                assgined_permissions_list.add(new Permissions(permission_id, user_assignedPermissions));
            }
        } catch (Exception e) {
            System.out.println("Error in getting User Assigned Permisions ");
            e.printStackTrace();
        }

        return assgined_permissions_list;

    }

    @Override
    public ArrayList<Permissions> getUnassignedPermissions(int user_cat_id) {

        ArrayList<Permissions> unassgined_permissions_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT permission_id,NAME FROM permission WHERE permission_id NOT IN (SELECT permission_id FROM user_permission WHERE user_cat_id=" + user_cat_id + ")";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int permission_id = rs.getInt("permission_id");
                String user_assignedPermissions = rs.getString("name");
                unassgined_permissions_list.add(new Permissions(permission_id, user_assignedPermissions));
            }
        } catch (Exception e) {
            System.out.println("Error in getting User Assigned Permisions ");
            e.printStackTrace();
        }

        return unassgined_permissions_list;
    }

    @Override
    public int savePermission(UserPermissions userPermissions) {
        int i = 0;
        String query = "INSERT INTO `foodiee_soft`.`user_permission` (`user_cat_id`, `permission_id`) VALUES (?, ?)";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userPermissions.getUser_cat_id());
            ps.setInt(2, userPermissions.getPermission_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving userPermissionss");
            System.out.println(e.getMessage());
        }
        return i;
    }

    @Override
    public int deletePermission(UserPermissions userPermissions) {
        int i = 0;
        String query = "DELETE FROM `foodiee_soft`.`user_permission` WHERE `user_cat_id` = ? AND `permission_id` = ? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userPermissions.getUser_cat_id());
            ps.setInt(2, userPermissions.getPermission_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of userPermissions");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Permissions> getUserPermissionName(int user_cat_id) {

        ArrayList<Permissions> permission_name_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT permission_id,NAME FROM `user_type` INNER JOIN `user_permission` USING (`user_cat_id`) INNER JOIN `permission` USING (`permission_id`) WHERE user_cat_id=" + user_cat_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int permission_id = rs.getInt("permission_id");
                String perm_name = rs.getString("name");

                permission_name_list.add(new Permissions(permission_id, perm_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting User permission name");
            e.printStackTrace();
        }

        return permission_name_list;
    }

}
