package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//===========================DB연동필요========
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jdbc.JdbcUtil;
import vo.Line;
import vo.Memo;

public class MemoDao {
	
	private LineDao lineDao = new LineDao();
	
	public Memo selectByMemoId(Connection conn,String userid, String memoid) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from memo where id=? and memoid=?");
			pstmt.setString(1, userid);
			pstmt.setString(2, memoid);
			rs = pstmt.executeQuery();
			Memo memo = null;
			if (rs.next()) {
				String lineid = rs.getString("lineid");
				if (lineid==null) {
					Line line = new Line(memoid);
					memo = new Memo(userid, memoid, line.getLineid());
				} else {
					memo = new Memo(userid, memoid, lineid);
				}
			}
			return memo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public String newMemo(Connection conn,String id, Memo memo) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String memoid = memo.getMemoid();
		try {
			pstmt = conn.prepareStatement(
					"insert into memo"+
							"(id, memoid)"+
							"values (?,?)"
					);
			pstmt.setString(1, id);
			pstmt.setString(2, memoid);
			pstmt.executeUpdate(); //반영된 행 갯수;
			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
