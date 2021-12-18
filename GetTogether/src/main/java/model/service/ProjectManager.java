package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Project;
import model.TeamMember;
import model.dao.ProjectDAO;
public class ProjectManager {

	private static ProjectManager projectMan = new ProjectManager();

	private ProjectDAO projectDAO;
	private TeamMemberDAO teamMemberDAO;
	private ProjectManager() {
		try {
			projectDAO = new ProjectDAO();
			teamMemberDAO = new TeamMemberDAO();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public static ProjectManager getInstance() {
		return projectMan;
	}

	public int removeProject(int pid) throws SQLException {
		return projectDAO.remove(pid);
	}
	public Project createProject(Project project) throws SQLException{
		return projectDAO.create(project);
	}

	public int updateProject(Project project) throws SQLException{
		return projectDAO.update(project);
	}

	 public Project findProject(int pid) throws SQLException {
		Project project = projectDAO.findProject(pid); 

//		List<TeamMember> memberList = teamMemberDAO.findMembersInProject(pid);
//		project.setMemberList(memberList);

//		int numOfMembers = teamMemberDAO.getNumberOfUsersInProject(pid);
//		project.setNumOfMembers(numOfMembers);
		return project;
	}
	public int updateLookupCnt(int pid, int lookupCnt) throws SQLException{
		return projectDAO.updateLookupCnt(pid, lookupCnt);
	}
}