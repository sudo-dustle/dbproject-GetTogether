package model.dao;

import java.sql.SQLException;

import model.TeamMember;

public class TeamMemberDAO {

	private JDBCUtil jdbcUtil = null;
	
	public TeamMemberDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

	//mnum pid approve
	public int create(TeamMember teamMember) throws SQLException {
		String sql = "INSERT INTO TEAMMEMBER VALUES (?, ?, ?)";		
		char approve = teamMember.isApprove() ? 'Y' : 'N';
		Object[] param = new Object[] {
			teamMember.getMnum(),
			teamMember.getPid(),
			approve
		};
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
		try {    
			int result = jdbcUtil.executeUpdate();  // insert 문 실행
		   	return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}
}
