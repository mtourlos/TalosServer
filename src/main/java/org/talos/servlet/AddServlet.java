package org.talos.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.talos.po.Data;
import org.talos.utils.HibernateUtil;

/**
 * Servlet for testing
 */
public class AddServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Data d = new Data();
		d.setCinr(1);
 		d.setLatitude(3f);
		d.setLongitude(4f);
		d.setOperator("COMOSTE");
		d.setTimestamp(new Date());
		d.setNetworkType("LTE");
		d.setEmail("user");
		session.save(d);
		session.getTransaction().commit();
		resp.setContentType("text/plain");
		resp.getWriter().write("success");
	}
	
}
