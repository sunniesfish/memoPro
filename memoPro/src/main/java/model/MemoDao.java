package model;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import vo.Memo;

public class MemoDao {

	public Memo selectByMemoId(String userid, String memoid) throws SQLException {

		Memo memo = null;
/*
		if ( db���� userid�� 'userid'�̸鼭 memoid�Ӽ��� 'memoid'�� ��� ) {
			linSet�� line �ֱ�
			memo = new Memo(memoid)
		}
*/		
		// �ӽ÷� ���� ================================
		memo = new Memo ("todaysmemo");
		
		//========================================
		
		return memo;
	}
	
	public void newMemo(Memo memo) throws SQLException {
		try {
			// Db�� �޸� ��ü ����
		}catch (Exception e) {
		}
	}
	
	
	
	
	
	
}
