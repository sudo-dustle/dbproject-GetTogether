package controller.project;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Project;
import model.ProjectManager;

public class UpdateProjectController implements Controller{

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		if (request.getMethod().equals("GET")) {	
    		// GET request: 프젝 수정 form 요청	
    		ProjectManager projectMan = ProjectManager.getInstance();
			Project project = projectMan.findProject(pid);	// 수정하려는 프젝 정보 검색
			request.setAttribute("project", project);		
			return "/project/form.jsp";   // 검색한 정보를 update form으로 전송     
	    }	
    	
		try {
    	// POST request (프로젝트 정보가 parameter로 전송됨)
    	Project project = new Project(	// project 객체를 생성하여 프젝 정보를 저장
    					pid,
    					request.getParameter("title"),
    					request.getParameter("field"),
    					request.getParameter("language"),
    					request.getParameter("subtitle"),null,null,null,null,
    					request.getParameter("goal"),
    					Integer.parseInt(request.getParameter("applicationNum")),
    					request.getParameter("description"),
    					true,
    					Integer.parseInt(request.getParameter("mnum")),
    					Integer.parseInt(request.getParameter("recommendCnt")),
    					Integer.parseInt(request.getParameter("lookupCnt")));

		ProjectManager manager = ProjectManager.getInstance();
		manager.updateProject(project);			
        return "redirect:/project/detail.jsp";	
		}
		catch (Exception e) {
			return "/project/detail.jsp";
		}
    }
}
