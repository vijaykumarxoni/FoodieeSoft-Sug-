/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.beans;

/**
 *
 * @author Vksoni
 */
public class OrderDetail {
    private int order_details_id;
    private int order_id;
    private int product_id;
    private int qantity;
    private int active;
    private int created_by;
    private String created_date;
    private int modified_by;
    private double total_price;
    private String modification_date;
    private int customer_id;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public OrderDetail() {
    }

    public int getOrder_details_id() {
        return order_details_id;
    }

    public OrderDetail(int order_details_id, int order_id, int product_id, int qantity, int active, int created_by, String created_date, int modified_by, double total_price, String modification_date) {
        
        
        this.order_details_id = order_details_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.qantity = qantity;
        this.active = active;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modified_by = modified_by;
        this.total_price = total_price;
        this.modification_date = modification_date;
    }

    public OrderDetail(int order_details_id, int order_id, int product_id, int qantity, int active, int created_by, String created_date, int modified_by, double total_price, String modification_date,int customer_id) {
        
        
        this.order_details_id = order_details_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.qantity = qantity;
        this.active = active;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modified_by = modified_by;
        this.total_price = total_price;
        this.modification_date = modification_date;
        this.customer_id=customer_id;
    }

     
    
    

    public void setOrder_details_id(int order_details_id) {
        this.order_details_id = order_details_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public int getModified_by() {
        return modified_by;
    }

    public void setModified_by(int modified_by) {
        this.modified_by = modified_by;
    }

    public String getModification_date() {
        return modification_date;
    }

    public void setModification_date(String modification_date) {
        this.modification_date = modification_date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

   
    
    
    
}
