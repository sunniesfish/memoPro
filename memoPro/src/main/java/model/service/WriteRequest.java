package model.service;

public class WriteRequest {
	private String content;
	private String memoid;
	
	public String getContent() {
		return content;
	}
	public String getMemoid() {
		return memoid;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public void setMemoid(String memoid) {
		this.memoid = memoid;
	}
}
