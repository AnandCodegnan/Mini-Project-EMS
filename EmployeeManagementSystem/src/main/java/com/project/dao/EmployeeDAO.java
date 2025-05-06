package com.project.dao;
import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.project.model.Employee;
public class EmployeeDAO {
	Connection connection = null;
	public EmployeeDAO() throws ClassNotFoundException, SQLException {
		connection = ConnectionManager.getConnection();
	}
	public boolean save(Employee employee) throws SQLException {
		String query = "insert into employee(name, age, gender, dept, salary, mobile, addr) values(?,?,?,?,?,?,?) ";
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, employee.getName());
		statement.setInt(2, employee.getAge());
		statement.setString(3, employee.getGender());
		statement.setString(4, employee.getDept());
		statement.setDouble(5, employee.getSalary());
		statement.setString(6, employee.getMobile());
		statement.setString(7, employee.getAddress());
		
		int count = statement.executeUpdate();
		
		if(count == 1)
			return true;
	
		return false;
	}
	public void commit() throws SQLException {
		connection.commit();
		connection.close();
	}
	public void rollback() throws SQLException {
		connection.rollback();
		connection.close();
	}
	public Employee findById(int id) throws ClassNotFoundException, SQLException {
		connection = ConnectionManager.getConnection();
		connection.setAutoCommit(true);
		String query = "select * from employee where id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		
		ResultSet set =	statement.executeQuery();
		Employee employee = new Employee();
		if(set.next()) {
			employee.setId(set.getInt(1));
			employee.setName(set.getString(2));
			employee.setAge(set.getInt(3));
			employee.setGender(set.getString(4));
			employee.setDept(set.getString(5));
			employee.setSalary(set.getDouble(6));
			employee.setMobile(set.getString(7));
			employee.setAddress(set.getString(8));
		}
		if(connection != null)
			connection.close();
		return employee;
	}
	public List<Employee> findAll() throws ClassNotFoundException, SQLException {
		List<Employee> empList = new ArrayList<Employee>();
		connection = ConnectionManager.getConnection();
		connection.setAutoCommit(true);
		String query = "select * from employee";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet set =  statement.executeQuery();
		while(set.next()) {
			Employee employee = new Employee();
			employee.setId(set.getInt(1));
			employee.setName(set.getString(2));
			employee.setAge(set.getInt(3));
			employee.setGender(set.getString(4));
			employee.setDept(set.getString(5));
			employee.setSalary(set.getDouble(6));
			employee.setMobile(set.getString(7));
			employee.setAddress(set.getString(8));
			
			empList.add(employee);
		}
		if(connection != null)
			connection.close();
		return empList;
	}
	public boolean deleteById(int id) throws SQLException {
		String query = "delete from employee where id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		int count = statement.executeUpdate();
		if(count == 0)
			return false;		
		return true;
	}
	public boolean update(Employee employee) throws SQLException {
		String query = "update employee set name = ?, age = ?, gender = ?, dept = ?, salary = ?, mobile = ?, addr =? where id = ?";
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, employee.getName());
		statement.setInt(2, employee.getAge());
		statement.setString(3, employee.getGender());
		statement.setString(4, employee.getDept());
		statement.setDouble(5, employee.getSalary());
		statement.setString(6, employee.getMobile());
		statement.setString(7, employee.getAddress());
		statement.setInt(8, employee.getId());
		
		int count = statement.executeUpdate();
		
		if(count == 1)
			return true;
		
		return false;
	}
}
