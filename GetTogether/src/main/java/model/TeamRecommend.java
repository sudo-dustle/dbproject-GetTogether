package model;
import java.util.Date;
import java.util.List;
public class TeamRecommend {
	private int pid;
	private String title;
	private String subtitle;
	private int lookupcnt;
	private int recommendcnt;
	private List<Member> memberList;
	private List<Project> projectList;

	public TeamRecommend() {}
	
	public TeamRecommend(int pid, String title, String subtitle, int lookupcnt, int recommendcnt) {
		super();
		this.pid = pid;
		this.title = title;
		this.subtitle = subtitle;
		this.lookupcnt = lookupcnt;
		this.recommendcnt = recommendcnt;
	}

	public TeamRecommend(List<Member> memberList, List<Project> projectList) {
		super();
		this.memberList = memberList;
		this.projectList = projectList;
	}

	
	public int getRecommendcnt() {
		return recommendcnt;
	}

	public void setRecommendcnt(int recommendcnt) {
		this.recommendcnt = recommendcnt;
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

	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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
