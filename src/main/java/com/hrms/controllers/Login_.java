package com.hrms.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.db.DatabaseConnection;
import com.hrms.utils.FinancialYearDAO;

/**
 * Servlet implementation class Login_
 */

public class Login_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FinancialYearDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login_() {
		super();
		dao= new FinancialYearDAO();
		
		// TODO Auto-generated constructor stub
	}

	PrintWriter out;
	HttpSession session;

	MessageDigest m;
	String financial_year,username,password,fname,mname,lname,userid,pass,fullname,position,status,nextPage;
	int level;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  // TODO Auto-generated method stub
	    String op = request.getParameter("operation");
	    HttpSession session=request.getSession(false);
	    if("logout".equalsIgnoreCase(op)) {
	      session.invalidate();
	    //  ServletUtility.setSuccessMessage("LogoutSucessfully",request);
	      
	    }
	    nextPage="login.jsp";
        session.setAttribute("login", status);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
