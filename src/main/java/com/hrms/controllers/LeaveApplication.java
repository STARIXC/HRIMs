/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hrms.controllers;

import com.google.gson.Gson;
import com.hrms.utils.JSONConverter;
import com.hrms.utils.LeaveDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CBWAHYI
 */
public class LeaveApplication extends HttpServlet {

  PrintWriter out;
  int status, execute_activity = 0;
  private LeaveDAO dao;
  Gson gson = new Gson();
  String result, nextPage;

  public LeaveApplication() {
    super();
    dao = new LeaveDAO();
  }

  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a
   * servlet-specific error occurs
   * @throws IOException if an I/O error
   * occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    out = response.getWriter();

    // setting the response type
    response.setContentType("application/json");
    //request.getParameter("action");
    String emp_no = request.getParameter("emp_no");
    List<com.hrms.models.LeaveApplication> applications = dao.getAllApplied(emp_no);
    System.out.println(JSONConverter.convert(applications));
    out.println(JSONConverter.convert(applications));
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
