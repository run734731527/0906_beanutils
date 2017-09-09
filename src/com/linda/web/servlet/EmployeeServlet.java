package com.linda.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.linda.dao.EmployeeDao;
import com.linda.dao.impl.EmployeeDaoImplByDBUtils;
import com.linda.domain.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(name = "Employee1Servlet", urlPatterns = { "/Employee1Servlet" })
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao dao=new EmployeeDaoImplByDBUtils();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
public void save(HttpServletRequest request,HttpServletResponse response){
	Employee emp=new Employee();
	try {
		BeanUtils.populate(emp, request.getParameterMap());
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dao.addEmployee(emp);
}
}
