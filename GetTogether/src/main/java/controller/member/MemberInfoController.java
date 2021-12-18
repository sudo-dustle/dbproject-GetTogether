package controller.member;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.service.MemberManager;

public class MemberInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mid = request.getParameter("mid");
		String passwd = request.getParameter("passwd");
		String mname = request.getParameter("mname");
		Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		String phonenum = null;
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		String school = request.getParameter("school");
		String major = request.getParameter("major");
		String field = null;
		String language = null;
		String experience = request.getParameter("experience");
		
		String phone1 = request.getParameter("phone");
		
		switch(phone1) {
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
		
		String[] word1 = request.getParameterValues("field");
		
		for(int i = 0; i < word1.length; i++) {
			if (!(word1[i].equals("ALL"))) {
				if (field == null) {
					field = word1[i];
				} else
					field = field + "," + word1[i];
			}
		}
		
		System.out.println(field);
		
		String[] word2 = request.getParameterValues("lan");
		
		for(int i = 0; i < word2.length; i++) {
			if (!(word2[i].equals("ALL"))) {
				if (language == null) {
					language = word2[i];
				} else
					language = language + "," + word2[i];
			}
		}
		
		System.out.println(language);
		
		Member member = new Member(mid, passwd, mname, date, phonenum, email, school, major, field, language, experience);
		
		try {
			MemberManager manager = MemberManager.getInstance();
			manager.create(member);
			
			return "redirect:/";
		}
		catch (Exception e) {
			request.setAttribute("inputFailed", true);
			request.setAttribute("exception", e);
			System.out.println(e);
			
			System.out.println(request.getAttribute("inputFailed"));
			
			return "/member/signup/inputForm.jsp";
		}
		
	}

}
