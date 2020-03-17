package com.jspServlet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jspServlet.Helper.DBConnectionUtil;
import com.jspServlet.entity.Employee;

/*to access the database class "EmployeeDAO (our Model class)" needs DB connection therefor
  therefor make use of DBConnectionUtil.java to get the connection
 * 
 * 
 * */


public class EmployeeDAOImpl implements EmployeeDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement=null;   //for insert,update,delete

	@Override
	public List<Employee> get() {
		
			// create reference vaiable
			List<Employee> list = null;
			Employee employee = null;
	
			try {
				list=new ArrayList<Employee>();
	
				//create sql query
				String sql="SELECT * FROM TBL_EMPLOYEE";
				
				//get the database connection
				connection=DBConnectionUtil.openConnection();	//openConnection() is static
				
				//create a statement
				statement=connection.createStatement();
				
				//execute a sql query
				resultSet=statement.executeQuery(sql);
				
				//process the resultset
				while(resultSet.next()) {
					employee=new Employee();	//for adding to the list every time create new object
					
					employee.setId(resultSet.getInt("ID"));
					employee.setName(resultSet.getString("NAME"));
					employee.setDob(resultSet.getString("DOB"));
					employee.setDepartment(resultSet.getString("DEPARTMENT"));
					
					//add employee to list
					list.add(employee);
				}
				
				

	
			} catch (Exception e) {
				e.printStackTrace();
			}

			//return list
			return list;
	}

	@Override
	public boolean save(Employee e) {
		boolean flag=false;
		
		try {
			String sql="INSERT INTO TBL_EMPLOYEE (NAME,DOB,DEPARTMENT) VALUES (?,?,?)";
			connection=DBConnectionUtil.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			
			
			preparedStatement.setString(1,e.getName());
			preparedStatement.setString(2,e.getDob());
			preparedStatement.setString(3,e.getDepartment());
			
			preparedStatement.executeUpdate();
			flag=true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public Employee get(int id) {
		
		Employee employee=null;
		
		
		try {
			employee=new Employee();
			String sql="SELECT * FROM TBL_EMPLOYEE WHERE ID="+id;
			connection=DBConnectionUtil.openConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			
			while(resultSet.next()) {
				employee.setName(resultSet.getString("name"));  //pass column name in getString()
				employee.setDob(resultSet.getString("dob"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setId(id);  //necessary otherwise id=0 if we not set id
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public boolean update(Employee e) {
		boolean flag=false;
		
		try {
			
			String sql="UPDATE TBL_EMPLOYEE SET NAME='"+e.getName()+"',DOB='"+e.getDob()+"',DEPARTMENT='"+e.getDepartment()+"' where ID="+e.getId();
			
			connection=DBConnectionUtil.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag=false;
		
		try {
			String sql="DELETE FROM TBL_EMPLOYEE WHERE ID="+id;
			connection=DBConnectionUtil.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			flag=true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
