package com.hrms.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.models.TimeSheetLog;
import com.hrms.utils.JSONConverter;
import com.hrms.utils.TimesheetLogDAO;

/**
 * Servlet implementation class ManageTimesheet
 */

public class ManageTimesheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	int status, execute_activity = 0;
	private TimesheetLogDAO dao;
//	Gson gson = new Gson();
	String result,nextPage;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageTimesheet() {
        super();
        dao = new TimesheetLogDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// defining the PrintWriter object
				out = response.getWriter();
				// setting the response type
				response.setContentType("application/json");
				request.getParameter("action");
				String emp_no = request.getParameter("emp_no");
				List<TimeSheetLog> logs = dao.getActivityByStaffID(emp_no);
				System.out.print(logs);
                out.println(JSONConverter.convert(logs));
//				out.println(logs);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
