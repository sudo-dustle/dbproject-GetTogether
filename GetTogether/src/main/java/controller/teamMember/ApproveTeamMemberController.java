package controller.teamMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.TeamMemberManager;

public class ApproveTeamMemberController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int mnum = Integer.parseInt(request.getParameter("mnum"));
		int pid = Integer.parseInt(request.getParameter("pid"));

		TeamMemberManager teamMan = TeamMemberManager.getInstance();
		teamMan.updateApproveTrue(pid, mnum);
		
		return "redirect:/project/detail?pid="+pid;
		}
	}