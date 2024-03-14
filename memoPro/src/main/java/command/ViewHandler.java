package command;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//================================================================기능은 구현
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.LineService;
import model.service.ViewService;
import vo.Line;
import vo.Memo;
import vo.User;

/*
 *  req에 memo객체와 lineSet객체를 저장
 */

public class ViewHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/logout.do";
	
	private ViewService viewService = new ViewService();
	private LineService lineService = new LineService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processSubmit(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		
		String memoid = (String) req.getSession().getAttribute("memoid");
		User user = (User) req.getSession().getAttribute("authUser");
		
		Map<String, Boolean> errors = new HashMap<>(); //ERROR MAP
		req.setAttribute("errors",errors);
		
		if (user == null) {errors.put("user", Boolean.TRUE);}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		
		
		String userid = user.getId();
		
		System.out.println("ViewHandler ======= userid : "+userid);
		System.out.println("ViewHandler ======= memoid : "+memoid);
		
		try {
			Memo memo = viewService.view(userid, memoid);
			System.out.println("vvvvv");
			System.out.println(memo.getMemoid()+" ; ");
			memo.setLineMap();
			HashMap<String,Line> lineMap = memo.getLineMap();
			HashMap<String,String> contentsMap = lineService.lineDistribute(lineMap);
			
			
			req.setAttribute("memo", memo);
			req.setAttribute("linemap",lineMap);	
			req.setAttribute("contentsmap", contentsMap);
			
			
			return "/views/screens/memoView.jsp";
		}catch (Exception e) {
			return FORM_VIEW;
		}
		
	}

}
