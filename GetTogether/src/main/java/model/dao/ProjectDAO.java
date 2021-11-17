package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;

public class ProjectDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public ProjectDAO() {jdbcUtil = new JDBCUtil(); }
	/**
	 * 프젝 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public Project create(Project project) throws  SQLException{
		/*pid 시퀀스 생성*/
		String sql = "INSERT INTO Project VALUES (pjId_seq.nextval, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?, 0, 0)";
		Object[] param = new Object[] {project.getTitle(),project.getField(),project.getLanguage(),project.getSubtitle(),project.getExecutionStart(),project.getExecutionEnd(),project.getApplicationStart(),project.getApplicationEnd(),project.getGoal(),project.getApplicationNum(),project.getDescription(),project.getMnum()};
		jdbcUtil.setSqlAndParameters(sql, param);
		String key[] = {"pid"};
		try {
			jdbcUtil.executeUpdate(key);  // insert 문 실행
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   // 생성된 PK 값
		   		project.setPid(generatedKey); 	// id필드에 저장  
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
	/**
	 * 기존의 프로젝트 정보를 수정
	 */
	public int update (Project project) throws SQLException{
		String sql = "UPDATE Project "
				+ "SET title=?, field=?, language=?, subtitle=?, executionStart=?, executionEnd=?,applicationStart=?,applicationEnd=?,goal=?,applicationNum=?,description=?,approve=?,recommendCnt+=1, lookupCnt+=1,"
				+ "WHERE pid=?";
		Object[] param = new Object[] {project.getTitle(),project.getField(),project.getLanguage(),project.getSubtitle(),project.getExecutionStart(),project.getExecutionEnd(),project.getApplicationStart(),project.getApplicationEnd(),project.getGoal(),project.getApplicationNum(),project.getDescription(),project.getPid()};
		jdbcUtil.setSqlAndParameters(sql, param);
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	/**
	 * 주어진 pid에 해당하는 프로젝트 정보를 삭제.
	 */
	public int remove(String pid) throws SQLException {
		String sql = "DELETE FROM Community WHERE pid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pid});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/* sql문 수정 아직 안했습니다 할예정임..ㅠ*/
	  	public Project findProject(int pid) throws SQLException {
        String sql = "SELECT ... "
        			+ "FROM ... "
        			+ "WHERE pid=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pid});	// JDBCUtil에 query문과 매개 변수 설정
		Project project = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				project = new Project(		// project 객체를 생성하여 커뮤니티 정보를 저장
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
			jdbcUtil.close();		// resource 반환
		}
		return project;
	}

}
