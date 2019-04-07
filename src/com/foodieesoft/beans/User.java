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
public class User {
    private int user_id;
    private int user_cat_id;
    private int  question_id;
    private int active;
    private int created_by;
    private int modified_by;
    private String user_name;
    private String password;
    private String name;
    private String address;
    private String modification_date;
    private String contact_num;
    private String answer;
    private String created_date;

    public User() {
    }

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    } public User(int user_id,String user_name, String password,int user_cat_id) {
        this.user_id=user_id;
        this.user_cat_id=user_cat_id;
        this.user_name = user_name;
        this.password = password;
    }

    public User(int user_id, int user_cat_id, int question_id, int active, int created_by, int modified_by, String user_name, String password, String name, String address, String modification_date, String contact_num, String answer, String created_date) {
        this.user_id = user_id;
        this.user_cat_id = user_cat_id;
        this.question_id = question_id;
        this.active = active;
        this.created_by = created_by;
        this.modified_by = modified_by;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.address = address;
        this.modification_date = modification_date;
        this.contact_num = contact_num;
        this.answer = answer;
        this.created_date = created_date;
    }


    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_cat_id() {
        return user_cat_id;
    }

    public void setUser_cat_id(int user_car_id) {
        this.user_cat_id = user_car_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
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

    public int getModified_by() {
        return modified_by;
    }

    public void setModified_by(int modified_by) {
        this.modified_by = modified_by;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModification_date() {
        return modification_date;
    }

    public void setModification_date(String modification_date) {
        this.modification_date = modification_date;
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(String contact_num) {
        this.contact_num = contact_num;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }     

          
}
