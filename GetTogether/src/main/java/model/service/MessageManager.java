package model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import model.Member;
import model.Message;
import model.dao.MemberDAO;
import model.dao.MessageDAO;



/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class MessageManager {
	private static MessageManager messageMan = new MessageManager();
	private MessageDAO messageDAO;
	private MemberDAO memberDAO;
	java.util.logging.Logger logger = Logger.getLogger(this.getClass().getName());

	private MessageManager() {
		try {
			messageDAO = new MessageDAO();
			memberDAO = new MemberDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MessageManager getInstance() {
		return messageMan;
	}
	
	public int create(Message message) throws SQLException{
		return messageDAO.create(message);
	}

//	public int update(User user) throws SQLException, UserNotFoundException {
//		int oldCommId = findUser(user.getUserId()).getCommId();
//		if (user.getCommId() != oldCommId) { 	// 소속 커뮤티니가 변경됨
//			Community comm = commDAO.findCommunity(oldCommId);  // 기존 소속 커뮤니티
//			if (comm != null && user.getUserId().equals(comm.getChairId())) {
//				// 사용자가 기존 소속 커뮤니티의 회장인 경우 -> 그 커뮤니티의 회장을 null로 변경 및 저장
//				comm.setChairId(null);
//				commDAO.updateChair(comm);
//			}
//		}
//		return userDAO.update(user);
//	}	
	
	public int deleteMessage(int msgId) throws SQLException, UserNotFoundException {
		return messageDAO.deleteMessage(msgId);
	}

	public int deleteMessageList(int[] msgIdList) throws SQLException, UserNotFoundException {
		return messageDAO.deleteMessageList(msgIdList);
	}

	public Message findMessage(int msgId) throws SQLException, MessageNotFoundException {
		Message msg = messageDAO.findMessage(msgId);
		
		if (msg == null) {
			throw new MessageNotFoundException("메세지가 존재하지 않습니다.");
		}			

		Member sender;
		try {
			int senderNum = msg.getSender().getMnum();
			sender = findMember(senderNum);
			int receiverNum = msg.getReceiver().getMnum();
			msg.setSender(sender);
			Member receiver = findMember(receiverNum);
			msg.setReceiver(receiver);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return msg;
	}

	public List<Message> findReceivedMessageList(int receiverNum) throws SQLException, MessageNotFoundException{
			List<Message> msgList = messageDAO.findReceivedMessageList(receiverNum);
			if(msgList == null) {
				throw new MessageNotFoundException("메세지가 존재하지 않습니다.");
			}
			for (Message msg : msgList) {
				int senderNum = msg.getSender().getMnum();
				Member sender;
				try {
					sender = findMember(senderNum);
					msg.setSender(sender);
					Member receiver = findMember(receiverNum);
					msg.setReceiver(receiver);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UserNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			return msgList;
	}
	
	public List<Message> findSentMessageList(int senderNum) throws SQLException, MessageNotFoundException{
		List<Message> msgList = messageDAO.findSentMessageList(senderNum);
		if(msgList == null) {
			throw new MessageNotFoundException("메세지가 존재하지 않습니다.");
		}
		for (Message msg : msgList) {
			int receiverNum = msg.getReceiver().getMnum();
			try {
				Member sender = findMember(senderNum);
				msg.setSender(sender);
				Member receiver = findMember(receiverNum);
				msg.setReceiver(receiver);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return msgList;
}
	
	public Member findMember(int mnum) throws SQLException, UserNotFoundException {
		Member member = memberDAO.findMember(mnum);
		if (member == null) {
			throw new UserNotFoundException(mnum + "는 존재하지 않는 아이디입니다.");
		}
		return member;
	}

	public MessageDAO getMessageDAO() {
		return this.messageDAO;
	}
}

