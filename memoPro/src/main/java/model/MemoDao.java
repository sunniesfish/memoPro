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
		if (memoid.equals("1")) {
			memo = new Memo (userid,memoid);
			
			System.out.println("==sbm== case 1" + memo.getLine().getLineid());
		} else {
			memo = new Memo (userid);
			String lineid = memo.getLine().getLineid();
			System.out.println("userid : "+userid+" memoid : "+memo.getMemoid()+" lineid : "+lineid);
		}
		
		//========================================
		return memo;
	}
	
	public String newMemo(Memo memo) throws SQLException {
//		try {
			// Db에 메모 개체 삽입
			String memoid = memo.getMemoid();
//		}catch (Exception e) {
//		}
		return memoid;
	}
	
	
	
	
	
	
}
