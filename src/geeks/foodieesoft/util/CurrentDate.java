/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.foodieesoft.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Vksoni
 */
public class CurrentDate {
    public static String getCurrentDate(){
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
   LocalDate now = LocalDate.now();  
    return ""+now.format(dtf);}
    
}
