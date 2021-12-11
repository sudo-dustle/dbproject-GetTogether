package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.comm.CreateCommunityController;
import controller.member.MemberSessionUtils;
import model.Message;
import model.service.MessageManager;

import java.util.List;

public class ListMessageController implements Controller{

	private static final Logger log = LoggerFactory.getLogger(CreateCommunityController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

    	if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
    	//mnum을 가져오는 함수 - 아직 mNum가져오는 로직이 없어서 mId입니다.
    	String mId = MemberSessionUtils.getLoginMemberId(request.getSession());
    	log.debug(mId);
    	
    	MessageManager msgManager = MessageManager.getInstance();
    	List<Message> messageList = msgManager.findReceivedMessageList(2);
    	request.setAttribute("messageList", messageList);
		return "/message/messageList.jsp";
	}
}
