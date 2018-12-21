package com.young.MemberCom;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.young.command.Command;
import com.young.dao.MDao;
import com.young.dto.MDto;

public class MRegiCommand implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String gender = req.getParameter("gender");
		String front_num = req.getParameter("front_num");
		String mid_num = req.getParameter("mid_num");
		String last_num = req.getParameter("last_num");
		String phone = front_num+mid_num+last_num;
		
		MDao dao = new MDao();
		int result = dao.regi(name,birth,gender,front_num,mid_num,last_num,phone);
		
		MDto dto = new MDto(name,birth,gender,front_num,mid_num,last_num,phone);
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(result);
		list.add(dto);
		
		req.setAttribute("REGI", list);
		
	}

	
	
}