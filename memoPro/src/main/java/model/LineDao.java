package model;

import java.sql.SQLException;

import vo.Line;

/*=============================
 * DB에서 memoid, lineid에 맞는 content 찾음
 * =============================
 */

public class LineDao {
	
	public Line selectByLineId(String memoid, String lineid) throws SQLException {
		Line line = null;
/*
		if ( db에서 memoid속성이 'memoid'이면서 lineid속성이 'lineid'인 경우) {
			
			line = new Line (
				memberid,
				lineid,
				db에서 해당하는 content
			)
	
 */
		//////임시로 생성
		if (memoid.equals("1") ) {
			line = new Line(memoid,lineid,"ContentContentContentContent");
		} else {
			line = new Line (memoid);
		}
		/////////db연동시 삭제
		return line;
	}
	
	public String newLine(Line line) throws SQLException {
			//Db에 Line 객체 삽입
		System.out.println("newline");
		String lineid = line.getLineid();
		return lineid;
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
