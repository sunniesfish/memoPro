package vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.ValueExp;

import model.LineDao;

public class Memo {
	
	private String memoid;
	private HashMap<String,Line> lineMap = new HashMap();
	
	private LineDao lineDao = new LineDao();
	
	
	public Memo(String memoid) {
		this.memoid = memoid;
		setLineMap(memoid);
	}
	

	public String getMemoid() {
		return memoid;
	}
	public void setMemoid() {
		long now = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		this.memoid = sdf.format(new Date(now)).toString();
	}
	

	public HashMap getLineMap() {
		return lineMap;
	}
	
	public void setLineMap(String memoid) {
		
		System.out.println("Memo - setLineMap() invoked======================");
		
		
		//line에 대해 hasNext 문 이용해서 lineSet에 line할당
		// lineDao.SelectByLineId(memoid, iter값 ); 을 사용
		//////////////
		//=========================
		HashSet lineSet = new HashSet();
		lineSet.add(new Line(memoid, "content(임시)"));
		
		Iterator lineIter = lineSet.iterator();
		
		for (Object l : lineSet) {
			Line line = (Line) l;
			lineMap.put(line.getLineid(),line);
			System.out.println("memoid : "+line.getMemoid());////////////////////////////////////
			System.out.println("lineid : "+line.getLineid());//////////////////////////////////////////
			System.out.println( "linecontent : "+line.getContent() );////////////////////////////////
		}
		
		System.out.println("setLineMap method end======================");
	}
	
}
