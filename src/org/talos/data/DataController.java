package org.talos.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataController {
	
	String url = "jdbc:mysql://localhost:3306/";  
	String dbName = "talos";
	String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
	String password = "root";
    Connection connect = null;
	//Statement statement = null;
	//PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	private ArrayList <Data> dataList = new ArrayList<Data>();
	
	public ArrayList<Data> getDataList(){
		return (ArrayList<Data>)this.dataList;
	}
	
	public int insertData(Data[] data){
		int result=0;
		int counter=0;
		int size=data.length;
		System.out.println("inserData Method Started whith list size="+size);
		
		for (Data item:data){
			System.out.println("For loop");
			
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
			 	
			 	PreparedStatement insertData = connect.prepareStatement("INSERT INTO `DATA` (`Time_Stamp`,`User`,`Operator`,`Cinr`,`Latitude`,`Longitude`) VALUES (?,?,?,?,?,?)");
			 	
			 	insertData.setString(1, item.getTimestamp());
			 	insertData.setString(2, item.getUser());
			 	insertData.setString(3, item.getOperator());
			 	insertData.setInt(4, item.getCinr());
			 	insertData.setFloat(5, item.getLatitude());
			 	insertData.setFloat(6, item.getLongtitude());
			 	
			 	int insertUserResult=insertData.executeUpdate();
			 	if (insertUserResult>0) 
			 		System.out.println("User:"+item.getUser()+" inserted succefully new record");
			 	connect.close();
			 	System.out.println("Disconnected from the database");
			 	
			 	result = 1;
			}catch (SQLException e) {
				System.out.println( e.getMessage());
				if (e.getMessage().contains("PRIMARY")){
					result = -1;
				}else{
					result = 0;
				}
			}
		}
		return result;
	}
}

