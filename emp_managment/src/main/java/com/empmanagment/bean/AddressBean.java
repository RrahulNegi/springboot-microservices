package com.empmanagment.bean;

public class AddressBean {
private int adddressId;
private String city;
private String state;
public int getAdddressId() {
	return adddressId;
}
public void setAdddressId(int adddressId) {
	this.adddressId = adddressId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public AddressBean(int adddressId, String city, String state) {
	super();
	this.adddressId = adddressId;
	this.city = city;
	this.state = state;
}


}
