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

@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String code = request.getParameter("log_code");
		//로그인 하는 형태
		HttpSession hs = request.getSession();
		if(code.equals("login")) {
			MemberDao md = new MemberDao();
			ArrayList<MemberBean> al = md.getMember(request.getParameter("p_name"));
			int cnt = al.size(); //1개 이상 값이 나오면 정상로그인, 0개가 나오면 로그인 실패
			if(cnt > 0) {
				System.out.println(cnt);
				//로그인 정보가 제대로 입력 되었을 시 처리
				request.setAttribute("MEMBER", al);
				
				//ID 값 세션에 세팅하기
				hs.setAttribute("S_ID", al.get(0).getName());
				
				RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
				rd.forward(request, response);				
				
			}else if(cnt == 0) {
				System.out.println("cnt == 0");
				//로그인 정보가 제대로 입력 안되었을 시 처리
				response.sendRedirect("login.jsp");
			}
			
		} else if(code.equals("logout")) {
			//로그아웃 하는 형태
			
			hs.removeAttribute("S_ID");
			
			response.sendRedirect("index.do");
			
		}
		
	}

}
