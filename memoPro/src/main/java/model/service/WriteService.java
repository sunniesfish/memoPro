package model.service;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionProvider;
import jdbc.JdbcUtil;
import model.LineDao;

public class WriteService {
	
	LineDao lineDao = new LineDao();
	
	public void write(WriteRequest writeReq) {
		
		String memoid = writeReq.getMemoid();
		String lineid = writeReq.getLineid();
		String content = writeReq.getContent();

		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			lineDao.writeLine(conn ,memoid, lineid, content);
			
			throw new SQLException();
		} catch (SQLException  e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
