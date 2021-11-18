package controller.message;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Message;
import model.User;
import model.dao.MessageDAO;

public class ViewMessageDetailController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//로그인 체크
//    	if (!UserSessionUtils.hasLogined(request.getSession())) {
//            return "redirect:/user/login/form";		// login form 요청으로 redirect
//        }
    	MessageDAO msgDAO = new MessageDAO();
    	
		int msgId = Integer.parseInt(request.getParameter("id"));
		java.util.logging.Logger logger = Logger.getLogger(this.getClass().getName());
		logger.info("id="+Integer.toString(msgId));
    	Message msg = msgDAO.findMessage(msgId);
		
    	request.setAttribute("message", msg);
		
		return "/message/messageDetail.jsp";
	}

}
