/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.OrderDetail;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface OrderDetailsDAO {
        public int saveOrderDetail(OrderDetail order_detail);
    public ArrayList<OrderDetail> getAllOrderDetail();
    public ArrayList<OrderDetail> getAllOrderDetailById(int order_id);    
    public int modifyOrderDetail(OrderDetail order_detail);
    public int removeOrderDetail(OrderDetail order_detail);
}
