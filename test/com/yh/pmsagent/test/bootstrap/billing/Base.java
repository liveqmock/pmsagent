package com.yh.pmsagent.test.bootstrap.billing;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yh.pmsagent.client.http.billing.bean.base.Auth;
import com.yh.pmsagent.client.http.billing.command.BillingInvoker;
import com.yh.pmsagent.common.SpringConfiguration;

public class Base {
	static ApplicationContext context = null;

	static BillingInvoker invoker = null;
	static Logger logger=LoggerFactory .getLogger(ProgramPrice.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		invoker = context.getBean(BillingInvoker.class);
		Auth auth = new Auth();
		auth.setAuthToken("77665544");
		auth.setHotelCode("2");
		invoker.setAuth(auth);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	
}
