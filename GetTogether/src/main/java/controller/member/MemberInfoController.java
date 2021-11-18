package controller.member;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.dao.MemberManager;

public class MemberInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mid = request.getParameter("mid");
		String passwd = request.getParameter("passwd");
		String mname = request.getParameter("mname");
		String dateString = request.getParameter("date");
		String phonenum = request.getParameter("phone") + request.getParameter("phone1") + request.getParameter("phone2");
		String email = request.getParameter("email1") + request.getParameter("email2");
		String school = request.getParameter("school");
		String major = request.getParameter("major");
		String field = null;
		String language = request.getParameter("lan");
		String experience = request.getParameter("experience");
		
		//Date타입으로 변환
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) fm.parse(dateString);
		
		String[] word1 = request.getParameterValues("project");
		
		//하나의 스트링으로 합치기?
		for(int i = 0; i < word1.length; i++) {
			if (field == null) {
				field = word1[i];
			}
			field = field + word1[i];
		}
		String[] word2 = request.getParameterValues("lan");
		for(int i = 0; i < word2.length; i++) {
			if (language == null) {
				language = word2[i];
			}
			language = language + word2[i];
		}
		
		
		Member member = new Member(0, mid, passwd, mname, date, phonenum, email, school, major, field, language, experience);
		
		try {
			MemberManager manager = MemberManager.getInstance();
			manager.create(member);
			
			//성공 시 메인화면
			return "redirect:/main.jsp";
		}
		catch (Exception e) {
			request.setAttribute("inputFailed", true);
			request.setAttribute("exception", e);
			return "/member/inputForm.jsp";
		}
		
	}

}
