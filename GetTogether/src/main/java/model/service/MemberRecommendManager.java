package model.service;

import java.sql.SQLException;
import java.util.List;

import model.MemberRecommend;
import model.dao.MemberRecommendDAO;


public class MemberRecommendManager {
	private static MemberRecommendManager memberRecommendMan = new MemberRecommendManager();
	private MemberRecommendDAO memberRecommendDAO;


	private MemberRecommendManager() {
		try {
			memberRecommendDAO = new MemberRecommendDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MemberRecommendManager getInstance() {
		return memberRecommendMan;
	}

	public List<MemberRecommend> findRecommendMemberList() throws SQLException {
			return memberRecommendDAO.findRecommendMember();
	}
}
