package command;
import java.util.HashMap;
import java.util.Map;
//================================================================����� ����
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.LineService;
import model.service.ViewService;
import vo.Line;
import vo.Memo;
import vo.User;

/*
 *  req�� memo��ü�� lineSet��ü�� ����
 */

public class ViewHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/logout.do";
	
	private ViewService viewService = new ViewService();
	private LineService lineService = new LineService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("ViewHandler proccessSubmit ȣ�� ==========================");
		
		String memoid = (String) req.getSession().getAttribute("memoid");
		User user = (User) req.getSession().getAttribute("authUser");
		
		String userid = user.getId();
		
		// line id�� �̹� �ִ� ����?
		System.out.println("memoid : "+memoid);
		System.out.println("userid : "+userid);
		
		
		
		try {
			Memo memo = viewService.view(userid, memoid);
			HashMap<String,Line> lineMap = memo.getLineMap();
			System.out.println("lineMap.isEmpty : " +lineMap.isEmpty());//////////////////////////////////
			if (lineMap.isEmpty()) {
				Line line = new Line(memoid);
				lineMap.put(line.getLineid(), line);
			}
			HashMap<String,String> contentsMap = lineService.lineDistribute(lineMap);
			
			
			
			req.setAttribute("memo", memo);
			req.setAttribute("linemap",lineMap);
			req.setAttribute("contentsmap", contentsMap);
			
			System.out.println("View Handler �Ϸ�========================");
			return "/views/screens/memoView.jsp";
		}catch (Exception e) {
			return FORM_VIEW;
		}
		
	}

}
