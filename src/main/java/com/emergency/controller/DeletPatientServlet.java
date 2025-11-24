package com.emergency.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.emergency.dao.PatientDAO;
import com.emergency.dao.PatientDAOImpl;


@WebServlet("/DeletPatientServlet")
public class DeletPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private PatientDAOImpl dao=new PatientDAOImpl();
    public DeletPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 int id=Integer.parseInt(request.getParameter("id"));
 
 boolean deleted=dao.deletePatient(id);
 
 if(deleted) {
	 response.sendRedirect("ListPatientServlet");

 }else {
     response.getWriter().println("Error deleting patient!");
 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
