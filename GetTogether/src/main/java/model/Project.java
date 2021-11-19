package model;

import java.util.Date;
import java.util.List;

public class Project {

	private int pid;
	private String title;
	private String field;
	private String language;
	private String subtitle;
	private Date executionStart;
	private Date executionEnd;
	private Date applicationStart;
	private Date applicationEnd;
	private String goal;
	private int applicationNum;
	private String description;
	private boolean approve;
	private int mnum;
	private int recommendCnt;
	private int lookupCnt;
	 //skill 삭제했습니다.
	private List<TeamMember> memberList;
	private int numOfMembers;
	
	public Project() {}
	
	public Project(int pid, String title, String field, String language, String subtitle, Date executionStart,
			Date executionEnd, Date applicationStart, Date applicationEnd, String goal, int applicationNum,
			String description, boolean approve, int mnum, int recommendCnt, int lookupCnt) {
		super();
		this.pid = pid;
		this.title = title;
		this.field = field;
		this.language = language;
		this.subtitle = subtitle;
		this.executionStart = executionStart;
		this.executionEnd = executionEnd;
		this.applicationStart = applicationStart;
		this.applicationEnd = applicationEnd;
		this.goal = goal;
		this.applicationNum = applicationNum;
		this.description = description;
		this.approve = approve;
		this.mnum = mnum;
		this.recommendCnt = recommendCnt;
		this.lookupCnt = lookupCnt;
	}

	public Project( String title, String field, String language, String subtitle, Date executionStart,
			Date executionEnd, Date applicationStart, Date applicationEnd, String goal, int applicationNum,
			String description, boolean approve, int mnum, int recommendCnt, int lookupCnt) {
		super();
		this.title = title;
		this.field = field;
		this.language = language;
		this.subtitle = subtitle;
		this.executionStart = executionStart;
		this.executionEnd = executionEnd;
		this.applicationStart = applicationStart;
		this.applicationEnd = applicationEnd;
		this.applicationNum = applicationNum;
		this.goal = goal;
		this.description = description;
		this.approve = approve;
		this.mnum = mnum;
		this.recommendCnt = recommendCnt;
		this.lookupCnt = lookupCnt;
	}

	
	public Project(String title, String field, String language, String subtitle, String goal,
			int applicationNum, String description, boolean approve, int mnum, int recommendCnt, int lookupCnt) {
		super();
		this.title = title;
		this.field = field;
		this.language = language;
		this.subtitle = subtitle;
		this.goal = goal;
		this.applicationNum = applicationNum;
		this.description = description;
		this.approve = approve;
		this.mnum = mnum;
		this.recommendCnt = recommendCnt;
		this.lookupCnt = lookupCnt;
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
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Date getExecutionStart() {
		return executionStart;
	}
	public void setExecutionStart(Date executionStart) {
		this.executionStart = executionStart;
	}
	public Date getExecutionEnd() {
		return executionEnd;
	}
	public void setExecutionEnd(Date executionEnd) {
		this.executionEnd = executionEnd;
	}
	public Date getApplicationStart() {
		return applicationStart;
	}
	public void setApplicationStart(Date applicationStart) {
		this.applicationStart = applicationStart;
	}
	public Date getApplicationEnd() {
		return applicationEnd;
	}
	public void setApplicationEnd(Date applicationEnd) {
		this.applicationEnd = applicationEnd;
	}
	public int getApplicationNum() {
		return applicationNum;
	}
	public void setApplicationNum(int applicationNum) {
		this.applicationNum = applicationNum;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public int getRecommendCnt() {
		return recommendCnt;
	}
	public void setRecommendCnt(int recommendCnt) {
		this.recommendCnt = recommendCnt;
	}
	public int getLookupCnt() {
		return lookupCnt;
	}
	public void setLookupCnt(int lookupCnt) {
		this.lookupCnt = lookupCnt;
	}

	
	public List<TeamMember> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<TeamMember> memberList) {
		this.memberList = memberList;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}

	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", title=" + title + ", field=" + field + ", language=" + language
				+ ", subtitle=" + subtitle + ", executionStart=" + executionStart + ", executionEnd=" + executionEnd
				+ ", applicationStart=" + applicationStart + ", applicationEnd=" + applicationEnd + ", goal=" + goal
				+ ", applicationNum=" + applicationNum + ", description=" + description + ", approve=" + approve
				+ ", mnum=" + mnum + ", recommendCnt=" + recommendCnt + ", lookupCnt=" + lookupCnt + "]";
	}
	
	
	
}
