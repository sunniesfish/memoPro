package command;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.LoginFailException;
import model.service.LoginService;
import model.User;

@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet implements CommandHandler {
	
	private static final String FORM_VIEW = "/views/screens/loginPage.jsp";
	
	private LoginService loginService = new LoginService();
       
	@Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception { 
		System.out.println("login handler process() invoked"); //===================================
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req,res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		} return null;
    }

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = trim(req.getParameter("userid"));
		String password = trim(req.getParameter("userpwd"));
		
		System.out.println("login attempt "+id+" : "+password); //====================================
		
		Map<String, Boolean> errors = new HashMap<>(); //ERROR MAP
		req.setAttribute("errors", errors);
		
		if(id==null || id.isEmpty()) {errors.put("id", Boolean.TRUE);}
		if(password == null || password.isEmpty()) {errors.put("password", Boolean.TRUE);}
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			System.out.println("=== try ===");//=============================================
			System.out.println("befor loginService id : "+id+"  pwd : "+password);//========================
			User user = loginService.login(id, password);
			
			req.getSession().setAttribute("authUser", user);
			System.out.println(user.getId());
			
			res.sendRedirect(req.getContextPath()+"/view.do");
//			res.sendRedirect(req.getContextPath()+"/oneDayMemo.jsp");
			return null; // 로그인 서비스를 호출하여 로그인, 세션의 로그인 정보 저장, MAIN으로 이동
		} catch (LoginFailException e) { //ID PWD가 맞지 않을 경우 로그인 페이지로 되돌아감
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
		
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
