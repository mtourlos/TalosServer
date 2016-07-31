package org.talos.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;
import org.talos.po.Data;
import org.talos.utils.HibernateUtil;

public class QuickTest {

	@Test
	public void main() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Data d = new Data();
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
	public void test() throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formatter.parse("2016-05-18 22:45:44"));
	}

} 	