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
public class RawMaterial {
    private int raw_materials_id;
    private int active;
    private int price;
    private int quantity;
    private int created_by;
    private int modified_by;
    private String created_date;
    private String modification_date;
    private String raw_product_name;


    public RawMaterial() {
    }

    public RawMaterial(int raw_materials_id, int active, int price, int quantity, int created_by, int modified_by, String created_date, String modification_date, String raw_product_name) {
        this.raw_materials_id = raw_materials_id;
        this.active = active;
        this.price = price;
        this.quantity = quantity;
        this.created_by = created_by;
        this.modified_by = modified_by;
        this.created_date = created_date;
        this.modification_date = modification_date;
        this.raw_product_name = raw_product_name;
    }

    public int getRaw_materials_id() {
        return raw_materials_id;
    }

    public void setRaw_materials_id(int raw_materials_id) {
        this.raw_materials_id = raw_materials_id;
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

    public String getRaw_product_name() {
        return raw_product_name;
    }

    public void setRaw_product_name(String raw_product_name) {
        this.raw_product_name = raw_product_name;
    }
   

}
