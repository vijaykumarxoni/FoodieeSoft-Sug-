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
public class TableReservation {
    private int table_reserv_id;
    private int customer_id;
    private String party_type;
    private String reservationDate;
    private String check_in_time;
    private int party_size;

    public TableReservation() {
    }

    public TableReservation(int table_reserv_id, int customer_id, String party_type, String date, String check_in_time, int party_size) {
        this.table_reserv_id = table_reserv_id;
        this.customer_id = customer_id;
        this.party_type = party_type;
        this.reservationDate = date;
        this.check_in_time = check_in_time;
        this.party_size = party_size;
    }

    
    
    
    public int getTable_reserv_id() {
        return table_reserv_id;
    }

    public void setTable_reserv_id(int table_reserv_id) {
        this.table_reserv_id = table_reserv_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getParty_type() {
        return party_type;
    }

    public void setParty_type(String party_type) {
        this.party_type = party_type;
    }

    
    public String getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(String check_in_time) {
        this.check_in_time = check_in_time;
    }

    public int getParty_size() {
        return party_size;
    }

    public void setParty_size(int party_size) {
        this.party_size = party_size;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    
    
}
