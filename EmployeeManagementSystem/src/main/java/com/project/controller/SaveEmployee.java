package com.project.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.EmployeeDAO;
import com.project.model.Employee;
@WebServlet("/save")
public class SaveEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String dept = request.getParameter("dept");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String mobile = request.getParameter("mobile");
		String addr = request.getParameter("addr");
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAge(age);
		employee.setGender(gender);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setMobile(mobile);
		employee.setAddress(addr);
		
		EmployeeDAO dao;
		try {
			dao = new EmployeeDAO();
			boolean status =  dao.save(employee);
			if(status) {
				dao.commit();
				request.setAttribute("status", "Employee Added Successfully...");
			}
			else {
				dao.rollback();
				request.setAttribute("status", "Error in adding employee....");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("addemp.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}