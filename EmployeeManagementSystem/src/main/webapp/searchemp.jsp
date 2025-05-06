<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="links.jsp"%>
<hr>
<center>
	<form action = 'findbyid' method = 'post'>
		<table border = '1'>
			<% if(request.getAttribute("status") != null){%>	
			<tr>
				<td colspan = '2' align = 'center'><h3><%=request.getAttribute("status")%></h3></td>
			</tr>
			<%}%>
			<tr>
				<td>Id</td>
				<td><input type = 'text' name = 'id'></td>
			</tr>
			<tr>	
				<td colspan = '2' align="center">
					<input type = 'submit' value = 'Search Employee'>
				</td>
			</tr>
		</table>
	</form>
</center>