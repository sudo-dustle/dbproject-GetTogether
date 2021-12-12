package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.MemberManager;

public class MemberDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("memberId");
		
		try {
			MemberManager manager = MemberManager.getInstance();
			manager.remove(mid);
			
			return "redirect:/";
		}
		catch (Exception e) {
			return "/member/mypage";
		}
	}

}
