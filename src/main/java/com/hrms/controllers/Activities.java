package com.hrms.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hrms.utils.ActivityDAO;

/**
 * Servlet implementation class Activities
 */

public class Activities extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	private final ActivityDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Activities() {
        super();
        dao=new ActivityDAO();
        
    }

	/**
     * @param request
     * @param response
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	String activity =dao.getAllActivities();
		out.println(activity);
		//out.println(JSONConverter.convert(activity));
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
