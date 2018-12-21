package kr.co.young;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3396578537091935703L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8"); 
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("third");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("안녕 안녕 나야나");
		pw.println("</body>");
		pw.println("</html>");
		
	}
	
}
