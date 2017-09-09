package com.linda.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linda.dao.EmployeeDao;
import com.linda.dao.impl.EmployeeDaoImplByDBUtils;
import com.linda.domain.Employee;

/**
 * Servlet implementation class EmployeeServlet2
 */
@WebServlet("/EmployeeServlet2")
public class EmployeeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao dao=new EmployeeDaoImplByDBUtils();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = new Employee();
		String username = request.getParameter("username");
		emp.setUsername(username);
		String password = request.getParameter("password");
		emp.setPassword(password);
		String realname = request.getParameter("realname");
		emp.setRealname(realname);
		String intro = request.getParameter("intro");
		emp.setIntro(intro);
		String bornDate = request.getParameter("bornDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(bornDate!=null)
			try {
				emp.setBornDate(format.parse( bornDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String edu = request.getParameter("edu");
		emp.setEdu(edu);
		String specialty = request.getParameter("specialty");
		emp.setSpecialty(specialty);
		String entryDate = request.getParameter("entryDate");
		if(entryDate != null)
			try {
				emp.setEntryDate(format.parse(entryDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String gender = request.getParameter("gender");
		emp.setGender(gender);	
		dao.addEmployee(emp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
