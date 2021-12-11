package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Message;
import model.service.MessageManager;

import java.util.List;

public class ListMessageController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

    	if (MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
    	//mnum을 가져오는 함수
    	int mnum = MemberSessionUtils.getLoginMemberNum(request.getSession());
    	MessageManager msgManager = MessageManager.getInstance();
    	List<Message> messageList = msgManager.findReceivedMessageList(mnum);
    	request.setAttribute("messageList", messageList);
		return "/message/messageList.jsp";
	}

}
