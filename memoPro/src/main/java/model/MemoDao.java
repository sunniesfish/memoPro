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
			// Db�� �޸� ��ü ����
			String memoid = memo.getMemoid();
//		}catch (Exception e) {
//		}
		return memoid;
	}
	
	
	
	
	
	
}
