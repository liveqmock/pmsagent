package com.yh.pmsagent.server.job.db;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
 
@XmlRootElement(name="DemondBill")
public class DemondBill {
 String roomnumber;
 //yyyyMMddHHmmss
 String demondstarttime;
//yyyyMMddHHmmss
 String demondendtime;
 String demondfee;
 String demondcost;
 String filmname;
 
 Integer demondid;
 
@XmlElement(name="demondcost")
 public String getDemondcost() {
	return demondcost;
}

public void setDemondcost(String demondcost) {
	this.demondcost = demondcost;
}
@XmlElement(name="demondendtime")
public String getDemondendtime() {
	return demondendtime;
}

public void setDemondendtime(String demondendtime) {
	this.demondendtime = demondendtime;
}
@XmlElement(name="demondfee")
public String getDemondfee() {
	return demondfee;
}

public void setDemondfee(String demondfee) {
	this.demondfee = demondfee;
}
 
public Integer getDemondid() {
	return demondid;
}

public void setDemondid(Integer demondid) {
	this.demondid = demondid;
}
@XmlElement(name="demondstarttime")
public String getDemondstarttime() {
	return demondstarttime;
}

public void setDemondstarttime(String demondstarttime) {
	this.demondstarttime = demondstarttime;
}
@XmlElement(name="filmname")
public String getFilmname() {
	return filmname;
}

public void setFilmname(String filmname) {
	this.filmname = filmname;
}
@XmlElement(name="roomnumber")
public String getRoomnumber() {
	return roomnumber;
}

public void setRoomnumber(String roomnumber) {
	this.roomnumber = roomnumber;
}

public static void main(String []args){
	 java.util.Date current=new java.util.Date();
     java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyyMMddHHmmss"); 
     String c=sdf.format(current);
     System.out.println(c); 
	 
 }
}
