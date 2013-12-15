package com.yh.pmsagent.client.http.billing.command;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.yh.pmsagent.client.http.billing.bean.base.Auth;
import com.yh.pmsagent.client.http.billing.bean.base.Request;
import com.yh.pmsagent.client.http.billing.bean.base.RequestInfo;
import com.yh.pmsagent.client.http.billing.bean.base.RequestWrapper;

@Service
@Scope("prototype")
public   class BaseBillingHttpCommandAdapter  extends BaseBillingHttpCommand{
	private RequestInfo  requestInfo;
	private Auth  auth   ;
	private com.yh.pmsagent.client.http.billing.bean.base.Service  service  ;
	public BaseBillingHttpCommandAdapter setData(RequestInfo requestInfo,Auth auth,com.yh.pmsagent.client.http.billing.bean.base.Service  service){
	  this.requestInfo=requestInfo;
	  this.auth=auth;
	  this.service=service;
	 return this;
	}
 
	@Override
	public String cmdBody() {
	    Request request= RequestWrapper.genRequest(requestInfo);
	    request.Auth=auth;
	    request.Service=service;
	    return request.toXml();
	}
	 
	 
	 

}
