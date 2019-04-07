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
public class Discount {
private int discount_id;
private String discount_type;

    public Discount() {
    }

    public Discount(int discount_id, String discount_type) {
        this.discount_id = discount_id;
        this.discount_type = discount_type;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

}
