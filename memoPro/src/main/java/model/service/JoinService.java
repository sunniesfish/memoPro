package model.service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import connection.ConnectionProvider;
import jdbc.JdbcUtil;
import model.LineDao;
import model.MemberDao;
import model.MemoDao;
import vo.Line;
import vo.Member;
import vo.Memo;

public class JoinService { //¿Ï·á
	
	private MemberDao memberDao = new MemberDao();
	private MemoDao memoDao = new MemoDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			String id = joinReq.getId();
			
			Member member = memberDao.selectById(conn, id);
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			memberDao.insert(conn, new Member(
					id,
					joinReq.getPassword(),
					new Date()
					) );
			Memo memo = new Memo (id);
			memoDao.newMemo(conn, id, memo);
			LineDao lineDao = new LineDao();
			lineDao.newLine(conn, new Line(memo.getMemoid()));
			
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
