/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.FoodCategory;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.FoodCategoryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class FoodCategoryDAOImpl implements FoodCategoryDAO {

    @Override
    public int saveFoodCategory(FoodCategory foodCategory) {

        int i = 0;
        String query = "INSERT INTO food_category(food_name, created_by, created_date) VALUES (?,?,?) ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, foodCategory.getFood_type());
            ps.setInt(2, foodCategory.getCreated_by());
            ps.setString(3, foodCategory.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving food types");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public ArrayList<FoodCategory> getAllFoodTypes() {
        ArrayList<FoodCategory> food_type_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM food_category WHERE active=1 ORDER BY food_cat_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int food_cat_id = rs.getInt("food_cat_id");
                String food_name = rs.getString("food_name");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                food_type_list.add(new FoodCategory(food_cat_id, active, created_by, modified_by,
                        created_date, modification_date, food_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return food_type_list;
    }

    @Override
    public int modifyFoodCategory(FoodCategory foodCategory) {
        int i = 0;
        String query = "UPDATE food_category SET food_name = ? ,modified_by = ? , modification_date = ? WHERE food_cat_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, foodCategory.getFood_type());
            ps.setInt(2, foodCategory.getModified_by());
            ps.setString(3, foodCategory.getModification_date());
            ps.setInt(4, foodCategory.getFood_cat_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Food type");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeFoodCategory(FoodCategory foodCategory) {
        int i = 0;
        String query = "UPDATE food_category SET active=0 WHERE `food_cat_id` =? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, foodCategory.getFood_cat_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of food type");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public String getFoodType(int food_cat_id) {
        String food_name = "";
        try {
            Connection con = DBConnection.load();
            String query = "SELECT food_name FROM food_category WHERE food_cat_id=" + food_cat_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                food_name = rs.getString("food_name");

            }
        } catch (Exception e) {
            System.out.println("Error in getting food type");
            e.printStackTrace();
        }

        return food_name;
    }

}
