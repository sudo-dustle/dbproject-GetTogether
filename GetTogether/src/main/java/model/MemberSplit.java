package model;

public class MemberSplit {
	private int mnum;
	private String field;
	private String language;
	
	
	public MemberSplit(int mnum, String field, String language) {
		super();
		this.mnum = mnum;
		this.field = field;
		this.language = language;
	}


	public MemberSplit() {
		// TODO Auto-generated constructor stub
	}


	public int getMnum() {
		return mnum;
	}


	public void setMnum(int mnum) {
		this.mnum = mnum;
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
}
