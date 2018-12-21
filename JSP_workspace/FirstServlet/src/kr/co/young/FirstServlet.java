package kr.co.young;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")

public class FirstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7734666345805799213L;
	
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("Servlet Service starting now");
		// UTF-8�� �ۼ��Ͽ� ����
		arg1.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html; charset=UTF-8"); 
		
		// �� ��� �뵵 ��� ��ü ����
		PrintWriter out = arg1.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello</title></head>");
		out.println("<body>");
		out.println("Hello Servlet!<br>");
		String name = "김영동";
		out.println(name + "님 반갑습니다");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
}
