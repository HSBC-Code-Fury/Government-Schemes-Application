package com.hsbc.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.hsbc.db.DBConnection;

public class ApplySchemeDao {

	Connection conn = null;

	public ApplySchemeDao() {
		conn = DBConnection.getConnection();
	}

	public List<Scheme> getAllSchemes() {
		List<Scheme> list = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from scheme");
			while (rs.next()) {
				list.add(new Scheme(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBlob(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public Scheme getSchemeById(String schemeId) {

		Scheme s = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from scheme where " + schemeId);
			while (rs.next()) {
				s = new Scheme(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBlob(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean validateScheme(String cid, String sid) throws SQLException {

		List<Scheme> list = new ArrayList<>();
		
		System.out.println(cid + " " + sid);
//		list.add(getSchemeById(sid));

		// creating 2 statements for 2 diff queries
		Statement stmt = conn.createStatement();
		Statement stmt2 = conn.createStatement();
		// get data from citizen and schemecriteria
		ResultSet rs = stmt.executeQuery("select * from citizen where uniqueId='" + cid + "'");
		ResultSet rs2 = stmt2.executeQuery("select * from schemecriteria where schemeId='" + sid + "'");
		rs.next();
		rs2.next();

		boolean age;
		Calendar calendar = new GregorianCalendar();
		Date d = new Date();
		calendar.setTime(d);
		int curdate = calendar.get(Calendar.YEAR);
		int min = Integer.parseInt(rs2.getString(2));
		int max = Integer.parseInt(rs2.getString(3));

		int bday = Integer.parseInt((rs.getString(3).substring(0, 4)));
		System.out.println(bday);
		int diff = curdate - bday;

		if (diff > min && diff < max) {
			age = true;
		} else {
			age = false;
		}
		
		Statement stmt3 = conn.createStatement();
		ResultSet rs1 = stmt3.executeQuery("select * from approvedSchemes");
		while(rs1.next()) 
			if(rs1.getString(1).equals(cid) && rs1.getString(2).equals(sid)) 
				return false;
		
		if (rs.getString(4).equals(rs2.getString(6))
				&& rs.getString(8).equals(rs2.getString(5))
				&& rs.getString(9).equals(rs2.getString(4)) 
				&& age) {
			System.out.println("in here");
			PreparedStatement ps = conn.prepareStatement("insert into approvedSchemes values(?,?)");
			ps.setString(1, cid);
			ps.setString(2, sid);
			ps.executeUpdate();
			return true;
		} else {
			return false;
		}
	}

}