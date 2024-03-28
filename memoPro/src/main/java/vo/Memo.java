package vo;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.ValueExp;

import connection.ConnectionProvider;
import model.LineDao;

public class Memo {
	
	private String userid;
	private String memoid;
	private Line line;
	
	private LineDao lineDao = new LineDao();
	private HashMap<String,String> lineMap = new HashMap();
	
	
	public Memo(String userid) throws SQLException {
		this.userid=userid;
		setMemoid();
	}
	
	public Memo(String userid, String memoid) throws SQLException {
		this.userid = userid;
		this.memoid = memoid;
	}
	public Memo(String userid, String memoid, String lineid) throws SQLException {
		this.userid = userid;
		this.memoid = memoid;
		try (Connection conn = ConnectionProvider.getConnection()){
			
			this.line = lineDao.selectByLineId(conn, memoid, lineid);
		} catch (SQLException  e) {
			throw new RuntimeException(e);
		}
	}
	

	public String getMemoid() {
		return memoid;
	}
	public void setMemoid() {
		long now = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
		lineMap.put(memoid, line.getContent());
	}
	
}
