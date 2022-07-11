package com.hrms.utils;

import java.sql.SQLException;
import com.hrms.db.DatabaseConnection;
import com.hrms.models.LeaveApplication;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {

    private DatabaseConnection conn;

    public LeaveDAO() {
        conn = new DatabaseConnection();
    }

    @SuppressWarnings("static-access")
    public String getAllLeaves() {
        String leaves = "";

        try {
            String sql = "SELECT * FROM tbl_leave_type";
            conn.rs = conn.st.executeQuery(sql);
            leaves = "<option value=''>Leave Type</option>";
            while (conn.rs.next()) {

                leaves += "<option value=\"" + conn.rs.getInt("leave_type_id") + "\" data-cadre=\"" + conn.rs.getInt("designation") + "\">" + conn.rs.getString("leave_name") + "</option>";

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return leaves;
    }

    @SuppressWarnings("static-access")
    public int addApplication(LeaveApplication leave) {
        int rowsAffected = 0;
//		write the insert Query
        String sql = "INSERT INTO tbl_leave_application (employee_id,leave_type_id,number_days,date_of_application,leave_status,start_date,end_date) VALUES (?,?,?,?,?,?,?)";
        try {
            //	prepare statement
            conn.pst = conn.conn.prepareStatement(sql);

            //	set parameter
            conn.pst.setInt(1, leave.getEmployee_id());
            conn.pst.setInt(2, leave.getLeave_type_id());
            conn.pst.setDouble(3, leave.getNumber_days());
            conn.pst.setString(4, leave.getDate_of_application());
            conn.pst.setInt(5, leave.getLeave_status());
            conn.pst.setString(6, leave.getStart_date());
            conn.pst.setString(7, leave.getEnd_date());
            //	execute the satements
            rowsAffected = conn.pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

//        public List<TimeSheetLog> getActivityByStaffID(String emp_no) {
//		List<TimeSheetLog> activityLogs = new ArrayList<>();
    public List<LeaveApplication> getAllApplied(String emp_no) {
        List<LeaveApplication> leaves = new ArrayList<>();
        try {

            String sql = "SELECT a.application_id as id,a.start_date as startdate,"
                    + "a.end_date as enddate,a.leave_status as status,"
                    + "a.date_of_application as applicationdate, t.leave_name AS leave_name"
                    + " FROM tbl_leave_application a join tbl_leave_type t"
                    + " on t.leave_type_id=a.leave_type_id  where employee_id ='" + emp_no + "'";
            conn.rs = conn.st.executeQuery(sql);

            while (conn.rs.next()) {
                LeaveApplication leave = new LeaveApplication();
                leave.setApplication_id(conn.rs.getInt("id"));
                leave.setStart_date(conn.rs.getString("startdate"));
                leave.setEnd_date(conn.rs.getString("enddate"));
                leave.setLeave_status(conn.rs.getInt("status"));
                leave.setLeave_type_name(conn.rs.getString("leave_name"));
                leave.setDate_of_application(conn.rs.getString("applicationdate"));
                leaves.add(leave);

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return leaves;
    }
// check if application period exists

    public int checkDates(int emp_no, String start_date, String end_date, int leave_type_id) {
        int response = 0;
        try {
            String checker_sql = "Select count(application_id) AS total From tbl_leave_application Where CAST('" + start_date + "' As Date) AND CAST('" + end_date + "' As Date) Between Cast(start_date As Date) And Cast(end_date as DATE) AND leave_type_id='"+leave_type_id+"' AND employee_id='" + emp_no + "'";
            conn.rs = conn.st.executeQuery(checker_sql);
            //Retrieving the result
            conn.rs.next();

            response =+ conn.rs.getInt("total");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;

    }
}
