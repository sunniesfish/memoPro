package command;

import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestToSessionHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Enumeration<String> reqParameters = req.getParameterNames();
		Iterator<String> reqIter = reqParameters.asIterator();
		while(reqIter.hasNext()) {
			String parameterName = reqIter.next();
			Object parameter = req.getParameter(parameterName);
			req.getSession().setAttribute(parameterName, parameter);
	
			System.out.println(parameterName);
		}
		return "/view.do";
	}
}
