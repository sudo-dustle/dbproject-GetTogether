package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.comm.UpdateCommunityController;
import model.ApplicationComment;
import model.Member;
import model.Message;
import model.Project;

public class ApplicationCommentDAO {
	private JDBCUtil jdbcUtil = null;

	public ApplicationCommentDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

	public int create(ApplicationComment comment) throws SQLException {
		String sql = "INSERT INTO ApplicationComment VALUES (seq_appid.nextval, ?, ?, SYSDATE, ?)";		
		Object[] param = new Object[] {
			comment.getContent(),
			comment.getApplicant().getMnum(),
			comment.getProject().getPid()
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
	
	public List<ApplicationComment> findListByPid(int pId) throws SQLException {
		String sql = "SELECT APP_ID, CONTENT, MNUM, COMMENTDATE, PID FROM APPLICATIONCOMMENT WHERE PID=? "
				+ "ORDER BY COMMENTDATE DESC";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {pId});
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<ApplicationComment> commentList = null;
			commentList = new ArrayList<ApplicationComment>();
			while (rs.next()) {
				Member applicant = new Member();
				applicant.setMnum(rs.getInt("mnum"));
				Project project = new Project();
				project.setPid(rs.getInt("pid"));
				ApplicationComment comment = new ApplicationComment(
					rs.getInt("app_id"),
					rs.getString("content"),
					applicant,
					rs.getDate("commentdate"),
					project
				);
				commentList.add(comment);
			}
			return commentList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
