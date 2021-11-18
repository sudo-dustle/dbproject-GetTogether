package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class ProjectSearchController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectManager manager = ProjectManager.getInstance();
		List <Project> projectList = manager.findProject();
		
		request.setAttribute("projectList", projectList);
		
		return "/project/projectSearch.jsp";
	}
	
}
