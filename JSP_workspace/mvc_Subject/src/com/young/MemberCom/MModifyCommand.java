package com.young.MemberCom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.young.command.Command;
import com.young.dao.MDao;
import com.young.dto.MDto;

public class MModifyCommand implements Command{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MDto dto = (MDto)req.getAttribute("MEMBER");
		
		MDao dao = new MDao();
		//dao.
		
	}
	
}
