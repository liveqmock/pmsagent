package com.yh.pmsagent.client.http.billing.bean.requestinfo;

import com.yh.pmsagent.client.http.billing.bean.base.RequestInfo;

public class GetProgramPriceRequestInfo extends RequestInfo{
	public String HotelCode;

	public String ProgramId;

	public String ProgramPrice;
	public String RoomNumber;
	 
	public String PolicyType ;/*—0:按片,1:免费,5:按天*/
}
