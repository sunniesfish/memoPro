package command;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.service.ViewService;
import model.service.WriteRequest;
import vo.Line;
import vo.Memo;

/*
 *  세션에 memo객체와 lineSet객체를 저장
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
		User user = (User) req.getSession().getAttribute("AuthUser");
		String userid = user.getId();
		//=================memberid에 따른 member 객체를 세션에 저장
		//=================memberid="1"인 경우는 oneDayMemo
		
		try {
			if (memoid == null) {
				Memo memo = viewService.view(userid, memoid);
			}

			Memo memo = viewService.view(userid, memoid);
			Set lineset = memo.getLineSet();
			req.getSession().setAttribute("memo", memo);
			req.getSession().setAttribute("lineSet",lineset);
			
			res.sendRedirect(req.getContextPath()+"/WEB-INF/memoView.jsp");
			return null;
		}catch (Exception e) {
			return FORM_VIEW;
		}
		
	}

}
