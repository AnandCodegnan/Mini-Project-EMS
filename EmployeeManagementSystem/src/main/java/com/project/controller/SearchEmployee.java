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
@WebServlet("/findbyid")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			EmployeeDAO dao = new EmployeeDAO();
			Employee empolyee =  dao.findById(id);
			if(empolyee.getId() == 0) {
				request.setAttribute("status", "Employee not found");
				RequestDispatcher dispatcher = request.getRequestDispatcher("searchemp.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("employee", empolyee);
				RequestDispatcher dispatcher = request.getRequestDispatcher("searchempresult.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
