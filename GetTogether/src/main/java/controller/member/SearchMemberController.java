package controller.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.service.MemberManager;

public class SearchMemberController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//로그인 체크하는 로직....
		//검색어로 user정보 찾기
		//찾은정보 리스트를 request에 담는다		

    	if (request.getMethod().equals("GET")) {	
    		// GET request: 검색어로 검색하는 경우
    		String query = request.getParameter("query");
    		
    		
    		MemberManager memberManager = MemberManager.getInstance();
			List<Member> searchedMemberList = memberManager.searchMember(query);
			request.setAttribute("memberList", searchedMemberList);
    	}
    	else {
    		//POST -> language나 관심 분야로 search 할 경우
    		String language = request.getParameter("language");
    		String field = request.getParameter("field");
    		
    		//search 로직 (,를 기점으로 나눠서 하나씩 찾는다던지,,)
    		//findUserList(language, field);
    	}
		
 		return "/member/searchResult.jsp";
	}

}
