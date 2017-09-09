package com.linda.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.linda.dao.EmployeeDao;
import com.linda.domain.Employee;
import com.linda.util.DBHelper;

public class EmployeeDaoIpmlByJDBC implements EmployeeDao{

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "insert into employee(username,emp_password,realname,gender,born_date,intro,edu,specialty,entry_date) values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBHelper.getConnection();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, employee.getUsername());
			ptst.setString(2, employee.getPassword());
			ptst.setString(3, employee.getRealname());
			ptst.setString(4, employee.getGender());
			
			ptst.setString(5, format.format(employee.getBornDate()));
			ptst.setString(6, employee.getIntro());
			ptst.setString(7, employee.getEdu());
			ptst.setString(8, employee.getSpecialty());
			ptst.setString(9, format.format(employee.getEntryDate()));
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeEmployee(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyEmpolyee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployee(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> loadEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
