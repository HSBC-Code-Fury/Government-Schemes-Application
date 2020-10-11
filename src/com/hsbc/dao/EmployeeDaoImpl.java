/*
 * @Author Pratham Sharma
 * 
 * Class- EmployeeDaoImpl is a class that has methods to execute employee's business logic
 * 
 * Methods
 * 1.	validateEmployeeDetails(String username, String password)
 * 			--This method accepts two arguments and validates these details with the employee table in the DB
 * 
 * 2.	addScheme(Scheme s)
 * 			--This Method accepts an object of type Scheme and adds to the Scheme table of the database
 * 
 * 3. 	deleteScheme(String id)
 * 			--This method accepts the scheme id and deletes the respective scheme from the Scheme table of the DB
 * 
 * 4. 	List<Scheme> displayAllSchemes()
 * 			--This method returns list of scheme objects which are then displayed in the ShowSchemes.jsp page
 * 
 * 5. 	getSchemeById(String id)
 * 			--This method extracts a scheme by the given id from DB
 * 
 * 6. 	editScheme(Scheme s)
 * 			--This method is used to change the DB values of a particular scheme
 * 	
 */
package com.hsbc.governmentschemes.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.governmentschemes.model.Scheme;
import com.hsbc.governmentschemes.model.SchemeCriteria;

public class EmployeeDaoImpl implements EmployeeDaoIntf{
	
	static Connection conn = null;
	
	public EmployeeDaoImpl(){
		conn=DBConnection.getConnection();
	}

	@Override
	public int validateEmployeeDetails(String username, String password) {
		String validateQuery = "select * from employee where username ="+username;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(validateQuery);
			while(rs.next()) {
				if(username.equals(rs.getString(1))){
					if(password.equals(rs.getString(2))) {
						return 1;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public void addScheme(Scheme s) {
		String addQuery = "insert into schemes values(?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt;
		
		try {
			pstmt=conn.prepareStatement(addQuery);
			pstmt.setString(1, s.getUniqueId());
			pstmt.setString(2,s.getName());
			pstmt.setString(3, s.getSummary());
			pstmt.setString(4, s.getDescription());
			pstmt.setString(5, s.getMinistry());
			pstmt.setString(6, s.getSector());
			pstmt.setDate(7,  (Date) s.getStartDate());
			pstmt.setString(8, s.getStatus());
			pstmt.setString(9, s.getPaymentBanks());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteScheme(String id) {
		String deleteQuery = "delete from schemes where uniqueid="+id+";";
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Scheme> displayAllSchemes() {
		List<Scheme> slist = new ArrayList<>();
		try {
			String str = "select * from schemes ";
			Statement pst = conn.createStatement();
			ResultSet rs = pst.executeQuery(str);

			//String uniqueId,name,summary,description,ministry,sector,status,paymentBanks;
			//private Date startDate;
			
			while (rs.next()) {
				String uniqueId = rs.getString(1);
				String name = rs.getString(2);
				String summary = rs.getString(3);
				String description = rs.getString(4);
				String ministry = rs.getString(5); 
				String sector = rs.getString(6);
				String status = rs.getString(7);
				String pay = rs.getString(8);
				Date d = rs.getDate(9);
				slist.add(new Scheme(uniqueId,name,summary,description,ministry,sector,d,pay,status));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return slist;
	}

	@Override
	public Scheme getSchemeById(String id) {
		Scheme s=null;
		String searchQuery = "select * from employee where uniqueId ="+id;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(searchQuery);
			while(rs.next()) {
				if(id.equals(rs.getString(1))){
					String uniqueId = rs.getString(1);
					String name = rs.getString(2);
					String summary = rs.getString(3);
					String description = rs.getString(4);
					String ministry = rs.getString(5); 
					String sector = rs.getString(6);
					String status = rs.getString(7);
					String pay = rs.getString(8);
					Date d = rs.getDate(9);
					s= new Scheme(uniqueId,name,summary,description,ministry,sector,d,pay,status);
					}
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void editScheme(Scheme s) {
		String updateQuery = "update schemes set uniqueid=?, name=?, summary=?, description=?, ministry=?,sector=?,startdate=?,status=?, paymentbanks=?;";
		PreparedStatement pstmt;
		
		try {
			pstmt=conn.prepareStatement(updateQuery);
			pstmt.setString(1, s.getUniqueId());
			pstmt.setString(2,s.getName());
			pstmt.setString(3, s.getSummary());
			pstmt.setString(4, s.getDescription());
			pstmt.setString(5, s.getMinistry());
			pstmt.setString(6, s.getSector());
			pstmt.setDate(7,  (Date) s.getStartDate());
			pstmt.setString(8, s.getStatus());
			pstmt.setString(9, s.getPaymentBanks());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addSchemeCriteria(SchemeCriteria s) {
		String addQuery = "insert into schemecriteria values(?,?,?,?,?,?,?);";
		PreparedStatement pstmt;
		
		try {
			pstmt=conn.prepareStatement(addQuery);
			pstmt.setString(1, s.getUniqueId());
			pstmt.setString(2, s.getProfession());
			pstmt.setString(3, s.getIncomeGroup());
			pstmt.setString(4, s.getGender());
			pstmt.setString(5, s.getDocuments());
			pstmt.setInt(6, s.getMinAge());
			pstmt.setInt(7, s.getMaxAge());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteSchemeCriteria(String id) {
		String deleteQuery = "delete from schemecriteria where uniqueid="+id+";";
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<SchemeCriteria> displayAllSchemesCriteria() {
		List<SchemeCriteria> slist = new ArrayList<>();
		try {

			String str = "select * from schemecriteria ";
			Statement pst = conn.createStatement();
			ResultSet rs = pst.executeQuery(str);

//			private String profession,incomeGroup,gender,documents,uniqueId;
//			private int minAge,maxAge;
			
			while (rs.next()) {
				String uniqueId = rs.getString(1);
				String profession = rs.getString(2);
				String incomeGroup = rs.getString(3);
				String gender = rs.getString(4);
				String documents = rs.getString(5); 
				int minAge = rs.getInt(6);
				int maxAge = rs.getInt(7);
				slist.add(new SchemeCriteria(uniqueId, profession, incomeGroup, gender, documents, minAge, maxAge));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SchemeCriteria getSchemeCriteriaById(String id) {
		SchemeCriteria s=null;
		String searchQuery = "select * from schemescriteria where uniqueId ="+id;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(searchQuery);
			while(rs.next()) {
				if(id.equals(rs.getString(1))){
					String uniqueId = rs.getString(1);
					String profession = rs.getString(2);
					String incomeGroup = rs.getString(3);
					String gender = rs.getString(4);
					String documents = rs.getString(5); 
					int minAge = rs.getInt(6);
					int maxAge = rs.getInt(7);
					s= new SchemeCriteria(uniqueId,profession,incomeGroup,gender,documents,minAge,maxAge);
					}
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void editSchemeCriteria(SchemeCriteria s) {
		String updateQuery = "update schemes set uniqueid=?, profession=?, incomeGroup=?, gender=?, documents=?,minage=?,maxage=?;";
		PreparedStatement pstmt;
		
		try {
			pstmt=conn.prepareStatement(updateQuery);
			pstmt.setString(1, s.getUniqueId());
			pstmt.setString(2,s.getProfession());
			pstmt.setString(3, s.getIncomeGroup());
			pstmt.setString(4, s.getGender());
			pstmt.setString(5, s.getDocuments());
			pstmt.setInt(6, s.getMinAge());
			pstmt.setInt(6, s.getMaxAge());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	
	
}
