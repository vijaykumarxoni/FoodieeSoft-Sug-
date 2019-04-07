/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.RawMaterial;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.RawProductsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class RawProductsDAOImpl implements RawProductsDAO {

    @Override
    public int saveRawProducts(RawMaterial rawMaterial) {
        int i = 0;
        String query = "INSERT INTO raw_material (product_name,price,quantity,created_by, created_date) VALUES (?,?,?,?,?)";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, rawMaterial.getRaw_product_name());
            ps.setInt(2, rawMaterial.getPrice());
            ps.setInt(3, rawMaterial.getQuantity());
            ps.setInt(4, rawMaterial.getCreated_by());
            ps.setString(5, rawMaterial.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving Raw Product");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<RawMaterial> getAllRawProducts() {
        ArrayList<RawMaterial> products_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM raw_material WHERE active=1 ORDER BY raw_material_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int raw_material_id = rs.getInt("raw_material_id");
                String product_name = rs.getString("product_name");
                int price = rs.getInt("price");
                int active = rs.getInt("active");
                int quantity = rs.getInt("quantity");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                products_list.add(new RawMaterial(raw_material_id, active, price, quantity, created_by, modified_by,
                        created_date, modification_date, product_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return products_list;
    }

    @Override
    public int modifyRawProduct(RawMaterial rawMaterial) {
        int i = 0;
        String query = "UPDATE raw_material SET product_name=?,price=?,quantity=?,modified_by = ? , modification_date = ? ,created_date=? WHERE raw_material_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, rawMaterial.getRaw_product_name());
            ps.setInt(2, rawMaterial.getPrice());
            ps.setInt(3, rawMaterial.getQuantity());
            ps.setInt(4, rawMaterial.getModified_by());
            ps.setString(5, rawMaterial.getModification_date());
            ps.setString(6, rawMaterial.getCreated_date());
            ps.setInt(7, rawMaterial.getRaw_materials_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of raw product");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeRawProducts(RawMaterial rawMaterial) {
        int i = 0;
        String query = "UPDATE raw_material SET active=0 WHERE `raw_material_id` =? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rawMaterial.getRaw_materials_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of raw products");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int mofidyRawProductsQuantity(RawMaterial rawMaterial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RawMaterial getRawProduct(int raw_material_id) {
        RawMaterial rawMaterial = null;
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM raw_material  WHERE active =1 AND raw_material_id=" + raw_material_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                String product_name = rs.getString("product_name");
                int price = rs.getInt("price");
                int active = rs.getInt("active");
                int quantity = rs.getInt("quantity");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                rawMaterial = new RawMaterial(raw_material_id, active, price, quantity, created_by, modified_by,
                        created_date, modification_date, product_name);

            }
        } catch (Exception e) {
            System.out.println("Error in getting  raw product");
            e.printStackTrace();
        }

        return rawMaterial;
    }

}
