/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.TableReservation;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface ReserveTableDAO {
     public int reserveTable(TableReservation tableReservation);
    public ArrayList<TableReservation> getAllReservedTables();
    public int modifyReservedTables(TableReservation tableReservation);
    public int removeReservedTable(TableReservation tableReservation);
    public TableReservation getReservedTableDetailsById(int table_reservation_id);   
}
