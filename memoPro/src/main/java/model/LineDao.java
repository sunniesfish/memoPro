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
			} else {
				line = newLine(conn, new Line(memoid, lineid,"*"));
			}
			return line;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Line newLine(Connection conn, Line line) throws SQLException {
		System.out.println("new Line =============");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		String memoid = line.getMemoid();
		String lineid = line.getLineid();
		String content = line.getContent();
		
		System.out.println("memoid : "+memoid+"  lineid : "+lineid+"  content : "+content);
		
		try {
			System.out.println("new Line try block");
			pstmt = conn.prepareStatement(
					"insert into  line values (?,?,?)"
					);
			pstmt.setString(1, memoid);
			pstmt.setString(2, lineid);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
			pstmt2 = conn.prepareStatement(
					"update memo set lineid=? where memoid=?");
			pstmt2.setString(1, lineid);
			pstmt2.setString(2, memoid);
			pstmt2.executeUpdate();
		
			return line;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void writeLine(Connection conn ,String memoid ,String lineid, String content) throws SQLException{
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement( "update line set content=? where memoid=? and lineid=?" );
			pstmt.setString(1, content);
			pstmt.setString(2, memoid);
			pstmt.setString(3, lineid);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
}
