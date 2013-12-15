package com.yh.pmsagent.client.http.billing.bean.responseresult;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.yh.pmsagent.client.http.billing.bean.Occupancy;
import com.yh.pmsagent.client.http.billing.bean.base.ResponseResult;

public class ListTimeshiftLogResponseResult extends ResponseResult{
	@XmlElementWrapper(name="Occupancies")
	@XmlElement(name="Occupancy")
	public List<Occupancy> Occupancies;
}
