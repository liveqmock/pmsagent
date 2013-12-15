package com.yh.pmsagent.client.http.billing.bean.responseresult;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.yh.pmsagent.client.http.billing.bean.Program;
import com.yh.pmsagent.client.http.billing.bean.ResultInfo;
import com.yh.pmsagent.client.http.billing.bean.base.Service;
@XmlRootElement(name="Result")
public class GetProgramListResponseResult/* extends  ResponseResult*/{
 
	private ResultData resultData;
	private ResultInfo resultInfo;
	 private Service service;
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
		private List<Program> programs;
		@XmlElementWrapper(name = "Programs")
		@XmlElement(name = "Program")
		public List<Program> getPrograms() {
			return programs;
		}
		public void setPrograms(List<Program> programs) {
			this.programs = programs;
		}
	}
	@XmlElement(name="ResultData")
	public ResultData getResultData() {
		return resultData;
	}
	public void setResultData(ResultData resultData) {
		this.resultData = resultData;
	}
}
