package model.service;

import java.sql.SQLException;
import java.util.List;

import model.TeamRecommand;
import model.dao.TeamRecommandDAO;

public class TeamRecommandManager {
	
	private static TeamRecommandManager teamRecommandMan = new TeamRecommandManager();
	private TeamRecommandDAO teamRecommandDAO;


	private TeamRecommandManager() {
		try {
			teamRecommandDAO = new TeamRecommandDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static TeamRecommandManager getInstance() {
		return teamRecommandMan;
	}

	public List<TeamRecommand> findRecommandTeamList() throws SQLException {
			return teamRecommandDAO.findRecomandTeam();
	}

}
