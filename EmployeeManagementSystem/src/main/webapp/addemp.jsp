<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="links.jsp"%>
<hr>
<center>
	<form action = 'save' method = 'post'>
		<table border = '1'>
			
			<% if(request.getAttribute("status") != null){%>	
			<tr>
				<td colspan = '2' align = 'center'><h3><%=request.getAttribute("status")%></h3></td>
			</tr>
			<%}%>
						
			<tr>
				<td>Name</td>
				<td><input type = 'text' name = 'name'></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type = 'text' name = 'age'></td>
			</tr>
			<tr>
				<td>Select Gender</td>
				<td>
					<input type = 'radio' name = 'gender' value = 'male'> Male
					<input type = 'radio' name = 'gender' value = 'female'> Female
					<input type = 'radio' name = 'gender' value = 'other'> Other
				</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>
					<select name = 'dept'>
						<option value = ''>----Select----</option>
						<option value = 'HR'>HR</option>
						<option value = 'Sales'>Sales</option>
						<option value = 'Marketing'>Marketing</option>
						<option value = 'Finance'>Finance</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type = 'text' name = 'salary'></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type = 'text' name = 'mobile'></td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<textarea name = 'addr' rows = '10' cols='20'></textarea>
				</td>
			</tr>
			<tr>	
				<td colspan = '2' align="center">
					<input type = 'submit' value = 'Add Employee'>
				</td>
			</tr>
		</table>
	</form>
</center>