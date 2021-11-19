package model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import model.Member;
import model.Message;
import model.dao.MemberDAO;
import model.dao.MessageDAO;



/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
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
//		if (user.getCommId() != oldCommId) { 	// �Ҽ� Ŀ��Ƽ�ϰ� �����
//			Community comm = commDAO.findCommunity(oldCommId);  // ���� �Ҽ� Ŀ�´�Ƽ
//			if (comm != null && user.getUserId().equals(comm.getChairId())) {
//				// ����ڰ� ���� �Ҽ� Ŀ�´�Ƽ�� ȸ���� ��� -> �� Ŀ�´�Ƽ�� ȸ���� null�� ���� �� ����
//				comm.setChairId(null);
//				commDAO.updateChair(comm);
//			}
//		}
//		return userDAO.update(user);
//	}	

//	public int remove(String userId) throws SQLException, UserNotFoundException {
//		int commId = findUser(userId).getCommId();
//		Community comm = commDAO.findCommunity(commId);  // �Ҽ� Ŀ�´�Ƽ
//		if (comm != null && userId.equals(comm.getChairId())) {
//			// ����ڰ� �Ҽ� Ŀ�´�Ƽ�� ȸ���� ��� -> �� Ŀ�´�Ƽ�� ȸ���� null�� ���� �� ����
//			comm.setChairId(null);
//			commDAO.updateChair(comm);
//		}
//		return userDAO.remove(userId);
//	}

	public Message findMessage(int msgId) throws SQLException, MessageNotFoundException {
		Message msg = messageDAO.findMessage(msgId);
		
		if (msg == null) {
			throw new MessageNotFoundException("�޼����� �������� �ʽ��ϴ�.");
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
				throw new MessageNotFoundException("�޼����� �������� �ʽ��ϴ�.");
			}
			for (Message msg : msgList) {
				logger.info(msg.getTitle());
				int senderNum = msg.getSender().getMnum();
				logger.info("senderNum is "  + Integer.toString(senderNum));
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
	
	public Member findMember(int mnum) throws SQLException, UserNotFoundException {
		Member member = memberDAO.findMember(mnum);
		if (member == null) {
			throw new UserNotFoundException(mnum + "�� �������� �ʴ� ���̵��Դϴ�.");
		}
		return member;
	}

	public MessageDAO getMessageDAO() {
		return this.messageDAO;
	}
}
