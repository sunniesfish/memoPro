package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import vo.Line;

/*=============================
 * DB에서 memoid, lineid에 맞는 content 찾음
 * =============================
 */

public class LineDao {
	
	public Line selectByLineId(Connection conn, String memoid, String lineid) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from line where memoid=? and lineid=?");
			pstmt.setString(1, memoid);
			pstmt.setString(2, lineid);
			rs = pstmt.executeQuery();
			Line line = null;
			
			if (rs.next()) {
				String content = rs.getString("content");
				line = new Line(memoid, lineid, content);
			}
			return line;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public String newLine(Connection conn, Line line) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String memoid = line.getMemoid();
		String lineid = line.getLineid();
		String content = line.getContent();
		
		try {
			pstmt = conn.prepareStatement(
					"update line set content=? where memoid=? and lineid=?"
					);
			pstmt.setString(1, content);
			pstmt.setString(2, memoid);
			pstmt.setString(3, content);
			pstmt.executeUpdate(); //반영된 행 갯수;
			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void writeLine(String memoid ,String lineid, String content) throws SQLException{
		try {
			/*
			 *DB에 연결하여 contents를 update
			 * 
			 */
			Line line = new Line(memoid ,lineid, content);
			System.out.println("writeLine");
		}catch (Exception e) {
		}
	}
	
}
