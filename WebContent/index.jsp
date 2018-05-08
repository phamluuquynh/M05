<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Car</h1>
	<form action="AddCarServlet" method="post">
		<table>
			<tr>
				<td>Car Name:</td>
				<td><input type="text" name="carName"></td>
			</tr>

			<tr>
				<td>Plate Number:</td>
				<td><input type="text" name="numberPlate"></td>
			</tr>

			<tr>
				<td>Year of manufacture:</td>
				<td><input type="text" name="yearOfM"></td>
			</tr>

			<tr>
				<td>Brand:</td>
				<td><input type="text" name="brand"></td>
			</tr>

			<tr>
				<td>Have positioning device:</td>
				<td><input type="text" name="position"></td>
			</tr>

			<tr>
				<td>Have power steering:</td>
				<td><input type="text" name="steering"></td>
			</tr>

			<tr>
				<td>Action Duration (Nam Su dung):</td>
				<td><input type="text" name="duration"></td>
			</tr>
			<tr>
			
				<td><input  type="submit" value="submit"></td>
			</tr>

		</table>
	</form>
</body>
</html>