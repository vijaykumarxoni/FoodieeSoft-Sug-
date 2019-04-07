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
public class Product {
    private int product_id;
    private int food_cat_id;
    private int active;
    private int price;
    private int quantity;
    private int created_by;
    private int modified_by;
    private String created_date;
    private String modification_date;
    private String food_name;

    public Product(int product_id, int food_cat_id, int active, int price, int quantity, int created_by, int modified_by, String created_date, String modification_date, String food_name) {
        this.product_id = product_id;
        this.food_cat_id = food_cat_id;
        this.active = active;
        this.price = price;
        this.quantity = quantity;
        this.created_by = created_by;
        this.modified_by = modified_by;
        this.created_date = created_date;
        this.modification_date = modification_date;
        this.food_name = food_name;
    }

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getFood_cat_id() {
        return food_cat_id;
    }

    public void setFood_cat_id(int food_cat_id) {
        this.food_cat_id = food_cat_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getModified_by() {
        return modified_by;
    }

    public void setModified_by(int modified_by) {
        this.modified_by = modified_by;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getModification_date() {
        return modification_date;
    }

    public void setModification_date(String modification_date) {
        this.modification_date = modification_date;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }
    

}
