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
public class Questions {
    
    private int question_id;
    private int active;
    private int created_by;
    private int modified_by;
    private String created_date;
    private String modification_date;
    private String question;
public Questions() {
    }
    public Questions(int question_id, String question,int modified_by, String modification_date) {
    
        this.question_id = question_id;
        this.modified_by = modified_by;
        this.modification_date = modification_date;
        this.question = question;
    }

    

    public Questions(int question_id, int active,
            int created_by, int modified_by, String created_date, String modification_date, String question) {
        this.question_id = question_id;
        this.active = active;
        this.created_by = created_by;
        this.modified_by = modified_by;
        this.created_date = created_date;
        this.modification_date = modification_date;
        this.question = question;
    }

    public String getQuestions() {
        return question;
    }

    public Questions(int created_by, String created_date, String question) {
        this.created_by = created_by;
        this.created_date = created_date;
        this.question = question;
    }

    public void setQuestions(String question) {
        this.question = question;
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

    @Override
    public String toString() {
        return "Questions{" + "question_id=" + question_id + ", active=" + active + ", created_by=" + created_by + ", modified_by=" + modified_by + ", created_date=" + created_date + ", modification_date=" + modification_date + ", question=" + question + '}';
    }

    
}
