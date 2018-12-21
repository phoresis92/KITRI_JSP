package com.young.MemberCom;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.young.command.Command;
import com.young.dao.MDao;
import com.young.dto.MDto;

public class MGetCommand implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		MDao dao = new MDao();
		MDto dto = dao.getMember((String)req.getAttribute("PHONE"));
		req.setAttribute("MDTO", dto);		
		
		
	}
	
	

}
