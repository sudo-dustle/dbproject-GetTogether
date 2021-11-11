package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Message;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class ListMessageController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//    	if (!UserSessionUtils.hasLogined(request.getSession())) {
//            return "redirect:/user/login/form";		// login form 요청으로 redirect
//        }
    	
    	//아직 DAO가 없어서 임시로 객체만 생성
    	List<Message> messageList = new ArrayList<Message>();
    	User sender = new User();
    	sender.setName("김보냈습니다");
    	User receiver = new User();
    	receiver.setName("박박디라라");
    	Message msg = new Message(0, sender, receiver, "제목 하하ㅏ", "메세지내용블라블라블라. 잘 부탁드립니다다다");
    	messageList.add(msg);
    	request.setAttribute("messageList", messageList);
		return "/message/messageList.jsp";
	}

}
