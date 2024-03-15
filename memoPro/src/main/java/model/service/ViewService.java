package model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import connection.ConnectionProvider;
import model.MemoDao;
import vo.Memo;

/*========================================================
 * 	userid�� memoid�� �޾� MemoDao���� (userid, memoid)�� �ش��ϴ� Memo ��ä ����
 * ========================================================
 */

public class ViewService {
	
	MemoDao memoDao = new MemoDao();	
	
	public Memo view(String userid, String memoid) {
		try (Connection conn = ConnectionProvider.getConnection()){
			Memo memo = null;
			if (memoid==null || memoid.equals("")) { //-------------------�� �޸� �����ϴ� ���
				memoid = memoDao.newMemo(conn, userid,new Memo(userid));
			}	
			
			memo = memoDao.selectByMemoId(conn, userid, memoid);
			return memo;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
