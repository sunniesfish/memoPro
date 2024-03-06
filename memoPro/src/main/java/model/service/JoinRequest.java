package model.service;

import java.util.Map;

public class JoinRequest {
	private String id;
	private String password;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, password, "password");
	}
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
	
}
