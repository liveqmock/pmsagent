package com.yh.pmsagent.client.http.billing.db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yh.pmsagent.client.http.billing.bean.VodLog;

@Repository
public class PmsDao {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
   public List<VodLog> getVodLogs(String hotelId)  {
	   List<VodLog> results = jdbcTemplate.query(
               "select l.log_id,l.userid,l.url,l.start_time,l.end_time,l.total_time,h.room_id ,p.program_id,h.res_type,h.hotel_id"+
               " from access_log l,hotel_room h ,program_store p "+
               		  " where   l.state=0 and l.url   not like '%.xml' "+
               		  " and l.uuid=h.stb_number  and l.url=p.program_path and h.hotel_id=? limit 10" , new Object[] { hotelId },
               new RowMapper<VodLog>() {
                  
                   public VodLog mapRow(ResultSet rs, int rowNum) throws SQLException {
                       VodLog vodLog= new VodLog();
                       vodLog.setLogId(rs.getString("log_id"));
                       vodLog.setStartTime(rs.getString("start_time"));
                       vodLog.setEndTime(rs.getString("end_time"));
                       vodLog.setTotalTime(rs.getString("total_time"));
                       vodLog.setVodClientId(rs.getString("userid"));
                       vodLog.setProgramId(rs.getString("program_id"));
                       vodLog.setPolicyType(rs.getString("res_type"));
                       vodLog.setHotelCode(rs.getString("hotel_id"));
                       return vodLog;
                   }
               });

	  return results;

   }
   public List<VodLog> getShiftTimeLogs(String hotelId)  {
	   List<VodLog> results = jdbcTemplate.query(
               "select l.log_id,l.userid,l.url,l.start_time,l.end_time,l.total_time,h.room_id ,p.program_id,h.res_type,h.hotel_id "+
               " from access_log l,hotel_room h ,program_store p "+
               		  " where   l.state=0 and l.url  like '%.xml' "+
               		  " and l.uuid=h.stb_number  and l.url=p.program_path and h.hotel_id=? limit 10" , new Object[] { hotelId },
               new RowMapper<VodLog>() {
                  
                   public VodLog mapRow(ResultSet rs, int rowNum) throws SQLException {
                       VodLog vodLog= new VodLog();
                       vodLog.setLogId(rs.getString("log_id"));
                       vodLog.setStartTime(rs.getString("start_time"));
                       vodLog.setEndTime(rs.getString("end_time"));
                       vodLog.setTotalTime(rs.getString("total_time"));
                       vodLog.setVodClientId(rs.getString("userid"));
                       vodLog.setProgramId(rs.getString("program_id"));
                       vodLog.setPolicyType(rs.getString("res_type"));
                       return vodLog;
                   }
               });

	  return results;

   }
   public void updateVodLog(final List<VodLog> vodLogs){
	   if(vodLogs!=null){
		   
		   jdbcTemplate.batchUpdate("update access_log set state=1  where log_id=?", new BatchPreparedStatementSetter(){

			public int getBatchSize() {
				 return vodLogs.size();
			}

			public void setValues(PreparedStatement ps, int paramInt) throws SQLException {
				ps.setString(1, vodLogs.get(paramInt).getLogId());
				
			}
			   
		   });
		   
	   }
	 
   }
}
