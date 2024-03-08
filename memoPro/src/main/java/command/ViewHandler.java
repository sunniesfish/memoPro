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
 *  ���ǿ� memo��ü�� lineSet��ü�� ����
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
		//=================memberid�� ���� member ��ü�� ���ǿ� ����
		//=================memberid="1"�� ���� oneDayMemo
		
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
