package com.yh.pmsagent.test.bootstrap.billing;

import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import com.yh.pmsagent.client.http.billing.bean.requestinfo.GetProgramPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.SetProgramPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.responseresult.GetProgramPriceResponseResult;
import com.yh.pmsagent.client.http.billing.bean.responseresult.SetProgramPriceResponseResult;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProgramPrice  extends Base{

	public void test1() {
		SetProgramPriceRequestInfo requestInfo = new SetProgramPriceRequestInfo();
		requestInfo.HotelCode = "2";
		requestInfo.ProgramId = "13";
		requestInfo.ProgramPrice = "17.00";
		SetProgramPriceResponseResult result=invoker.setProgramPrice(requestInfo); 
		 
		assertNotNull(result.getResultInfo().getResultcode());
	}

	@Test
	public void test2() {
		GetProgramPriceRequestInfo requestInfo = new GetProgramPriceRequestInfo();
		requestInfo.HotelCode = "2";
		requestInfo.ProgramId = "13";
		requestInfo.PolicyType="0";
		requestInfo.RoomNumber="10";
		GetProgramPriceResponseResult result =invoker.getProgramPrice(requestInfo);
		assertNotNull(result.getResultInfo().getResultcode());
	}
}
