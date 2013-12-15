package com.yh.pmsagent.client.http.billing.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.yh.pmsagent.client.http.billing.bean.base.Auth;
import com.yh.pmsagent.client.http.billing.bean.base.Service;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.AdTimeshiftLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.AddVodLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.GetProgramListRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.GetProgramPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.ListTimeshiftLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.ListVodLogRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.SetProgramPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.SetTimeshiftDayPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.requestinfo.VodDayPriceRequestInfo;
import com.yh.pmsagent.client.http.billing.bean.responseresult.AddVodLogResponseResult;
import com.yh.pmsagent.client.http.billing.bean.responseresult.GetProgramListResponseResult;
import com.yh.pmsagent.client.http.billing.bean.responseresult.GetProgramPriceResponseResult;
import com.yh.pmsagent.client.http.billing.bean.responseresult.ListVodLogResponseResult;
import com.yh.pmsagent.client.http.billing.bean.responseresult.SetProgramPriceResponseResult;
import com.yh.pmsagent.client.http.billing.bean.responseresult.VodDayPriceResponseResult;
import com.yh.pmsagent.common.util.XmlHelper;

@org.springframework.stereotype.Service
public class BillingInvoker {

	@Autowired
	private BaseBillingHttpCommandAdapter command;

	@Autowired
	private DirectXmlCommand dcommand;

	// ȡ��ӰƬ�б�ӿ�
	private Auth auth;

	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
	}

	public GetProgramListResponseResult getProgramList(GetProgramListRequestInfo requestInfo) {

		Service service = new Service();
		service.setBusiness("VOD").setFunction("getProgramList");
		String response= command.setData(requestInfo, auth, service).execute();
		GetProgramListResponseResult result = XmlHelper.genType(response,
				GetProgramListResponseResult.class);
		return result;

	}

	// ���ý�Ŀ�۸�ӿ� setProgramPrice ����
	public SetProgramPriceResponseResult setProgramPrice(
			SetProgramPriceRequestInfo requestInfo) {

		Service service = new Service();
		service.setBusiness("VOD").setFunction("setProgramPrice");
		String response = command.setData(requestInfo, auth, service).execute();
		SetProgramPriceResponseResult result = XmlHelper.genType(response,
				SetProgramPriceResponseResult.class);
		return result;
	}

	// ���õ㲥�����շѼ۸�ӿ� setVodDayPrice
	public VodDayPriceResponseResult setVodDayPrice(
			VodDayPriceRequestInfo requestInfo) {

		Service service = new Service();
		service.setBusiness("VOD").setFunction("setVodDayPrice");
		String response = command.setData(requestInfo, auth, service).execute();

		VodDayPriceResponseResult result = XmlHelper.genType(response,
				VodDayPriceResponseResult.class);
		return result;
	}

	// ȡ�ý�Ŀ�۸�ӿ� getProgramPrice
	public GetProgramPriceResponseResult getProgramPrice(
			GetProgramPriceRequestInfo requestInfo) {

		Service service = new Service();
		service.setBusiness("VOD").setFunction("getProgramPrice");
		String response = command.setData(requestInfo, auth, service).execute();
		GetProgramPriceResponseResult result = XmlHelper.genType(response,
				GetProgramPriceResponseResult.class);
		return result;
	}

	// ��ӵ㲥��־�ӿ� addVodLog
	public AddVodLogResponseResult addVodLog(AddVodLogRequestInfo requestInfo) {

		Service service = new Service();
		service.setBusiness("VOD").setFunction("addVodLog");
		String response= command.setData(requestInfo, auth, service).execute();
		AddVodLogResponseResult result = XmlHelper.genType(response,
				AddVodLogResponseResult.class);
		return result;
	}

	// ȡ��ָ������㲥��־�ӿ� listVodLog
	public ListVodLogResponseResult listVodLog(ListVodLogRequestInfo requestInfo) {

		Service service = new Service();
		service.setBusiness("VOD").setFunction("listVodLog");
		String response= command.setData(requestInfo, auth, service).execute();
		ListVodLogResponseResult result= XmlHelper.genType(response,
				ListVodLogResponseResult.class);
		return result;
	}

	// ����ʱ�ư����շѼ۸�ӿ� setTimeshiftDayPrice
	public String setTimeshiftDayPrice(
			SetTimeshiftDayPriceRequestInfo requestInfo) {

		Service service = new Service();
		service.setBusiness("TIMESHIFT").setFunction("setTimeshiftDayPrice");
		return command.setData(requestInfo, auth, service).execute();
	}

	// ���ʱ����־�ӿ� adTimeshiftLog
	public String adTimeshiftLog(AdTimeshiftLogRequestInfo requestInfo) {

		Service service = new Service();
		service.setBusiness("TIMESHIFT").setFunction("adTimeshiftLog");
		return command.setData(requestInfo, auth, service).execute();
	}

	// ȡ��ָ������ʱ����־�ӿ� listTimeshiftLog
	public String listTimeshiftLog(ListTimeshiftLogRequestInfo requestInfo) {

		Service service = new Service();
		service.setBusiness("TIMESHIFT").setFunction("listTimeshiftLog");
		return command.setData(requestInfo, auth, service).execute();
	}

	public String sendXmlDirectly(String cmdBody) {

		return dcommand.setCmdBody(cmdBody).execute();

	}

	public void releaseResource() {

	}
}
