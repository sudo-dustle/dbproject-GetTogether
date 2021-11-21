package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import controller.Controller;
import model.Project;
import model.service.ProjectManager;

public class CreateProjectController implements Controller{

	@Override
	// request를 처리한 후 이동할 URL을 반환
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		/*if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/member/login/form";
		}*/
		  Date executionStart = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("executionStart"));
		  Date executionEnd = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("executionEnd"));
		  Date applicationStart = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("applicationStart"));
		  Date applicationEnd = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("applicationEnd"));
		
		  String[] lan = request.getParameterValues("language");
		  String language = lan[0];
		  for(int i = 1; i< lan.length;i++) {
			  language += ','+lan[i]; 
		  }
		Project project = new Project(request.getParameter("title"),request.getParameter("field"),language,request.getParameter("subtitle"), executionStart,executionEnd,applicationStart,applicationEnd,
				request.getParameter("goal"), Integer.parseInt(request.getParameter("applicationNum")), request.getParameter("description"), true, 2, 0,0);

		ProjectManager projectMan = ProjectManager.getInstance();
		project = projectMan.createProject(project);

		return "redirect:/project/detail?pid="+project.getPid(); //성공시 이동
		/*try {
			ProjectManager projectMan = ProjectManager.getInstance();
			projectMan.createProject(project);

			
			return "/project/form.jsp"; //성공시 이동
		} catch(Exception e) {
			request.setAttribute("registerFailed", true);
			request.setAttribute("Project", project);
			request.setAttribute("ExistingProjectException", e);
			return "redirect:/project/list.jsp"; //실패시 여기로
		}*/
	}

}