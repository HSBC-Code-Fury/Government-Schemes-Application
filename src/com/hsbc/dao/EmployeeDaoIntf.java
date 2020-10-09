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

import java.util.List;

import com.hsbc.governmentschemes.model.Scheme;

public interface EmployeeDaoIntf {
	int validateEmployeeDetails(String username, String password);
	void addScheme(Scheme s);
	void deleteScheme(String id);
	List<Scheme> displayAllSchemes();
	Scheme getSchemeById(String id);
	void editScheme(Scheme s);
}
