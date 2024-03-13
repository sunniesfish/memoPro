package command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.JoinService;
import model.service.WriteRequest;
import model.service.WriteService;
import vo.User;


@WebServlet("/write.do")
public class WriteHandler extends HttpServlet implements CommandHandler {
	
	private static final String FORM_VIEW = "/logout.do";
	private WriteService writeService = new WriteService();

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
		String content = (String) req.getAttribute("content");
		
		Map<String, Boolean> errors = (Map<String, Boolean>) req.getAttribute("errors");
		
		WriteRequest writeReq = new WriteRequest();
		writeReq.setMemoid(memoid);
		writeReq.setLineid(lineid);
		writeReq.setContent(content);
		
		try {
			writeService.write(writeReq);
			return "/view.do";
		} catch (Exception e) {
			errors.put("writingFail",Boolean.TRUE);
		} return FORM_VIEW;
	}
}
