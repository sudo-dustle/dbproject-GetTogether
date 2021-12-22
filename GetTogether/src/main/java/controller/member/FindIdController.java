package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.service.MemberManager;

public class FindIdController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mname = request.getParameter("name");
		String phonenum = null;

		String phone1 = request.getParameter("phone");

		System.out.println("findIdController execute");
		
		switch (phone1) {
		case "010":
			phonenum = phone1 + "-" + request.getParameter("phone1") + "-" + request.getParameter("phone2");
		case "011":
			phonenum = phone1 + "-" + request.getParameter("phone1") + "-" + request.getParameter("phone2");
		case "017":
			phonenum = phone1 + "-" + request.getParameter("phone1") + "-" + request.getParameter("phone2");
		case "070":
			phonenum = phone1 + "-" + request.getParameter("phone1") + "-" + request.getParameter("phone2");
		case "080":
			phonenum = phone1 + "-" + request.getParameter("phone1") + "-" + request.getParameter("phone2");
		default:
			break;
		}

		try {
			MemberManager manager = MemberManager.getInstance();
			Member member = (Member) manager.findIdByMname(mname, phonenum);
			
			
			request.setAttribute("memberInfo", member);
			
			System.out.println("findIdController 실행되었음");
			
			return "/member/findIdResult.jsp";
		} catch (Exception e) {
			request.setAttribute("exception", e);
			return "/member/findIdResult.jsp";
		}

	}
}
