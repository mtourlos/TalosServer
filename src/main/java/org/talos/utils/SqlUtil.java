package org.talos.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.talos.po.Data;


public class SqlUtil {
	
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
	
	public Set<Data> fetchData() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		String q = "SELECT * FROM DATA;";
		Connection connection = connectToDatabase();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(q);
		Set<Data> results = new HashSet<Data>();
		while(rs.next()){
			Data d = new Data();
			d.setCinr(rs.getInt("CINR"));
			d.setId(rs.getInt("ID"));
			d.setLatitude(rs.getFloat("LATITUDE"));
			d.setLongitude(rs.getFloat("LONGITUDE"));
			d.setNetworkType(rs.getString("NETWORK_TYPE"));
			d.setOperator(rs.getString("OPERATOR"));
			d.setTimestamp(rs.getTimestamp("TIME_STAMP"));
			d.setUser(rs.getString("USER"));
			results.add(d);
		}
		disconnectFromDatabase(connection);
		return results;
	}
	
	public void disconnectFromDatabase(Connection connection) throws SQLException{
		connection.close();
	}
	
	
	
	

}
