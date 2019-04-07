/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vksoni
 */
public class DBConnection {

    private static String url = "jdbc:mysql://localhost:3306/foodiee_soft";
    private static String user = "root";
    private static String password = "";
    private static Connection con;

    private DBConnection(){}
    public static Connection load() {
        if(con==null){
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            System.out.println("DataBase Succesfully Loaded");

        } catch (Exception e) {

            System.out.println("Error in Load");
            e.printStackTrace();
        }

    }
    
    return con;
  
}
}
