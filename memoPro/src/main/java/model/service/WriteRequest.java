package model.service;

public class WriteRequest {
	private String memoid;
	private String lineid;
	private String content;
	
	public String getMemoid() {
		return memoid;
	}
	
	public String getLineid() {
		return lineid;
	}
	
	public String getContent() {
		return content;
	}
	
	
	public void setMemoid(String memoid) {
		this.memoid = memoid;
	}
	
	public void setLineid(String lineid) {
		this.lineid = lineid;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
