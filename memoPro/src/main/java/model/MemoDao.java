package model;
//===========================DB�����ʿ�========
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import vo.Line;
import vo.Memo;

public class MemoDao {

	public Memo selectByMemoId(String userid, String memoid) throws SQLException {

		Memo memo = null;
/* 
		if ( db���� userid�� 'userid'�̸鼭 memoid�Ӽ��� 'memoid'�� ��� ) {
			Db���� lineid�� ������
			memo = new Memo(userid, memoid, lineid)
		}
*/		
		// �ӽ÷� ���� ================================
		memo = new Memo (userid,memoid,"samplelineid");
		//========================================
		return memo;
	}
	
	public String newMemo(Memo memo) throws SQLException {
		try {
			// Db�� �޸� ��ü ����
		}catch (Exception e) {
		}
		return memo.getMemoid();
	}
	
	
	
	
	
	
}
