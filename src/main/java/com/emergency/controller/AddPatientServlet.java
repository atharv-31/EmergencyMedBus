package com.emergency.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.emergency.dao.PatientDAOImpl;
import com.emergency.model.Patient;


@WebServlet("/AddPatientServlet")
public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PatientDAOImpl dao=new PatientDAOImpl();
   
    public AddPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
		    int age = Integer.parseInt(request.getParameter("age"));
		    String location = request.getParameter("location");   
		    String emergencyType = request.getParameter("emergencyType"); 	
		    String contact = request.getParameter("contact");

		    Patient p = new Patient(name, age, location,emergencyType, contact );
             
        boolean saved = dao.addPatient(p);

        if (saved) {
            response.sendRedirect("ListPatientServlet");
        } else {
            response.getWriter().println("Error adding patient!");
        }
    }
	}


