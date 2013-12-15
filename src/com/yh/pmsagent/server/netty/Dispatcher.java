package com.yh.pmsagent.server.netty;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.yh.pmsagent.client.http.billing.bean.ResultInfo;
import com.yh.pmsagent.client.http.billing.bean.base.ResponseResult;
import com.yh.pmsagent.common.util.XmlHelper;
import com.yh.pmsagent.server.job.db.DemondBill;
import com.yh.pmsagent.server.job.db.IJobDao;
 

@Service
public class Dispatcher {
	public static final String defaultResult="<?xml version='1.0' encoding='UTF-8'?><Result> <ResultInfo resultcode='-1' errormessage='没有响应' /></Result>";
	@Autowired
	private IJobDao jobDao;
	 
	//返回结果 为xml样式
	public   String dispatch(String command){
		String function=findServiceFunction(command);
		String business=findServiceBusiness(command);
		if("TIMESHIFT".equals(business)){
			 
		}else if("VOD".equals(business)){
			 
		}else if("BILLING".equals(business)){
			if("addDemondBill".equals(function)){
				String billNode=XmlHelper.getNode(command,"DemondBill");
				DemondBill bill=XmlHelper.genType(billNode, DemondBill.class);
			 boolean exeResult=	jobDao.insertCommand(bill);
			 return getResult(exeResult,"BILLING","addDemondBill");
			}
		}
		return defaultResult;
	}
	 
	private static String findServiceAttr(String content,String attr){
		 
		    InputSource source = new InputSource(new StringReader(content));
		    XPath xPath = XPathFactory.newInstance().newXPath();
		    NodeList list = null;
		    try {
		        list = (NodeList) xPath.evaluate("/Request/Service/@"+attr, source,
		                XPathConstants.NODESET);
		    } catch (Exception ex) {
		        System.out.println(ex.getMessage());
		    }
		    if (list.getLength()>0) {
		        return list.item(0).getTextContent();
		    }
		    return null;
		}
		private  static String findServiceFunction(String content){
			return findServiceAttr(content,"function");
		}
		private  static String findServiceBusiness(String content){
			return findServiceAttr(content,"business");
		}
		private   String getResult(boolean resultcode,String business,String function){
			ResponseResult result=new ResponseResult();
			ResultInfo resultInfo=new ResultInfo();
			resultInfo.setErrormessage("");
			if(resultcode){
				resultInfo.setResultcode("200");	
				resultInfo.setErrormessage("成功");	
			}
			else {
				resultInfo.setResultcode("-999");
				resultInfo.setErrormessage("执行出错");
			}
			
			com.yh.pmsagent.client.http.billing.bean.base.Service service=new com.yh.pmsagent.client.http.billing.bean.base.Service();
			service.setBusiness(business);
			service.setFunction(function);
			result.setResultInfo(resultInfo);
			result.setService(service);
			return XmlHelper.genXmlStr(result);
		}
}
