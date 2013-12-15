package com.yh.pmsagent.client.http.billing.bean.base;

import javax.xml.bind.annotation.XmlSeeAlso;

import com.yh.pmsagent.client.http.billing.bean.requestinfo.AdTimeshiftLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.AddVodLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.GetProgramListRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.GetProgramPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.ListTimeshiftLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.ListVodLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.SetProgramPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.SetTimeshiftDayPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.VodDayPriceRequestInfo;



@XmlSeeAlso({AddVodLogRequestInfo.class,AdTimeshiftLogRequestInfo.class,
	GetProgramListRequestInfo.class,ListTimeshiftLogRequestInfo.class,
	ListVodLogRequestInfo.class,SetProgramPriceRequestInfo.class,
	SetTimeshiftDayPriceRequestInfo.class,VodDayPriceRequestInfo.class,
	GetProgramPriceRequestInfo.class}) 
public class RequestInfo {
   
}
