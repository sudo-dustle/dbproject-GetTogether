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
//	    	MemberRecommend member = new MemberRecommend("±èÁö¼ö", "C, Java");
			List<MemberRecommend> memberRecommendList = manager.findRecommendMemberList();
//	    	List<MemberRecommend> memberRecommendList = new ArrayList<MemberRecommend>();
//	    	java.util.logging.Logger logger = Logger.getLogger(this.getClass().getName());
//	    	logger.info(member.getMname());
//	    	memberRecommendList.add(member);
			
			request.setAttribute("memberRecommendList", memberRecommendList);				
			return "/memberrecommend/memberrecommend.jsp";        
	    }
	
}
