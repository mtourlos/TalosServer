package org.talos.ws.controlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.talos.po.Data;
import org.talos.utils.HibernateUtil;
import org.talos.ws.beans.DataBean;
import org.talos.ws.beans.Response;
import org.talos.ws.service.Service;

/**
 * Main operation for {@link Data}
 */
public class DataController {
	
	
	private List<Data> dataList = new ArrayList<Data>();
	
	public List<Data> getDataList(){
		return dataList;
	}
	
	/**
	 * Saves the uploaded {@link Data} from the {@link Service} to the database
	 * @param dataTable
	 * @return a {@link Response}
	 */
	public Response uploadData(DataBean[] dataTable){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction t = session.getTransaction(); 
		try{
			for (int c = 0; c < dataTable.length; c++) {
				session.save(transformDataBeanToPo(dataTable[c]));
			}
			t.commit();
			return Response.getSuccessResponse(2);
		}catch(Exception e){
			t.rollback();
			return  Response.getFailResponse(2);
			
		}
		
	}
	
	
	/**
	 * Transforms a {@link DataBean} to {@link Data}
	 * @param bean
	 * @return
	 * @throws ParseException
	 */
	private Data transformDataBeanToPo(DataBean bean) throws ParseException{
		Data d = new Data();
		d.setCinr(bean.getCinr());
		d.setLatitude(bean.getLatitude());
		d.setLongitude(bean.getLongitude());
		d.setNetworkType(bean.getNetworkType());
		d.setOperator(bean.getOperator());
		d.setUser(bean.getUser());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		d.setTimestamp(formatter.parse(bean.getTimestamp()));
		return d;
		
	}
}

