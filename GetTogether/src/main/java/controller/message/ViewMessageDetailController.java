package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Message;
import model.User;

public class ViewMessageDetailController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//로그인 체크
    	User sender = new User();
    	sender.setName("김보냈습니다");
    	User receiver = new User();
    	receiver.setName("박박디라라");
    	Message msg = new Message(0, sender, receiver, "제목 하하ㅏ", "메세지내용블라블라블라. 잘 부탁드립니다다다");
    	request.setAttribute("message", msg);
		
		return "/message/messageDetail.jsp";
	}

}
