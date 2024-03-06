package model.service;
//========================�����ʿ�
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import model.MemberDao;
import vo.Member;

public class JoinService {
	
	private MemberDao memberDao = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		try {
			Member member = memberDao.selectById(joinReq.getId());
			if (member != null) {
				// rollback�ʿ��Ѱ�?
				throw new DuplicateIdException();
			}
			
			memberDao.insert(new Member(
					joinReq.getId(),
					joinReq.getPassword(),
					new Date()
					) );
		} catch (SQLException e) {
			// rollback �ʿ��Ѱ�?
			throw new RuntimeException();
		}
		
	}
	
}
