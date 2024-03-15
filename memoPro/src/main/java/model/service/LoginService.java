package model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import connection.ConnectionProvider;
import model.MemberDao;
import vo.Member;
import vo.User;

public class LoginService {  //¿Ï¼º
	
	private MemberDao memberDao = new MemberDao();
	
	public User login(String id, String password) {
		try (Connection conn =ConnectionProvider.getConnection()){
			Member member = memberDao.selectById(conn,id);
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
