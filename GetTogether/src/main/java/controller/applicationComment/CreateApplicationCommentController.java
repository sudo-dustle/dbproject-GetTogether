package controller.applicationComment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.ApplicationComment;
import model.Member;
import model.Project;
import model.service.ApplicationCommentManager;

public class CreateApplicationCommentController implements Controller{
			@Override
			public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				// TODO Auto-generated method stub
				
				ApplicationCommentManager commentMan = ApplicationCommentManager.getInstance();
				
				int applicantNum = MemberSessionUtils.getLoginMemberNum(request.getSession());
				int pid = Integer.parseInt(request.getParameter("pid"));
				
				ApplicationComment comment = new ApplicationComment();
				Member applicant = new Member();
				applicant.setMnum(applicantNum);
				comment.setApplicant(applicant);
				
				Project project = new Project();
				project.setPid(pid);
				comment.setProject(project);
				
				comment.setContent(request.getParameter("content"));
				
				commentMan.create(comment);
				
				return "redirect:/project/detail?pid="+pid;
			}
		}