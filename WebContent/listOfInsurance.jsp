<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Insurance"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
	List<Insurance> listAllInsurance = (ArrayList<Insurance>) request.getAttribute("listAllInsurance");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show all insurance</title>
</head>
<body>
	<h1>List of all Insurance</h1>
	<table border="1">
		<tr>
			<th>Insurance Name</th>
			<th>Insurance Type</th>
			<th>Is Bought</th>
		</tr>

		<tr>
			<%
				for (int i = 0; i < listAllInsurance.size(); i++) {
			%>
		
		<tr>
			<td><%=listAllInsurance.get(i).getNameInsurance()%></td>
			<td><%=listAllInsurance.get(i).getTypeInsurance()%></td>
			<td><%=listAllInsurance.get(i).isBought()%></td>
		<tr />
		<%
			}
		%>
		</tr>
		


	</table>

</body>
</html>