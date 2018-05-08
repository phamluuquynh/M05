<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="model.Car"%>
	<%@page import="java.util.ArrayList"%>

<%
	ArrayList<Car> listCars = (ArrayList<Car>)request.getAttribute("listAllCar");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>See all cars</title>
</head>
<body>
	<h1>List of all cars</h1>

	<table>
		<tr>
			<th>Car Name</th>
			<th>Plate Number</th>
			<th>Year of manufacture</th>
			<th>Brand</th>
			<th>Having insurance</th>
			<th>Other feature</th>
		</tr>
			<%for(int i=0;i<listCars.size();i++){ %>
			<tr>
				<td><%=listCars.get(i).getCarName() %></td>
				<td><%=listCars.get(i).getNumberPlate() %></td>
				<td><%=listCars.get(i).getYearOfManufacture() %></td>
				<td><%=listCars.get(i).getBrand() %></td>
				<td><%=listCars.get(i).isInsurance() %></td>
				
			</tr>
		<%} %>
	
	</table>
</body>
</html>