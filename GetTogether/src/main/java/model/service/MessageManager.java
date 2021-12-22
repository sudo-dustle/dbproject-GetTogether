package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Member;
import model.Message;
import model.dao.MemberDAO;
import model.dao.MessageDAO;

public class MessageManager {
	private static MessageManager messageMan = new MessageManager();
	private MessageDAO messageDAO;
	private MemberDAO memberDAO;

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

