package org.talos.ws.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data bean class
 */

@XmlRootElement
public class DataBean implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	String timestamp;
	String user;
	String operator;
	String networkType;
	Integer cinr;
	Float latitude;
	Float longitude;
	
	
	
	public DataBean() {
		super();
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getNetworkType(){
		return networkType;
	}
	public void setNetworkType(String networkType){
		this.networkType = networkType;
	}
	public Integer getCinr() {
		return cinr;
	}
	public void setCinr(Integer cinr) {
		this.cinr = cinr;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	

}
