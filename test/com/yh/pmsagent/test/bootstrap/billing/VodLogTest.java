package com.yh.pmsagent.test.bootstrap.billing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import com.yh.pmsagent.client.http.billing.bean.Occupancy;
import com.yh.pmsagent.client.http.billing.bean.VodLog;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.AddVodLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.ListVodLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.responseresult.AddVodLogResponseResult;
import com.yh.pmsagent.client.http.billing.bean.responseresult.ListVodLogResponseResult;
import com.yh.pmsagent.client.http.billing.db.PmsDao;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VodLogTest  extends Base{
	@Test
	 
	public void test1(){
		PmsDao pmsDao=context.getBean(PmsDao.class);
		List<VodLog> vodLogs =pmsDao.getVodLogs("22");
		AddVodLogRequestInfo requestInfo = new AddVodLogRequestInfo();
		/*List<VodLog> vodLogs = new ArrayList<VodLog>();
		VodLog vodLog = new VodLog();
		vodLog.setLogId("13991");
		vodLog.setHotelCode("2");
		vodLog.setRoomNumber("10");
		vodLog.setVodClientId("34-40-B5-8D-82-B5");
		vodLog.setProgramId("12");
		vodLog.setStartTime("1386315697");
		vodLog.setEndTime("1386316179");
		vodLog.setTotalTime("482");
		vodLog.setPolicyType("0");
		vodLogs.add(vodLog);
		VodLog vodLog1= new VodLog();
		vodLog1.setLogId("13990");
		vodLog1.setHotelCode("2");
		vodLog1.setRoomNumber("10");
		vodLog1.setVodClientId("34-40-B5-8D-82-B5");
		vodLog1.setProgramId("13");
		vodLog1.setStartTime("1386310000");
		vodLog1.setEndTime("1386310482");
		vodLog1.setTotalTime("482");
		vodLog1.setPolicyType("0");
		vodLogs.add(vodLog1);
		 */
		requestInfo.setVodLogs(vodLogs);
	
		AddVodLogResponseResult result= invoker.addVodLog(requestInfo);
		pmsDao.updateVodLog(vodLogs);
		Assert.assertEquals(result.getService().getBusiness(), "VOD");
	}
	@Test
	@Ignore
	public void test2(){
		ListVodLogRequestInfo requestInfo = new ListVodLogRequestInfo();
		requestInfo.HotelCode = "2";
		requestInfo.RoomNumber = "10";
		requestInfo.PolicyType = "0";

		List<Occupancy> occupancies = new ArrayList<Occupancy>();
		Occupancy occupancy = new Occupancy();
		occupancy.RoomNumber = "10";
		occupancy.StartTime = "1386315697";
		occupancy.EndTime ="1386316179";
		occupancies.add(occupancy);
		requestInfo.Occupancies = occupancies;

		ListVodLogResponseResult result=invoker.listVodLog(requestInfo); 
		Assert.assertEquals(result.getService().getBusiness(), "VOD");
	}
}
