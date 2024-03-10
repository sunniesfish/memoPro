package command;
//================================================================기능은 구현
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.ViewService;
import model.service.WriteRequest;
import vo.Line;
import vo.Memo;
import vo.User;

/*
 *  req에 memo객체와 lineSet객체를 저장
 */

public class ViewHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/logout.do";
	
	private ViewService viewService = new ViewService();
	
	

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
		String memoid = (String) req.getSession().getAttribute("memoid");
		
		User user = (User) req.getSession().getAttribute("authUser");
		String userid = user.getId();

		
		try {
			if (memoid == null) {//==================??????
				Memo memo = viewService.view(userid, memoid);
			}

			Memo memo = viewService.view(userid, memoid);
			Set lineset = memo.getLineSet();
			req.setAttribute("memo", memo);
			req.setAttribute("lineSet",lineset);
			
			
//			res.sendRedirect(req.getContextPath()+"/views/screens/memoView.jsp");
			return "/views/screens/memoView.jsp";
		}catch (Exception e) {
			return FORM_VIEW;
		}
		
	}

}
