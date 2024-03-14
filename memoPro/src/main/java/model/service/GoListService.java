package model.service;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.MemberDao;

public class GoListService {
	private MemberDao memberDao = new MemberDao();
	
	public List<String> bringList(String userid) {
		try {
			List<String> memoList = memberDao.getMemoList(userid);
				memoList.sort(new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						return Integer.compare(o2.length(), o1.length());
					}
				});
			return memoList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
