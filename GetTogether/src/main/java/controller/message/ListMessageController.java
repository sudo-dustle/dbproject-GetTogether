package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Message;
import model.dao.MessageDAO;
import model.service.MessageManager;

import java.util.List;

public class ListMessageController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 우리는 Member지만 임시로 해놨습니다..
//    	if (!UserSessionUtils.hasLogined(request.getSession())) {
//            return "redirect:/user/login/form";		// login form 요청으로 redirect
//        }
    	//mnum을 가져오는 함수가 필요하다..
    	int mnum = 2;
    	//UserSessionUtils.getLoginUserNumber(request.getSession());
    	MessageManager msgManager = MessageManager.getInstance();
    	List<Message> messageList = msgManager.findReceivedMessageList(mnum);
    	request.setAttribute("messageList", messageList);
		return "/message/messageList.jsp";
	}

}
