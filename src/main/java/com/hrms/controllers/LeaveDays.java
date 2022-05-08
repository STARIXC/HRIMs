/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hrms.controllers;

import com.hrms.models.LeaveDayCounter;
import com.hrms.utils.DAYCalculator;
import com.hrms.utils.JSONConverter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CBWAHYI
 */
public class LeaveDays extends HttpServlet {

  HttpSession session;
  String output = "";
  DAYCalculator dao;

  public LeaveDays() {
    super();
    dao = new DAYCalculator();
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String start_date = request.getParameter("start_date");
    String end_date = request.getParameter("end_date");
    LeaveDayCounter applied_days=dao.WorkingDays(start_date, end_date);
    System.out.println(JSONConverter.convert(applied_days));
    out.println(JSONConverter.convert(applied_days));
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      Logger.getLogger(LeaveDays.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      Logger.getLogger(LeaveDays.class.getName()).log(Level.SEVERE, null, ex);
    }
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
