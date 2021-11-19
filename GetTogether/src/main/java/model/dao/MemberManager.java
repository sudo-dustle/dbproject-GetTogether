package model.dao;

import java.sql.SQLException;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import model.Member;
import model.service.ExistingUserException;
import model.service.PasswordMismatchException;
import model.service.UserNotFoundException;

public class MemberManager {
	private static MemberManager memMan = new MemberManager();
	private MemberDAO memberDAO;
	
	private MemberManager() {
		try
		{
			memberDAO = new MemberDAO();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static MemberManager getInstance()
	{
		return memMan;
	}
	
	public int create(Member member) throws SQLException, ExistingUserException {
		System.out.println("create in");
		if (memberDAO.existingMember(member.getMid())) {
			throw new ExistingUserException(member.getMid()+"는 존재하는 아이디입니다.");
		}
		
		return memberDAO.create(member);
	}
	
	public int update(Member member) throws SQLException {
		return memberDAO.update(member);
	}
	
	public int remove(String mid) throws SQLException {
		return memberDAO.remove(mid);
	}
	
	public Member findMemberByMnum(int mnum) throws SQLException, UserNotFoundException {
		Member member = memberDAO.findMemberByMnum(mnum);
		
		if(mnum < 0) {
			throw new UserNotFoundException(mnum + "은 존재하지 않는 유저 번호입니다.");
		}
		
		return member;
	}
	
	public Member findMemberByMid(String mid) throws SQLException, UserNotFoundException {
		Member member = memberDAO.findMemberByMid(mid);
		
		if (member == null) {
			throw new UserNotFoundException(mid + "는 존재하는 아이디입니다.");
		}
		
		return member;
	}
	
	
	public boolean login(String mid, String passwd)
			throws SQLException, UserNotFoundException, PasswordMismatchException {
		Member member = findMemberByMid(mid);
		
		System.out.println("mid=" + mid);
		System.out.println("password=" + passwd);
		
		if (member.checkPassword(passwd) == false) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}

		return true;
	}
	 
}
