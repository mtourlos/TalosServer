package org.talos.po;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * User class
 */
public class User implements Serializable {
	
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
	 * connected date 
	 */
	Date connectedDate;
	
	/**
	 * points 
	 */
	Long points;
	
	/**
	 * {@link Data} 
	 */
	Set<Data> datas;
	
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
	 * @return the first name
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
	 * @return the last name
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
	
	/**
	 * Gets the connected date
	 * @return the connected date
	 */
	public Date getConnectedDate(){
		return connectedDate;
	}
	
	/**
	 * Sets the connected date
	 * @param connectedDate
	 */
	public void setConnectedDate(Date connectedDate){
		this.connectedDate = connectedDate;
	}
	
	/**
	 * Gets the points
	 * @return the points
	 */
	public Long getPoints(){
		return points;
	}
	
	/**
	 * Sets the points
	 * @param points
	 */
	public void setPoints(Long points){
		this.points = points;
	}
	
	/**
	 * Gets the {@link Data}
	 * @return the {@link Data}
	 */
	public Set<Data> getDatas(){
		return datas;
	}
	
	/**
	 * Sets the {@link Data}
	 * @param datas
	 */
	public void setDatas(Set<Data> datas){
		this.datas = datas;
	}
}

