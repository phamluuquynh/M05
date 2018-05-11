<%@page import="model.Car"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Car"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
	List<Car> listAvailableCars = (ArrayList<Car>) request.getAttribute("listAvailableCars");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List Of Available Cars</h1>

	<table border="1">

		<tr>
			<th>Car Name</th>
			<th>Plate Number</th>
			<th>Year of manufacture</th>
			<th>Brand</th>
			<th>Having insurance</th>
			<th>Other feature</th>
		</tr>
		<%
			for (int i = 0; i < listAvailableCars.size(); i++) {
		%>

		<tr>
			<td><%=listAvailableCars.get(i).getCarName()%></td>
			<td><%=listAvailableCars.get(i).getNumberPlate()%></td>
			
			<td><input type="text" name="year" value="<%=listAvailableCars.get(i).getYearOfManufacture()%>" ></td>
			<td><%=listAvailableCars.get(i).getBrand()%></td>
			<td><%=listAvailableCars.get(i).isInsurance()%></td>
			<td><%=listAvailableCars.get(i).getOtherFeature()%></td>
			<td><form action="chooseInsurance?index=<%=listAvailableCars.get(i).getYearOfManufacture() %>" method="post"><button>Mua bảo hiểm</button></form></td>
			
		</tr>

		<%
			}
		%>

	</table>
</body>
</html>