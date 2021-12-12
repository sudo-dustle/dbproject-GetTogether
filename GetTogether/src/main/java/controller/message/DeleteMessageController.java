package controller.message;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.comm.CreateCommunityController;
import model.Member;
import model.Message;
import model.dao.MessageDAO;
import model.service.MessageManager;

public class DeleteMessageController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(CreateCommunityController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		
		MessageManager msgManager = MessageManager.getInstance();
		String[] numList = request.getParameterValues("select");
		
		for(String s : numList) {
			log.debug(s);
		}
//		msgManager.delete(messageNum);
		return "redirect:/message/list/received";
	}
}
