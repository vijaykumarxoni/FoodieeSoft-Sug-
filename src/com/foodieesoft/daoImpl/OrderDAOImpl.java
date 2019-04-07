/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.Discount;
import com.foodieesoft.beans.Order;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.OrderDAO;
import geeks.foodieesoft.util.CurrentDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class OrderDAOImpl implements OrderDAO{
    
     @Override
    public int saveOrder(Order order) {

        int i = 0;
        String query = "INSERT INTO order_table (customer_id, created_by, created_date, discount_id, discount, total_bill,number,order_status,customer_name) VALUES (?, ?, ?, ?, ?,?,?, ?, ?)";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, order.getCustomer_id());
            ps.setInt(2, order.getCreated_by());
            ps.setString(3, order.getCreated_date());
            ps.setInt(4, order.getDiscount_id());
            ps.setInt(5, order.getDiscount());
            ps.setInt(6, order.getTotal_bill());
            ps.setInt(7, order.getNumber());
            ps.setString(8, order.getOrder_status());
            ps.setString(9, order.getCustomerName());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving order");
            e.printStackTrace();
        }
        return i;
    }
 @Override
    public int getLastOrderId() {
        int order_id = 0;
        try {
            Connection con = DBConnection.load();
            String query = "SELECT order_id FROM order_table ORDER BY order_id DESC LIMIT 1";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                order_id = rs.getInt("order_id");

            }
        } catch (Exception e) {
            System.out.println("Error in getting order id");
            e.printStackTrace();
        }

        return order_id;
    }
 @Override
    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> order_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM order_table WHERE active=1 ORDER BY order_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int customer_id = rs.getInt("customer_id");
                int number = rs.getInt("number");
                int active = rs.getInt("active");
                int discount_id = rs.getInt("discount_id");
                int discount = rs.getInt("discount");
                int total_bill = rs.getInt("total_bill");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String order_status = rs.getString("order_status");
                String modification_date = rs.getString("modification_date");
                String customer_name=rs.getString("customer_name");

                order_list.add(new Order(order_id, customer_id, number, active,
                        created_by, created_date, modified_by, modification_date,
                        discount_id, discount, total_bill, order_status,customer_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting usertypes");
            e.printStackTrace();
        }

        return order_list;
    }
    
     @Override
    public int removeOrder(int order_id) {
        int i = 0;
        String query = "UPDATE order_table SET active =0 WHERE order_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, order_id);

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Usertype");
            e.printStackTrace();
        }
        return i;
    }
 @Override
    public ArrayList<Order> getAllTodayOrder() {
        ArrayList<Order> order_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM order_table WHERE active=1 and created_date=" + CurrentDate.getCurrentDate() + " ORDER BY order_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int customer_id = rs.getInt("customer_id");
                int number = rs.getInt("number");
                int active = rs.getInt("active");
                int discount_id = rs.getInt("discount_id");
                int discount = rs.getInt("discount");
                int total_bill = rs.getInt("total_bill");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String customer_name=rs.getString("customer_name");

                String modification_date = rs.getString("modification_date");

                order_list.add(new Order(order_id, customer_id, number, active,
                        created_by, created_date, modified_by, modification_date,
                        discount_id, discount, total_bill));

            }
        } catch (Exception e) {
            System.out.println("Error in getting usertypes");
            e.printStackTrace();
        }

        return order_list;
    }
    
     @Override
    public ArrayList<Order> getAllOrderOfMonth() {
        ArrayList<Order> order_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT  * FROM order_table WHERE created_date BETWEEN CURRENT_DATE - INTERVAL '1' MONTH AND CURRENT_DATE ORDER BY order_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int customer_id = rs.getInt("customer_id");
                int number = rs.getInt("number");
                int active = rs.getInt("active");
                int discount_id = rs.getInt("discount_id");
                int discount = rs.getInt("discount");
                int total_bill = rs.getInt("total_bill");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String order_status = rs.getString("order_status");
                String modification_date = rs.getString("modification_date");
                     String customer_name=rs.getString(rs.getString("customer_name"));


                order_list.add(new Order(order_id, customer_id, number, active,
                        created_by, created_date, modified_by, modification_date,
                        discount_id, discount, total_bill, order_status,customer_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting usertypes");
            e.printStackTrace();
        }

        return order_list;
    }

    @Override
    public ArrayList<Order> getAllOrderBetweenDate(String from, String to) {
        ArrayList<Order> order_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM order_table WHERE created_date BETWEEN " + from + " AND " + to;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int customer_id = rs.getInt("customer_id");
                int number = rs.getInt("number");
                int active = rs.getInt("active");
                int discount_id = rs.getInt("discount_id");
                int discount = rs.getInt("discount");
                int total_bill = rs.getInt("total_bill");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                order_list.add(new Order(order_id, customer_id, number, active,
                        created_by, created_date, modified_by, modification_date,
                        discount_id, discount, total_bill));

            }
        } catch (Exception e) {
            System.out.println("Error in getting order between date");
            System.out.println(e.getMessage());
        }

        return order_list;
    }
@Override
    public int modifyOrderStatus(Order order) {
        int i = 0;
        String query = "UPDATE order_table SET order_status = ? WHERE order_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, order.getOrder_status());
            ps.setInt(2, order.getOrder_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Usertype");
            e.printStackTrace();
        }
        return i;
    }

    
    @Override
    public Order getorderById(int order_id) {
        Order order = null;
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM order_table WHERE active=1 and order_id=" + order_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int ord_id = rs.getInt("order_id");
                int customer_id = rs.getInt("customer_id");
                int number = rs.getInt("number");
                int active = rs.getInt("active");
                int discount_id = rs.getInt("discount_id");
                int discount = rs.getInt("discount");
                int total_bill = rs.getInt("total_bill");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String order_status = rs.getString("order_status");
                String modification_date = rs.getString("modification_date");
                String customer_name=rs.getString("customer_name");


                order = new Order(order_id, customer_id, number, active,
                        created_by, created_date, modified_by, modification_date,
                        discount_id, discount, total_bill, order_status,customer_name);

            }
        } catch (Exception e) {
            System.out.println("Error in getting usertypes");
            e.printStackTrace();
        }

        return order;
    }

@Override
    public ArrayList<Discount> getDiscountTypes() {
        ArrayList<Discount> discount_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM discount";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int discount_id = rs.getInt("discount_id");
                String discount_type = rs.getString("discount_type");

                discount_list.add(new Discount(discount_id, discount_type));

            }
        } catch (Exception e) {
            System.out.println("Error in getting Discount types");
            e.printStackTrace();
        }

        return discount_list;
    }
  @Override
    public Discount getDiscountTypeById(int discount_id) {
        Discount discount = null;
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM discount where discount_id=" + discount_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int discoun_id = rs.getInt("discount_id");
                String discount_type = rs.getString("discount_type");

                discount = new Discount(discount_id, discount_type);

            }
        } catch (Exception e) {
            System.out.println("Error in getting Discount types");
            e.printStackTrace();
        }

        return discount;
    }
}
