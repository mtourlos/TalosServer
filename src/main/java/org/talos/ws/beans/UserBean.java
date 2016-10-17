package org.talos.ws.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.talos.operations.RegisterUserOperation;

/**
 * Input for {@link RegisterUserOperation}
 */
@XmlRootElement
public class UserBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * email
	 */
	String email;
	
	/**
	 * first name 
	 */
	String firstName;
	
	/**
	 * last name 
	 */
	String lastName;
	
	/**
	 * Gets the email
	 * @return the email 
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the first name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
