package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.service.MemberManager;

public class TeamMemberDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(!MemberSessionUtils.hasLogined(request.getSession()))
		{
			return "redirect:/member/login/form";
		}
		
		int mnum = Integer.parseInt(request.getParameter("mnum"));
		
		MemberManager manager = MemberManager.getInstance();
		Member member = manager.findMemberByMnum(mnum);
		
		request.setAttribute("memberInfo", member);
		
		return "/member/teamMemberDetail.jsp";
	}
		
}
