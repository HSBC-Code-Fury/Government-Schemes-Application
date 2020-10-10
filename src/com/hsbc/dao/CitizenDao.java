package com.hsbc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.hsbc.db.DBConnection;

public class CitizenDao {
	
	Connection conn = null;
	
	public CitizenDao() {
		conn = DBConnection.getConnection();
	}
	
	
	//Adds a citizen into the DB using Citizen Object
	public Boolean addCitizen(Citizen c, String password) {
		
		int flag = 0, flag1 = 1;
		try{   
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("insert into citizen values(?,?,?,?,?,?,?,?,?,?,?)");  
			ps.setString(1,c.getUniqueId());  
			ps.setString(2,c.getName());  
			ps.setString(3, c.getDob());
			ps.setString(4, c.getGender());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getPhone());
			ps.setString(7, c.getAddress());
			ps.setString(8, c.getIncomeGroup());
			ps.setString(9, c.getProfession());
			ps.setString(10, c.getAadhar());
			ps.setString(11, c.getPan());
			
			PreparedStatement ps1 = conn.prepareStatement("insert into citizenLogin values(?,?)");  
			ps1.setString(1,c.getUniqueId());  
			ps1.setString(2, password);
			
			flag = ps.executeUpdate();
			flag1 = ps1.executeUpdate(); 
			conn.commit();
			if(flag == 1 && flag1 == 1)
				return true;
		}catch(SQLException e){
			e.printStackTrace();
		}  
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean validateCitizen() {
		return null;
	}
	
}
