package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
//import controller.member.MemberSessionUtils;
import model.Project;
import model.service.ProjectManager;

public class ProjectSearchController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * if (!MemberSessionUtils.hasLogined(request.getSession())) { return
		 * "redirect:/user/login/form"; }
		 */

    	if (request.getMethod().equals("GET")) {	
    		// GET request: 검색어로 검색하는 경우
    		String query = request.getParameter("srhTxt");
    		String val = request.getParameter("selectTxt");
    		
    		System.out.println("query: "+query);
    		
			if (query != "") {
				if (val.equals("0")) {
					ProjectManager projectManager = ProjectManager.getInstance();
					List<Project> searchedProjectList = projectManager.searchProjectByTitle(query);
					request.setAttribute("projectList", searchedProjectList);
					request.setAttribute("srhTxt", query);
				}
				if (val.equals("1")) {
					ProjectManager projectManager = ProjectManager.getInstance();
					List<Project> searchedProjectList = projectManager.searchProjectByWriter(query);
					request.setAttribute("projectList", searchedProjectList);
					request.setAttribute("srhTxt", query);
				}
			}
			
    	}
    	else {
    		//POST -> language나 관심 분야로 search 할 경우
			/*
			 * String language = request.getParameter("language"); String field =
			 * request.getParameter("field");
			 */
    		
    		//search 로직 (,를 기점으로 나눠서 하나씩 찾는다던지,,)
    		//findUserList(language, field);
    	}
		
		return "/project/searchProject/projectSearch.jsp";
	}
	
}
