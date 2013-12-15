package com.yh.pmsagent.client.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test {
 public static void main(String []args) throws Exception{
	 CloseableHttpClient httpclient = HttpClients.createDefault();
	  HttpPost httpost = new HttpPost("http://www.baidu.com");
   /*  List <NameValuePair> nvps = new ArrayList <NameValuePair>();
     nvps.add(new BasicNameValuePair("test", "a"));
     nvps.add(new BasicNameValuePair("test1", "b"));*/
     
   /*  httpost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("GBK")));*/
     StringEntity strEntity=new StringEntity("<xml>aaaa</xml>");
     httpost.setEntity(strEntity);
     CloseableHttpResponse response2 = httpclient.execute(httpost);
     try {
         HttpEntity entity = response2.getEntity();

         System.out.println("Login form get: " + response2.getStatusLine());
         EntityUtils.consume(entity);

       
        
     } finally {
         response2.close();
     }
  
     httpclient.close();

 }
}
