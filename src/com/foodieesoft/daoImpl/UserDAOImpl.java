/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.User;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public User userAuthentication(String username, String password) {
        User user = null;
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM user WHERE user_name =? AND password =?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(
                    1, username);
            ps.setString(
                    2, password);    // Statement st=con.createStatement();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_name = rs.getString("user_name");
                String pass = rs.getString("password");
                int user_cat_id = rs.getInt("user_cat_id");

                user = new User(user_id, username, password, user_cat_id);
            }

        } catch (Exception e) {
            System.out.println("Error in userAuthentication");
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public int resetPassword(int user_id, String password) {
        int i = 0;
        try {
            Connection con = DBConnection.load();
            String query = "UPDATE USER SET PASSWORD='" + password + "' WHERE user_id=" + user_id;
            PreparedStatement ps = con.prepareStatement(query);
//            ps.setInt(1, user_id);
//            ps.setString(2, password);

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Food type");
            e.printStackTrace();
        }
        System.out.println("reset password:" + user_id + "  " + password + "   " + i);

        return i;
    }

    @Override
    public int verifyUser(User user) {
        int user_id = 0;

        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM USER WHERE user_name='" + user.getUser_name() + "' AND NAME='" + user.getName() + "' AND contact_num='" + user.getContact_num() + "' AND question_id=" + user.getQuestion_id() + " AND answer='" + user.getAnswer() + "' AND active=1";
            PreparedStatement ps = con.prepareStatement(query);
//         

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                user_id = rs.getInt("user_id");

            }
        } catch (Exception e) {
            System.out.println("Error in user verification");
            e.printStackTrace();
        }

        return user_id;

    }

    @Override
    public String retriveUsername(int user_id) {
        String name = "";
        try {

            Connection con = DBConnection.load();
            String query = "SELECT name FROM user WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
            }

        } catch (Exception e) {
            System.out.println("Error in retriveUsername ");
            e.printStackTrace();
        }

        return name;
    }

    
    @Override
    public int saveUsers(User user) {

        System.out.println("in save user");
        int i = 0;
        int counter=0;
        String selectQuery = " SELECT * FROM USER WHERE (contact_num='"+user.getContact_num()+"' OR user_name='"+user.getUser_name()+"') and  active=1";

        String InsertQuery = " INSERT INTO USER (user_cat_id, user_name, PASSWORD, NAME, address,contact_num,question_id,answer,created_by,created_date) VALUES (?,?,?,?,?,?,?,?,?,?)  ";
        try {
            Connection con = DBConnection.load();

            PreparedStatement psSelect = con.prepareStatement(selectQuery);

            ResultSet rs = psSelect.executeQuery();
            while (rs.next()) {
              ++counter;
            }
            
            if((counter==0)){

            PreparedStatement ps = con.prepareStatement(InsertQuery);
            ps.setInt(1, user.getUser_cat_id());
            ps.setString(2, user.getUser_name());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getName());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getContact_num());
            ps.setInt(7, user.getQuestion_id());
            ps.setString(8, user.getAnswer());
            ps.setInt(9, user.getCreated_by());
            ps.setString(10, user.getCreated_date());

            i = ps.executeUpdate();}
            else{
            i=-1;
            }
        } catch (Exception e) {

            System.out.println("Error in saving user");
            e.printStackTrace();
        }
        System.out.println("iiii"+i);
        return i;

    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM USER WHERE active=1 ORDER BY user_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                int user_cat_id = rs.getInt("user_cat_id");
                String user_name = rs.getString("user_name");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String contact_num = rs.getString("contact_num");
                int question_id = rs.getInt("question_id");
                String answer = rs.getString("answer");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                users_list.add(new User(user_id, user_cat_id, question_id, active, created_by, modified_by, user_name, password, name,
                        address, modification_date, contact_num, answer, created_date));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return users_list;
    }

    @Override
    public int modifyUser(User user) {
        System.out.println("in modddddfy");
        int i = 0;
        String query = " UPDATE user SET user_cat_id = ? , user_name = ? , password = ? , name = ? , address = ? , contact_num = ? , question_id = ? , answer = ? , modified_by = ?, modification_date=? WHERE user_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user.getUser_cat_id());
            ps.setString(2, user.getUser_name());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getName());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getContact_num());
            ps.setInt(7, user.getQuestion_id());
            ps.setString(8, user.getAnswer());
            ps.setInt(9, user.getModified_by());
            ps.setString(10, user.getModification_date());
            ps.setInt(11, user.getUser_id());
              System.out.println("In modify user");
            i = ps.executeUpdate();
            System.out.println("i= "+i);
        } catch (Exception e) {

            System.out.println("Error in modification of User");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeUser(User user) {
        int i = 0;
        String query = "UPDATE user SET active=0 WHERE `user_id` =? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user.getUser_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of User");
            e.printStackTrace();
        }
        return i;
    }

}
