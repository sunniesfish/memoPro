package model.service;

import java.sql.SQLException;

import model.LineDao;

public class WriteService {
	
	private LineDao lineDao = new LineDao();
	
	public void write(WriteRequest writeReq) {
		try {
			MemoContent memoContent = ContentDao.########();
			if (memoContent != null) {
				 = memoContent.getContent();
				
			} else {
				contentDao.newMemo(new MemoContent(writeReq.getContent()));
			}
		}catch (SQLException  e) {
			throw new RuntimeException();
		}
	}

}
