package org.talos.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Data class
 */
public class Data implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * data id
	 */
	Integer id;
	
	/**
	 * author's id
	 */
	String email;
	
	/**
	 * timestamp of data
	 */
	Date timestamp;
	
	/**
	 * operator name 
	 */
	String operator;
	
	/**
	 * network type
	 */
	String networkType;
	
	/**
	 * cinr 
	 */
	Integer cinr;
	
	/**
	 * latitude
	 */
	Float latitude;
	
	/**
	 * longitude
	 */
	Float longitude;
	
	
	/**
	 * Gets the id
	 * @return the id 
	 */
	public Integer getId(){
		return id;
	}
	
	
	/**
	 * Sets the id
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 * Gets the author's email
	 * @return the author's email 
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * Sets the email
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
	/**
	 * Gets the timestamp
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Sets the timestamp
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Gets the operator
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * Sets the operator
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * Gets the network type
	 * @return the network type
	 */
	public String getNetworkType(){
		return networkType;
	}
	
	/**
	 * Sets the network type
	 * @param networkType
	 */
	public void setNetworkType(String networkType){
		this.networkType = networkType;
	}
	
	/**
	 * Gets the cinr
	 * @return the cinr
	 */
	public Integer getCinr() {
		return cinr;
	}
	
	/**
	 * Sets the cinr
	 * @param cinr
	 */
	public void setCinr(Integer cinr) {
		this.cinr = cinr;
	}
	
	/**
	 * Gets the latitude
	 * @return the latitude
	 */
	public float getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude
	 * @param latitude
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	/**
	 * Gets the longitude
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude
	 * @param longitude
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

}
