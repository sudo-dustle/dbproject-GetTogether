package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.user.LogoutController;
import controller.comm.*;
import controller.message.*;
import controller.teamrecommend.ListTeamRecommendController;
import controller.memberrecommend.ListMemberRecommendController;
import controller.member.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 占쏙옙 占쏙옙청 uri占쏙옙 占쏙옙占쏙옙 controller 占쏙옙체占쏙옙 占쏙옙占쏙옙占쏙옙 HashMap 占쏙옙占쏙옙
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 占쏙옙 uri占쏙옙 占쏙옙占쏙옙占실댐옙 controller 占쏙옙체占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/member/login/form", new ForwardController("/member/login/loginForm.jsp"));
//        mappings.put("/user/login", new LoginController());
//        mappings.put("/user/logout", new LogoutController());
//        mappings.put("/member", new ForwardController("/testMain.jsp"));
        mappings.put("/member/login", new MemberLoginController());
        mappings.put("/member/logout", new MemberLogoutController());
        mappings.put("/member/signup/input", new ForwardController("/member/signup/inputForm.jsp"));
        mappings.put("/member/signup", new MemberInfoController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());

//      mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/user/register", new RegisterUserController());

        // �궗�슜�옄 �젙蹂� �닔�젙 �뤌 �슂泥�怨� �닔�젙 �슂泥� 泥섎━ 蹂묓빀

//      mappings.put("/user/update/form", new UpdateUserFormController());
//      mappings.put("/user/update", new UpdateUserController());        
        mappings.put("/user/update", new UpdateUserController());
        
        mappings.put("/user/delete", new DeleteUserController());
        

        mappings.put("/community/list", new ListCommunityController());
        mappings.put("/community/view", new ViewCommunityController());
        mappings.put("/community/create/form", new ForwardController("/community/creationForm.jsp"));
        mappings.put("/community/create", new CreateCommunityController());
        mappings.put("/community/update", new UpdateCommunityController());
        

        //recommend愿��젴 留ㅽ븨
        mappings.put("/memberRecommend/list", new ListMemberRecommendController());
        mappings.put("/teamRecommend/list", new ListTeamRecommendController());



        mappings.put("/message/list", new ListMessageController());
        mappings.put("/message/detail", new ViewMessageDetailController());
        mappings.put("/message/create/form", new ForwardController("/message/form.jsp"));
        mappings.put("/message/create", new CreateMessageController());
        
        mappings.put("/member/search", new SearchMemberController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
        return mappings.get(uri);
    }
}
