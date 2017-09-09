package com.linda.dao;

import java.io.Serializable;
import java.util.List;

import com.linda.domain.Employee;

public interface EmployeeDao {
//    ���employee
	void addEmployee(Employee employee);
//	ɾ��ָ��id��employee
	void removeEmployee(Serializable id);
//	����id�޸�employee
	void modifyEmpolyee(Employee employee);
//����id��ȡָ����Employee����
	Employee getEmployee(Serializable id);
//	��ѯȫ��employee����
	List<Employee> loadEmployees();
}
