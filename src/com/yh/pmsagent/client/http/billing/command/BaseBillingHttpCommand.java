package com.yh.pmsagent.client.http.billing.command;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

public abstract class BaseBillingHttpCommand {
	@Value("${yhagent.billing.reqstr}")
	private String req;

	@Value("${yhagent.billing.host}")
	private String host;

	@Value("${yhagent.billing.port}")
	private int port;

	@Value("${yhagent.billing.context}")
	private String contextPath;

	@Value("${yhagent.encoding}")
	private String encoding;

	@Autowired
	@Qualifier("billingclient")
	private CloseableHttpClient httpclient;

	public static Logger logger = LoggerFactory
			.getLogger(BaseBillingHttpCommand.class);

	public abstract String cmdBody();

	// CloseableHttpClient httpclient = HttpClients.createDefault();
	public String execute() {
		String result = null;
		try {

			String xmlContent = cmdBody();
			

			HttpPost httpost = new HttpPost("http://" + host + ":" + port
					+ contextPath);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair(req, xmlContent));
			httpost.setEntity(new UrlEncodedFormEntity(nvps, Charset
					.forName(encoding)));
			/*
			 * StringEntity strEntity=new StringEntity("<xml>aaaa</xml>");
			 * httpost.setEntity(strEntity);
			 */
			CloseableHttpResponse response = httpclient.execute(httpost);
			try {
				HttpEntity entity = response.getEntity();
				int statuscode=response.getStatusLine().getStatusCode();
				logger.info(xmlContent);
				if(response.getStatusLine().getStatusCode()!=200){
					logger.error(xmlContent);
					logger.error("调用计费接口异常，返回状态码为："+statuscode);
				}
				result = StringUtils.trimWhitespace(EntityUtils.toString(entity));
				logger.info(result);
				EntityUtils.consume(entity);

			} finally {
				response.close();
			}

			// httpclient.close();
		} catch (Exception e) {

			logger.error("系统调用计费接口出错");
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return result;
		/*
		 * try { xmlContent= java.net.URLEncoder.encode(xmlContent, encoding); }
		 * catch (UnsupportedEncodingException e1) { // TODO Auto-generated
		 * catch block e1.printStackTrace(); }
		 */

	}
}
