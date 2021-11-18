package controller.teamrecommand;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.TeamRecommand;
import model.service.TeamRecommandManager;

public class ListTeamRecommandController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	TeamRecommandManager manager = TeamRecommandManager.getInstance();
		List<TeamRecommand> teamRecommandList = manager.findRecommandTeamList();
		
		request.setAttribute("teamRecommandList", teamRecommandList);				
		return "/teamrecommand/teamreocmmand.jsp";        
    }
}