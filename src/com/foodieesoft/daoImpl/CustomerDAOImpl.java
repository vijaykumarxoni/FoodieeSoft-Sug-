/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.Customer;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.CustomerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public int saveCustomer(Customer customer) {
        int i = 0;
        String query = "INSERT INTO customer (customer_name, contact, address, created_by, created_date) VALUES(?, ?, ?, ?, ?) ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getCustomer_name());
            ps.setString(2, customer.getContact());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getCreated_by());
            ps.setString(5, customer.getCreated_date());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                i = rs.getInt(1);
            }

        } catch (Exception e) {

            System.out.println("Error in saving usertypes");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM customer WHERE active=1 AND customer_id>1 ORDER BY customer_id DESC ";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                customers_list.add(new Customer(customer_id, active, contact, address, created_by, modified_by,
                        created_date, modification_date, customer_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return customers_list;
    }

    @Override
    public Customer getCustomerDetail(int cust_id) {
        Customer customer = null;
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM customer WHERE active=1 and customer_id=" + cust_id+" ORDER BY customer_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                customer = new Customer(customer_id, active, contact, address, created_by, modified_by,
                        created_date, modification_date, customer_name);

            }
        } catch (Exception e) {
            System.out.println("Error in getting customer");
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public int modifyCustomers(Customer customer) {
        int i = 0;
        String query = " UPDATE customer SET customer_name = ? , contact = ? , address = ? , modified_by = ? , modification_date = ? WHERE customer_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, customer.getCustomer_name());
            ps.setString(2, customer.getContact());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getModified_by());
            ps.setString(5, customer.getModification_date());
            ps.setInt(6, customer.getCustomer_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Customer");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeCustomer(Customer customer) {
        int i = 0;
        String query = "UPDATE customer SET active=0 WHERE `customer_id` =? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, customer.getCustomer_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of Customer");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Customer> searchCustomers(String txt) {
   ArrayList<Customer> customers_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM customer WHERE customer_name LIKE '%"+txt+"%' AND  active=1 AND customer_id>1 ORDER BY customer_id DESC  ";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                customers_list.add(new Customer(customer_id, active, contact, address, created_by, modified_by,
                        created_date, modification_date, customer_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return customers_list;    }

}
