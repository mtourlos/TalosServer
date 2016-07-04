package org.talos.test;

import org.hibernate.Session;
import org.talos.data.Data;
import org.talos.utils.HibernateUtil;

public class QuickTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Data d = new Data();
		d.setCinr(1);
		d.setId(1);
		d.setLatitude(3f);
		d.setLongtitude(4f);
		d.setOperator("COMOSTE");
		d.setTimestamp("2016-02-02 00:00:00");
		d.setUser("user");
		session.save(d);
		session.getTransaction().commit();
	}

}
