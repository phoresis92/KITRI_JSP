package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public interface CommandHandler {

	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception
;
	
}
