package model;

import java.util.Date;

public class Member {
	private int mnum;
	private String mid;
	private String passwd;
	private String mname;
	private Date date;
	private String phonenum;
	private String email;
	private String school;
	private String major;
	private String field;
	private String language;
	private String experience;
	
	public Member() {}
	
	//시퀀스(mnum)없는 생성자
	public Member(String mid, String passwd, String mname, Date date, String phonenum, String email,
			String school, String major, String field, String language, String experience)
	{
		this.mid = mid;
		this.passwd = passwd;
		this.mname = mname;
		this.date = date;
		this.phonenum = phonenum;
		this.email = email;
		this.school = school;
		this.major = major;
		this.field = field;
		this.language = language;
		this.experience = experience;
	}
	
	//시퀀스(mnum)있는 생성자
	public Member(int mnum, String mid, String passwd, String mname, Date date, String phonenum, String email,
			String school, String major, String field, String language, String experience)
	{
		this.mnum = mnum;
		this.mid = mid;
		this.passwd = passwd;
		this.mname = mname;
		this.date = date;
		this.phonenum = phonenum;
		this.email = email;
		this.school = school;
		this.major = major;
		this.field = field;
		this.language = language;
		this.experience = experience;
	}

	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean checkPassword(String passwd) {
		
		if (passwd.equals(this.passwd))
			return true;
		else
			return false;
	}

}
