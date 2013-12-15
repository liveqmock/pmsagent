package com.yh.pmsagent.client.http.billing.bean.responseresult;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.yh.pmsagent.client.http.billing.bean.Program;
import com.yh.pmsagent.client.http.billing.bean.ResultInfo;
import com.yh.pmsagent.client.http.billing.bean.base.Service;
@XmlRootElement(name="Result")
public class GetProgramPriceResponseResult {
	private ResultInfo resultInfo;
	 private Service service;
	 private List<Program> programList;
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
	@XmlElementWrapper(name = "ResultData")
	@XmlElement(name = "Program")
	 
	public List<Program> getProgramList() {
		return programList;
	}
	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}
}
