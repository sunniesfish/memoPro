package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Line {

	private String memberid;
	private String lineid;
	private String content;
	
	public Line(String memberid, String lineid, String content) {
		this.memberid = memberid;
		this.lineid = lineid;
		this.content = content;
	}
	
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	
	public String getLineid() {
		return lineid;
	}
	public void setLineid() {
		long now = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		this.lineid = sdf.format(new Date(now)).toString();
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
