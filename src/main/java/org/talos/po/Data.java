package org.talos.po;

import java.io.Serializable;
import java.util.Date;

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
	private Date timestamp;
	private String user;
	private String operator;
	private String networkType;
	private Integer cinr;
	private float latitude;
	private float longitude;
	
	
	public Data() {
		super();
	}
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
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
