package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/views/screens/loginPage.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.getSession().invalidate();
		return FORM_VIEW;
	}
}
