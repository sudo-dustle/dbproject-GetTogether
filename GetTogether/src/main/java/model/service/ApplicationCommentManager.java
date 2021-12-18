package model.service;

import java.sql.SQLException;

import model.ApplicationComment;
import model.TeamMember;
import model.dao.ApplicationCommentDAO;
import model.dao.TeamMemberDAO;

public class ApplicationCommentManager {
	private static ApplicationCommentManager commentMan = new ApplicationCommentManager();
	private ApplicationCommentDAO commentDAO;
	private TeamMemberDAO teamMemberDAO;
	
	private ApplicationCommentManager() {
		try {
			commentDAO = new ApplicationCommentDAO();
			teamMemberDAO = new TeamMemberDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ApplicationCommentManager getInstance() {
		return commentMan;
	}
	
	public int create(ApplicationComment comment) throws SQLException {
		int result = commentDAO.create(comment);
		TeamMember teamMember = new TeamMember(comment.getProject().getPid(), comment.getApplicant().getMnum());
		result += teamMemberDAO.create(teamMember);
		return result;
	}
}
