package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Line {

	private String memoid;
	private String lineid;
	private String content;
	
	public Line(String memoid, String lineid, String content) {
		this.memoid = memoid;
		this.lineid = lineid;
		this.content = content;
	}

	public Line(String memoid) {
		this.memoid = memoid;
		this.content = "";
		setLineid();
	}
	
	public String getMemoid() {
		return memoid;
	}
	public void setMemoid(String memoid) {
		this.memoid = memoid;
	}
	
	public String getLineid() {
		return lineid;
	}
	public void setLineid() {
		long now = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.lineid = sdf.format(new Date(now)).toString();
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
