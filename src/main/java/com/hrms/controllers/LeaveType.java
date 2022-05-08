package com.hrms.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hrms.utils.DAYCalculator;
import com.hrms.utils.LeaveDAO;

/**
 * Servlet implementation class LeaveType
 */

public class LeaveType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LeaveDAO dao;
	Gson gson = new Gson();
	private DAYCalculator dcal;
	int status= 0;
	String message="";
	PrintWriter out;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveType() {
        super();
        dao = new LeaveDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out= response.getWriter();
		String leave = dao.getAllLeaves();
		out.println(leave);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
