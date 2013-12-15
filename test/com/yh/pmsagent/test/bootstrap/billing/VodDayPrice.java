package com.yh.pmsagent.test.bootstrap.billing;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import com.yh.pmsagent.client.http.billing.bean.requestinfo.VodDayPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.responseresult.VodDayPriceResponseResult;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VodDayPrice extends Base {
	@Test
	public void testSetVodDayPrice() {
		VodDayPriceRequestInfo requestInfo = new VodDayPriceRequestInfo();
		requestInfo.HotelCode = "2";
		requestInfo.DayPrice = "200.00";
		VodDayPriceResponseResult result = invoker.setVodDayPrice(requestInfo);
		Assert.assertNotNull(result.getResultInfo().getResultcode());
		Assert.assertEquals(result.getService().getBusiness(), "VOD");
	}

}
