package listener;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import entity.User;
import util.SessionUtil;
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	private int onlineNum=0;

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		onlineNum++;
		arg0.getSession().getServletContext().setAttribute("onlineNum", onlineNum);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		onlineNum--;
		arg0.getSession().getServletContext().setAttribute("onlineNum", onlineNum);
		
		ArrayList<User> userList = null;//在线用户List
		
		userList = (ArrayList<User>)arg0.getSession().getServletContext().getAttribute("userList");
		
		if(SessionUtil.getUserBySessionId(userList, arg0.getSession().getId())!=null){
			userList.remove(SessionUtil.getUserBySessionId(userList, arg0.getSession().getId()));
			arg0.getSession().getServletContext().setAttribute("userList",userList);
		}
	}

}
