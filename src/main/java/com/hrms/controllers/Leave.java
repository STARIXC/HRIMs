package com.hrms.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hrms.models.LeaveApplication;
import com.hrms.models.Response;
import com.hrms.utils.LeaveDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Leave
 */
public class Leave extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private final LeaveDAO dao;
  Gson gson = new Gson();
  HttpSession session;
  String activity_id;
  Response res = new Response();
  int code_;
  int status, checker, code = 0;
  String message, list = "";
  PrintWriter out;

  /**
   * @see HttpServlet#HttpServlet()
   */
  /**
   * @see HttpServlet#HttpServlet()
   */
  public Leave() {
    super();
    dao = new LeaveDAO();
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, SQLException {
    try {
      out = response.getWriter();
      session = request.getSession();
      activity_id = request.getParameter("id");
      int employee_id, leave_type_id, leave_status;
      Double number_days;
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date date = new Date();
      System.out.println(dateFormat.format(date));
      String date_of_application = dateFormat.format(date);
      employee_id = Integer.parseInt(request.getParameter("employee_id"));
      leave_type_id = Integer.parseInt(request.getParameter("leave_type_id"));
      leave_status = Integer.parseInt(request.getParameter("leave_status"));
      number_days = Double.parseDouble(request.getParameter("no_days"));
      String start_date = request.getParameter("start_date");
      String end_date = request.getParameter("end_date");
      System.out.println("Start Date:" + start_date + "End Date:" + end_date + "Number of Days : " + number_days);
      checker = dao.checkDates(employee_id, start_date, end_date, leave_type_id);

      if (checker > 0) {
        System.out.println("Application could not be submited. There already exist another application for the same dates.");
        code = 0;
         out.println(code);
      } else {
        LeaveApplication application = new LeaveApplication(employee_id, leave_type_id, date_of_application, number_days, leave_status, start_date, end_date);
        status = dao.addApplication(application);
         if (status > 0) {
        message = "Leave Saved Successfully.";
                code = 1;
        out.println(code);
      //  out.println(message);
      } else {
        message = "No change detected.";
        code = 2;
        out.println(code);
       // out.println(message);
      }
      
      }

    } catch (Exception e) {
      out.println(e);
    } finally {
      out.close();
    }



  }

  /**
   * @see
   * HttpServlet#doGet(HttpServletRequest
   * request, HttpServletResponse
   * response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    out = response.getWriter();
    String leave = dao.getAllLeaves();
    out.println(leave);

  }

  /**
   * @see
   * HttpServlet#doPost(HttpServletRequest
   * request, HttpServletResponse
   * response)
   */
  @SuppressWarnings("static-access")
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (SQLException ex) {
      Logger.getLogger(Leave.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
