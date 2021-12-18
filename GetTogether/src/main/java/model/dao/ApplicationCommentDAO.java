package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ApplicationComment;

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
}
