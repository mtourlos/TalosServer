package org.talos.data;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private String timeStamp;
	private String user;
	private String operator;
	private String networkType;
	private int cinr;
	private float latitude;
	private float longtitude;
	
	
	public Data() {
		super();
	}
	public String getTimestamp() {
		return timeStamp;
	}
	public void setTimestamp(String timeStamp) {
		this.timeStamp = timeStamp;
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
	public float getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}
	

}
