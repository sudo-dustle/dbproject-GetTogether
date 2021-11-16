package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Message;

public class MessageDAO {
	private JDBCUtil jdbcUtil = null;
	
	public MessageDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * create new message
	 */
	public int create(Message message) throws SQLException {
		String sql = "INSERT INTO Message VALUES (?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {message.getId(), message.getReceiver(), 
						message.getSender(), message.getTitle(), message.getSendDate(),
						message.getContent(), message.isChecked() };				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
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
