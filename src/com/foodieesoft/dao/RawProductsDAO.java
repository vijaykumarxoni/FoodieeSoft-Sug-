/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.RawMaterial;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface RawProductsDAO {
        public int saveRawProducts(RawMaterial rawMaterial);
    public ArrayList<RawMaterial> getAllRawProducts();
    public int modifyRawProduct(RawMaterial rawMaterial);
    public int removeRawProducts(RawMaterial rawMaterial);
    public int mofidyRawProductsQuantity(RawMaterial rawMaterial);
    public RawMaterial  getRawProduct(int raw_material_id);
    
}
