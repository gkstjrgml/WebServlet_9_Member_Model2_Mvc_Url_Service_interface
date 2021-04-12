package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.mvcregisterdao;
import kr.or.bit.dto.registerdto;

public class RegisterOkServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		registerdto dto = new registerdto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		
		mvcregisterdao dao = new mvcregisterdao();
		int result = dao.writeOk(dto);
		
		String resultdata = "";
		if(result > 0) {
			resultdata = dto.getId() +"님 welcome to bit!";
			
		}else {
			resultdata = "insert fail ...";
		}
		
		request.setAttribute("data", resultdata);
		
		//뷰지정
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/Register/Register_welcome.jsp");
		
		return forward;
	}

}
