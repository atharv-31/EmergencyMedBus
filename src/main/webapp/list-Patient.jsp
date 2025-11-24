<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.emergency.model.Patient" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Patients</title>
</head>
<body>

<h2>Patient List</h2>

<a href="index.jsp">Add New Patient</a>
<br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Emergency Type</th>
        <th>Contact</th>
        <th>Action</th>
    </tr>

<%
    List<Patient> list = (List<Patient>) request.getAttribute("patientList");

    if (list != null) {
        for (Patient p : list) {
%>

    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getAge() %></td>
        <td><%= p.getEmergencyType() %></td>
        <td><%= p.getContact() %></td>


        <td>
            <a href="UpdatePatientServlet?id=<%= p.getId() %>">Update</a><br>
<a href="DeletPatientServlet?id=<%= p.getId() %>" onclick="return confirm('Delete this patient?')">Delete</a>

        </td>
    </tr>

<%
        }
    }
%>

</table>

</body>
</html>
