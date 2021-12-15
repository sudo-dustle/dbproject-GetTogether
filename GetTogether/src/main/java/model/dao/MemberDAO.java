package model.dao;

//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Member;

public class MemberDAO {
	private JDBCUtil jdbcUtil = new JDBCUtil();

	public int create(Member member) throws SQLException {
		String query = "INSERT INTO Member VALUES (seq_mnum.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		long time = member.getDate().getTime();
		java.sql.Date date = new java.sql.Date(time); 
		
		Object[] param = new Object[] { member.getMid(), member.getPasswd(), member.getMname(), date,
				member.getPhonenum(), member.getEmail(), member.getSchool(), member.getMajor(), member.getField(),
				member.getLanguage(), member.getExperience() };

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
		jdbcUtil.setSqlAndParameters(sql, new Object[] { mid });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return false;
	}

	public Member findMemberByMnum(int mnum) throws SQLException {
		String query = "SELECT mnum, mid, passwd, mname, birth, phonenum, email, school, major, field, language, experience "
				+ "FROM Member WHERE mnum=?";
		Object[] param = new Object[] { mnum };

		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			Member member = null;

			if (rs.next()) {
				member = new Member();

				member.setMnum(rs.getInt("mnum"));
				member.setMid(rs.getString("mid"));
				member.setPasswd(rs.getString("passwd"));
				member.setMname(rs.getString("mname"));
				member.setDate(rs.getDate("birth"));
				member.setPhonenum(rs.getString("phonenum"));
				member.setEmail(rs.getString("email"));
				member.setSchool(rs.getString("school"));
				member.setMajor(rs.getString("major"));
				member.setField(rs.getString("field"));
				member.setLanguage(rs.getString("language"));
				member.setExperience(rs.getString("experience"));

				System.out.println("mnum= " + member.getMnum());
				System.out.println("mid= " + member.getMid());
				System.out.println("passwd= " + member.getPasswd());
			}
			return member;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}

		return null;

	}

	public Member findMemberByMid(String mid) throws SQLException {
		String query = "SELECT mnum, mid, passwd, mname, birth, phonenum, email, school, major, field, language, experience "
				+ "FROM Member WHERE mid=?";

		Object[] param = new Object[] { mid };

		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			Member member = null;

			if (rs.next()) {
				member = new Member();

				member.setMnum(rs.getInt("mnum"));
				member.setMid(rs.getString("mid"));
				member.setPasswd(rs.getString("passwd"));
				member.setMname(rs.getString("mname"));
				member.setDate(rs.getDate("birth"));
				member.setPhonenum(rs.getString("phonenum"));
				member.setEmail(rs.getString("email"));
				member.setSchool(rs.getString("school"));
				member.setMajor(rs.getString("major"));
				member.setField(rs.getString("field"));
				member.setLanguage(rs.getString("language"));
				member.setExperience(rs.getString("experience"));
			}
			return member;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public Member findMember(int mNum) throws SQLException {
		String query = "SELECT mnum, mid, passwd, mname, birth, phonenum, email, school, major, field, language, experience "
				+ "FROM Member WHERE mnum=?";

		Object[] param = new Object[] { mNum };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			Member member = null;

			if (rs.next()) {
				member = new Member();

				member.setMnum(rs.getInt("mnum"));
				member.setMid(rs.getString("mid"));
				member.setPasswd(rs.getString("passwd"));
				member.setMname(rs.getString("mname"));
				member.setDate(new java.util.Date(rs.getDate("birth").getTime()));
				member.setPhonenum(rs.getString("phonenum"));
				member.setEmail(rs.getString("email"));
				member.setSchool(rs.getString("school"));
				member.setMajor(rs.getString("major"));
				member.setField(rs.getString("field"));
				member.setLanguage(rs.getString("language"));
				member.setExperience(rs.getString("experience"));
			}
			return member;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public int update(Member member) throws SQLException {
		String sql = "UPDATE MEMBER "
				+ "SET passwd=?, mname=?, birth=?, phonenum=?, email=?, school=?, major=?, field=?, "
				+ "language=?, experience=? WHERE mid=?";
		
		long time = member.getDate().getTime();
		java.sql.Date date = new java.sql.Date(time); 
		
		Object[] param = new Object[] { member.getPasswd(), member.getMname(), date,
				member.getPhonenum(), member.getEmail(), member.getSchool(), member.getMajor(), member.getField(),
				member.getLanguage(), member.getExperience(), member.getMid() };
		
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

	public int remove(String mid) throws SQLException {
		String sql = "DELETE FROM MEMBER WHERE mid=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { mid }); 
		
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
	
	public List<Member> searchMember(String query) throws SQLException {
		String sql = "SELECT * FROM MEMBER WHERE MNAME LIKE ? OR EXPERIENCE LIKE ?";
		Object[] param = new Object[] { query , "%"+query+"%" };

		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Member> memberList = new ArrayList<Member>();

			while (rs.next()) {
				Member member = new Member();

				member.setMnum(rs.getInt("mnum"));
				member.setMid(rs.getString("mid"));
				member.setPasswd(rs.getString("passwd"));
				member.setMname(rs.getString("mname"));
				member.setDate(rs.getDate("birth"));
				member.setPhonenum(rs.getString("phonenum"));
				member.setEmail(rs.getString("email"));
				member.setSchool(rs.getString("school"));
				member.setMajor(rs.getString("major"));
				member.setField(rs.getString("field"));
				member.setLanguage(rs.getString("language"));
				member.setExperience(rs.getString("experience"));

				memberList.add(member);
			}
			return memberList;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;		
	}

}
