package model.service;
// Map<lineid, Line>�� �޾�  Map<lineid,linecontent> ��ȯ
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import vo.Line;

public class LineService {
	
	HashMap<String,String> contentsMap = new HashMap();
	
	public HashMap lineDistribute(HashMap lineMap) {
		
		for (Object entry : lineMap.entrySet()) {
			Entry<String, Line> lineEntry = (Entry<String, Line>) entry;
			String lineid = lineEntry.getKey();
			Line line = lineEntry.getValue();
			contentsMap.put(lineid, line.getContent());
			System.out.println("LineService : lineid : "+lineid);
		}
		return contentsMap;
	}
}
