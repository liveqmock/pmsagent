package com.yh.pmsagent.test.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yh.pmsagent.client.http.billing.bean.Occupancy;
import com.yh.pmsagent.client.http.billing.bean.VodLog;
import com.yh.pmsagent.client.http.billing.bean.base.Auth;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.AdTimeshiftLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.AddVodLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.GetProgramListRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.GetProgramPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.ListTimeshiftLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.ListVodLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.SetProgramPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.SetTimeshiftDayPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.VodDayPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.command.BillingInvoker;
import com.yh.pmsagent.common.SpringConfiguration;
@RunWith(JUnit4.class)
public class BillingTest   {
	static ApplicationContext context = null;

	static BillingInvoker invoker = null;
	@BeforeClass
	public static void setUp() throws Exception {

		context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		invoker = context.getBean(BillingInvoker.class);
		Auth auth = new Auth();
		auth.setAuthToken("1111");
		auth.setHotelCode("1");
		invoker.setAuth(auth);
	}
	@AfterClass
	public static void tearDown() throws Exception {
	}
	@Test
	public void testSetProgramPrice() {
		invoker.setProgramPrice(setProgramPrice());
		 System.out.println(2);
	}
	@Test
	@Ignore
	public void testGetProgramPrice() {
		invoker.getProgramPrice(getProgramPrice());
		 System.out.println(3);
	}
	@Test
	@Ignore
	public void testSetVodDayPrice() {
		 invoker.setVodDayPrice(setVodDayPrice());
		 System.out.println(1);
	}
	@Test
	public void testAddVodLog() {
		 invoker.addVodLog(addVodLog());//ok
	}
	public void testListVodLog() {
		invoker.listVodLog(listVodLog());
	}
	public void testListTimeshiftLog() {
		 invoker.listTimeshiftLog(listTimeshiftLog());
	}
	public void testAdTimeshiftLog() {
		 invoker.adTimeshiftLog(adTimeshiftLog());
	}
	public void testSetTimeshiftDayPrice() {
		 invoker.setTimeshiftDayPrice(setTimeshiftDayPrice());//价格不能过低
	}
	// test getProgramList
	static GetProgramListRequestInfo getProgramList() {
		GetProgramListRequestInfo requestInfo = new GetProgramListRequestInfo();
		return requestInfo;
	}

	// test setProgramPrice
	static SetProgramPriceRequestInfo setProgramPrice() {
		SetProgramPriceRequestInfo requestInfo = new SetProgramPriceRequestInfo();
		requestInfo.HotelCode = "0012";
		requestInfo.ProgramId = "12";
		requestInfo.ProgramPrice = "16.00";
		return requestInfo;
	}

	// test setVodDayPrice
	static VodDayPriceRequestInfo setVodDayPrice() {
		VodDayPriceRequestInfo requestInfo = new VodDayPriceRequestInfo();
		requestInfo.HotelCode = "YH";
		requestInfo.DayPrice = "200.00";
		return requestInfo;
	}

	// test setProgramPrice
	static GetProgramPriceRequestInfo getProgramPrice() {
		GetProgramPriceRequestInfo requestInfo = new GetProgramPriceRequestInfo();
		requestInfo.HotelCode = "0012";
		requestInfo.ProgramId = "12";
		// requestInfo.ProgramPrice = "0";
		return requestInfo;
	}

	// test setProgramPrice
	static AddVodLogRequestInfo addVodLog() {
		AddVodLogRequestInfo requestInfo = new AddVodLogRequestInfo();
		List<VodLog> vodLogs = new ArrayList<VodLog>();
		VodLog vodLog = new VodLog();
		vodLog.setLogId("1232");
		vodLog.setHotelCode("1");
		vodLog.setRoomNumber("10");
		vodLog.setVodClientId("34-40-B5-8D-82-B5");
		vodLog.setProgramId("1");
		vodLog.setStartTime("1");
		vodLog.setEndTime("200");
		vodLog.setTotalTime("199");
		vodLog.setPolicyType("0");
		vodLogs.add(vodLog);
		requestInfo.setVodLogs(vodLogs);
		return requestInfo;
	}

	// test setProgramPrice
	static ListVodLogRequestInfo listVodLog() {
		ListVodLogRequestInfo requestInfo = new ListVodLogRequestInfo();
		requestInfo.HotelCode = "1";
		requestInfo.RoomNumber = "1";
		requestInfo.PolicyType = "0";

		List<Occupancy> occupancies = new ArrayList<Occupancy>();
		Occupancy occupancy = new Occupancy();
		occupancy.RoomNumber = "10";
		occupancy.StartTime = "1";
		occupancy.EndTime = "200";
		occupancies.add(occupancy);
		requestInfo.Occupancies = occupancies;
		return requestInfo;
	}

	// test setProgramPrice
	static SetTimeshiftDayPriceRequestInfo setTimeshiftDayPrice() {
		SetTimeshiftDayPriceRequestInfo requestInfo = new SetTimeshiftDayPriceRequestInfo();
		requestInfo.HotelCode = "1";
		requestInfo.DayPrice = "600.00";
		return requestInfo;
	}

	// test setProgramPrice
	static AdTimeshiftLogRequestInfo adTimeshiftLog() {
		AdTimeshiftLogRequestInfo requestInfo = new AdTimeshiftLogRequestInfo();
		VodLog vodLog = new VodLog();
		vodLog.setHotelCode("1");
		vodLog.setRoomNumber("1");
		vodLog.setVodClientId("34-40-B5-8D-83-B6");
		vodLog.setChannelId("1");
		vodLog.setStartTime("1312983240");
		vodLog.setEndTime("1312983281");
		vodLog.setTotalTime("41");
		requestInfo.vodLogs = new ArrayList<VodLog>();
		requestInfo.vodLogs.add(vodLog);
		return requestInfo;
	}

	// test setProgramPrice
	static ListTimeshiftLogRequestInfo listTimeshiftLog() {
		ListTimeshiftLogRequestInfo requestInfo = new ListTimeshiftLogRequestInfo();
		requestInfo.HotelCode = "1";
		requestInfo.RoomNumber = "1";
		Occupancy occupancy = new Occupancy();
		occupancy.EndTime = " abc";
		occupancy.StartTime = "edf ";
		occupancy.RoomNumber = "1";
		List<Occupancy> occupancies = new ArrayList<Occupancy>();
		requestInfo.Occupancies = occupancies;
		return requestInfo;
	}

}
