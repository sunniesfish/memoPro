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
		return line;
	}
	
	public void newLine(Line line) throws SQLException {
		try {
			//Db에 Line 객체 삽입
		} catch (Exception e) {
		}
	}
	
}
