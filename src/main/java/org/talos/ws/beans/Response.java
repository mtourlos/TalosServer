package org.talos.ws.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bean for responding the web services
 */
@XmlRootElement
public class Response implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message for success
	 */
	private static final String SUCCESS_MESSAGE = "Operation Succeed";
	
	/**
	 * Message for failures
	 */
	private static final String FAIL_MESSAGE = "Operation Failed";
	
	/**
	 * service id
	 */
	int serviceId;
	
	/**
	 * flag for success of operation 
	 */
	boolean isOperationSuccess;
	
	/**
	 * message 
	 */
	String message;
	
	/**
	 * Gets the service id
	 * @return service id
	 */
	public int getServiceId() {
		return serviceId;
	}
	
	/**
	 * Sets the serviceId
	 * @param serviceId
	 */
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	/**
	 * Gets flag for success of operation
	 * @return flag for success of operation
	 */
	public boolean getIsOperationSuccess(){
		return isOperationSuccess;
	}
	
	/**
	 * Sets the flag for operation success
	 * @param isOperationSuccess
	 */
	public void setIsOperationSuccess (boolean isOperationSuccess){
		this.isOperationSuccess = isOperationSuccess;
	}
	
	/**
	 * Gets the message
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Gets a success {@link Response}
	 * 
	 * @param serviceId
	 * @return  a success {@link Response}
	 */
	public static Response getSuccessResponse(int serviceId){
		Response r = new Response();
		r.setIsOperationSuccess(true);
		r.setMessage(SUCCESS_MESSAGE);	
		r.setServiceId(serviceId);
		return r;
	}
	
	/**
	 * Gets a fail {@link Response}
	 * 
	 * @param serviceId
	 * @return a fail {@link Response}
	 */
	public static Response getFailResponse(int serviceId){
		Response r = new Response();
		r.setIsOperationSuccess(false);
		r.setMessage(FAIL_MESSAGE);
		r.setServiceId(serviceId);
		return r;
	}
	
}
