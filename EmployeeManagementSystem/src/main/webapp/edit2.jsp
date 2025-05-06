<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="links.jsp"%>
<hr>
<center>
	<form action = 'update'>
		<table border = '1'>
			
			<tr>
				<td>Id</td>
				<td><input type = 'text' readonly="readonly" name = 'id' value = <%= request.getParameter("id")%>></td>
			</tr>
			
						
			<tr>
				<td>Name</td>
				<td><input type = 'text' name = 'name' value = <%= request.getParameter("name")%>></td>
			</tr>
			
			<tr>
				<td>Age</td>
				<td><input type = 'text' name = 'age' value = <%= request.getParameter("age")%>></td>
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
				<td><input type = 'text' name = 'salary' value = <%= request.getParameter("salary")%>></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type = 'text' name = 'mobile' value = <%= request.getParameter("mobile")%>></td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<textarea name = 'addr' rows = '10' cols='20'> <%= request.getParameter("addr")%> </textarea>
				</td>
			</tr>
			<tr>	
				<td colspan = '2' align="center">
					<input type = 'submit' value = 'Edit Employee'>
				</td>
			</tr>
		</table>
	</form>
</center>