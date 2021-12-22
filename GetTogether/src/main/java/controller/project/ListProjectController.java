package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Project;
import model.service.ProjectManager;

public class ListProjectController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

    	if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	int mnum = MemberSessionUtils.getLoginMemberNum(request.getSession());

    	ProjectManager projectMan = ProjectManager.getInstance();
    	List<Project> pjList = projectMan.findProjectList(mnum);
    	request.setAttribute("projectList", pjList);
		return "/project/manager.jsp";
	}
}
