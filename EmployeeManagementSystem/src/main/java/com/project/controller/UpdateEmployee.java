package com.project.controller;
import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.EmployeeDAO;
import com.project.model.Employee;
@WebServlet("/update")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String dept = request.getParameter("dept");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String mobile = request.getParameter("mobile");
		String addr = request.getParameter("addr");
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setAge(age);
		employee.setGender(gender);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setMobile(mobile);
		employee.setAddress(addr);
		
		try {
			EmployeeDAO dao = new EmployeeDAO();
			boolean status = dao.update(employee);
			
			if(status) {
				dao.commit();
				RequestDispatcher dispatcher = request.getRequestDispatcher("findall");
				dispatcher.forward(request, response);
			}
			else {
				dao.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
