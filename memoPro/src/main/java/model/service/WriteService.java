package model.service;

import java.sql.SQLException;

import model.LineDao;

public class WriteService {
	
	LineDao lineDao = new LineDao();
	
	public void write(WriteRequest writeReq) {
		
		String memoid = writeReq.getMemoid();
		String lineid = writeReq.getLineid();
		String content = writeReq.getContent();

		
		try {
			lineDao.writeLine(memoid, lineid, content);
			
			throw new SQLException();
		} catch (SQLException  e) {
			//rollback ÇÊ¿ä?
			throw new RuntimeException();
		}
		
		
	}

}
