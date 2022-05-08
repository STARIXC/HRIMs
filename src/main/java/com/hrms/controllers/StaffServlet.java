package com.hrms.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hrms.models.*;
import com.hrms.utils.JSONConverter;
import com.hrms.utils.StaffDAO;

/**
 * Servlet implementation class StaffServlet
 */

public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDAO dao;
	Gson gson = new Gson();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StaffServlet() {
		super();
		dao = new StaffDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// defining the PrintWriter object
		PrintWriter out = response.getWriter();

		// setting the response type
		response.setContentType("application/json");

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("view")) {

			String emp_no = request.getParameter("emp_no");
			Staff staff = dao.getStaffById(emp_no);
			out.println(JSONConverter.convert(staff));

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
