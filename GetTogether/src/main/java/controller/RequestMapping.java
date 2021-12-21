package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.applicationComment.CreateApplicationCommentController;
import controller.comm.*;
import controller.message.*;
import controller.teamrecommend.ListTeamRecommendController;
import controller.memberrecommend.ListMemberRecommendController;
import controller.member.*;
import controller.project.*;
import controller.teamMember.ApproveTeamMemberController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        mappings.put("/", new ForwardController("index.jsp"));

        mappings.put("/member/login/form", new ForwardController("/member/login/loginForm.jsp"));
        mappings.put("/member/login", new MemberLoginController());
        mappings.put("/member/logout", new MemberLogoutController());
        mappings.put("/member/signup/form", new ForwardController("/member/signup/inputForm.jsp"));
        mappings.put("/member/signup", new MemberInfoController());
        mappings.put("/member/duplicate", new MemberDuplicateCheckController());
        mappings.put("/member/detail", new MemberDetailController());
        mappings.put("/member/detail/update", new MemberDetailUpdateController());
        mappings.put("/member/mypage", new ForwardController("/member/myPage.jsp"));
        mappings.put("/member/delete", new MemberDeleteController());
        mappings.put("/member/info", new ForwardController("/member/infoUpdate.jsp"));
        mappings.put("/member/update", new MemberUpdateController());
        mappings.put("/teammember/detail", new TeamMemberDetailController());
        
        mappings.put("/project/search", new ProjectSearchController());
//      mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/user/register", new RegisterUserController());


//      mappings.put("/user/update/form", new UpdateUserFormController());
//      mappings.put("/user/update", new UpdateUserController());        
        mappings.put("/user/update", new UpdateUserController());
        
        mappings.put("/user/delete", new DeleteUserController());
        

        mappings.put("/community/list", new ListCommunityController());
        mappings.put("/community/view", new ViewCommunityController());
        mappings.put("/community/create/form", new ForwardController("/community/creationForm.jsp"));
        mappings.put("/community/create", new CreateCommunityController());
        mappings.put("/community/update", new UpdateCommunityController());
        

        mappings.put("/memberRecommend/list", new ListMemberRecommendController());
        mappings.put("/teamRecommend/list", new ListTeamRecommendController());

        mappings.put("/message/list/received", new ReceivedListMessageController());
        mappings.put("/message/list/sent", new SentListMessageController());
        mappings.put("/message/detail", new ViewMessageDetailController());
        mappings.put("/message/create/form", new ForwardController("/message/form.jsp"));
        mappings.put("/message/create", new CreateMessageController());
        mappings.put("/message/delete", new DeleteMessageController());
        
        mappings.put("/member/search", new SearchMemberController());
        
        mappings.put("/applicationComment/create", new CreateApplicationCommentController());
        mappings.put("/teammember/approve", new ApproveTeamMemberController());
        
        
        mappings.put("/project/new/form", new ForwardController("/project/form.jsp"));
        mappings.put("/project/new", new CreateProjectController());
        mappings.put("/project/update/form", new UpdateProjectController());
        mappings.put("/project/update", new UpdateProjectController());
        mappings.put("/project/delete", new DeleteProjectController());
        mappings.put("/project/detail",new ViewProjectDetailController());
        mappings.put("/project/manage", new ListProjectController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
        return mappings.get(uri);
    }
}
