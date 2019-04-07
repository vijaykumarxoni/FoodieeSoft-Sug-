/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.Discount;
import com.foodieesoft.beans.Order;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface OrderDAO {

    public int saveOrder(Order order);

    public int getLastOrderId();

    public ArrayList<Order> getAllOrder();

    public ArrayList<Order> getAllOrderOfMonth();

    public ArrayList<Order> getAllTodayOrder();

    public int modifyOrderStatus(Order order);

    public Order getorderById(int order_id);

    public int removeOrder(int order_id);

    public ArrayList<Order> getAllOrderBetweenDate(String from, String to);

    public ArrayList<Discount> getDiscountTypes();

    public Discount getDiscountTypeById(int discount_id);
}
