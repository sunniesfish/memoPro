package model;
//===========================DB연동필요========
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
		if ( db에서 userid가 'userid'이면서 memoid속성이 'memoid'인 경우 ) {
			Db에서 lineid를 가져옴
			memo = new Memo(userid, memoid, lineid)
		}
*/		
		// 임시로 구현 ================================
		memo = new Memo (userid,memoid,"samplelineid");
		//========================================
		return memo;
	}
	
	public String newMemo(Memo memo) throws SQLException {
		try {
			// Db에 메모 개체 삽입
		}catch (Exception e) {
		}
		return memo.getMemoid();
	}
	
	
	
	
	
	
}
