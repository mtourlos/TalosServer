package org.talos.operations;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.talos.po.User;
import org.talos.utils.HibernateUtil;
import org.talos.ws.beans.Response;
import org.talos.ws.beans.UserBean;


/**
 * Stores a {@link User} to the database due to registration.
 */
public class RegisterUserOperation {
	
	/**
	 * Service id
	 */
	private final int SERVICE_ID = 1;
	
	/**
	 * Hibernate {@link Session}
	 */
	Session session;
	
	/**
	 * Hibernate {@link Transaction}
	 */
	Transaction transaction;
	
	
	/**
	 * Main method to call
	 */
	public Response execute(UserBean userBean){
		initHibernate();
		try{
			session.save(transformUserBeanToPo(userBean));
			transaction.commit();
			return Response.getSuccessResponse(SERVICE_ID);
		}catch(Exception e){
			transaction.rollback();
			return  Response.getFailResponse(SERVICE_ID);
			
		}
	}
	
	/**
	 * Inits the hibernate
	 */
	void initHibernate() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		transaction = session.getTransaction();
	}
	
	/**
	 * Transforms a {@link UserBean} to {@link User} persistent object
	 * @param userBean
	 * @return
	 */
	User transformUserBeanToPo(UserBean userBean){
		User u = new User();
		u.setConnectedDate(new Date());
		u.setEmail(userBean.getEmail());
		u.setFirstName(userBean.getFirstName());
		u.setLastName(userBean.getLastName());
		u.setPoints(0L);
		return u;
	}

}
