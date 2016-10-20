package org.talos.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.talos.operations.StoreDataOperation;
import org.talos.operations.RegisterUserOperation;
import org.talos.po.Data;
import org.talos.po.User;
import org.talos.ws.beans.DataBean;
import org.talos.ws.beans.Response;
import org.talos.ws.beans.UserBean;

import com.sun.jersey.spi.resource.Singleton;


/**
 * Main Web Service Class
 */
@Singleton
@Path("/userservice")
public class Service {
	
	
	/**
	 * {@link RegisterUserOperation}
	 */
	RegisterUserOperation storeUserOp = new RegisterUserOperation();
	
	/**
	 * {@link StoreDataOperation}
	 */
	StoreDataOperation storeDataOp = new StoreDataOperation();
	
	/**
	 * Registers a {@link User}
	 * 
	 * @param userBean
	 * @return a {@link Response}
	 */
	@Path("/registeruser")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response registerUser(UserBean userBean){
		return storeUserOp.execute(userBean);
	}
	
	/**
	 * Upload {@link Data}
	 * 
	 * @param dataTable
	 * @return a {@link Response}
	 */
	@Path("/datas")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response uploadDatas(DataBean[] dataTable){
		int length=dataTable.length;
		System.out.println("Size of list:"+length);
		return storeDataOp.execute(dataTable);
	}
}