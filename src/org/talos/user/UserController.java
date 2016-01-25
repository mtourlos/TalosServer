package org.talos.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
	
	String url = "jdbc:mysql://localhost:3306/";  
	String dbName = "talos";
	String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
	String password = "";
    Connection connect = null;
	//Statement statement = null;
	//PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public int signUpUser(User user ){
		
			try {
				Class.forName(driver).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
			 	connect = DriverManager.getConnection(url+dbName,userName,password);
			 	System.out.println("Connected to the database");
			 	
			 	PreparedStatement insertUser = connect.prepareStatement("INSERT INTO `users` (`username`,`password`,`email`,`connected_date`) VALUES (?,?,?,?)");
			 	
			 	
			 	insertUser.setString(1, user.getUsername());
			 	insertUser.setString(2, user.getPassword());
			 	insertUser.setString(3, user.getEmail());
			 	java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
			 	insertUser.setTimestamp(4, sqlDate);
			 	
			 	int insertUserResult=insertUser.executeUpdate();
			 	if (insertUserResult>0) 
			 		System.out.println("New user:"+user.getUsername()+" inserted succefully");
			 	connect.close();
			 	System.out.println("Disconnected from the database");
			 	return 1;
			} catch (SQLException e) {
				System.out.println( e.getMessage());
				if (e.getMessage().contains("email_UNIQUE")){
					return -1;
				}else if (e.getMessage().contains("PRIMARY")){
					return -2;
				}else
					return 0;
			}					
		
		
	}
	
	public int signInUser (User user){
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
		 	connect = DriverManager.getConnection(url+dbName,userName,password);
		 	System.out.println("Connected to the database");
		 	
		 	PreparedStatement selectUser = connect.prepareStatement("SELECT password FROM users WHERE username=?");
		 	selectUser.setString(1, user.getUsername());
		 	ResultSet selectUserResult = selectUser.executeQuery();
		 	String dbPassword = null;
		 	
		 	while (selectUserResult.next()){
		 		dbPassword = selectUserResult.getString("password");
		 	}
		 	
		 	//correct username - wrong password
		 	int result = 0;
		 	
		 	try{
		 		//correct username - correct password
		 		if (user.getPassword().contentEquals(dbPassword))
		 			result=1;
		 	}catch(NullPointerException e){
		 		connect.close();
			 	System.out.println("Disconnected from the database");
		 		return -1;
		 	}
		 	connect.close();
		 	System.out.println("Disconnected from the database");
		 	return result;
		 	
		}catch (SQLException e){
			System.out.println(e.getMessage());
			return -2;
		}
		
		
	}

}
