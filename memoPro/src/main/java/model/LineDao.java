package model;

import java.sql.SQLException;

import vo.Line;

/*=============================
 * DB���� memoid, lineid�� �´� content ã��
 * =============================
 */

public class LineDao {
	
	public Line selectByLineId(String memoid, String lineid) throws SQLException {
		
		Line line = null;
		
/*
		if ( db���� memoid�Ӽ��� 'memoid'�̸鼭 lineid�Ӽ��� 'lineid'�� ���) {
			
			line = new Line (
				memberid,
				lineid,
				db���� �ش��ϴ� content
			)
	
 */
		return line;
	}
	
	public void newLine(Line line) throws SQLException {
		try {
			//Db�� Line ��ü ����
		} catch (Exception e) {
		}
	}
	
}
