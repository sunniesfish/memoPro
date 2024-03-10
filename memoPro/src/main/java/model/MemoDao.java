package model;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import vo.Memo;

public class MemoDao {

	public Memo selectByMemoId(String userid, String memoid) throws SQLException {

		Memo memo = null;
/*
		if ( db에서 userid가 'userid'이면서 memoid속성이 'memoid'인 경우 ) {
			linSet에 line 넣기
			memo = new Memo(memoid)
		}
*/		
		// 임시로 구현 ================================
		memo = new Memo ("todaysmemo");
		
		//========================================
		
		return memo;
	}
	
	public void newMemo(Memo memo) throws SQLException {
		try {
			// Db에 메모 개체 삽입
		}catch (Exception e) {
		}
	}
	
	
	
	
	
	
}
