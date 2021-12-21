package model.dao;


import java.sql.ResultSet;
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
			jdbcUtil.close();
		}		
		return 0;			
	}
	
	public int updateApprove(int pid, int mnum, boolean approve) throws SQLException{
		String sql = "UPDATE TEAMMEMBER "
				+ "SET approve=? "
				+ "WHERE pid=? and mnum=?";

		char chApprove = (approve) ? 'T':'F';
		Object[] param = new Object[] {
					chApprove,
					pid,
					mnum
				};
		
		jdbcUtil.setSqlAndParameters(sql, param);
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}
	
	/**
	 *  등록댓글 달았을 때 해당 프로젝트에 사용자가 있는지를 검사한다. 
	 */
	public boolean existingTeamMember(int pid, int mnum) throws SQLException {
		String sql = "SELECT count(*) FROM TEAMMEMBER "
				+ "WHERE pid = ? and mnum = ?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pid, mnum});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

}
