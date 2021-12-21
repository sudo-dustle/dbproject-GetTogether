package controller.applicationComment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.ApplicationComment;
import model.Member;
import model.Project;
import model.service.AlreadyExistTeamMemberException;
import model.service.ApplicationCommentManager;
import model.service.TeamMemberManager;

public class CreateApplicationCommentController implements Controller{
			@Override
			public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				// TODO Auto-generated method stub
			
				if (!MemberSessionUtils.hasLogined(request.getSession())) {
		            return "redirect:/member/login/form";		// login form 요청으로 redirect
		        }
				
				ApplicationCommentManager commentMan = ApplicationCommentManager.getInstance();
				TeamMemberManager teamMan = TeamMemberManager.getInstance();
				
				
				int applicantNum = MemberSessionUtils.getLoginMemberNum(request.getSession());
				int pid = Integer.parseInt(request.getParameter("pid"));
				try {	
					boolean check =  teamMan.existingTeamMember(pid, applicantNum);
					if (check)
						throw new AlreadyExistTeamMemberException("이미 대기명단이나 팀 멤버에 등록된 유저입니다.");
						
					ApplicationComment comment = new ApplicationComment();
					Member applicant = new Member();
					applicant.setMnum(applicantNum);
					comment.setApplicant(applicant);
					
					Project project = new Project();
					project.setPid(pid);
					comment.setProject(project);
					
					comment.setContent(request.getParameter("content"));
					
					commentMan.create(comment);
				}catch (Exception e) {
					request.setAttribute("commentFailed", true);
					request.setAttribute("exception", e);
				}
				return "redirect:/project/detail?pid="+pid;
			}
		}