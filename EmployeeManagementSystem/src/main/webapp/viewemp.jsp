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
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<c:forEach items="${list}" var="employee">
				<tr bgcolor="#14A3C7">	
					<td>${employee.getId()}</td>
					<td>${employee.getName()}</td>
					<td>${employee.getAge()}</td>
					<td>${employee.getGender()}</td>
					<td>${employee.getDept()}</td>
					<td>${employee.getSalary()}</td>
					<td>${employee.getMobile()}</td>
					<td>${employee.getAddress()}</td>
					<td><a href = 'edit.jsp?id=${employee.getId()}&name=${employee.getName()}&age=${employee.getAge()}&salary=${employee.getSalary()}&mobile=${employee.getMobile()}&addr=${employee.getAddress()}'>Edit</a></td>
					<td><a href = 'delete?id=${employee.getId()}'>Delete</a></td>
				</tr>
			</c:forEach>
			
		</table>
</center>