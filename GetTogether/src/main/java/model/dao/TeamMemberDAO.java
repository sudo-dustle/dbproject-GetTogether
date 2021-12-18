package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.Project;
import model.TeamMember;


public class TeamMemberDAO {
	private JDBCUtil jdbcUtil = null;
	
	public TeamMemberDAO() {			
		jdbcUtil = new JDBCUtil();	
	}
	public int create(Project project, Member member) throws SQLException{
		String sql = "INSERT INTO USERINFO VALUES (?, ?, false)";
		Object[] param = new Object[] {project.getPid(), member.getMnum()};
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
	

	public List<TeamMember> findMembersInProject(int pid) throws SQLException {
        String sql = "SELECT mnum FROM TeamMember "
     				+ "WHERE pid=? and approve = 1";                         
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pid});	
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<TeamMember> memList = new ArrayList<TeamMember>();	
			while (rs.next()) {
				TeamMember member = new TeamMember(			
					pid,
					rs.getInt("mnum"),
					rs.getBoolean("approve"));
				memList.add(member);		
			}		
			return memList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return null;
	}
	
	public int getNumberOfUsersInProject(int pid) {
		String sql = "SELECT COUNT(mnum) FROM TeamMember "
     				+ "WHERE pid=? and approve = 1";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pid});	
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			rs.next();										
			return rs.getInt(1);			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return 0;
	}
}
