package com.govt.applyscheme;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ApplySchemeDao {
	
	Connection conn=null;

	public ApplySchemeDao() {
		conn=DBConnection.getConnection();	
	}
	
	public List<String> getAllSchemes() {
		List<String> list=new ArrayList<String>();
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from scheme");
			while(rs.next()) {
				list.add(rs.getString("schemeId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean validateScheme(String cid,String sid) throws SQLException {
		//creating 2 statements for 2 diff queries
		Statement stmt=conn.createStatement();
		Statement stmt2=conn.createStatement();
		//get data from citizen and schemecriteria
		ResultSet rs=stmt.executeQuery("select * from citizen where uniqueId='"+cid+"'");
		ResultSet rs2=stmt2.executeQuery("select * from schemecriteria where schemeId='"+sid+"'");
		rs.next();
		rs2.next();
		
//			System.out.println(rs.getString("DOB"));
//			System.out.println(rs.getString("gender"));
//			System.out.println(rs.getString("income"));
//			System.out.println(rs.getString("profession"));
//			
//			System.out.println(rs2.getString("agemin"));
//			System.out.println(rs2.getString("agemax"));
//			System.out.println(rs2.getString("profession"));
//			System.out.println(rs2.getString("incomeGroup"));
//			System.out.println(rs2.getString("gender"));
//			System.out.println("----------------");
			
			boolean age;
			Calendar calendar = new GregorianCalendar();
			Date d = new Date();
			calendar.setTime(d);
			int curdate=calendar.get(Calendar.YEAR);
			int min=Integer.parseInt(rs2.getString("agemin"));
			int max=Integer.parseInt(rs2.getString("agemax"));
			
			int bday=Integer.parseInt((rs.getString("DOB").substring(0, 4)));
			int diff= curdate-bday;
			
			if(diff>min && diff<max) {
				age=true; 
			}
			else {
				age=false;
			}
			if(rs.getString("gender").equals(rs2.getString("gender")) && rs.getString("income").equals(rs2.getString("incomeGroup"))
					&& rs.getString("profession").equals(rs2.getString("profession")) && age)
			{
				System.out.println("in here");
				return true;
			}
			else {
				return false;
			}
	}

}
