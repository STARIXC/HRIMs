package com.hrms.utils;

import java.sql.SQLException;

import com.hrms.db.DatabaseConnection;
import com.hrms.models.FinancialYear;

public class FinancialYearDAO {
	private DatabaseConnection conn;

	 public FinancialYearDAO() {
		 conn = new DatabaseConnection();
	}
	 
	 @SuppressWarnings("static-access")
	public FinancialYear getCurrentFinancialYear() {
		 FinancialYear fy = new FinancialYear(); 
		 try {
			 String sql = "select * from tbl_financial_year where status='1'";
			 conn.pst = conn.conn.prepareStatement(sql);
			 conn.rs = conn.pst.executeQuery();
			 if (conn.rs.next()) {
				 fy.setId(conn.rs.getInt("id"));
							 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
		}
		return fy;
		 
	 }
}
