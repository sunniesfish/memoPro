package vo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.ValueExp;

import model.LineDao;

public class Memo {
	
	private String userid;
	private String memoid;
	private Line line;
	
	private LineDao lineDao = new LineDao();
	private HashMap<String,Line> lineMap = new HashMap();
	
	
	public Memo(String userid) throws SQLException {
		this.userid=userid;
		setMemoid();
		String lineid = lineDao.newLine(new Line(memoid));
		this.line = lineDao.selectByLineId(memoid, lineid);
	}
	
	public Memo(String userid, String memoid, String lineid) throws SQLException {
		this.userid = userid;
		this.memoid = memoid;
		this.line = lineDao.selectByLineId(memoid, lineid);
	}
	

	public String getMemoid() {
		return memoid;
	}
	public void setMemoid() {
		long now = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		this.memoid = sdf.format(new Date(now)).toString();
	}
	
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	

	public HashMap getLineMap() {
		return lineMap;
	}
	
	
	public void setLineMap() {
		lineMap.put(line.getLineid(), line);
	}
	
}
