<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Insurance</h1>
	<form action="AddInsuranceServlet" method="get">
		<table>
			<tr>
				<td>Insurance Name:<td />
				<td><input type="text" name="insuranceName"><td />
			<tr />
			
			<tr>
				<td>Insurance Type:<td />
				<td><input type="text" name="insuranceType"><td />
			<tr />
			
			<tr>
				
				<td><input type="submit" value="submit"><td />
			<tr />
			
			

		</table>
	</form>

</body>
</html>