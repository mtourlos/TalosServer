package org.talos.ws.beans;

import java.io.Serializable;
import java.util.Date;

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
	
	private String timestamp;
	private String user;
	private String operator;
	private String networkType;
	private int cinr;
	private float latitude;
	private float longitude;
	
	
	
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
	public int getCinr() {
		return cinr;
	}
	public void setCinr(int cinr) {
		this.cinr = cinr;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	

}
