/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.Product;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface ProductDAO {
        public int saveProducts(Product product);
    public ArrayList<Product> getAllProducts(String txt);
    public int modifyProducts(Product product);
    public int removeProducts(Product product);
    public int mofidyProductsQuantity(Product product);
    public int getProductId(String food_name,int price);
    public Product getProduct(int proudct_id);

    
}
