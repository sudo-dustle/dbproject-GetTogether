package controller.teamrecommend;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.TeamRecommend;
import model.service.TeamRecommendManager;

public class ListTeamRecommendController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	TeamRecommendManager manager = TeamRecommendManager.getInstance();
		List<TeamRecommend> teamRecommendList = manager.findRecommendTeamList();
		
		request.setAttribute("teamRecommendList", teamRecommendList);				
		return "/teamrecommend/teamreocmmend.jsp";        
    }
}