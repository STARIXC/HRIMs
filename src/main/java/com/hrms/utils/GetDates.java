package com.hrms.utils;

import com.hrms.db.DatabaseConnection;
import com.hrms.models.Day;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CBWAHYI
 */
public class GetDates {

  private DatabaseConnection conn;

  public GetDates() {
    conn = new DatabaseConnection();
  }
 

  public List<Day> getMonthDates(String month, String year,String emp_no) {
    List<Day> month_days = new ArrayList<>();
    
    //String SELECT_ALL_DATES = "SELECT date_field, DAYNAME(date_field) AS day_name FROM (SELECT MAKEDATE(YEAR('"+Start_date+"'),1) + INTERVAL (MONTH('"+Start_date+"')-1) MONTH + INTERVAL daynum DAY date_field FROM ( SELECT t*10+u daynum FROM (SELECT 0 t UNION SELECT 1 UNION SELECT 2 UNION SELECT 3) A,(SELECT 0 u UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) B ORDER BY daynum) AA) AAA WHERE MONTH(date_field) = MONTH('"+Start_date+"');";
  String SELECT_ALL_DATES = " SELECT a.dt as date_field, a.dayName AS day_name, IFNULL(b.hours_worked,'0') as hours_worked ,a.isWeekday as isWeekday,a.isHoliday as isHoliday"
          + ",IFNULL(b.log_no,'0') as log_no, "
          + "IFNULL(b.activity_desc,'-') as activity,IFNULL(b.leave_hours,0) as leave_hours,IFNULL(b.public_holiday,0) as public_holiday,IFNULL(b.extra,0) as extra_hrs FROM calendar_table a"
          + " LEFT JOIN timesheet_log_activities b ON a.dt=b.log_date WHERE a.y='"+year+"' AND a.m='"+month+"' AND b.emp_no='"+emp_no+"'" ;
  //String SELECT_ALL_DATES = "SELECT  `activity_log_id`,  `activity_code`,  `hours_worked`,  `log_date`,  `emp_no`,  `log_no`, LEFT(`activity_desc`, 256) FROM `hrh`.`timesheet_log_activities` ORDER BY `activity_desc` ASC LIMIT 1000";
   try {
      System.out.println(SELECT_ALL_DATES);
            conn.rs = conn.st.executeQuery(SELECT_ALL_DATES);
            while (conn.rs.next()) {
                Day day= new Day();
                day.setDate_field(conn.rs.getString("date_field"));
                day.setDate_name(conn.rs.getString("day_name"));
                day.setHours_worked(conn.rs.getInt("hours_worked"));
                day.setLeave_hours(conn.rs.getInt("leave_hours"));
                day.setPublic_holiday(conn.rs.getInt("public_holiday"));
                day.setExtra(conn.rs.getInt("extra_hrs"));
                day.setLog_no(conn.rs.getString("log_no"));
                //day.setEmp_no(conn.rs.getString(emp_no));
                day.setActivity_desc(conn.rs.getString("activity"));
                day.setIsHoliday(conn.rs.getString("isHoliday"));
                day.setIsWeekday(conn.rs.getString("isWeekday"));
                month_days.add(day);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    return month_days;

  }

  public List<Day> getMonthBlankDates(String month, String year,String emp_no) {
    List<Day> month_days = new ArrayList<>();
    
    //String SELECT_ALL_DATES = "SELECT date_field, DAYNAME(date_field) AS day_name FROM (SELECT MAKEDATE(YEAR('"+Start_date+"'),1) + INTERVAL (MONTH('"+Start_date+"')-1) MONTH + INTERVAL daynum DAY date_field FROM ( SELECT t*10+u daynum FROM (SELECT 0 t UNION SELECT 1 UNION SELECT 2 UNION SELECT 3) A,(SELECT 0 u UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) B ORDER BY daynum) AA) AAA WHERE MONTH(date_field) = MONTH('"+Start_date+"');";
  String SELECT_ALL_DATES = " SELECT a.dt as date_field, a.dayName AS day_name, IFNULL(b.hours_worked,0) as hours_worked,a.isWeekday as isWeekday,a.isHoliday as isHoliday ,IFNULL(b.log_no,'0') as log_no, IFNULL(b.activity_desc,'-') as activity ,IFNULL(b.leave_hours,'0') as leave_hours,IFNULL(b.public_holiday,'0') as public_holiday,IFNULL(b.extra,'0') as extra_hrs FROM calendar_table a LEFT JOIN timesheet_log_activities b ON a.dt=b.log_date WHERE a.y='"+year+"' AND a.m='"+month+"'" ;
  //String SELECT_ALL_DATES = "SELECT  `activity_log_id`,  `activity_code`,  `hours_worked`,  `log_date`,  `emp_no`,  `log_no`, LEFT(`activity_desc`, 256) FROM `hrh`.`timesheet_log_activities` ORDER BY `activity_desc` ASC LIMIT 1000";
   try {
      System.out.println(SELECT_ALL_DATES);
            conn.rs = conn.st.executeQuery(SELECT_ALL_DATES);
            while (conn.rs.next()) {
                Day day= new Day();
                day.setDate_field(conn.rs.getString("date_field"));
                day.setDate_name(conn.rs.getString("day_name"));
                day.setHours_worked(conn.rs.getInt("hours_worked"));
                day.setLeave_hours(conn.rs.getInt("leave_hours"));
                day.setPublic_holiday(conn.rs.getInt("public_holiday"));
                day.setExtra(conn.rs.getInt("extra_hrs"));
                day.setLog_no(conn.rs.getString("log_no"));
               // day.setEmp_no(conn.rs.getString(emp_no));
                day.setActivity_desc(conn.rs.getString("activity"));
                day.setIsHoliday(conn.rs.getString("isHoliday"));
                day.setIsWeekday(conn.rs.getString("isWeekday"));
                month_days.add(day);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    return month_days;

  }

}
