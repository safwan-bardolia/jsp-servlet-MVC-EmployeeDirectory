package com.jspServlet.DAO;

import java.util.List;

import com.jspServlet.entity.Employee;

public interface EmployeeDAO {
	List<Employee> get();	//return list of employee so we can pass to jsp
	
	boolean save(Employee e);  //store the data in database
	
	Employee get(int id);      //return single record for update operation which is pass to html form
	
	boolean update(Employee e);
	
	boolean delete(int id);
}
