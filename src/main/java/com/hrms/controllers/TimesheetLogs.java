package com.hrms.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hrms.models.ActivityLog;
import com.hrms.utils.JSONConverter;
import com.hrms.utils.TimesheetLogDAO;

/**
 * Servlet implementation class TimesheetLogs
 */

public class TimesheetLogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TimesheetLogDAO dao;
	Gson gson = new Gson();
	PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesheetLogs() {
        super();
       dao= new TimesheetLogDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// defining the PrintWriter object
		PrintWriter out = response.getWriter();

		// setting the response type
		response.setContentType("application/json");
		String log_no = request.getParameter("activity_no");
		String emp_no = request.getParameter("service_no");
		
		List<ActivityLog> logs =dao.getActivitiesByLogNo(log_no,emp_no);
		System.out.println(JSONConverter.convert(logs));
		out.println(JSONConverter.convert(logs));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
