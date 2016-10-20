package org.talos.operations;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.talos.po.Data;
import org.talos.po.User;
import org.talos.utils.HibernateUtil;
import org.talos.ws.beans.DataBean;
import org.talos.ws.beans.Response;

/**
 * Stores the {@link Data} for a {@link User}.
 * Receives as an input a {@link DataBean}.
 * Also respects {@link User}'s points 
 */
public class StoreDataOperation {
	
	/**
	 * Service id
	 */
	private final int SERVICE_ID = 2;
	
	/**
	 * Points will be added for every data
	 */
	private final Long DATA_MULTIPLIER = 1L;
	
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
	 * @param dataTable
	 * @return a {@link Response}
	 */
	public Response execute(DataBean[] dataTable){
		initHibernate(); 
		try{
			for (int c = 0; c < dataTable.length; c++) {
				User u = loadUser(dataTable[c]);
				if (u == null)
					return Response.getFailResponse(SERVICE_ID);
				u.getDatas().add(transformDataBeanToPo(dataTable[c]));
				u.setPoints(u.getPoints() + DATA_MULTIPLIER);
				session.save(u);
			}
			transaction.commit();
			System.out.println("*** Data uploaded from:" + dataTable[0].getUser());
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
	 * Loads the {@link User}
	 * @param bean
	 * @return a {@link User}
	 */
	User loadUser(DataBean bean){
		try {
			return (User) session.load(User.class, bean.getUser());
		} catch (ObjectNotFoundException e) {
			return null;
		}
	}
	
	
	/**
	 * Transforms a {@link DataBean} to {@link Data} persistent object
	 * @param bean
	 * @return a {@link Data} persistent object
	 * @throws ParseException
	 */
	Data transformDataBeanToPo(DataBean bean) throws ParseException{
		Data d = new Data();
		d.setCinr(bean.getCinr());
		d.setLatitude(bean.getLatitude());
		d.setLongitude(bean.getLongitude());
		d.setNetworkType(bean.getNetworkType());
		d.setOperator(bean.getOperator());
		d.setEmail(bean.getUser());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		d.setTimestamp(formatter.parse(bean.getTimestamp()));
		return d;
	}
}

