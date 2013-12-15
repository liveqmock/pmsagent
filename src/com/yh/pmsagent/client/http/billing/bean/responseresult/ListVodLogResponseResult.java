package com.yh.pmsagent.client.http.billing.bean.responseresult;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.yh.pmsagent.client.http.billing.bean.ResultInfo;
import com.yh.pmsagent.client.http.billing.bean.VodLog;
import com.yh.pmsagent.client.http.billing.bean.base.Service;
@XmlRootElement(name="Result")
public class ListVodLogResponseResult/* extends ResponseResult*/{
	 private ResultInfo resultInfo;
	 private Service service;
	 private ResultData resultData;
	 @XmlElement(name="ResultData")
	 public ResultData getResultData() {
		return resultData;
	}
	public void setResultData(ResultData resultData) {
		this.resultData = resultData;
	}
	@XmlElement(name="ResultInfo")
	public ResultInfo getResultInfo() {
		return resultInfo;
	}
	public void setResultInfo(ResultInfo resultInfo) {
		this.resultInfo = resultInfo;
	}
	@XmlElement(name="Service")
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	 static class ResultData{
		 public String StartTime;
		 public String EndTime;
		 public String TotalFee;
		 public String PolicyType;
		 @XmlElementWrapper(name="VodLogs")
		 @XmlElement(name="Log")
		 public List<VodLog> vodLogs; 
	 }
	
}
