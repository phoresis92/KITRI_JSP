package kr.co.young.cont;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.young.model.MemberBean;
import kr.co.young.model.MemberDao;

@WebServlet("/mem.do")
public class MemberCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println(uri);
		System.out.println(conPath);
		System.out.println(com);
		
		
		MemberDao mdao = new MemberDao();
		request.setCharacterEncoding("utf-8");
		
		String code = request.getParameter("mem_code");
		
		// 등록 회원정보를 수정할 시에 실행되는 컨트롤러 영역
		if(code.equals("modify")) {
			//modify 페이지 출력할 수 있도록 구성하기
			System.out.println("Mod 실행");
			MemberBean mb = new MemberBean();
			mb.setName(request.getParameter("h_name"));
			mb.setEmail(request.getParameter("h_email"));
			//view.jsp에서부터 저장된 이름과 이메일 값을 hidden 타입의 input 값에 넣어서 파라미터로 전달 받아 온 값을 세팅
			
			request.setAttribute("MEMBER", mb);
			
			RequestDispatcher rd = request.getRequestDispatcher("modify.jsp");
			rd.forward(request, response);
		}else if(code.equals("modify_ok")) {
			//수정된 회원 정보를 반영할 시에 실행되는 컨트롤러 영역
			System.out.println("Mod OK 실행");
			
			//modify.jsp 에서 수정된 결과값을 받아올 수 있도록 함
			MemberBean mod_mb = new MemberBean();
			mod_mb.setName(request.getParameter("mod_name"));
			mod_mb.setEmail(request.getParameter("mod_email"));
			
			int result = mdao.modify(mod_mb.getName(), mod_mb.getEmail(), request.getParameter("origin"));
			
			if(result == 0) {
				System.out.println("정보수정 실패");
			}else if(result == 1) {
				System.out.println("정보수정 성공!!!");
			}
			
			MemberBean mod_new = mdao.getMember(mod_mb.getName()).get(0);
			
			
			request.setAttribute("MEMBER", mod_new);
			RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
			
		}else if(code.equals("show_all")){
			
			System.out.println("show_all 실행");
			
			ArrayList<MemberBean> list = mdao.showList();
			
			request.setAttribute("MEMBERS", list);
			RequestDispatcher rd = request.getRequestDispatcher("showlist.jsp");
			rd.forward(request, response);
			
		}else if(code.equals("delete")) {
			
			System.out.println("delete 실행");
			String fn = request.getParameter("h_name");
			int result = mdao.delete(fn);
			if(result == 0) {
				System.out.println("계정삭제 실패");
				response.sendRedirect("del.fal.jsp");
			}else if(result !=0) {
				System.out.println("계정삭제 성공!!!");
				//response.sendRedirect("del.succ.jsp");
				request.setAttribute("DELCNT", result);
				RequestDispatcher rd = request.getRequestDispatcher("del.succ.jsp");
				rd.forward(request, response);
			}
		}else if(code.equals("search")) {
			System.out.println("search 실행");
			
			
		}
		
	}

}
