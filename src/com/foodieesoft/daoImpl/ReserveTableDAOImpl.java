/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.TableReservation;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.ReserveTableDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class ReserveTableDAOImpl implements ReserveTableDAO {

    @Override
    public int reserveTable(TableReservation tableReservation) {

        int i = 0;
        String query = "INSERT INTO table_reservation(customer_id, party_type, reservation_date,check_in_time,party_size) VALUES (?,?,?,?,?) ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, tableReservation.getCustomer_id());
            ps.setString(2, tableReservation.getParty_type());
            ps.setString(3, tableReservation.getReservationDate());
            ps.setString(4, tableReservation.getCheck_in_time());
            ps.setInt(5, tableReservation.getParty_size());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in reservation of table");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<TableReservation> getAllReservedTables() {
        ArrayList<TableReservation> table_reservation_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM   table_reservation WHERE active=1 ORDER BY table_reserv_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int table_reserv_id = rs.getInt("table_reserv_id");
                int customer_id = rs.getInt("customer_id");
                String party_type = rs.getString("party_type");
                String reservation_date = rs.getString("reservation_date");
                String check_in_time = rs.getString("check_in_time");
                int party_size = rs.getInt("party_size");

                table_reservation_list.add(new TableReservation(table_reserv_id, customer_id, party_type, reservation_date, check_in_time, party_size));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return table_reservation_list;
    }

    @Override
    public int modifyReservedTables(TableReservation tableReservation) {
        int i = 0;
        String query = "UPDATE table_reservation SET customer_id=?,party_type=?,date=?,check_in_time = ? , party_size = ? WHERE table_reserv_id = ?";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, tableReservation.getCustomer_id());
            ps.setString(2, tableReservation.getParty_type());
            ps.setString(3, tableReservation.getReservationDate());
            ps.setString(4, tableReservation.getCheck_in_time());
            ps.setInt(5, tableReservation.getParty_size());
            ps.setInt(6, tableReservation.getTable_reserv_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification table reservation");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeReservedTable(TableReservation tableReservation) {
        int i = 0;
        String query = "UPDATE table_reservation SET active=0 WHERE `table_reserv_id` =? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, tableReservation.getTable_reserv_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of reserved table");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public TableReservation getReservedTableDetailsById(int table_reservation_id) {
        TableReservation tableReservation = null;
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM   table_reservation WHERE active=1 table_reservation_id=?  and ORDER BY table_reserv_id DESC";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, table_reservation_id);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int table_reserv_id = rs.getInt("table_reserv_id");
                int customer_id = rs.getInt("customer_id");
                String party_type = rs.getString("party_type");
                String reservation_date = rs.getString("reservation_date");
                String check_in_time = rs.getString("check_in_time");
                int party_size = rs.getInt("party_size");

                tableReservation = new TableReservation(table_reserv_id, customer_id, party_type, reservation_date, check_in_time, party_size);

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return tableReservation;
    }

}
