package vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.LineDao;

public class Memo {
	
	private String memoid;
	private Set lineSet;
	
	private LineDao lineDao = new LineDao();
	
	
	public Memo(String memoid) {
		this.memoid = memoid;
		setLineSet(memoid);
	}
	

	public String getMemoid() {
		return memoid;
	}
	public void setMemoid() {
		long now = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		this.memoid = sdf.format(new Date(now)).toString();
	}
	

	public Set getLineSet() {
		return lineSet;
	}
	
	public void setLineSet(String memoid) {
		
		System.out.println("Memo - setLineSet() invoked");
		
		lineSet = new HashSet();
		
		//line에 대해 hasNext 문 이용해서 lineSet에 line할당
		// lineDao.SelectByLineId(memoid, iter값 ); 을 사용
		//////////////
		
		//=========================
		lineSet.add(new Line(memoid, "content(임시)"));
		//=========================
		Iterator lineIter = lineSet.iterator();
		while (lineIter.hasNext()) {
			Line line = (Line) lineIter.next();
			System.out.println("memoid : "+line.getMemoid());
			System.out.println("lineid : "+line.getLineid());
			System.out.println( "linecontent : "+line.getContent() );
		}
		System.out.println("============setLineSet method end");
	}
	
}
