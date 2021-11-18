package model.service;

import java.sql.SQLException;
import java.util.List;

import model.MemberRecommand;
import model.dao.MemberRecommandDAO;


public class MemberRecommandManager {
	private static MemberRecommandManager memberRecommandMan = new MemberRecommandManager();
	private MemberRecommandDAO memberRecommandDAO;


	private MemberRecommandManager() {
		try {
			memberRecommandDAO = new MemberRecommandDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MemberRecommandManager getInstance() {
		return memberRecommandMan;
	}

	public List<MemberRecommand> findRecommandMemberList() throws SQLException {
			return memberRecommandDAO.findRecommandMember();
	}
}
