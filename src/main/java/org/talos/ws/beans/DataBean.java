package org.talos.ws.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.talos.operations.StoreDataOperation;
import org.talos.po.Data;

/**
 * Input bean for {@link StoreDataOperation}
 */
@XmlRootElement
public class DataBean implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Timestamp
	 */
	String timestamp;
	
	/**
	 * {@link Data}'s author 
	 */
	String user;
	
	/**
	 * Operator name
	 */
	String operator;
	
	/**
	 *  Network type
	 */
	String networkType;
	
	/**
	 * Cinr 
	 */
	Integer cinr;
	
	/**
	 * Latitude 
	 */
	Float latitude;
	
	/**
	 * Longitude 
	 */
	Float longitude;
	
	/**
	 * Gets the timestamp
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * Sets the timestamp
	 * @param timestamp
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Gets the user
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	
	
	/**
	 * Sets the user
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
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
	public Float getLatitude() {
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
	public Float getLongitude() {
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
