package model.service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import connection.ConnectionProvider;
import jdbc.JdbcUtil;
import model.MemberDao;
import vo.Member;

public class JoinService { //¿Ï·á
	
	private MemberDao memberDao = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, joinReq.getId());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			memberDao.insert(conn, new Member(
					joinReq.getId(),
					joinReq.getPassword(),
					new Date()
					) );
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
