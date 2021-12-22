package controller.project;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Project;
import model.service.ProjectManager;

public class UpdateProjectController implements Controller{
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
		if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	int mnum = MemberSessionUtils.getLoginMemberNum(request.getSession());
    	
		int pid = Integer.parseInt(request.getParameter("pid"));
		if (request.getMethod().equals("GET")) {	
    		// GET request: 프젝 수정 form 요청	
			ProjectManager projectMan = ProjectManager.getInstance();
			Project project = projectMan.findProject(pid);	// 수정하려는 프젝 정보 검색
			request.setAttribute("project", project);		
			return "/project/updateForm.jsp";  
	    }	

		//try {
    	// POST request (프로젝트 정보가 parameter로 전송됨)
			 Date executionStart = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("executionStart"));
			  Date executionEnd = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("executionEnd"));
			  Date applicationStart = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("applicationStart"));
			  Date applicationEnd = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("applicationEnd"));
			
			  String[] lan = request.getParameterValues("language");
			  String language = lan[0];
			  for(int i = 1; i< lan.length;i++) {
				  language += ','+lan[i]; 
			  }
			Project project = new Project(
					Integer.parseInt(request.getParameter("pid")),
					request.getParameter("title"),
					request.getParameter("field"),
					language,
					request.getParameter("subtitle"), 
					executionStart,
					executionEnd,
					applicationStart,
					applicationEnd,
					request.getParameter("goal"), 
					Integer.parseInt(request.getParameter("applicationNum")), 
					request.getParameter("description"), 
					true, mnum, 0,0); 

		 	
			ProjectManager projectMan = ProjectManager.getInstance();
			projectMan.updateProject(project);
    	
        return "redirect:/project/detail?pid="+project.getPid();	
/*	}
		catch (Exception e) {
			request.setAttribute("ExistingProjectException", e);
			request.setAttribute("registerFailed", true);
			return "/project/updateForm.jsp";
		}*/
    }
}