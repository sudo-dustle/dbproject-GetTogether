package model.service;

import java.sql.SQLException;
import java.util.List;

//import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import model.Member;
import model.dao.MemberDAO;
//import model.service.ExistingUserException;
//import model.service.PasswordMismatchException;
//import model.service.UserNotFoundException;

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
			throw new ExistingUserException(member.getMid()+"�� �̹� �����ϴ� ȸ���Դϴ�.");
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
			throw new UserNotFoundException(mnum + "�� �������� �ʴ� ȸ����ȣ�Դϴ�.");
		}
		
		return member;
	}
	
	public Member findMemberByMid(String mid) throws SQLException, UserNotFoundException {
		Member member = memberDAO.findMemberByMid(mid);
		
		if (member == null) {
			throw new UserNotFoundException(mid + "�� �������� �ʴ� ȸ�� ���̵��Դϴ�.");
		}
		
		return member;
	}
	
	public Member findMember(int mNum) throws SQLException, UserNotFoundException {
		Member member = memberDAO.findMember(mNum);
		if (member == null) {
			throw new UserNotFoundException(mNum + "�� �������� �ʴ� ȸ����ȣ�Դϴ�.");
		}
		return member;
	}
	
	public List<Member> searchMember(String query) throws SQLException, UserNotFoundException {
		List<Member> memberList = memberDAO.searchMember(query);

		return memberList;
	}
	
	public boolean login(String mid, String passwd)
			throws SQLException, UserNotFoundException, PasswordMismatchException {
		Member member = findMemberByMid(mid);
		
		if (member.checkPassword(passwd) == false) {
			System.out.println("in checkPassword");
			System.out.println(member.checkPassword(passwd));
			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}

		return true;
	}
	 
}
