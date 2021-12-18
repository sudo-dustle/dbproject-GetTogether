package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Member;
import model.Message;
import model.service.MemberManager;
import model.service.MessageManager;

public class CreateMessageController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String title = request.getParameter("title");
		String content = request.getParameter("msgcontent");
		String receiverId = request.getParameter("receiver");

		MemberManager memberManager = MemberManager.getInstance();
		Member receiver = memberManager.findMemberByMid(receiverId);
		int senderNum = MemberSessionUtils.getLoginMemberNum(request.getSession());
		Member sender = new Member();
		sender.setMnum(senderNum);
		MessageManager msgManager = MessageManager.getInstance();
		Message message = new Message(receiver, sender, title, content);
		msgManager.create(message);
		return "redirect:/message/list/received";
	}
}
