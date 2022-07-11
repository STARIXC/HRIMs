package com.hrms.utils;

import com.hrms.db.DatabaseConnection;
import com.hrms.models.AvailableDay;
import com.hrms.models.Day;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CBWAHYI
 */
public class GetAvailableDays {

  private DatabaseConnection conn;

  public GetAvailableDays() {
    conn = new DatabaseConnection();
  }

  public AvailableDay getAvailableDays(String leave_type, String fy, String emp_no) {
   AvailableDay day = new AvailableDay();
    String SELECT_LEAVE_SUM = "SELECT a.no_days AS available,b.no_days AS enjoyed FROM tbl_leave_days_available a JOIN tbl_leave_taken b ON a.available_id=b.taken_id WHERE a.employee_id='"+emp_no+"' AND a.fy_id='"+fy+"' AND a.leave_type_id='"+leave_type+"'";
    try {
      System.out.println(SELECT_LEAVE_SUM);
      conn.rs = conn.st.executeQuery(SELECT_LEAVE_SUM);
      while (conn.rs.next()) {
        
        day.setDaysavailable(conn.rs.getString("available"));
        day.setEnjoyed(conn.rs.getString("enjoyed"));

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return day;
  }
;
}
