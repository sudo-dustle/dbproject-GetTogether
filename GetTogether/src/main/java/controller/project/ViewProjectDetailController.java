package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.comm.CreateCommunityController;
import model.Project;
import model.service.ProjectManager;

public class ViewProjectDetailController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ViewProjectDetailController.class);
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			

		ProjectManager manager = ProjectManager.getInstance();
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		Project project = manager.findProject(pid);	
		int lookupCnt = project.getLookupCnt() + 1;
		project.setLookupCnt(lookupCnt);
		manager.updateLookupCnt(pid, lookupCnt);
		
		log.debug("Create Community : {}", project);
		request.setAttribute("project", project);	//  정보 저장				
		return "/project/detail.jsp";				// 화면으로 이동
    }
}