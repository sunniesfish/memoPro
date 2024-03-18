package model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import connection.ConnectionProvider;
import model.MemberDao;
import model.MemoDao;

public class GoListService {
	private MemoDao memoDao = new MemoDao();
	
	public List<String> bringList(String userid) {
		try (Connection conn=ConnectionProvider.getConnection()){
			List<String> memoList = memoDao.getMemoList(conn, userid);
			return memoList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
