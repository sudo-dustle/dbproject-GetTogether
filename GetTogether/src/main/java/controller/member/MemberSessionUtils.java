package controller.member;

import javax.servlet.http.HttpSession;

public class MemberSessionUtils {

	public static final String MEMBER_SESSION_KEY = "memberId";
	public static final String MEMBER_SESSION_NUM = "mnum";

	/* 현재 로그인한 사용자의 ID를 구함 */
	public static String getLoginMemberId(HttpSession session) {
		String mId = (String) session.getAttribute(MEMBER_SESSION_KEY);
		return mId;
	}

	/* 현재 로그인한 사용자의 mnum */
	public static int getLoginMemberNum(HttpSession session) {
		int mnum = (int) session.getAttribute(MEMBER_SESSION_NUM); 
		return mnum;
	}
	/* 로그인한 상태인지를 검사 */
	public static boolean hasLogined(HttpSession session) {
		if (getLoginMemberId(session) != null) {
			return true;
		}
		return false;
	}

	/* 현재 로그인한 사용자의 ID가 memberId인지 검사 */
	public static boolean isLoginMember(String mId, HttpSession session) {
		String loginMember= getLoginMemberId(session);
		if (loginMember == null) {
			return false;
		}
		return loginMember.equals(mId);
	}

}
