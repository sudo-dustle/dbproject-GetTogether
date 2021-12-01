package controller.member;

import java.util.Date;
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
		String language = null;
		String experience = request.getParameter("experience");
		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) fm.parse(dateString);
		
		String[] word1 = request.getParameterValues("field");
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
		
		System.out.println("mid= " + mid + ", passwd=" + passwd + ", mname=" + mname + ", phonenum=" + phonenum
				+ ", email=" + email + "school=" + school + ", major="+ major + ", field="+ field + ", language="+ language + ", experience="+ experience);
		
		Member member = new Member(mid, passwd, mname, date, phonenum, email, school, major, field, language, experience);
		
		try {
			System.out.println("try1");
			MemberManager manager = MemberManager.getInstance();
			manager.create(member);
			System.out.println("try2");
			return "redirect:/main.jsp";
		}
		catch (Exception e) {
			System.out.println("catch");
			request.setAttribute("inputFailed", true);
			request.setAttribute("exception", e);
			return "/member/signup/inputForm.jsp";
		}
		
	}

}
