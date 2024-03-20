package vo;

import java.util.Date;
import java.util.List;

public class Member {
	private String id;
	private String password;
	private Date regDate;
	private List<String> memoList; //db연결 후 수정필요
	
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
	
	public List<String> getMemoList() {
		return memoList;
	}
	
	public void setMemoList(List<String> memoList) {
		this.memoList = memoList;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
}
