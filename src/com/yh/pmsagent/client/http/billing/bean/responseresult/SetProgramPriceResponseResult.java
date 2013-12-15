package com.yh.pmsagent.client.http.billing.bean.responseresult;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.yh.pmsagent.client.http.billing.bean.ResultInfo;
import com.yh.pmsagent.client.http.billing.bean.base.Service;
@XmlRootElement(name="Result")
public class SetProgramPriceResponseResult/* extends ResponseResult*/{
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
}
