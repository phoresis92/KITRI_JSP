package kr.co.young;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7365322477262309007L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charsert=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>hello2</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		//String link = "/FirstServlet/hello3";
		//String link = "http://127.0.0.1/FirstServlet/hello3";
		String link = "hello3";
		
		pw.println("<a href=\" "+ link + " \">Hello Servlet2</a><br/>");
		String name = "김영동";
		pw.println(name + " 입니다!");
		pw.println("<form>");
		pw.println("<input type=\"text\" name=\"name\">");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doGet(req, resp);
	}
	
}