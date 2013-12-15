package com.yh.pmsagent.client.http.billing.bean.requestinfo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.yh.pmsagent.client.http.billing.bean.VodLog;
import com.yh.pmsagent.client.http.billing.bean.base.RequestInfo;
 
public class AddVodLogRequestInfo extends  RequestInfo{
	
	private List<VodLog> vodLogs;
	public void setVodLogs( List<VodLog> vodLogs  ){
		this.vodLogs=vodLogs;
	}
	@XmlElementWrapper(name = "VodLogs")
	@XmlElement(name = "Log")
	public  List<VodLog> getVodLogs(){
		return vodLogs;
	}
	 
	
} 