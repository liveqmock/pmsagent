package com.yh.pmsagent.client.http.billing.bean.base;

import javax.xml.bind.annotation.XmlAttribute;

public class Auth {
public Auth(String hotelCode,String authToken){
	this.hotelCode=hotelCode;
	this.authToken=authToken;
}
public Auth(){
	
}
 private String hotelCode;
 private String authToken;
 @XmlAttribute(name="authToken")
public String getAuthToken() {
	return authToken;
}
public Auth setAuthToken(String authToken) {
	this.authToken = authToken;
	return this;
}
@XmlAttribute(name="hotelCode")
public String getHotelCode() {
	return hotelCode;
}
public Auth setHotelCode(String hotelCode) {
	this.hotelCode = hotelCode;
	return this;
}
}
