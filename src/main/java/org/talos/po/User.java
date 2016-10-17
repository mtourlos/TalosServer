package org.talos.po;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	String email;
	String firstName;
	String lastName;
	Date connectedDate;
	Long points; 
	Set<Data> datas;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getConnectedDate(){
		return connectedDate;
	}
	public void setConnectedDate(Date connectedDate){
		this.connectedDate = connectedDate;
	}
	public Long getPoints(){
		return points;
	}
	public void setPoints(Long points){
		this.points = points;
	}
	public Set<Data> getDatas(){
		return datas;
	}
	public void setDatas(Set<Data> datas){
		this.datas = datas;
	}
}

