package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;

import model.Member;
import model.Message;
import model.Project;

public class ProjectDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public ProjectDAO() {jdbcUtil = new JDBCUtil(); }
	
	public Project create(Project project) throws  SQLException{
		
		String sql = "INSERT INTO Project VALUES (seq_pid.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?, 0, 0)";
		long time = project.getExecutionStart().getTime();
		java.sql.Date ExecutionStart = new java.sql.Date(time);
		time = project.getExecutionEnd().getTime();
		java.sql.Date ExecutionEnd = new java.sql.Date(time);
		time = project.getApplicationStart().getTime();
		java.sql.Date ApplicationStart = new java.sql.Date(time);
		time = project.getApplicationEnd().getTime();
		java.sql.Date ApplicationEnd = new java.sql.Date(time);
		Object[] param = new Object[] {project.getTitle(),project.getField(),project.getLanguage(),project.getSubtitle()
				,ExecutionStart,ExecutionEnd,ApplicationStart
				,ApplicationEnd,project.getGoal(),project.getApplicationNum(),project.getDescription()
				,project.getMnum()};
		jdbcUtil.setSqlAndParameters(sql, param);
		String key[] = {"pid"};
		try {
			jdbcUtil.executeUpdate(key);  
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   
		   		project.setPid(generatedKey); 	  
		   	}
		   	return project;
		}  	catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}
	
	public int update (Project project) throws SQLException{
		String sql = "UPDATE Project "
				+ "SET title=?, field=?, language=?, subtitle=?, executionStart=?, executionEnd=?,applicationStart=?,applicationEnd=?,goal=?,applicationNum=?,description=?"
				+ "WHERE pid=?";
		long time = project.getExecutionStart().getTime();
		java.sql.Date ExecutionStart = new java.sql.Date(time);
		time = project.getExecutionEnd().getTime();
		java.sql.Date ExecutionEnd = new java.sql.Date(time);
		time = project.getApplicationStart().getTime();
		java.sql.Date ApplicationStart = new java.sql.Date(time);
		time = project.getApplicationEnd().getTime();
		java.sql.Date ApplicationEnd = new java.sql.Date(time);
		
		Object[] param = new Object[] {
				project.getTitle(),
				project.getField(),
				project.getLanguage(),
				project.getSubtitle(),
				ExecutionStart,
				ExecutionEnd,
				ApplicationStart,
				ApplicationEnd,
				project.getGoal(),
				project.getApplicationNum(),
				project.getDescription(),
				project.getPid()};
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
	
	public int updateLookupCnt(int pid, int lookupCnt) throws SQLException{
		String sql = "UPDATE Project "
				+ "SET lookupcnt=? "
				+ "WHERE pid=?";

		Object[] param = new Object[] {
				lookupCnt++,
				pid};
		
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
	
	public int remove(int pid) throws SQLException {
		String sql = "DELETE FROM Project WHERE pid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pid});	

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

	  	public Project findProject(int pid) throws SQLException {
        String sql = "SELECT title, field, language, subtitle, executionStart, executionEnd, applicationStart, applicationEnd, goal, applicationNum, description, approve, mnum, recommendCnt, lookupCnt "
        			+ "FROM Project "
        			+ "WHERE pid=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pid});	
		Project project = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			if (rs.next()) {						
				project = new Project(		
					pid,
					rs.getString("title"),
					rs.getString("field"),
					rs.getString("language"),
					rs.getString("subtitle"),
					rs.getDate("executionStart"),
					rs.getDate("executionEnd"),
					rs.getDate("applicationStart"),
					rs.getDate("applicationEnd"),
					rs.getString("goal"),
					rs.getInt("applicationNum"),
					rs.getString("description"),
					rs.getBoolean("approve"),
					rs.getInt("mnum"),
					rs.getInt("recommendCnt"),
					rs.getInt("lookupCnt"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return project;
	}

	  	public List<Project> searchProjectByTitle(String query) throws SQLException {
			String sql = "SELECT * FROM PROJECT WHERE TITLE LIKE ?";
			Object[] param = new Object[] { "%"+query+"%" };

			jdbcUtil.setSqlAndParameters(sql, param);

			try {
				ResultSet rs = jdbcUtil.executeQuery();
				List<Project> projectList = new ArrayList<Project>();

				while (rs.next()) {
					Project project = new Project();

					project.setPid(rs.getInt("pid"));
					project.setTitle(rs.getString("title"));
					project.setField(rs.getString("field"));
					project.setLanguage(rs.getString("language"));
					project.setSubtitle(rs.getString("subtitle"));
					project.setExecutionStart(rs.getDate("executionStart"));
					project.setExecutionEnd(rs.getDate("executionEnd"));
					project.setApplicationStart(rs.getDate("applicationStart"));
					project.setApplicationEnd(rs.getDate("applicationEnd"));
					project.setApplicationNum(rs.getInt("applicationNum"));
					project.setGoal(rs.getString("goal"));
					project.setDescription(rs.getString("description"));
					project.setApprove(rs.getBoolean("approve"));
					project.setMnum(rs.getInt("mnum"));
					project.setRecommendCnt(rs.getInt("recommendCnt"));
					project.setLookupCnt(rs.getInt("lookupcnt"));

					projectList.add(project);
				}
				return projectList;
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			return null;		
		}
	  	
	  	public List<Project> searchProjectByWriter(String query) throws SQLException {
			String sql = "SELECT * FROM MEMBER M, PROJECT P WHERE M.MNUM = P.MNUM AND M.MNAME LIKE ?";
			Object[] param = new Object[] { "%"+query+"%" };

			jdbcUtil.setSqlAndParameters(sql, param);

			try {
				ResultSet rs = jdbcUtil.executeQuery();
				List<Project> projectList = new ArrayList<Project>();

				while (rs.next()) {
					Project project = new Project();

					project.setPid(rs.getInt("pid"));
					project.setTitle(rs.getString("title"));
					project.setField(rs.getString("field"));
					project.setLanguage(rs.getString("language"));
					project.setSubtitle(rs.getString("subtitle"));
					project.setExecutionStart(rs.getDate("executionStart"));
					project.setExecutionEnd(rs.getDate("executionEnd"));
					project.setApplicationStart(rs.getDate("applicationStart"));
					project.setApplicationEnd(rs.getDate("applicationEnd"));
					project.setApplicationNum(rs.getInt("applicationNum"));
					project.setGoal(rs.getString("goal"));
					project.setDescription(rs.getString("description"));
					project.setApprove(rs.getBoolean("approve"));
					project.setMnum(rs.getInt("mnum"));
					project.setRecommendCnt(rs.getInt("recommendCnt"));
					project.setLookupCnt(rs.getInt("lookupcnt"));

					projectList.add(project);
				}
				return projectList;
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			return null;		
		}

	  	public List<Project> findProjectList(int mnum) throws SQLException {
			String sql = "SELECT PID, TITLE, SUBTITLE, applicationNum FROM PROJECT WHERE MNUM=? ";
			jdbcUtil.setSqlAndParameters(sql, new Object[] {mnum});
			try {
				ResultSet rs = jdbcUtil.executeQuery();
				List<Project> pjList = new ArrayList<Project>();
				while (rs.next()) {
					int pid = rs.getInt("pid");
					String title = rs.getString("title");
					String subtitle = rs.getString("subtitle");
					int applicationNum = rs.getInt("applicationNum");
					
					Project pj = new Project(
							pid,
							title,
							subtitle,
							applicationNum
							);
					pjList.add(pj);
				}
				return pjList;
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		
			}
			return null;
		}

}
