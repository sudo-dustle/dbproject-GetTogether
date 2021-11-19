package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.comm.*;
import controller.message.*;
import controller.member.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // �� ��û uri�� ���� controller ��ü�� ������ HashMap ����
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// �� uri�� �����Ǵ� controller ��ü�� ���� �� ����
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
        
        // ȸ�� ���� �� ��û�� ���� ��û ó�� ���� (���� Ŀ�´�Ƽ ���� �޴� �߰��� ����)
//      mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
//      mappings.put("/user/register", new RegisterUserController());
        mappings.put("/user/register", new RegisterUserController());

        // ����� ���� ���� �� ��û�� ���� ��û ó�� ����
//      mappings.put("/user/update/form", new UpdateUserFormController());
//      mappings.put("/user/update", new UpdateUserController());        
        mappings.put("/user/update", new UpdateUserController());
        
        mappings.put("/user/delete", new DeleteUserController());
        
        // Ŀ�´�Ƽ ���� request URI �߰�
        mappings.put("/community/list", new ListCommunityController());
        mappings.put("/community/view", new ViewCommunityController());
        mappings.put("/community/create/form", new ForwardController("/community/creationForm.jsp"));
        mappings.put("/community/create", new CreateCommunityController());
        mappings.put("/community/update", new UpdateCommunityController());
        
        mappings.put("/message/list", new ListMessageController());
        mappings.put("/message/detail", new ViewMessageDetailController());
        mappings.put("/message/create/form", new ForwardController("/message/form.jsp"));
        mappings.put("/message/create", new CreateMessageController());
        
        mappings.put("/member/search", new SearchMemberController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// �־��� uri�� �����Ǵ� controller ��ü�� ã�� ��ȯ
        return mappings.get(uri);
    }
}
