package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Message;
import model.service.MessageManager;

public class ViewMessageDetailController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//로그인 체크
//    	if (!UserSessionUtils.hasLogined(request.getSession())) {
//            return "redirect:/user/login/form";		// login form 요청으로 redirect
//        }
    	MessageManager msgManager = MessageManager.getInstance();
    	
		int msgId = Integer.parseInt(request.getParameter("id"));
    	Message msg = msgManager.findMessage(msgId);
		
    	request.setAttribute("message", msg);
		
		return "/message/messageDetail.jsp";
	}
}
