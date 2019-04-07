/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.OrderDetail;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.OrderDetailsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class OrderDetailsDAOImpl implements OrderDetailsDAO{
     
     @Override
    public int saveOrderDetail(OrderDetail order_detail) {
        int i = 0;
        String query = "INSERT INTO order_details(order_id, product_id, quantity, created_by, created_date,total_price,customer_id) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, order_detail.getOrder_id());
            ps.setInt(2, order_detail.getProduct_id());
            ps.setInt(3, order_detail.getQantity());
            ps.setInt(4, order_detail.getCreated_by());
            ps.setString(5, order_detail.getCreated_date());
            ps.setDouble(6, order_detail.getTotal_price());
            ps.setInt(7, order_detail.getCustomer_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving usertypes");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<OrderDetail> getAllOrderDetail() {

        ArrayList<OrderDetail> order_detail_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM order_details WHERE active=1 ORDER BY order_details_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_details_id = rs.getInt("order_details_id");
                int order_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                double total_price = rs.getDouble("total_price");
                int quantity = rs.getInt("quantity");

                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                order_detail_list.add(new OrderDetail(order_details_id, order_id, product_id, quantity, active, created_by, created_date, modified_by, total_price, modification_date));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return order_detail_list;

    }

    @Override
    public int modifyOrderDetail(OrderDetail order_detail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeOrderDetail(OrderDetail order_detail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      @Override
    public ArrayList<OrderDetail> getAllOrderDetailById(int order_id) {
        ArrayList<OrderDetail> order_detail_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM order_details WHERE   active=1 AND order_id=" + order_id+" ORDER BY order_details_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_details_id = rs.getInt("order_details_id");
                int ordr_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                double total_price = rs.getDouble("total_price");
                int quantity = rs.getInt("quantity");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                order_detail_list.add(new OrderDetail(order_details_id, ordr_id, product_id, quantity, active, created_by, created_date, modified_by, total_price, modification_date));

            }
        } catch (Exception e) {
            System.out.println("Error in getting order details by id");
            e.printStackTrace();
        }

        return order_detail_list;
    }


}
