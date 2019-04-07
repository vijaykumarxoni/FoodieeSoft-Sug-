/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface FoodCategoryDAO {
    public int saveFoodCategory(com.foodieesoft.beans.FoodCategory foodCategory);
    public ArrayList<com.foodieesoft.beans.FoodCategory> getAllFoodTypes();
    public int modifyFoodCategory(com.foodieesoft.beans.FoodCategory foodCategory);
    public int removeFoodCategory(com.foodieesoft.beans.FoodCategory foodCategory);
    public String getFoodType(int food_cat_id);

}
