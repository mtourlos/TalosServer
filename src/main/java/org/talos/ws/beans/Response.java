package org.talos.ws.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_MESSAGE = "Operation Succeed";
	
	private static final String FAIL_MESSAGE = "Operation Failed";
	
	int serviceId;
	boolean isOperationSuccess;
	String message;
	
	public int getServiceId() {
		return serviceId;
	}
	
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	public boolean getIsOperationSuccess(){
		return isOperationSuccess;
	}
	
	public void setIsOperationSuccess (boolean isOperationSuccess){
		this.isOperationSuccess = isOperationSuccess;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static Response getSuccessResponse(int serviceId){
		Response r = new Response();
		r.setIsOperationSuccess(true);
		r.setMessage(SUCCESS_MESSAGE);	
		r.setServiceId(serviceId);
		return r;
	}
	
	public static Response getFailResponse(int serviceId){
		Response r = new Response();
		r.setIsOperationSuccess(false);
		r.setMessage(FAIL_MESSAGE);
		r.setServiceId(serviceId);
		return r;
	}
	
}
