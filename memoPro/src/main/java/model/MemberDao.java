package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import vo.Member;

//Map을 이용해 임시로 구현
public class MemberDao {
	Map<String, String> memberMap = new HashMap<>();
	Map<String, Date> regDateMap = new HashMap<>();
	Set<String> idSet = memberMap.keySet();
	
	
	public Member selectById(String id) throws SQLException {
		System.out.println(memberMap);
		System.out.println(regDateMap);
		Member member = null;
		if (idSet.contains(id)) {
			member = new Member(
					 id,
					 memberMap.get(id),
					 regDateMap.get(id)
					);
		}
		return member;
	}
	
	private Date toDate() {
		Date date = new Date(System.currentTimeMillis());
		return date;
		
	}
	
	public void insert(Member mem) throws SQLException {
		try {
			memberMap.put(mem.getId(), mem.getPassword());
			regDateMap.put(mem.getId(), toDate());
		}catch (Exception e) {
		}
		System.out.println(memberMap);
	}
}
 