<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Patient</title>
</head>
<body>


	<form action="addPatient" method="post">

		Name: <input type="text" name="name" required><br>
		<br> Age: <input type="number" name="age" required><br>
		<br> Emergency Type: <input type="text" name="emergencyType" required><br>
		<br> Phone: <input type="text" name="phone" required><br>
		<br>

		<button type="submit">Save Patient</button>

	</form>
	
	<br>
<a href="listPatient">View All Patients</a>
</body>
</html>