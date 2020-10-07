package com.hsbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.hsbc.db.DBConnection;

public class CitizenDao {
	
	Connection conn = null;
	
	public CitizenDao() {
		conn = DBConnection.getConnection();
	}
	
	public int addCitizen(Citizen c) {
		
		int flag = 0;
		try{   
			PreparedStatement ps=conn.prepareStatement("insert into citizen values(?,?,?,?,?,?,?,?,?,?,?)");  
			ps.setString(1,c.getUniqueId());  
			ps.setString(2,c.getName());  
			ps.setDate(3,(Date) c.getDob());  
			ps.setString(4, c.getGender());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getPhone());
			ps.setString(7, c.getAddress());
			ps.setString(8, c.getIncomeGroup());
			ps.setString(9, c.getProfession());
			ps.setString(10, c.getAadhar());
			ps.setString(11, c.getPan());
			flag = ps.executeUpdate();
			return flag;
		}catch(Exception e){
			e.printStackTrace();
		}  
		return flag;
	}
}
