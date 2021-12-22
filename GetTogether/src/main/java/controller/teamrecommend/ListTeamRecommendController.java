package controller.teamrecommend;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import controller.Controller;
import controller.member.MemberSessionUtils;
import model.MemberSplit;
import model.TeamRecommend;
import model.service.TeamRecommendManager;

public class ListTeamRecommendController implements Controller {
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	TeamRecommendManager manager = TeamRecommendManager.getInstance();
    			
		if (MemberSessionUtils.hasLogined(request.getSession())) {
			
			HttpSession session = request.getSession();
			MemberSplit membersplit = manager.memberSplit((int)session.getAttribute("mnum"));
			String[] field = membersplit.getField().split(",");
			
			String[] language= membersplit.getLanguage().split(",");
			List<TeamRecommend> teamRecommendList = manager.findIdentifyRecomendTeam(field ,language);
					   	
			request.setAttribute("teamRecommendList", teamRecommendList);  
        }
		else {
			List<TeamRecommend> teamRecommendList = manager.findRecommendTeamList();
			request.setAttribute("teamRecommendList", teamRecommendList);
		}
       

		return "/teamRecommend/teamRecommend.jsp";        
    }
}