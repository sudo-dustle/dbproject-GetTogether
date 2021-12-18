package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.MemberManager;

public class MemberDuplicateCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid = request.getParameter("mid");
		try {
			MemberManager manager = MemberManager.getInstance();
			manager.findMemberByMid(mid);
			
			request.setAttribute("memberID", manager.findMemberByMid(mid).getMid());
			
			return "redirect:/member/signup/input";
		}
		catch (Exception e) {
			request.setAttribute("duplicate", true);
			request.setAttribute("exception", e);
			System.out.println(e);
			
			return "/member/signup/inputForm.jsp";
		}
	}
	
}
