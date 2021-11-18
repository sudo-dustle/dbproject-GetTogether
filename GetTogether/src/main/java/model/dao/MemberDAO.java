package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.Member;

public class MemberDAO {
	private JDBCUtil jdbcUtil = new JDBCUtil();

	public int create(Member member) throws SQLException {
		String query = "INSERT INTO Member VALUES (seq_mnum.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] { member.getMid(), member.getPasswd(), member.getMname(),
				member.getDate(), member.getPhonenum(), member.getEmail(), member.getSchool(), member.getMajor(),
				member.getField(), member.getLanguage(), member.getExperience() };

		jdbcUtil.setSqlAndParameters(query, param);

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

	public boolean existingMember(String mid) throws SQLException {
		String sql = "SELECT count(*) FROM MEMBER WHERE mid=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {mid});	// JDBCUtil에 query문과 매개 변수 설정

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
	
	public Member findMember(String mid) throws SQLException {
		String query = "SELECT seq_mnum, mid, passwd, mname, date, phonenum, email, school, major, field, language, experience"
				+ "FROM Member WHERE mnum=?";
		
		jdbcUtil.setSql(query);
		
		Object[] param = new Object[] {mid};
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			Member member = null;
			
			
			if(rs.next()) {
				member = new Member();
				
				member.setMnum(rs.getInt("mnum"));
				member.setMid(rs.getString("mid"));
				member.setPasswd(rs.getString("passwd"));
				member.setMname(rs.getString("mname"));
				
				//date타입 처리
				SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
				Date date = (Date) fm.parse(rs.getString("date"));
				
				member.setDate(date);
				
				member.setPhonenum(rs.getString("phonenum"));
				member.setEmail(rs.getString("email"));
				member.setSchool(rs.getString("school"));
				member.setMajor(rs.getString("major"));
				member.setField(rs.getString("field"));
				member.setLanguage(rs.getString("language"));
				member.setExperience(rs.getString("experience"));
			}
			return member;
		}catch(Exception ex) {
			
		}
		finally {
			jdbcUtil.close();
		}

		return null;
	}
	
	public int update(Member member) throws SQLException {
		String sql = "UPDATE MEMBER "
					+ "SET mid=?, passwd=?, mname=?, date=?, phonenum=?, email=?, school=?, major=?, field=?, "
					+ "language=?, experience=?"
					+ "WHERE mnum=?";
		Object[] param = new Object[] { member.getMid(), member.getPasswd(), member.getMname(), member.getDate(),
				member.getPhonenum(), member.getEmail(), member.getSchool(), member.getMajor(), member.getField(), 
					member.getEmail(), member.getMnum()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
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

	public int remove(String mid) throws SQLException {
		String sql = "DELETE FROM MEMBER WHERE mid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {mid});	// JDBCUtil에 delete문과 매개 변수 설정

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

}
