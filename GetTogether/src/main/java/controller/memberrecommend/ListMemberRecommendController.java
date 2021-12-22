package controller.memberrecommend;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MemberRecommend;
import model.service.MemberRecommendManager;


public class ListMemberRecommendController implements Controller{
	
	 public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			

	    	MemberRecommendManager manager = MemberRecommendManager.getInstance();

			List<MemberRecommend> memberRecommendList = manager.findRecommendMemberList();
		
			request.setAttribute("memberRecommendList", memberRecommendList);				

			return "/memberrecommend/memberrecommend.jsp";        
	    }
	
}
