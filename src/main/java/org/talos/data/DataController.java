package org.talos.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.talos.utils.HibernateUtil;

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
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		for (int c=0 ; c<data.length; c++ ){
			session.save(data[c]);
		}
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		return 1;
	}
}

