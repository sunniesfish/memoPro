package command;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//=============================================================================미구현
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.GoListService;
import vo.User;

public class GoListHandler implements CommandHandler {
	private static final String FORM_VIEW = "/logout.do";
	
	private GoListService goListService = new GoListService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = (User) req.getSession().getAttribute("authUser");
		
		Map<String, Boolean> errors = new HashMap<>(); //ERROR MAP
		req.setAttribute("errors",errors);
		
		if (user == null) {errors.put("user", Boolean.TRUE);}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		String userid =user.getId();
		req.getSession().removeAttribute("memoid");
		
		List<String> memoList = goListService.bringList(userid);
		req.setAttribute("memolist",memoList);
		System.out.println("golisthandler 완료"+memoList.toString());
		return "/views/screens/memos.jsp";
	}
}
