/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodieesoft.daoImpl;

import com.foodieesoft.beans.Employee;
import com.foodieesoft.dbcon.DBConnection;
import com.foodieesoft.dao.EmployeeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public int saveEmployee(Employee employee) {
        int i = 0;
        String query = "INSERT INTO employee (`emp_name`, `contact_num`, `salary`, `created_by`, `creation_date`,`designation`) VALUES (?,?,?,?,?,?)";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, employee.getEmployee_name());
            ps.setString(2, employee.getContact_num());
            ps.setDouble(3, employee.getSalary());
            ps.setInt(4, employee.getCreated_by());
            ps.setString(5, employee.getCreation_date());
            ps.setString(6, employee.getDesignation());

            i = ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error in saving employee record");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Employee> getAllEmployee(String txt) {
        ArrayList<Employee> employee_list = new ArrayList<>();
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM employee WHERE emp_name LIKE '%"+txt+"%' AND  active=1 ORDER BY employee_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int employee_id = rs.getInt("employee_id");
                String employee_name = rs.getString("emp_name");
                String contact_num = rs.getString("contact_num");
                double salary = rs.getDouble("salary");
                String designation = rs.getString("designation");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String creation_date = rs.getString("creation_date");
                int modified_by = rs.getInt("modified_by");

                employee_list.add(new Employee(employee_id, employee_name, contact_num, salary, designation, created_by, modified_by, creation_date, active));

            }
        } catch (Exception e) {
            System.out.println("Error in getting employee records");
            e.printStackTrace();
        }

        return employee_list;
    }

    @Override
    public int modifyEmployee(Employee employee) {
        int i = 0;
        String query = "UPDATE `foodiee_soft`.`employee` SET `emp_name` = ? , `contact_num` = ? , `salary` = ? , `modified_by` = ? , `designation` = ?,creation_date=? WHERE `employee_id` = ? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, employee.getEmployee_name());
            ps.setString(2, employee.getContact_num());
            ps.setDouble(3, employee.getSalary());
            ps.setInt(4, employee.getModified_by());
            ps.setString(5, employee.getDesignation());
            ps.setString(6, employee.getCreation_date());

            ps.setInt(7, employee.getEmployee_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of employee");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeEmployee(Employee employee) {
        int i = 0;
        String query = "UPDATE employee SET active=0 WHERE `employee_id` =? ";
        try {
            Connection con = DBConnection.load();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, employee.getEmployee_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of employee");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Employee getEmployeeDetailById(int emp_id) {
        Employee employee = null;
        try {
            Connection con = DBConnection.load();
            String query = "SELECT * FROM employee WHERE active=1 and employee_id=" + emp_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int employee_id = rs.getInt("employee_id");
                String employee_name = rs.getString("emp_name");
                String contact_num = rs.getString("contact_num");
                double salary = rs.getDouble("salary");
                String designation = rs.getString("designation");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String creation_date = rs.getString("creation_date");
                int modified_by = rs.getInt("modified_by");

                employee = new Employee(employee_id, employee_name, contact_num, salary, designation, created_by, modified_by, creation_date, active);

            }
        } catch (Exception e) {
            System.out.println("Error in getting employee records by id");
            e.printStackTrace();
        }

        return employee;
    }

}
