package controller.memberrecommend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MemberRecommend;
import model.service.MemberRecommendManager;


public class ListMemberRecommendController implements Controller{
	
	 public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
	    	MemberRecommendManager manager = MemberRecommendManager.getInstance();
			List<MemberRecommend> memberRecommendList = manager.findRecommendMemberList();
			
			// commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
			request.setAttribute("memberRecommendList", memberRecommendList);				
			return "/memberrecommend/memberreocmmend.jsp";        
	    }
	
}
