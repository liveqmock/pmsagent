package com.yh.pmsagent.test.bootstrap.billing;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import com.yh.pmsagent.client.http.billing.bean.requestinfo.GetProgramListRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.responseresult.GetProgramListResponseResult;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProgramList  extends Base{
	@Test
	public void test1(){
		// test getProgramList
		 
			GetProgramListRequestInfo requestInfo = new GetProgramListRequestInfo();
			GetProgramListResponseResult result=invoker.getProgramList(requestInfo);
			Assert.assertEquals(result.getService().getBusiness(), "VOD");
	}
}
