package mvc.hello;

import mvc.command.CommandHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHandler implements CommandHandler {

	public String process(HttpServletRequest req, HttpServletResponse resp) {
		
		req.setAttribute("hello", "안녕하세요");
		return "/view/hello.jsp";
		
	}
	
}
