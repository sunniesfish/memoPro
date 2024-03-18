package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/memoPro/views/screens/loginPage.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
		res.sendRedirect(FORM_VIEW);
		return null;
	}
}
