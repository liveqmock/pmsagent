package com.yh.pmsagent.server.job.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class JobDao implements IJobDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Autowired
	private DataSourceTransactionManager dsTxManager;
	public static final String MockQuery = "select * from vodbill where state=1";
	public static final String MockUpdate = "update vodbill set state=2 where roomnumber=?";
	public static final String DELETEDONE = "delete from  commands where status = ? and commandtype=4";
	public static final String INSERTCOMMAND = "insert into commands (commandtype,roomnumber,status,mark) values(?,?,?,?) ";
	public static final String INSERTBILL = "insert into demondbill(roomnumber,demondstarttime,demondendtime,demondfee,demondcost,filmname) values(?,?,?,?,?,?)";

	@Override
	public int deleteAllDoneCommand() {
		 return jdbcTemplate.update(DELETEDONE, new Object[] { "2" });
	}

	@Override
	public boolean insertCommand(final DemondBill bill) {
		boolean result = false;
		TransactionTemplate tt = new TransactionTemplate(dsTxManager);
		result = tt.execute(new TransactionCallback<Boolean>() {
			public Boolean doInTransaction(TransactionStatus status) {
				jdbcTemplate.update(INSERTCOMMAND,
						new PreparedStatementSetter() {
							public void setValues(PreparedStatement ps)
									throws SQLException {
								ps.setString(1, "4");
								ps.setString(2, bill.getRoomnumber());
								ps.setString(3, "1");
								ps.setString(4, "vod");
							}
						});
				jdbcTemplate.update(INSERTBILL, new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, bill.getRoomnumber());
						ps.setString(2, bill.getDemondstarttime());
						ps.setString(3, bill.getDemondendtime());
						ps.setString(4, bill.getDemondfee());
						ps.setString(5, bill.getDemondcost());
						ps.setString(6, bill.getFilmname());
					}
				});

				return Boolean.TRUE;
			}
		});

		return result;
	}

	@Override
	public List<DemondBill> mockQueryCommand() {
		List<DemondBill> list = jdbcTemplate.query(MockQuery,
				new RowMapper<DemondBill>() {
					@Override
					public DemondBill mapRow(ResultSet rs, int arg1)
							throws SQLException {
						DemondBill demondBill = new DemondBill();
						demondBill.setRoomnumber(rs.getString("roomnumber"));
						demondBill.setDemondendtime(rs
								.getString("demondendtime"));
						demondBill.setDemondstarttime(rs
								.getString("demondstarttime"));
						demondBill.setDemondfee(rs.getString("demondfee"));
						demondBill.setDemondcost(rs.getString("demondcost"));
						demondBill.setFilmname(rs.getString("filmname"));
						return demondBill;
					}

				});
		return list;

	}

	@Override
	public void mockUpdateCommand(final DemondBill bill) {
		jdbcTemplate.update(MockUpdate, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bill.getRoomnumber());
			}
		});

	}

}
