package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.Message;
import model.service.MessageManager;

public class CreateMessageController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String title = request.getParameter("title");
		String content = request.getParameter("msgcontent");
//		int receiverNum = Integer.parseInt(request.getParameter("receiver"));
		//아직 위 코드가 이전 jsp에서 미구현 되었음.
		int receiverNum = 3;
//		int senderNum = MemberSessionUtils.getLoginMemberNum(request.getSession());
		//얘도 미구현....
		int senderNum = 2;
		
		Member sender = new Member();
		sender.setMnum(senderNum);
		Member receiver = new Member();
		receiver.setMnum(receiverNum);
		MessageManager msgManager = MessageManager.getInstance();
		Message message = new Message(receiver, sender, title, content);
		msgManager.create(message);
		return "redirect:/message/list/received";
	}
}
