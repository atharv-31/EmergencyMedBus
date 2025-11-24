package com.emergency.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.emergency.dao.PatientDAOImpl;
import com.emergency.model.Patient;

@WebServlet("/UpdatePatientServlet")
public class UpdatePatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PatientDAOImpl dao = new PatientDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Patient patient = dao.getPatientById(id);

        request.setAttribute("patient", patient);
        request.getRequestDispatcher("updatePatient.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String location = request.getParameter("location");
        String emergencyType = request.getParameter("emergencyType");
        String contact = request.getParameter("contact");

        // Create object
        Patient p = new Patient(name, age, location, emergencyType, contact);
        p.setId(id);  // IMPORTANT

        // Update
        boolean updated = dao.updatePatient(p);

        if (updated) {
            response.sendRedirect("ListPatientServlet");  
        } else {
            response.getWriter().println("Error updating patient info");
        }
    }
}
