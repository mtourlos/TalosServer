package org.talos.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Utility class for SQL
 */
public class SqlUtil {
	
	/**
	 * Connects to database
	 * 
	 * @return a {@link Connection}
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public Connection connectToDatabase() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		String url = "jdbc:mysql://localhost:3306/";  
		String dbName = "talos";
		String driver = "com.mysql.jdbc.Driver";
	    String userName = "root"; 
		String password = "root";
		Class.forName(driver).newInstance();
		Connection connect = DriverManager.getConnection(url+dbName,userName,password);
	 	return connect;
	}
	
	/**
	 * Closes the connection
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public void disconnectFromDatabase(Connection connection) throws SQLException{
		connection.close();
	}
	
	
	
	

}
