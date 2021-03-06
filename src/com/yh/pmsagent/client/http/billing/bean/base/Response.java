package com.yh.pmsagent.client.http.billing.bean.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.yh.pmsagent.client.http.billing.bean.ResultInfo;

@XmlRootElement(name = "Result")
public abstract class Response {
	public ResultInfo ResultInfo;

	public Service Service;

	@XmlElement(name = "ResultData")
	public abstract ResponseResult getResponseResult();
	
}
