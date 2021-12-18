package controller.teamrecommend;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch.qos.logback.classic.Logger;
import controller.Controller;
import controller.member.MemberSessionUtils;
import model.TeamRecommend;
import model.service.TeamRecommendManager;

public class ListTeamRecommendController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	TeamRecommendManager manager = TeamRecommendManager.getInstance();
    	
//    	TeamRecommend team = new TeamRecommend(1,"¸ð¿©ºÁ¿ä", "¸ô¶ó", 4);
		
		if (MemberSessionUtils.hasLogined(request.getSession())) {
			//List<TeamRecommend> teamRecommendList = manager.findIdentifyRecomendTeam();
			TeamRecommend team = new TeamRecommend(33,"¸ð¿©ºÁ¿ä", "¸ô¶ó", 4,5);
			List<TeamRecommend> teamRecommendList = new ArrayList<TeamRecommend>();
			teamRecommendList.add(team);
			request.setAttribute("teamRecommendList", teamRecommendList);      // login form ¿äÃ»À¸·Î redirect
        }
		else {
			List<TeamRecommend> teamRecommendList = manager.findRecommendTeamList();
			request.setAttribute("teamRecommendList", teamRecommendList);
		}
        //int mnum = MemberSessionUtils.getLoginMemberNum(request.getSession());
		
//		List<TeamRecommend> teamRecommendList = new ArrayList<TeamRecommend>();
 //   	java.util.logging.Logger logger = Logger.getLogger(this.getClass().getName());
 //   	logger.info(team.getTitle());
 //   	teamRecommendList.add(team);
		
						
		return "/teamRecommend/teamRecommend.jsp";        
    }
}