package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Project;
import model.service.ProjectManager;

public class ViewProjectDetailController implements Controller {

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			

		ProjectManager manager = ProjectManager.getInstance();
		int pid = Integer.parseInt(request.getParameter("pid"));
		Project project = manager.findProject(pid);		// 정보 검색			

		request.setAttribute("project", project);	//  정보 저장				
		return "/project/detail.jsp";				// 화면으로 이동
    }
}