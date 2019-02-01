package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class NullHandler implements CommandHandler {

	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		return "/Fail404.html";
		
	}
	
}
