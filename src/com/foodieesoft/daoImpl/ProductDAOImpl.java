/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.Product;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.ProductDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class ProductDAOImpl implements ProductDAO {

    @Override
    public int saveProducts(Product product) {

        int i = 0;
        String query = "INSERT INTO product (food_cat_id,food_name,price,quantity, created_by, created_date) VALUES (?,?,?,?,?,?)";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getFood_cat_id());
            ps.setString(2, product.getFood_name());
            ps.setInt(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getCreated_by());
            ps.setString(6, product.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving product");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Product> getAllProducts(String txt) {
        ArrayList<Product> products_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM product WHERE food_name LIKE '%"+txt+"%' AND active=1 ORDER BY product_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                int category_id = rs.getInt("food_cat_id");
                String food_name = rs.getString("food_name");
                int price = rs.getInt("price");
                int active = rs.getInt("active");
                int quantity = rs.getInt("quantity");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                products_list.add(new Product(product_id, category_id, active, price, quantity, created_by, modified_by,
                        created_date, modification_date, food_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return products_list;
    }

    @Override
    public int modifyProducts(Product product) {
        int i = 0;
        String query = "UPDATE product SET food_cat_id=?,food_name = ?,price=?,quantity=?,modified_by = ? , modification_date = ? WHERE product_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getFood_cat_id());
            ps.setString(2, product.getFood_name());
            ps.setInt(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getModified_by());
            ps.setString(6, product.getModification_date());
            ps.setInt(7, product.getProduct_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of product");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeProducts(Product product) {
        int i = 0;
        String query = "UPDATE product SET active=0 WHERE `product_id` =? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getProduct_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of questions");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int mofidyProductsQuantity(Product product) {
        int i = 0;
        String query = "UPDATE product SET quantity = ? WHERE product_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getQuantity());
            ps.setInt(2, product.getProduct_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in updating quantity of products");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int getProductId(String food_name, int price) {
        int product_id = 0;

        return product_id;

    }

    @Override
    public Product getProduct(int product_id) {
        Product product = null;
        try {
            Connection con = DBConnection.load();
            String query = "SELECT food_cat_id,product_id, RPAD(food_name,29,' '),RPAD(quantity,10,' '), price,active,created_by,modified_by,modification_date,created_date FROM product WHERE active =1 AND product_id=" + product_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int category_id = rs.getInt("food_cat_id");
                String food_name = rs.getString(3);
                int price = rs.getInt("price");
                int active = rs.getInt("active");
                int quantity = rs.getInt(4);
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                product = new Product(product_id, category_id, active, price, quantity, created_by, modified_by,
                        created_date, modification_date, food_name);

            }
        } catch (Exception e) {
            System.out.println("Error in getting User permission name");
            e.printStackTrace();
        }

        return product;
    }

}
