/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hrms.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hrms.utils.GetAvailableDays;
import com.hrms.models.*;
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
public class AvailableDays extends HttpServlet {
 private GetAvailableDays dao;
  PrintWriter out;
  private Gson gson = new Gson();
  
  public AvailableDays() {
    dao = new GetAvailableDays();
  }

 
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
    out = response.getWriter();
    String leave_type = request.getParameter("leave_type");
    String fy = request.getParameter("fy");
    String emp_no = request.getParameter("employee_id");
      Gson gson = new Gson(); 
        JsonObject myObj = new JsonObject();
 
        AvailableDay daysInfo = dao.getAvailableDays(leave_type, fy,emp_no);
        JsonElement dayObj = gson.toJsonTree(daysInfo);
       if(daysInfo.getDaysavailable()== null){
            myObj.addProperty("success", false);
        }
        else {
            myObj.addProperty("success", true);
        }
        myObj.add("result", dayObj);
        out.println(myObj.toString());
//    com.hrms.models.AvailableDay result = dao.getAvailableDays(leave_type, fy,emp_no);
//    String dayJsonString = this.gson.toJson(result);
System.out.println(myObj.toString());
//    //System.out.println(leave_type + ":" + fy + "totalHOurs :" + result);
//    out.println(dayJsonString);
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
