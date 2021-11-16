package controller.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.User;
import model.service.UserManager;

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
    		
//    		UserManager manager = UserManager.getInstance(); 아직 미작성된 찾는 클래스..
			List<User> userList = new ArrayList<User>();
    		//= manager.findUserList();
			User user = new User();
			user.setName("김테스트");
			userList.add(user);
			User user2 = new User();
			user2.setName("이테스트");
			userList.add(user2);
			User user3 = new User();
			user3.setName("박테스트");
			userList.add(user3);
			User user4 = new User();
			user4.setName("최테스트");
			userList.add(user4);
			User user5 = new User();
			user5.setName("독고테스트");
			userList.add(user5);
//			userList = manager.findUserList(query);//이름 or 소개내용으로 검색
			request.setAttribute("userList", userList);
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
