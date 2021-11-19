package model;
import java.util.Date;
import java.util.List;

public class MemberRecommend {
	
	private String mname;
	private String language;
	private List<Member> memberList;
	private List<Project> projectList;
	
	
	public MemberRecommend() {}
	
	public MemberRecommend(String mname, String language) {
		super();
		this.mname = mname;
		this.language = language;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public MemberRecommend(List<Member> memberList, List<Project> projectList) {
		super();
		this.memberList = memberList;
		this.projectList = projectList;
	}

	public List<Member> getMemberList() {
		return memberList;
	}
	
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	
	public List<Project> getProjectList() {
		return projectList;
	}
	
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	
	
}
