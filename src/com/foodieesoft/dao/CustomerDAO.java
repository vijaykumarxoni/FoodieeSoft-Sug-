/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.Customer;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface CustomerDAO {
     public int saveCustomer(Customer customer);
    public ArrayList<Customer> getAllCustomers();
    public ArrayList<Customer> searchCustomers(String txt);
    public int modifyCustomers(Customer customer);
    public int removeCustomer(Customer customer);
    public Customer getCustomerDetail(int cust_id);

}
