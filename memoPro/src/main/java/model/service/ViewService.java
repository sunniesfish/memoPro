package model.service;

import java.sql.SQLException;

import model.MemoDao;
import vo.Memo;

/*========================================================
 * 	userid�� memoid�� �޾� MemoDao���� (userid, memoid)�� �ش��ϴ� Memo ��ä ����
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
