package com.hrms.utils;

import java.sql.SQLException;

import com.hrms.db.DatabaseConnection;
import com.hrms.models.Staff;

public class StaffDAO {
	private DatabaseConnection conn;

	public StaffDAO() {
		conn = new DatabaseConnection();
	}

	public Staff getStaffById(String emp_no) {
		Staff staff = new Staff();
		System.out.println(emp_no);
		try {
			String sql = "select *" + "from emp_bio b join employee_hist h on h.emp_no =b.emp_no "
					+ "join cadre_positions c on h.position=c.id "
					+ "join subpartnera s on s.CentreSanteId = h.mfl"
//					+ "join banking_det bn on bn.employee_no = b.emp_no"
			//+ "join statutory_details sd bn on sd.employee_no = b.emp_no"
					+ " where b.emp_no ='" + emp_no + "'";
			
			conn.rs = conn.st.executeQuery(sql);
			if (conn.rs.next()) {
				staff.setId(conn.rs.getInt("id"));
				staff.setEmp_no(conn.rs.getString("emp_no"));
				staff.setFirst_name(conn.rs.getString("first_name"));
				staff.setSurname(conn.rs.getString("surname"));
				staff.setOther_name(conn.rs.getString("other_name"));
				staff.setGender(conn.rs.getString("gender"));
				staff.setNational_id(conn.rs.getString("national_id"));
				staff.setPhone(conn.rs.getString("phone"));
				staff.setEmail(conn.rs.getString("email"));
				staff.setDob(conn.rs.getString("dob"));
				staff.setHome_address(conn.rs.getString("home_address"));
				staff.setPostal_code(conn.rs.getString("postal_code"));
				staff.setNationality(conn.rs.getString("nationality"));
				staff.setDisability(conn.rs.getString("disability"));
				staff.setDisability_explain(conn.rs.getString("disability_explain"));
				staff.setMfl(conn.rs.getString("SubPartnerNom"));
				staff.setPosition(conn.rs.getString("position_title"));
				staff.setActive(conn.rs.getInt("active"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(staff);
		return staff;

	}

	@SuppressWarnings("static-access")
	public void updateEmployee(Staff staff) {
		try {
			String sql = "REPLACE INTO emp_bio" + "(emp_no,first_name,surname," + "other_name,national_id,"
					+ "gender,phone,email,dob,home_address," + "postal_code,nationality,"
					+ "disability,disability_explain)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			conn.pst = conn.conn.prepareStatement(sql);
			conn.pst.setString(1, staff.getEmp_no());
			conn.pst.setString(2, staff.getFirst_name());
			conn.pst.setString(3, staff.getSurname());
			conn.pst.setString(4, staff.getOther_name());
			conn.pst.setString(5, staff.getNational_id());
			conn.pst.setString(6, staff.getGender());
			conn.pst.setString(7, staff.getPhone());
			conn.pst.setString(8, staff.getEmail());
			conn.pst.setString(9, staff.getDob());
			conn.pst.setString(10, staff.getHome_address());
			conn.pst.setString(11, staff.getPosition());
			conn.pst.setString(12, staff.getNationality());
			conn.pst.setString(13, staff.getDisability());
			conn.pst.setString(14, staff.getDisability_explain());

			conn.pst.executeUpdate();
			String sql1 = "REPLACE INTO employee_hist" + "(emp_no, national_id, mfl," + " position, date_started, "
					+ "date_ended, months_worked, " + "current_contract, contract_period,"
					+ " contract_end_date, expected_months," + " active" + ")" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			conn.pst1 = conn.conn.prepareStatement(sql1);
			conn.pst1.setString(1, staff.getEmp_no());
			conn.pst1.setString(2, staff.getNational_id());
			conn.pst1.setString(3, staff.getMfl());
			conn.pst1.setString(4, staff.getPosition());
			conn.pst1.setString(5, staff.getDate_started());
			conn.pst1.setString(6, staff.getDate_ended());
			conn.pst1.setString(7, staff.getMonths_worked());
			conn.pst1.setString(8, staff.getCurrent_contract());
			conn.pst1.setString(9, staff.getContract_period());
			conn.pst1.setString(10, staff.getContract_end_date());
			conn.pst1.setString(11, staff.getExpected_months());
			conn.pst1.setInt(12, staff.getActive());
			conn.pst1.executeUpdate();
			String sql2 = "REPLACE INTO banking_det(employee_no,bank_name,branch,account_name,acount_number) VALUES (?,?,?,?,?)";
			conn.pst2 = conn.conn.prepareStatement(sql2);
			conn.pst2.setString(1, staff.getEmp_no());
			conn.pst2.setString(2, staff.getBank_name());
			conn.pst2.setString(3, staff.getBranch());
			conn.pst2.setString(4, staff.getAccount_name());
			conn.pst2.setString(5, staff.getAcount_number());
			conn.pst2.executeUpdate();
			String sql3 = "REPLACE INTO statutory_details(employee_no,kra_pin,nssf_no,nhif_no,cert_good_conduct_no,helb_clearance_no) VALUES (?,?,?,?,?,?)";
			conn.pst3 = conn.conn.prepareStatement(sql3);
			conn.pst3.setString(1, staff.getEmp_no());
			conn.pst3.setString(2, staff.getKra_pin());
			conn.pst3.setString(3, staff.getNssf_no());
			conn.pst3.setString(4, staff.getNhif_no());
			conn.pst3.setString(5, staff.getCert_good_conduct_no());
			conn.pst3.setString(6, staff.getHelb_clearance_no());
			conn.pst3.executeUpdate();
			String sql4 = "REPLACE INTO login( emp_no, username, password, is_admin, profile_path)VALUES (?,?,?,?)";
			conn.pst4 = conn.conn.prepareStatement(sql4);
			conn.pst4.setString(1, staff.getEmp_no());
			conn.pst4.setString(2, staff.getEmp_no());
			conn.pst4.setInt(3, 0);
			conn.pst4.setString(4, "");
			conn.pst4.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
