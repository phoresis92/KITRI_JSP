package com.young.cont;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.young.MemberCom.MDelCommand;
import com.young.MemberCom.MGetCommand;
import com.young.MemberCom.MModOKCommand;
import com.young.MemberCom.MRegiCommand;
import com.young.command.Command;
import com.young.dto.MDto;

@WebServlet("*.do")
public class MFrontController extends HttpServlet {
	private static final long serialVersionUID = -208940600818474736L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(req, resp);
	}
	
	private void actionDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("actionDo");
		req.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String com = uri.substring(conPath.length());
		//System.out.println(uri);
		//System.out.println(conPath);
		System.out.println(com);
		
		if(com.equals("/SignUP.do")) {
			viewPage = "SignUP.html";
		}else if(com.equals("/Regi.do")) {
			command = new MRegiCommand();
			command.execute(req, resp);
			
			if(((ArrayList<Integer>)req.getAttribute("REGI")).get(0) == 0) {
				viewPage = "SignFail.jsp";
			}else {
				req.setAttribute("MEMBER", ((ArrayList<MDto>)req.getAttribute("REGI")).get(1));
				viewPage = "SignSuccess.jsp";
			}
		}else if(com.equals("/Modify.do")) {
			req.setAttribute("PHONE", req.getParameter("PHONE"));
			command = new MGetCommand();
			command.execute(req, resp);
			viewPage = "Modify.jsp";
		}else if(com.equals("/ModOK.do")) {
			command = new MModOKCommand();
			command.execute(req, resp);
			
			if(((ArrayList<Integer>)req.getAttribute("UPDATE")).get(0) == 0) {
				viewPage = "SignFail.jsp";
			}else {
				req.setAttribute("MEMBER", ((ArrayList<MDto>)req.getAttribute("UPDATE")).get(1));
				viewPage = "ModOK.jsp";
			}
			
		}else if(com.equals("/Delete.do")) {
			command = new MDelCommand();
			command.execute(req, resp);
			if((int)req.getAttribute("DELCNT") == 0) {
				viewPage = "SignFail.jsp";
			}else {
				viewPage = "DelOK.jsp";
			}
			
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
	
}
