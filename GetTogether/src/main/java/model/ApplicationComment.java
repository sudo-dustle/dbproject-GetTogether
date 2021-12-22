package model;

import java.util.Date;

public class ApplicationComment {
	int app_id;
	String content;
	Member applicant;
	Date date;
	Project project;
	boolean applicantApproved;

	public ApplicationComment(int app_id, String content, Member applicant, Date date, Project project) {
		super();
		this.app_id = app_id;
		this.content = content;
		this.applicant = applicant;
		this.date = date;
		this.project = project;
		this.applicantApproved = false;
	}

	public ApplicationComment() {
		// TODO Auto-generated constructor stub
	}

	public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Member getApplicant() {
		return applicant;
	}
	public void setApplicant(Member applicant) {
		this.applicant = applicant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	public boolean isApplicantApproved() {
		return applicantApproved;
	}

	public ApplicationComment(int app_id, String content, Member applicant, Date date, Project project,
			boolean applicantApproved) {
		super();
		this.app_id = app_id;
		this.content = content;
		this.applicant = applicant;
		this.date = date;
		this.project = project;
		this.applicantApproved = applicantApproved;
	}

	public void setApplicantApproved(boolean applicantApproved) {
		this.applicantApproved = applicantApproved;
	}
}
