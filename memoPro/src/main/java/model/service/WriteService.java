package model.service;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionProvider;
import jdbc.JdbcUtil;
import model.LineDao;

public class WriteService {
	
	LineDao lineDao = new LineDao();
	
	public void write(WriteRequest writeReq)  {
		
		String memoid = writeReq.getMemoid();
		String content = writeReq.getContent();
		
		int i=0;

		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			lineDao.writeLine(conn ,memoid, content);
			conn.commit();
			
		} catch (SQLException  e) {
			System.out.println(i);
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
