package com.young.MemberCom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.young.command.Command;
import com.young.dao.MDao;

public class MDelCommand implements Command{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String phone = req.getParameter("PHONE");
		
		MDao dao = new MDao();
		int result = dao.delMember(phone);
		req.setAttribute("DELCNT", result);
	}
	
}
