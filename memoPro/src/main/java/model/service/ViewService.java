package model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import connection.ConnectionProvider;
import model.MemoDao;
import vo.Memo;

/*========================================================
 * 	userid와 memoid를 받아 MemoDao에서 (userid, memoid)에 해당하는 Memo 객채 생성
 * ========================================================
 */

public class ViewService {
	
	MemoDao memoDao = new MemoDao();	
	
	public Memo view(String userid, String memoid) {
		try (Connection conn = ConnectionProvider.getConnection()){
			Memo memo = null;
			if (memoid==null || memoid.equals("")) { //-------------------새 메모를 생성하는 경우
				memoid = memoDao.newMemo(conn, userid,new Memo(userid));
			}	
			
			memo = memoDao.selectByMemoId(conn, userid, memoid);
			return memo;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
