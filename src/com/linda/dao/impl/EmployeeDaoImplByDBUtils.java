package com.linda.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.linda.dao.EmployeeDao;
import com.linda.domain.Employee;
import com.linda.util.DBHelper;

public class EmployeeDaoImplByDBUtils implements EmployeeDao {
private QueryRunner runner=new QueryRunner(DBHelper.getDataSource());
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
       String sql="insert into employee(username,emp_password,realname,gender,born_date,intro,edu,specialty,entry_date)values(?,?,?,?,?,?,?,?,?)";
       try {
		runner.execute(sql, employee.getUsername(),employee.getPassword(),employee.getRealname(),employee.getGender(),
					employee.getBornDate(),employee.getIntro(),employee.getEdu(),employee.getSpecialty(),employee.getEntryDate());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void removeEmployee(Serializable id) {
		// TODO Auto-generated method stub
        String sql="delete from employee where emp_id=?";
        try {
			runner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modifyEmpolyee(Employee employee) {
		// TODO Auto-generated method stub
        String sql="update employee set username=?,emp_password=?,realname=?,gender=?,born_date=?,intro=?,edu=?,specialty=?,entry_date=? where emp_id=?";
        try {
			runner.update(sql, employee.getUsername(),employee.getPassword(),employee.getRealname(),employee.getGender(),
					employee.getBornDate(),employee.getIntro(),employee.getEdu(),employee.getSpecialty(),employee.getEntryDate(),employee.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployee(Serializable id) {
		// TODO Auto-generated method stub
		String sql = "select emp_id as id,username,emp_password as password,realname,gender,born_date bornDate,intro,edu,specialty,entry_date entryDate from employee where emp_id=?";
		try {
			return runner.query(sql, new BeanHandler<>(Employee.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Employee> loadEmployees() {
		// TODO Auto-generated method stub
		String sql = "select emp_id as id,username,emp_password as password,realname,gender,born_date bornDate,intro,edu,specialty,entry_date entryDate from employee";
		try {
			return runner.query(sql, new BeanListHandler<>(Employee.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
