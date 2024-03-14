package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import vo.Member;

public class MemberDao {
	//Map�� �̿��� �ӽ÷� ����================================
	Map<String, String> memberMap = new HashMap<>();
	Map<String, Date> regDateMap = new HashMap<>();
	Set<String> idSet = memberMap.keySet();
	//=================================================
	
	
	public Member selectById(String id) throws SQLException {
		//=====================�ӽ� ����==============
		Date date =new Date(0);
		memberMap.put("a", "a");
		regDateMap.put("a", date);
		//==========================================
		

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
	}
	
	public List getMemoList(String userid) throws SQLException {
//		try {
			/*
			 * DB���� userid�� ���� memoid�� ������
			 */
			List<String> memoList = new ArrayList();// db���� �� ����
			memoList.add("1");// db���� �� ����
//		} catch (Exception e) {
//		}
		return memoList;
	}
}
 