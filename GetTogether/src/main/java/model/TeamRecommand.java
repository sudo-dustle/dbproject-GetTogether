package model;
import java.util.Date;
import java.util.List;
public class TeamRecommand {
	private String title;
	private String subtitle;
	private int lookupcnt;
	private List<Member> memberList;
	private List<Project> projectList;

	public TeamRecommand() {}
	
	public TeamRecommand(String title, String subtitle, int lookupcnt) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.lookupcnt = lookupcnt;
	}

	public TeamRecommand(List<Member> memberList, List<Project> projectList) {
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



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getSubtitle() {
		return subtitle;
	}



	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}



	public int getLookupcnt() {
		return lookupcnt;
	}



	public void setLookupcnt(int lookupcnt) {
		this.lookupcnt = lookupcnt;
	}
	
}
