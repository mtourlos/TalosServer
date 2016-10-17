package org.talos.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.talos.po.User;
import org.talos.ws.beans.DataBean;
import org.talos.ws.beans.Response;
import org.talos.ws.beans.UserBean;
import org.talos.ws.controlers.DataController;
import org.talos.ws.controlers.UserController;

import com.sun.jersey.spi.resource.Singleton;


@Singleton
@Path("/userservice")
public class Service {
	private UserController userC = new UserController();
	private DataController dataC = new DataController();
	
	@Path("/signup")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response signUpUser(UserBean user){
		System.out.println(user.getEmail());
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getDate().toString());
		Response resp = new Response();
		resp.setServiceId(0);
		return resp;
	}
	
	@Path("/datas")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response uploadDatas(DataBean[] dataTable){
		int length=dataTable.length;
		System.out.println("Size of list:"+length);
		return dataC.uploadData(dataTable);
	}
}