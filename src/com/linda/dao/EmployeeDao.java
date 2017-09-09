package com.linda.dao;

import java.io.Serializable;
import java.util.List;

import com.linda.domain.Employee;

public interface EmployeeDao {
//    添加employee
	void addEmployee(Employee employee);
//	删除指定id的employee
	void removeEmployee(Serializable id);
//	根据id修改employee
	void modifyEmpolyee(Employee employee);
//根据id获取指定的Employee对象
	Employee getEmployee(Serializable id);
//	查询全部employee对象
	List<Employee> loadEmployees();
}
