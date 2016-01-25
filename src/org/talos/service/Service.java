package org.talos.service;

import java.util.ArrayList;
import javax.ws.rs.*;
import org.talos.user.*;
import org.talos.response.*;
import org.talos.data.*;
import com.sun.jersey.spi.resource.Singleton;


@Singleton

@Path("/userservice")
public class Service {
	private UserController userC = new UserController();
	private DataController dataC = new DataController();
	private DataController dataC2 = new DataController();
	//private Response resp = new Response();
	
	@Path("/signup")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response signUpUser(User user){
		int result =userC.signUpUser(user);
		Response resp = new Response();
		resp.setId(0);
		switch (result){
			case -2: 
				resp.setResponse(-2);
				resp.setText("Register Failed:Username already exists");
				return resp;
				//return "{ \"id\":0, \"response\":-2, \"text\":\"Register Failed:Username already exists\"}";
			case -1: 
				resp.setResponse(-1);
				resp.setText("Register Failed:Email already exists");
				return resp;
				//return "{ \"id\":0, \"response\":-1, \"text\":\"Register Failed:Email already exists\"}";
			case 0:
				resp.setResponse(0);
				resp.setText("Register Failed:Unknown reason");
				return resp;
				//return "{ \"id\":0, \"response\":0, \"text\":\"Register Failed:Unknown reason\"}";
			case 1:
				resp.setResponse(1);
				resp.setText("Register Succeed");
				//return "{ \"id\":0, \"response\":1, \"text\":\"Register Succeed\"}";
			default : 
				resp.setResponse(0);
				resp.setText("Register Failed:Unknown reason");
				return resp;
				//return "{ \"id\":0, \"response\":0, \"text\":\"Register Failed:Unknown reason\"}";
		}
	}
	
	@Path("/signin")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response signInUser(User user){
		int result=userC.signInUser(user);
		Response resp = new Response();
		resp.setId(1);
		switch (result){
			case -2:
				resp.setResponse(-2);
				resp.setText("Login Failed:Reason Unknown");
				return resp;
			case -1: //wrong username
				resp.setResponse(-1);
				resp.setText("Login Failed:Wrong username or password");
				return resp;
			case 0: //wrong password
				resp.setResponse(0);
				resp.setText("Login Failed:Wrong username or password");
				return resp;
			case 1:
				resp.setResponse(1);
				resp.setText("Login Succeed");
				return resp;
			default:
				resp.setResponse(0);
				resp.setText("Login Failed:Wrong username or password");
				return resp;
		}
	}
	
	/*@Path("/data")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertData(Data data){
		int result=dataC.insertData(data);
		Response resp = new Response();
		resp.setId(2);
		switch (result){
			case -1: //duplicate entry
				resp.setResponse(-1);
				resp.setText("Operation Failed: Duplicate Entry");
				return resp;
			case 0: //unknown
				resp.setResponse(0);
				resp.setText("Operation Failed: Reason Unknown");
				return resp;
			case 1: //success
				resp.setResponse(1);
				resp.setText("Upload Succeed");
				return resp;
			default:
				resp.setResponse(0);
				resp.setText("Operation Failed: Reason Unknown");
				return resp;
		}
	}*/
	
	@Path("/datas")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertDatas(Data[] data){
		int result =2;
		int counter=0;
		int length=data.length;
		System.out.println("Size of list:"+length);
		//for (counter=0;counter>length;counter++){
		//	result=dataC.insertData(data[counter]);
		//}
		result = dataC.insertData(data);
		
		Response resp = new Response();
		resp.setId(2);
		switch (result){
			case -1: //duplicate entry
				resp.setResponse(-1);
				resp.setText("Operation Failed: Duplicate Entry");
				return resp;
			case 0: //unknown
				resp.setResponse(0);
				resp.setText("Operation Failed: Reason Unknown");
				return resp;
			case 1: //success
				resp.setResponse(1);
				resp.setText("Upload Succeed");
				return resp;
			default:
				resp.setResponse(0);
				resp.setText("Operation Failed: Reason Unknown");
				return resp;
		}
	}
	
	@Path("/getData")
	@GET
	@Produces("application/json")
	public ArrayList<Data> getData(){
		return dataC.getDataList();
		
	}
}