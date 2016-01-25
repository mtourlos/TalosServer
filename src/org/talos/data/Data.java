package org.talos.data;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data implements Serializable {
	private String timestamp;
	private String user;
	private String operator;
	private int cinr;
	private float latitude;
	private float longtitude;
	
	
	public Data() {
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
