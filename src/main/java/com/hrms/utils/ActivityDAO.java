package com.hrms.utils;

import java.sql.SQLException;

import com.hrms.db.DatabaseConnection;
import com.hrms.models.Activity;

public class ActivityDAO {
	private DatabaseConnection conn;

	public ActivityDAO() {
		conn= new DatabaseConnection();
	}

	@SuppressWarnings("static-access")
	public  String  getAllActivities(){
	//	List<Activity> activities = new ArrayList<Activity>();
		 String activities="";
		try {
			String sql = "SELECT * FROM activities";
			conn.rs = conn.st.executeQuery(sql);
			activities = "<option value=\"\">Select Activity</option>";
			while (conn.rs.next()) {
		
				//Activity activity = new Activity();
				activities += "<option value=\"" + conn.rs.getInt("activity_id") + "\" data-cadre=\"" + conn.rs.getInt("activity_cadre_type") + "\">" + conn.rs.getString("activity_description") + "</option>";
			//	activity.setActivity_id(c);
					

				//activities.add(activity);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activities;
	}
	@SuppressWarnings("static-access")
	public Activity getActivityById(int activity_id) {
		Activity activity = new Activity();
		
		try {
			String sql = "SELECT * FROM activities where activity_id=?";
			conn.pst = conn.conn.prepareStatement(sql);
			conn.pst.setInt(1, activity_id);
			conn.rs = conn.pst.executeQuery();
			if (conn.rs.next()) {

				activity.setActivity_id(conn.rs.getInt("activity_id"));
				activity.setActivity_description(conn.rs.getString("activity_description"));
				activity.setActivity_cadre_type(conn.rs.getInt("activity_cadre_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activity;

	}

}
