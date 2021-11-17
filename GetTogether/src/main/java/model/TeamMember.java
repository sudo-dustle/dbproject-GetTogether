package model;


public class TeamMember {

	private int pid;
	private int mnum;
	private boolean approve;
	
	public TeamMember() {};
	public TeamMember(int pid, int mnum, boolean approve) {
		super();
		this.pid = pid;
		this.mnum = mnum;
		this.approve = approve;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	
	@Override
	public String toString() {
		return "TeamMember [pid=" + pid + ", mnum=" + mnum + ", approve=" + approve + "]";
	}
	
	
	
}
