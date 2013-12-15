package com.yh.pmsagent.client.http.billing.bean.requestinfo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.yh.pmsagent.client.http.billing.bean.VodLog;
import com.yh.pmsagent.client.http.billing.bean.base.RequestInfo;

public class AdTimeshiftLogRequestInfo extends RequestInfo{
	@XmlElementWrapper(name="ChannelLogs")
	@XmlElement(name="Log")
	public List<VodLog> vodLogs;
}
