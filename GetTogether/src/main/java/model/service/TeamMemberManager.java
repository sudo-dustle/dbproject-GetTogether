package model.service;

import java.sql.SQLException;

import model.TeamMember;
import model.dao.TeamMemberDAO;

public class TeamMemberManager {
	private static TeamMemberManager commentMan = new TeamMemberManager();
	private TeamMemberDAO teamMemberDAO;
	
	private TeamMemberManager() {
		try {
			teamMemberDAO = new TeamMemberDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TeamMemberManager getInstance() {
		return commentMan;
	}
	
	public int create(TeamMember teamMember) throws SQLException {
		int result = teamMemberDAO.create(teamMember);
		return result;
	}
	
	public int updateApproveTrue(int pid, int mnum) throws SQLException {
		int result = teamMemberDAO.updateApprove(pid, mnum ,true);
		return result;
	}
	
	public boolean existingTeamMember(int pid, int mnum) throws SQLException {
		boolean result = teamMemberDAO.existingTeamMember(pid, mnum);
		return result;
	}
}
