package model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.MemberDao;
import vo.Member;
import vo.User;

// Map을 이용해서 임시로 구현
public class LoginService {
	
	private MemberDao memberDao = new MemberDao();
	
	public User login(String id, String password) {
		try {
			Member member = memberDao.selectById(id);
			System.out.println(member.getId()); //===========================
			if(member == null) {
				throw new LoginFailException();
			}
			if(!member.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new User(member.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
