package com.hrms.models;

public class LeaveM {
	private int typeID, emp_type;
	private String leave_type_name, total_days;

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(int emp_type) {
		this.emp_type = emp_type;
	}

	public String getLeave_type_name() {
		return leave_type_name;
	}

	public void setLeave_type_name(String leave_type_name) {
		this.leave_type_name = leave_type_name;
	}

	public String getTotal_days() {
		return total_days;
	}

	public void setTotal_days(String total_days) {
		this.total_days = total_days;
	}

	public LeaveM(int typeID, int emp_type, String leave_type_name, String total_days) {
	
		this.typeID = typeID;
		this.emp_type = emp_type;
		this.leave_type_name = leave_type_name;
		this.total_days = total_days;
	}

	public LeaveM(String leave_type_name, String total_days, int emp_type) {
	
		this.emp_type = emp_type;
		this.leave_type_name = leave_type_name;
		this.total_days = total_days;
	}

	public LeaveM(int typeID) {
		
		this.typeID = typeID;
	}

	public LeaveM() {
		
	}
}
