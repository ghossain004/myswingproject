package com.swing.project.dao;

import com.swing.project.common.ICommonDAO;
import com.swing.project.model.Employee;
import com.swing.project.model.SalaryScale;
import com.swing.project.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SalaryScaleDAO implements ICommonDAO<SalaryScale>{

    @Override
    public int save(SalaryScale c) {
        int status = 0;
        String sql = "insert into salary_scale(salary_grade, salary_scale) values (?, ?)";
        Connection con = DatabaseConnection.getDBConnection();
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, c.getSalaryGrade());
            psmt.setString(2, c.getSalaryScale());
            status = psmt.executeUpdate();
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public List<SalaryScale> getAll() {
        List<SalaryScale> salary = new ArrayList<>();
        String sql = "select * from salary_scale";
        Connection con = DatabaseConnection.getDBConnection();
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {                
                SalaryScale ss = new SalaryScale();
                
                ss.setSalaryGrade(rs.getString("salary_grade"));
                ss.setSalaryScale(rs.getString("salary_scale"));
                salary.add(ss);
            }
        } catch (Exception e) {
        }
     
        return salary;
    }

    @Override
    public int delete(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
