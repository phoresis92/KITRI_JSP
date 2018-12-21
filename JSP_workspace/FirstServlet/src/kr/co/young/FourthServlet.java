package kr.co.young;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fouth")

public class FourthServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7810236711894519756L;

	
/*	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF=8");
		
		PrintWriter pw = resp.getWriter();
		
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("third");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("입력한 이름 : ");
		String p_name = req.getParameter("i_name");
		pw.println(p_name);
		// 파라미터 값을 서블릿이 받아올 수 있음
		// HttpServletRequest 가 이를 관리해줌
		pw.println("<br/>");
		pw.println("입력한 생년월일 : ");
		String p_birth = req.getParameter("i_birth");
		pw.println(p_birth);
		pw.println("</body>");
		pw.println("</html>");
		
	}*/
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req,resp);
		
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF=8");
		req.setCharacterEncoding("UTF-8");
		
		
		PrintWriter pw = resp.getWriter();
		
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("third");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("입력한 이름 : ");
		String p_name = req.getParameter("i_name");
		pw.println(p_name);
		// 파라미터 값을 서블릿이 받아올 수 있음
		// HttpServletRequest 가 이를 관리해줌
		pw.println("<br/>");
		pw.println("입력한 생년월일 : ");
		String p_birth = req.getParameter("i_birth");
		pw.println(p_birth);
		pw.println("<br/>");
		String p_chk1 = req.getParameter("chk");
		String p_chk2 = req.getParameter("chk");
		String p_chk3 = req.getParameter("chk");
		//chk 값의 경우 현재 html에서 부터 배열로 구분하여 값을 가져옴
		String[] p_chk = null;
		p_chk = req.getParameterValues("chk");
		
		pw.println("선택 취미");
		//pw.println(p_chk[0] + " " + p_chk[1] + " " + p_chk[2]);
		//배열의 공간에 값이 있는 만큼의 갯수만 출력해주기
		//배열 공간의 사이즈 가져오는 방법
		
		int cnt = p_chk.length; // => 현재 배열의 저장된 갯수
		for(int i = 0 ; i < cnt ; i++) {
			pw.println(p_chk[i] + " ");
		}
		
		
		pw.println("</body>");
		pw.println("</html>");
		
	}
	
	/*servlet 생명주기
	1. init();
	2. service();
	3. destroy();*/
	
	
	//Servlet 초기화 단계
	@Override
	public void init() throws ServletException {
		System.out.println("최초 1회 Servlet 초기화 구동");
		System.out.println("Server Check");
		System.out.println("Server 구동 : ok");
		System.out.println("사용자 접속 환경 : ok");
		System.out.println("구동 완료!");
	}
	
	//2단계 service라고 하는 부분이 실행
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//메인 Servlet 구동 내용임
		System.out.println("Service 구동");
		System.out.println("접근 IP : " + req.getRemoteHost());
		doGet(req, resp);
	}
	
	//3단계 destroy 서블릿 종료 전에 1번 실행됨
	@Override
	public void destroy() {
		//서블릿 종료 시점 1번 실행 => 톰캣 종료시
		//세션을 올바르게 종료 시켜주어야 할 때 사용
		//클라이언트의 자료나 정보를 쿠키에 저장
		System.out.println("Servlet 종료");
	}
	
}