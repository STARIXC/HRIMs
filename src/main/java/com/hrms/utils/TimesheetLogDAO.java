package com.hrms.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrms.db.DatabaseConnection;
import com.hrms.models.ActivityLog;
import com.hrms.models.TimeSheetLog;

public class TimesheetLogDAO {
	private DatabaseConnection conn;

	public TimesheetLogDAO() {
		conn = new DatabaseConnection();
	}

	@SuppressWarnings("static-access")
	public List<TimeSheetLog> getActivityByStaffID(String emp_no) {
		List<TimeSheetLog> activityLogs = new ArrayList<>();

		try {
			//PreparedStatement pstmt=conn.prepareStatement("Select * from user");
		    //ResultSet rs= pstmt.executeQuery();
			String sql = "SELECT DISTINCT a.log_id,a.month,a.year,a.log_no,a.emp_no,a.log_date,a.hours_worked,a.leave_hours,"
                                + "a.holiday_hours,a.extra_hours,a.expected_hours,a.status,  b.monthName ,a.total_hours AS total_hours  FROM timesheet_logs a JOIN calendar_table b ON a.month=b.m  where a.emp_no='" + emp_no + "'";
			conn.rs = conn.st.executeQuery(sql);
			while (conn.rs.next()) {
				TimeSheetLog activityLog = new TimeSheetLog();
				activityLog.setLog_id(conn.rs.getInt("log_id"));
				activityLog.setMonth(conn.rs.getInt("month"));
				activityLog.setYear(conn.rs.getInt("year"));
				activityLog.setLog_no(conn.rs.getString("log_no"));
				activityLog.setEmp_no(conn.rs.getString("emp_no"));
				activityLog.setMonthName(conn.rs.getString("monthName"));
				activityLog.setLog_date(conn.rs.getString("log_date"));
				activityLog.setExpected_hrs(conn.rs.getString("expected_hours"));
				activityLog.setHours_worked(conn.rs.getString("hours_worked"));
				activityLog.setOnleave_hours(conn.rs.getString("leave_hours"));
				activityLog.setExtra_hours_worked(conn.rs.getString("extra_hours"));
				activityLog.setHoliday(conn.rs.getString("holiday_hours"));
				activityLog.setThours_worked(conn.rs.getString("total_hours"));
                
				activityLog.setShift(conn.rs.getInt("status"));

				activityLogs.add(activityLog);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activityLogs;
	}

	@SuppressWarnings("static-access")
	public List<ActivityLog> getActivitiesByLogNo(String log_no, String emp_no) {
		List<ActivityLog> activity = new ArrayList<>();
//		this.acitivity_log_id = ;
//		this.activity_code = ;
//		this.log_no = log_no;
//		this.emp_no = emp_no;
//		this.log_date = log_date;
//		this.hours_worked = hours_worked;
		try {
			String sql = "SELECT * FROM timesheet_log_activities where log_no=? and emp_no=?";
			conn.pst = conn.conn.prepareStatement(sql);
			conn.pst.setString(1, log_no);
			conn.pst.setString(2, emp_no);
			conn.rs = conn.pst.executeQuery();
			while (conn.rs.next()) {
				ActivityLog activityLogs = new ActivityLog();
				activityLogs.setAcitivity_log_id(conn.rs.getInt("acitivity_log_id"));
				activityLogs.setActivity_code(conn.rs.getString("activity_code"));
				activityLogs.setEmp_no(conn.rs.getString("emp_no"));
				activityLogs.setLog_date(conn.rs.getString("log_date"));
				activityLogs.setHours_worked(conn.rs.getString("hours_worked"));
				// activityLog.setShift(conn.rs.getInt("shift"));

				activity.add(activityLogs);

			}
			

		} catch (SQLException e) {

		}

		return activity;
	}

	@SuppressWarnings("static-access")
	public int addLog(String sql) {
		int rowsAffected = 0;
//		write the insert Query
				
		try {
						//	prepare statement
			conn.pst = conn.conn.prepareStatement(sql);
		
			//	execute the satements
			rowsAffected = conn.pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsAffected;
	}
	
	@SuppressWarnings("static-access")
	public int addActivityLog(String Query) {
		int rowsAffected = 0;
		//System.out.println("Activity Codes:"+Arrays.toString(activity_code));
		
	try {
			conn.pst1 = conn.conn.prepareStatement(Query);
			rowsAffected = conn.pst1.executeUpdate();
			
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

		return rowsAffected;

		
	}
}
