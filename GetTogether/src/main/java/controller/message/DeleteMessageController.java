package controller.message;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.MessageManager;

public class DeleteMessageController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		MessageManager msgManager = MessageManager.getInstance();
		
		if (request.getMethod().equals("GET")) {
			int msgId = Integer.parseInt(request.getParameter("id"));
			msgManager.deleteMessage(msgId);
			return "redirect:/message/list/received";
		}
		
		String[] numList = request.getParameterValues("select");
			if (numList != null){
			int len = numList.length;
			int[] msgIdList= new int[len];
			int i = 0;
			
			for(String s : numList) {
				msgIdList[i++] = Integer.parseInt(s);
			}
			msgManager.deleteMessageList(msgIdList);
		}
		return "redirect:/message/list/received";
	}
}
