/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.dao;

import com.foodieesoft.beans.Employee;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface EmployeeDAO {
        public int saveEmployee(Employee employee);
    public ArrayList<Employee> getAllEmployee(String txt);
    public int modifyEmployee(Employee employee);
    public int removeEmployee(Employee employee);
    public Employee getEmployeeDetailById(int emp_id);
}
