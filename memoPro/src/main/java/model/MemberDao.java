package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jdbc.JdbcUtil;
import vo.Member;

public class MemberDao {

	
	public Member selectById(Connection conn ,String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from member where mem_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if(rs.next()) {
				member = new Member (
						rs.getString("mem_id"),
						rs.getString("password"),
						toDate(rs.getTimestamp("regdate"))
						);
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} 
	}

	
	private Date toDate(Timestamp date) {
		return date == null? null: new Date(date.getTime());
	}
	
	public void insert(Connection conn ,Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into member values(?,?,?)")){
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setTimestamp(3, new Timestamp(mem.getRegDate().getTime()));
			pstmt.executeUpdate();
		}
	}
	
	public List getMemoList(String userid) throws SQLException {
//		try {
			/*
			 * DB에서 userid를 통해 memoid를 가져옴
			 */
			List<String> memoList = new ArrayList();// db연결 후 수정
			memoList.add("1");// db연결 후 수정
//		} catch (Exception e) {
//		}
		return memoList;
	}
}
 