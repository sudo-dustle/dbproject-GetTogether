package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.service.MemberManager;

public class MemberDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(!MemberSessionUtils.hasLogined(request.getSession()))
		{
			return "redirect:/member/login/form";
		}
		HttpSession session = request.getSession();
		String mId = (String) session.getAttribute("memberId");
		
		MemberManager manager = MemberManager.getInstance();
		Member member = (Member) manager.findMemberByMid(mId);
		
		request.setAttribute("memberInfo", member);
		
		return "/member/myPage.jsp";
	}

}
