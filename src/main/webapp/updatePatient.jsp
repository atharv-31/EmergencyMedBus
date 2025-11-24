<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.emergency.model.Patient" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Patient</title>
</head>
<body>

<%
    Patient p = (Patient) request.getAttribute("patient");
%>

<h2>Update Patient</h2>

<form action="UpdatePatientServlet" method="post">

    <input type="hidden" name="id" value="<%= p.getId() %>">

    Name: <input type="text" name="name" value="<%= p.getName() %>" required><br><br>

    Age: <input type="number" name="age" value="<%= p.getAge() %>" required><br><br>

    Disease: <input type="text" name="emergencyType" value="<%= p.getEmergencyType() %>" required><br><br>

    Phone: <input type="text" name="contact" value="<%= p.getContact() %>" required><br><br>

    <button type="submit">Update </button>

</form>

<br>
<a href="list-Patient.jsp">Back to List</a>

</body>
</html>
