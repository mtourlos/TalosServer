package org.talos.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.talos.po.User;
import org.talos.ws.beans.DataBean;
import org.talos.ws.beans.Response;
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
	public Response signUpUser(User user){
		int result =userC.signUpUser(user);
		Response resp = new Response();
		resp.setServiceId(0);
		return resp;
//		switch (result){
//			case -2: 
//				resp.setResponse(-2);
//				resp.setText("Register Failed:Username already exists");
//				return resp;
//				//return "{ \"id\":0, \"response\":-2, \"text\":\"Register Failed:Username already exists\"}";
//			case -1: 
//				resp.setResponse(-1);
//				resp.setText("Register Failed:Email already exists");
//				return resp;
//				//return "{ \"id\":0, \"response\":-1, \"text\":\"Register Failed:Email already exists\"}";
//			case 0:
//				resp.setResponse(0);
//				resp.setText("Register Failed:Unknown reason");
//				return resp;
//				//return "{ \"id\":0, \"response\":0, \"text\":\"Register Failed:Unknown reason\"}";
//			case 1:
//				resp.setResponse(1);
//				resp.setText("Register Succeed");
//				//return "{ \"id\":0, \"response\":1, \"text\":\"Register Succeed\"}";
//			default : 
//				resp.setResponse(0);
//				resp.setText("Register Failed:Unknown reason");
//				return resp;
//				//return "{ \"id\":0, \"response\":0, \"text\":\"Register Failed:Unknown reason\"}";
//		}
	}
	
	@Path("/signin")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response signInUser(User user){
		int result=userC.signInUser(user);
		Response resp = new Response();
		resp.setServiceId(1);
		return resp;
//		switch (result){
//			case -2:
//				resp.setResponse(-2);
//				resp.setText("Login Failed:Reason Unknown");
//				return resp;
//			case -1: //wrong username
//				resp.setResponse(-1);
//				resp.setText("Login Failed:Wrong username or password");
//				return resp;
//			case 0: //wrong password
//				resp.setResponse(0);
//				resp.setText("Login Failed:Wrong username or password");
//				return resp;
//			case 1:
//				resp.setResponse(1);
//				resp.setText("Login Succeed");
//				return resp;
//			default:
//				resp.setResponse(0);
//				resp.setText("Login Failed:Wrong username or password");
//				return resp;
//		}
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