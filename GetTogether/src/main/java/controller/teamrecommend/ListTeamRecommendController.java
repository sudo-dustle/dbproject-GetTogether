package controller.teamrecommend;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.qos.logback.classic.Logger;
import controller.Controller;
import model.TeamRecommend;
import model.service.TeamRecommendManager;

public class ListTeamRecommendController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	TeamRecommendManager manager = TeamRecommendManager.getInstance();
    	
//    	TeamRecommend team = new TeamRecommend(1,"¸ð¿©ºÁ¿ä", "¸ô¶ó", 4);
    	
		List<TeamRecommend> teamRecommendList = manager.findRecommendTeamList();
		
//		List<TeamRecommend> teamRecommendList = new ArrayList<TeamRecommend>();
 //   	java.util.logging.Logger logger = Logger.getLogger(this.getClass().getName());
 //   	logger.info(team.getTitle());
 //   	teamRecommendList.add(team);
		
		request.setAttribute("teamRecommendList", teamRecommendList);				
		return "/teamRecommend/teamRecommend.jsp";        
    }
}