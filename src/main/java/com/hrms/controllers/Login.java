/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hrms.controllers;

import com.hrms.db.DatabaseConnection;
import com.hrms.utils.FinancialYearDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CBWAHYI
 */
public class Login extends HttpServlet {

	private FinancialYearDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		dao= new FinancialYearDAO();
		
		// TODO Auto-generated constructor stub
	}

	PrintWriter out;
	HttpSession session;

	MessageDigest m;
	String financial_year,username,password,fname,mname,lname,userid,pass,fullname,position,status,nextPage;
	int level;
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
		try {
			out = response.getWriter();
			session = request.getSession();
			financial_year=username=password=fname=mname=lname=userid=pass=fullname=position=status=nextPage="";
			level=0;
				System.out.println("In Login");
				/* Getting The Value From TextBox */
				
				String username = request.getParameter("username").toUpperCase();
				String password = request.getParameter("password");
				System.out.println(username + " " + password);
				DatabaseConnection conn = new DatabaseConnection();

				String sql = "select l.emp_no as id, e.first_name as firstname,"
						+ "e.surname as surname,  e.other_name as middlename,  e.phone, e.email, "
						+ " e.nationality, c.position_title as position, c.cadre_type_id as emp_cat from login l "
						+ " join emp_bio e on e.emp_no=l.emp_no "
						+ "join employee_hist h on h.emp_no =l.emp_no"
						+ " join cadre_positions c on h.position=c.id  where username='"
						+ username + "' and password=md5('" + password + "')";
				conn.rs = conn.st.executeQuery(sql);

				if (conn.rs.next()) {
					
					userid = conn.rs.getString("id");
				    fname = conn.rs.getString("firstname");
				    mname = conn.rs.getString("middlename");
				    lname = conn.rs.getString("surname");
				    position = conn.rs.getString("position");
				    level = conn.rs.getInt("emp_cat");
				    financial_year=dao.getCurrentFinancialYear().toString();
				    fullname = fname+" "+mname+" "+lname;
				    session.setAttribute("userid", userid);
		             session.setAttribute("fullname", fullname);
		             session.setAttribute("level", level);
		             session.setAttribute("position", position);
		             session.setAttribute("username", username);
		             session.setAttribute("fname", fname);
		             session.setAttribute("mname", mname);
		             session.setAttribute("lname", lname);
		             session.setAttribute("financial_year", financial_year);
		             
		             status="success"; 
		             nextPage="index.jsp";
		             
		             System.out.println("System log : "+session.getAttribute("level"));
		             
				} else {
					 status="<font color=\"red\"><b>Failed:</b> Wrong username and password combination.</font>";
		             nextPage="login.jsp";
		             session.setAttribute("login", status);
				}
				 System.out.println("STATUS IS :  "+status);
				out.println(status);
		} catch (Exception e) {
			out.println(e);
		} finally {
			out.close();
		}
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code>
   * method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a
   * servlet-specific error occurs
   * @throws IOException if an I/O error
   * occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code>
   * method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a
   * servlet-specific error occurs
   * @throws IOException if an I/O error
   * occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the
   * servlet.
   *
   * @return a String containing servlet
   * description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
