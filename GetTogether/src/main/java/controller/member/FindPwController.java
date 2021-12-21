package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.service.MemberManager;

public class FindPwController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid = request.getParameter("memberId");
		
		try {
			MemberManager manager = MemberManager.getInstance();
			Member member = (Member) manager.findMemberByMid(mid);
			
			request.setAttribute("memberInfo", member);
			
			return "/member/findPwResult.jsp";	
		}
		catch(Exception e) {
			request.setAttribute("exception", e);
			
			return "/member/findPwResult.jsp";
		}
	}

}
