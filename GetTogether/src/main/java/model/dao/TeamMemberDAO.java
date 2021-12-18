package model.dao;


import java.sql.SQLException;

import model.TeamMember;

public class TeamMemberDAO {

	private JDBCUtil jdbcUtil = null;
	
	public TeamMemberDAO() {			
		jdbcUtil = new JDBCUtil();
	}

	//mnum pid approve
	public int create(TeamMember teamMember) throws SQLException {
		String sql = "INSERT INTO TEAMMEMBER VALUES (?, ?, ?)";		
		char approve = teamMember.isApprove() ? 'T' : 'F';
		Object[] param = new Object[] {
			teamMember.getMnum(),
			teamMember.getPid(),
			approve
		};
		jdbcUtil.setSqlAndParameters(sql, param);
		try {    
			int result = jdbcUtil.executeUpdate();
		   	return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;			
	}
}
