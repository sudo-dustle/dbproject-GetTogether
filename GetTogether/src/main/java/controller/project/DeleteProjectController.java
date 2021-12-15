package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.Controller;
import model.service.ProjectManager;

public class DeleteProjectController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      int pid = Integer.parseInt(request.getParameter("pid"));
	      
	      try {
	         ProjectManager manager = ProjectManager.getInstance();
	         manager.removeProject(pid);
	         
	         return "redirect:/";
	      }
	      catch (Exception e) {
	         return "/project/detail";
	      }
	   }


}
