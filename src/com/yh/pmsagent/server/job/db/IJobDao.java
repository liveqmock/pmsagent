package com.yh.pmsagent.server.job.db;

import java.util.List;

public interface IJobDao {
	public int deleteAllDoneCommand();
	public boolean insertCommand(final DemondBill bill);
	public  List<DemondBill> mockQueryCommand();
	public void mockUpdateCommand(final DemondBill bill);
}
