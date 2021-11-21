package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dao.MemberManager;

public class MemberLoginController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String memberId = request.getParameter("memberId");
		String passwd = request.getParameter("passwd");
		
		try {
			//로그인
			MemberManager.getInstance().login(memberId, passwd);
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			
			//로그인 성공 시 메인 화면으로 이동
			return "/index.jsp";
		}
		catch(Exception e){
			request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			e.printStackTrace();
			
			//로그인 실패 시 다시 로그인 화면으로 돌아온다.
			return "/member/login/loginForm.jsp";
		}
	}
}
