package model.service;

import java.sql.SQLException;
import java.util.List;

import model.TeamRecommend;
import model.dao.TeamRecommendDAO;

public class TeamRecommendManager {
	
	private static TeamRecommendManager teamRecommendMan = new TeamRecommendManager();
	private TeamRecommendDAO teamRecommendDAO;


	private TeamRecommendManager() {
		try {
			teamRecommendDAO = new TeamRecommendDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static TeamRecommendManager getInstance() {
		return teamRecommendMan;
	}

	public List<TeamRecommend> findRecommendTeamList() throws SQLException {
			return teamRecommendDAO.findRecomendTeam();
	}

}
