package com.hrms.utils;

import com.hrms.db.DatabaseConnection;
import java.sql.SQLException;

/**
 *
 * @author CBWAHYI
 */
public class FindExpectedHours {

  private DatabaseConnection conn;

  public FindExpectedHours() {
    conn = new DatabaseConnection();
  }

  public  String  totalHours(String year, String month){
    String hours="";
    	try {
			String query = "SELECT SUM(workingHours) AS expectedHours FROM `hrh`.`calendar_table` WHERE y='"+year+"' AND m='"+month+"' AND   isWeekday=1 AND isHoliday=0";
			conn.rs = conn.st.executeQuery(query);
		
			while (conn.rs.next()) {
              hours=conn.rs.getString("expectedHours");
							
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    return hours;
  }
}
