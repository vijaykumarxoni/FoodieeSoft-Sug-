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
public class Order {

    private int order_id;
    private int customer_id;
    private int number;
    private int active;
    private int created_by;
    private String created_date;
    private int modified_by;
    private String modification_date;
    private int discount_id;
    private int discount;
    private int total_bill;
    private String order_status;
    
      private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    
     public Order() {
    }

    public Order(int order_id, int customer_id, int number, int active, int created_by, String created_date, int modified_by, String modification_date, int discount_id, int discount, int total_bill) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.number = number;
        this.active = active;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modified_by = modified_by;
        this.modification_date = modification_date;
        this.discount_id = discount_id;
        this.discount = discount;
        this.total_bill = total_bill;
    }

    public Order(int order_id, int customer_id, int number, int active, int created_by, String created_date, int modified_by, String modification_date, int discount_id, int discount, int total_bill, String order_status) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.number = number;
        this.active = active;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modified_by = modified_by;
        this.modification_date = modification_date;
        this.discount_id = discount_id;
        this.discount = discount;
        this.total_bill = total_bill;
        this.order_status = order_status;
    }

    public Order(int order_id, int customer_id, int number, int active, int created_by, String created_date, int modified_by, String modification_date, int discount_id, int discount, int total_bill, String order_status, String customerName) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.number = number;
        this.active = active;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modified_by = modified_by;
        this.modification_date = modification_date;
        this.discount_id = discount_id;
        this.discount = discount;
        this.total_bill = total_bill;
        this.order_status = order_status;
        this.customerName = customerName;
    }
    
    

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(int total_bill) {
        this.total_bill = total_bill;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    
}
