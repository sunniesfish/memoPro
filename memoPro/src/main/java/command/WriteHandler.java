package command;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.JoinService;
import model.service.WriteRequest;
import vo.User;


@WebServlet("/write.do")
public class WriteHandler extends HttpServlet implements CommandHandler {
	
	private static final String FORM_VIEW = "/views/screens/"".jsp";
	

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
		String lineid = (String) req.getSession().getAttribute("lineid");
		
		WriteRequest writeReq = new WriteRequest();
		                                                                                                                                                                                          
		
		return null;
	}
}
