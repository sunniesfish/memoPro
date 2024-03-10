package vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
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
		
		
		Set lineSet = new HashSet();
		
		//line�� ���� hasNext �� �̿��ؼ� lineSet�� line�Ҵ�
		// lineDao.SelectByLineId(memoid, iter�� ); �� ���
		//////////////
		
		//=========================
		lineSet.add(new Line(memoid, "lineid(�ӽ�)", "content(�ӽ�)"));
		//=========================
	}
	
}
