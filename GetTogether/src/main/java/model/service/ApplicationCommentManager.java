package model.service;

import java.sql.SQLException;
import java.util.List;

import model.ApplicationComment;
import model.Member;
import model.TeamMember;
import model.dao.ApplicationCommentDAO;
import model.dao.MemberDAO;
import model.dao.TeamMemberDAO;

public class ApplicationCommentManager {
	private static ApplicationCommentManager commentMan = new ApplicationCommentManager();
	private ApplicationCommentDAO commentDAO;
	private TeamMemberDAO teamMemberDAO;
	private MemberDAO memberDAO;
	
	private ApplicationCommentManager() {
		try {
			commentDAO = new ApplicationCommentDAO();
			teamMemberDAO = new TeamMemberDAO();
			memberDAO = new MemberDAO();
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
	
	public List<ApplicationComment> findListByPid(int pid) throws SQLException {
		List<ApplicationComment> commentList = commentDAO.findListByPid(pid);
		
		for(ApplicationComment comment : commentList) {
			int applicantNum = comment.getApplicant().getMnum();
			try {
				Member applicant = findMember(applicantNum);
				comment.setApplicant(applicant);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return commentList;
	}
	
	
	public Member findMember(int mnum) throws SQLException, UserNotFoundException {
		Member member = memberDAO.findMember(mnum);
		if (member == null) {
			throw new UserNotFoundException(mnum + "는 존재하지 않는 아이디입니다.");
		}
		return member;
	}
}
