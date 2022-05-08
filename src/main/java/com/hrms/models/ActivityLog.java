package com.hrms.models;

public class ActivityLog {

  private int acitivity_log_id;
  private String log_no, emp_no, log_date;

  private String activity_code;
  private String hours_worked;
  private String onleave_hours;
  private String holiday;
  private String extra_hours_worked;
  private String Thours_worked;
  private String expected_hrs;
  private String monthName;

  public String getMonthName() {
    return monthName;
  }

  public void setMonthName(String monthName) {
    this.monthName = monthName;
  }

  public String getExpected_hrs() {
    return expected_hrs;
  }

  public void setExpected_hrs(String expected_hrs) {
    this.expected_hrs = expected_hrs;
  }

  public String getLog_no() {
    return log_no;
  }

  public String getOnleave_hours() {
    return onleave_hours;
  }

  public void setOnleave_hours(String onleave_hours) {
    this.onleave_hours = onleave_hours;
  }

  public String getHoliday() {
    return holiday;
  }

  public void setHoliday(String holiday) {
    this.holiday = holiday;
  }

  public String getExtra_hours_worked() {
    return extra_hours_worked;
  }

  public void setExtra_hours_worked(String extra_hours_worked) {
    this.extra_hours_worked = extra_hours_worked;
  }

  public String getThours_worked() {
    return Thours_worked;
  }

  public void setThours_worked(String Thours_worked) {
    this.Thours_worked = Thours_worked;
  }

  public void setLog_no(String log_no) {
    this.log_no = log_no;
  }

  public String getEmp_no() {
    return emp_no;
  }

  public void setEmp_no(String emp_no) {
    this.emp_no = emp_no;
  }

  public String getLog_date() {
    return log_date;
  }

  public void setLog_date(String log_date) {
    this.log_date = log_date;
  }

  public String getActivity_code() {
    return activity_code;
  }

  public void setActivity_code(String activity_code) {
    this.activity_code = activity_code;
  }

  public String getHours_worked() {
    return hours_worked;
  }

  public void setHours_worked(String hours_worked) {
    this.hours_worked = hours_worked;
  }

  public ActivityLog(String log_no, String emp_no, String log_date, String activity_code, String hours_worked) {

    this.log_no = log_no;
    this.emp_no = emp_no;
    this.log_date = log_date;
    this.activity_code = activity_code;
    this.hours_worked = hours_worked;
  }

  public ActivityLog(int acitivity_log_id, String log_no, String emp_no, String log_date, String activity_code,
          String hours_worked) {
    super();
    this.acitivity_log_id = acitivity_log_id;
    this.log_no = log_no;
    this.emp_no = emp_no;
    this.log_date = log_date;
    this.activity_code = activity_code;
    this.hours_worked = hours_worked;
  }

  public int getAcitivity_log_id() {
    return acitivity_log_id;
  }

  public void setAcitivity_log_id(int acitivity_log_id) {
    this.acitivity_log_id = acitivity_log_id;
  }

  public ActivityLog() {
    super();

  }

}
