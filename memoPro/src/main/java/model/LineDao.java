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
		//////�ӽ÷� ����
		if (memoid.equals("1") ) {
			line = new Line(memoid,lineid,"ContentContentContentContent");
		} else {
			line = new Line (memoid);
		}
		/////////db������ ����
		return line;
	}
	
	public String newLine(Line line) throws SQLException {
			//Db�� Line ��ü ����
		System.out.println("newline");
		String lineid = line.getLineid();
		return lineid;
	}
	
	public void writeLine(String memoid ,String lineid, String content) throws SQLException{
		try {
			/*
			 *DB�� �����Ͽ� contents�� update
			 * 
			 */
			Line line = new Line(memoid ,lineid, content);
			System.out.println("writeLine");
		}catch (Exception e) {
		}
	}
	
}
