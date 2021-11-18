package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dao.MemberManager;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberId = request.getParameter("memberId");
		String passwd = request.getParameter("passwd");
		
		try {
//			모델에 login 처리를 위임
			MemberManager.getInstance().login(memberId, passwd);
			
//			세션에 아이디 저장
			HttpSession session = request.getSession();
			session.setAttribute("memberId", session);
			
			return "/main.jsp";
		}
		catch(Exception e){
			request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			return "/member/loginForm.jsp";
		}
	}
	
}
