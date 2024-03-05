package model.service;

import model.Writer;

public class WriteRequest {
	
	private Writer writer;
	private String content;
	
	public WriteRequest(Writer writer, String content) {
		this.writer = writer;
		this.content = content;
	}
	
	public Writer getWriter() {
		return writer;
	}
	
	public String getContent() {
		return content;
	}

}
