package model.service;

import java.sql.SQLException;

import model.MemoDao;
import vo.Memo;

/*========================================================
 * 	userid와 memoid를 받아 MemoDao에서 (userid, memoid)에 해당하는 Memo 객채 생성
 * ========================================================
 */

public class ViewService {
	
	MemoDao memoDao = new MemoDao();	
	
	public Memo view(String userid, String memoid) {
		try {
			
			Memo memo = memoDao.selectByMemoId(userid, memoid);
			return memo;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
