/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.UserType;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.UserDAO;
import com.foodieesoft.dao.UserTypesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class UserTpesDAOImpl implements UserTypesDAO {

    @Override
    public int saveUserType(UserType userType) {
        int i = 0;
        String query = "INSERT INTO user_type(user_type, created_by, created_date) VALUES (?,?,?) ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userType.getUser_type());
            ps.setInt(2, userType.getCreated_by());
            ps.setString(3, userType.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving usertypes");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public ArrayList<UserType> getAllUserTypes() {
        ArrayList<UserType> user_type_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM user_type WHERE active=1 ORDER BY `user_cat_id` DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int user_cat_id = rs.getInt("user_cat_id");
                String user_type = rs.getString("user_type");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                user_type_list.add(new UserType(user_cat_id, active, created_by, modified_by,
                        created_date, modification_date, user_type));

            }
        } catch (Exception e) {
            System.out.println("Error in getting usertypes");
            e.printStackTrace();
        }

        return user_type_list;
    }

    @Override
    public int modifyUserType(UserType userType) {
        int i = 0;
        String query = "UPDATE user_type SET user_type = ? ,modified_by = ? , modification_date = ? WHERE user_cat_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userType.getUser_type());
            ps.setInt(2, userType.getModified_by());
            ps.setString(3, userType.getModification_date());
            ps.setInt(4, userType.getUser_cat_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Usertype");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeUserType(UserType userType) {
        int i = 0;
        String query = "UPDATE user_type SET active=0 WHERE `user_cat_id` =? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userType.getUser_cat_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of Usertype");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public String getUserType(int user_type_id) {

        String user_type = "";
        try {
            Connection con = DBConnection.load();
            String query = "SELECT user_type FROM user_type WHERE user_cat_id=" + user_type_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                user_type = rs.getString("user_type");

            }
        } catch (Exception e) {
            System.out.println("Error in getting Usertype");
            e.printStackTrace();
        }

        return user_type;

    }

}
