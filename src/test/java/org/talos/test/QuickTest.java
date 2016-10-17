package org.talos.test;


import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.json.JSONObject;
import org.junit.Test;
import org.talos.po.Data;
import org.talos.po.User;
import org.talos.utils.HibernateUtil;
import org.talos.utils.SqlUtil;
import org.talos.ws.beans.DataBean;

public class QuickTest {

	@Test
	public void main() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Data d = new Data();
		d.setEmail("sdafadf");
		d.setCinr(1);
 		d.setLatitude(3f);
		d.setLongitude(4f);
		d.setOperator("COMOSTE");
		d.setTimestamp(new Date());
		d.setNetworkType("LTE");
		d.setUser("user");
		session.save(d);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
	
	@Test
	public void testUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User u = new User();
		u.setEmail("michaeltourlos@gmail.com");
		u.setConnectedDate(new Date());
		u.setFirstName("Michail");
		u.setLastName("Tourlos");
		u.setPoints(1L);
		Data d = new Data();
		d.setEmail("michaeltourlos@gmail.com");
		d.setCinr(1);
 		d.setLatitude(3f);
		d.setLongitude(4f);
		d.setOperator("COMOSTE");
		d.setTimestamp(new Date());
		d.setNetworkType("LTE");
		d.setUser("user");
		u.setDatas(new HashSet<Data>());
		u.getDatas().add(d);
		session.save(u);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
	
	@Test
	public void testRead(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User u = new User();
		u.setEmail("michaeltourlos@gmail.com");
		u = (User) session.load(User.class, "michaeltourlos@gmail.com");
		System.out.println(u.getDatas().size());
		System.out.println(u.getFirstName());
	}
	
//	@Test
	public void test() throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formatter.parse("2016-05-18 22:45:44"));
	}
	
//	@Test
	public void testSql() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		SqlUtil sql = new SqlUtil();
		Set<Data> results = sql.fetchData();
		for (Data d :results){
			System.out.println(d.getId());
		}
		JSONObject j = new JSONObject();
		j.put("datas", results);
		System.out.println(String.valueOf(j));
			
	}
	
	@Test
	public void testReflection(){
		DataBean data = new DataBean();
		for (Field f : data.getClass().getDeclaredFields()){
            f.setAccessible(true);
            System.out.println("***"+f.getName());
            try {
				if (f.get(data) == null) {
				    System.out.println(true);
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        System.out.println(false);
	}

} 	