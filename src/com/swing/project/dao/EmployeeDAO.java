package com.swing.project.dao;

import com.swing.project.common.ICommonDAO;
import com.swing.project.model.Employee;
import com.swing.project.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO implements ICommonDAO<Employee>{

    @Override
    public int save(Employee c) {
        int status = 0;
        String sql = "insert into department(department_name, designation) values (?, ?)";
        Connection con = DatabaseConnection.getDBConnection();
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, c.getDepartment());
            psmt.setString(2, c.getDesignation());
            status = psmt.executeUpdate();
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> emp = new ArrayList<>();
        String sql = "select * from department";
        Connection con = DatabaseConnection.getDBConnection();
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {                
                Employee em = new Employee();
                
                em.setDepartment(rs.getString("department_name"));
//                em.setDeisgnation(rs.getString("designation"));
                emp.add(em);
            }
        } catch (Exception e) {
        }
     
        return emp;
    }

    @Override
    public int delete(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Employee getByID(String id) {
         Employee em = new Employee();
        String sql = "select * from employees where employee_id = ?";
        Connection con = DatabaseConnection.getDBConnection();
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {                
               
                em.setFirstName("first_name");
                em.setLastName("last_name");
                em.setDepartment(rs.getString("department_name"));
                em.setDesignation(rs.getString("designation"));
            }
        } catch (Exception e) {
        }
     
        return em;
    }
}
