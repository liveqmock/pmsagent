package com.yh.pmsagent.server.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yh.pmsagent.server.job.db.DemondBill;
import com.yh.pmsagent.server.job.db.IJobDao;

@Component
public class Cron {
	Logger logger=LoggerFactory.getLogger(Cron.class);
	@Autowired 
	private IJobDao jobDao;
	@Scheduled(cron = "${dbtask.cron.delete}")
	public void deleteAllDone() {
		logger.info("删除任务启动。。。。");
		int result=jobDao.deleteAllDoneCommand();
		logger.info("删除任务结束。。");
	}
	@Scheduled(cron = "${dbtask.cron.scan}")
	public void mockCommand(){
		logger.info("抛账任务启动。。。。");
		 List<DemondBill> bills=jobDao.mockQueryCommand();
		 if(bills!=null){
			 for(DemondBill bill:bills){
				boolean result= jobDao.insertCommand(bill);
				if(result){
					jobDao.mockUpdateCommand(bill);
				} 
			 }
		 }
		 if(bills!=null){
			 logger.info("本次抛出"+bills.size()+"条账"); 
		 }
		 else{
			 logger.info("本次抛出0条账"); 
		 }
		
	}
}
