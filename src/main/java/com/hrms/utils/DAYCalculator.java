package com.hrms.utils;

import com.hrms.db.DatabaseConnection;
import com.hrms.models.LeaveDayCounter;
import java.sql.SQLException;
import java.util.*;

public class DAYCalculator {

  public DatabaseConnection conn;

  public DAYCalculator() {
    conn = new DatabaseConnection();
  }

  public LeaveDayCounter WorkingDays(String startDate, String endDate) throws SQLException {
    LeaveDayCounter workDays = new LeaveDayCounter();

    try {
      String checker_sql = "SELECT sum(isWeekday) as number_of_days,SUM(isHoliday) as number_of_holidays FROM calendar_table WHERE dt BETWEEN CAST('" + startDate + "' As Date) AND CAST('" + endDate + "' As Date)";
      conn.rs = conn.st.executeQuery(checker_sql);
      conn.rs = conn.st.executeQuery(checker_sql);
      //Retrieving the result
      if (conn.rs.next()) {
        workDays.setNo_weekdays(conn.rs.getInt("number_of_days"));
        workDays.setNo_holidays(conn.rs.getInt("number_of_holidays"));
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return workDays;
  }
}
