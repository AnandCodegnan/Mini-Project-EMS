<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="links.jsp"%>
<hr>
<center>
		<table border = '1'>
			<tr bgcolor="#66CDAA">
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Salary</th>
				<th>Mobile</th>
				<th>Address</th>
			</tr>
			<tr bgcolor="#14A3C7">	
				<td>${employee.getId()}</td>
				<td>${employee.getName()}</td>
				<td>${employee.getAge()}</td>
				<td>${employee.getGender()}</td>
				<td>${employee.getDept()}</td>
				<td>${employee.getSalary()}</td>
				<td>${employee.getMobile()}</td>
				<td>${employee.getAddress()}</td>
			</tr>
		</table>
</center>