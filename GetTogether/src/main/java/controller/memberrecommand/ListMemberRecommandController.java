package controller.memberrecommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MemberRecommand;
import model.service.MemberRecommandManager;


public class ListMemberRecommandController implements Controller{
	
	 public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
	    	MemberRecommandManager manager = MemberRecommandManager.getInstance();
			List<MemberRecommand> memberRecommandList = manager.findRecommandMemberList();
			
			// commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
			request.setAttribute("memberRecommandList", memberRecommandList);				
			return "/memberrecommand/memberreocmmand.jsp";        
	    }
	
}
