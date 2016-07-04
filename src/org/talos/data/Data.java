package org.talos.data;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data class
 * @author michaeltourlos
 */
@XmlRootElement
public class Data implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String timestamp;
	private String user;
	private String operator;
	private String networkType;
	private int cinr;
	private float latitude;
	private float longtitude;
	
	
	public Data() {
		super();
	}
	
	public Data(String timestamp, String user, String operator, int cinr, float latitude, float longitude){
	}
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
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
	public float getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}
	

}
