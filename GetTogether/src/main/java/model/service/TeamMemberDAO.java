package model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.Project;
import model.TeamMember;
import model.dao.JDBCUtil;


public class TeamMemberDAO {
	private JDBCUtil jdbcUtil = null;
	
	public TeamMemberDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체생성
	}
	public int create(Project project, Member member) throws SQLException{
		String sql = "INSERT INTO USERINFO VALUES (?, ?, false)";
		Object[] param = new Object[] {project.getPid(), member.getMnum()};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문생성
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
	

	public List<TeamMember> findMembersInProject(int pid) throws SQLException {
        String sql = "SELECT mnum FROM TeamMember "
     				+ "WHERE pid=? and approve = 1";                         
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pid});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<TeamMember> memList = new ArrayList<TeamMember>();	// member들의 리스트 생성
			while (rs.next()) {
				TeamMember member = new TeamMember(			// 객체를 생성하여 현재 행 정보 저장
					pid,
					rs.getInt("mnum"),
					rs.getBoolean("approve"));
				memList.add(member);			// List에 프젝 객체 저장
			}		
			return memList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public int getNumberOfUsersInProject(int pid) {
		String sql = "SELECT COUNT(mnum) FROM TeamMember "
     				+ "WHERE pid=? and approve = 1";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pid});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			rs.next();										
			return rs.getInt(1);			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return 0;
	}
}
