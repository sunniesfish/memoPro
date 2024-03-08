package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.DuplicateIdException;
import model.service.JoinRequest;
import model.service.JoinService;

public class JoinHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/views/screens/joinForm.jsp";
	private JoinService joinService = new JoinService();
	
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
		JoinRequest joinReq = new JoinRequest();
		joinReq.setId(req.getParameter("userid"));
		joinReq.setPassword(req.getParameter("userpwd"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			joinService.join(joinReq);
			return "/views/screens/joinSuccess.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
		} return FORM_VIEW;
	}

}
