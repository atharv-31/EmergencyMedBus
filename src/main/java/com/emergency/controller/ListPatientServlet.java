package com.emergency.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.emergency.dao.PatientDAOImpl;
import com.emergency.model.Patient;

@WebServlet("/ListPatientServlet")
public class ListPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatientDAOImpl dao = new PatientDAOImpl();

	public ListPatientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Patient> list = dao.getAllPatients();

		request.setAttribute("patientList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("list-Patient.jsp");

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
