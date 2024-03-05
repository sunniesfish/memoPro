package vo;

import java.util.Date;

public class Member {
	private String id;
	private String password;
	private Date regDate;
	
	public Member(String id, String password, Date regDate) {
		this.id = id;
		this.password=password;
		this.regDate=regDate;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Date getRegDate() {
		return regDate;
	}
	
	public boolean matchPassword(String password) {
		return password.equals(password);
	}
	
}
