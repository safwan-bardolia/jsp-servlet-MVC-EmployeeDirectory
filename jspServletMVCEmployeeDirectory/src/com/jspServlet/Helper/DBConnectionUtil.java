package com.jspServlet.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String username = "hr";
	private static final String password = "hr";

	private static Connection connection = null; // reference variable to hold connection object

	public static Connection openConnection() throws SQLException {
		// check the connection i.e if connection already available then we return it 
		if (connection != null) {
			return connection;
		} else {						//else established new connection

			try {
				// load the driver
				Class.forName(driver);

				// get the connection
				connection = DriverManager.getConnection(url, username, password);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// return connection
			return connection;
		}

	}

}
