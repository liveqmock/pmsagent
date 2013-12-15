package com.yh.pmsagent.test.bootstrap;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yh.pmsagent.client.http.billing.db.PmsDao;
import com.yh.pmsagent.common.SpringConfiguration;

public class SpringConfigCase extends TestCase {
	ApplicationContext context = null;

	protected void setUp() throws Exception {

		super.setUp();
		context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testApplication() {
		SpringConfiguration appliation=context.getBean(SpringConfiguration.class);
		 
	}
	public void testGetAllHotel(){
		PmsDao dao= context.getBean(PmsDao.class);
		System.out.println(dao.getVodLogs(""));
	}
	 
}
