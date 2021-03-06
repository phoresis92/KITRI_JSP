package kr.co.young.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.young.model.MemberBean;
import kr.co.young.model.MemberDao;
/**
 * Servlet implementation class Reg
 */
@WebServlet("/reg.do")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBean mb = new MemberBean();

		request.setCharacterEncoding("utf-8");
		response.sendRedirect("input.jsp");
		
		
/*		mb.setName(request.getParameter("p_name"));
		mb.setEmail(request.getParameter("p_email"));
		
		//response.sendRedirect("view.jsp?mb_name=" + mb.getName() + "&mb_email=" + mb.getEmail());
		// -> parameter로 데이터 전달
		// 간단하게 구현 가능하고, 편하게 사용가능
		// 파라미터 값이 노출되기 때문에 보안적으로 문제가 발생
		// 파라미터에 입력되는 값은 String 만 입력가능
		// req.setAttribute(String name, Object o) 객체타입의 모든 자료 저장
		
		request.setAttribute("MEMBER", mb);
		Object mb_1 = request.getAttribute("MEMBER");
		if(mb_1 instanceof MemberBean) {
			MemberBean mb_test = (MemberBean)mb_1;
			System.out.println(mb_test.getName());
			System.out.println(mb_test.getEmail());*/
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//가입한 정보의 이름 저장하기. 자바 객체에 저장함
		//저장 공간(객체 -> JavaBean 만들기)
		
		request.setCharacterEncoding("utf-8");
		
		MemberBean mb = new MemberBean();
		
		mb.setName(request.getParameter("p_name"));
		mb.setEmail(request.getParameter("p_email"));
		
		//response.sendRedirect("view.jsp?mb_name=" + mb.getName() + "&mb_email=" + mb.getEmail());
		// -> parameter로 데이터 전달
		// 간단하게 구현 가능하고, 편하게 사용가능
		// 파라미터 값이 노출되기 때문에 보안적으로 문제가 발생
		// 파라미터에 입력되는 값은 String 만 입력가능
		// req.setAttribute(String name, Object o) 객체타입의 모든 자료 저장
		
		//request.setAttribute("MEMBER", mb);
		
		//db에 연결하여 Insert 하기
		MemberDao md = new MemberDao();
		int result = md.addMember(mb.getName(), mb.getEmail());
		if(result == 0) {
			System.out.println("회원가입 에러발생");
		}else if(result == 1) {
			System.out.println("회원가입 완료");
		}
		
		MemberBean mb_new = (md.getMember(mb.getName())).get(0);
		System.out.println(mb_new);
		request.setAttribute("MEMBER", mb_new);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
		/*Object mb_1 = request.getAttribute("MEMBER");
		if(mb_1 instanceof MemberBean) {
			MemberBean mb_test = (MemberBean)mb_1;
			System.out.println(mb_test.getName());
			System.out.println(mb_test.getEmail());
		}*/
	}

}
