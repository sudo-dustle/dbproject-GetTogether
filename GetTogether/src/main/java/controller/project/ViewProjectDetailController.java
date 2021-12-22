package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ApplicationComment;
import model.Project;
import model.service.ApplicationCommentManager;
import model.service.ProjectManager;

public class ViewProjectDetailController implements Controller {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
		ProjectManager manager = ProjectManager.getInstance();
		ApplicationCommentManager commentMan = ApplicationCommentManager.getInstance();
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		Project project = manager.findProject(pid);	
		
		int lookupCnt = project.getLookupCnt()+1;
		project.setLookupCnt(lookupCnt);
		manager.updateLookupCnt(pid, lookupCnt);
		
		List<ApplicationComment> commentList = commentMan.findListByPid(pid);
		
		request.setAttribute("project", project);
		request.setAttribute("commentList", commentList);
		return "/project/detail.jsp";				// 화면으로 이동
    }
}