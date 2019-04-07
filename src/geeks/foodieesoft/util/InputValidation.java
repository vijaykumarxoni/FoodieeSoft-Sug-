/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.foodieesoft.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vksoni
 */
public class InputValidation {

    public static boolean validateName(String name) {
        String regx_for_name = "^[a-zA-Z\\s]+$";
        Pattern p_name = Pattern.compile(regx_for_name);
        Matcher matcher_name = p_name.matcher(name.toString().trim());
        return matcher_name.find();
    }
    
    public static boolean validatePhoneNum(String num) {
        String regx_phone_num = "^[0-9]+$";
        Pattern p = Pattern.compile(regx_phone_num);
        Matcher matcher = p.matcher(num.toString().trim());
        return matcher.find();
    }
public static boolean validateAmount(String amount) {
        String regex = "^$?\\-?([1-9]{1}[0-9]{0,2}(\\,\\d{3})*(\\.\\d{0,2})?|[1-9]{1}\\d{0,}(\\.\\d{0,2})?|0(\\.\\d{0,2})?|(\\.\\d{1,2}))$|^\\-?$?([1-9]{1}\\d{0,2}(\\,\\d{3})*(\\.\\d{0,2})?|[1-9]{1}\\d{0,}(\\.\\d{0,2})?|0(\\.\\d{0,2})?|(\\.\\d{1,2}))$|^\\($?([1-9]{1}\\d{0,2}(\\,\\d{3})*(\\.\\d{0,2})?|[1-9]{1}\\d{0,}(\\.\\d{0,2})?|0(\\.\\d{0,2})?|(\\.\\d{1,2}))\\)$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(amount.toString().trim());
        return matcher.find();
    }
}
