package kr.co.young.cont;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.young.model.MemberBean;
import kr.co.young.model.MemberDao;

@WebServlet("/index.do")
public class MainController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//01. 회원 정보 입력할 수 있는 창 출력 하기
		//	input.html
		// session을 생성하여 login page 또는 login 된 페이지를 볼 수 있도록 구성
		HttpSession hs = request.getSession();
		// ID가 세션에 남아 있는지 (로그인이 되있는 상태인지)
		System.out.println("Session ID : " + hs.getId());
		if(hs.getAttribute("S_ID") != null) {
			//로그인 되있는 상태
			MemberDao md = new MemberDao();//회원 가입된 사람 정보 조회
			ArrayList<MemberBean> al = md.getMember((String)hs.getAttribute("S_ID"));
			request.setAttribute("MEMBER", al);
			
			RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
		}else {
			
			//로그인 안 되어 있는 상태
			response.sendRedirect("login.jsp");
			
		}
		
//		System.out.println("MainController doGet 실행");
//		response.sendRedirect("input.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}


}
