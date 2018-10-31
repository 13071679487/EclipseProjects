package listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import entity.User;
import util.SessionUtil;
@WebListener
public class MyHttpRequestListener implements ServletRequestListener {
	private ArrayList<User> userList;
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		userList=(ArrayList<User>) arg0.getServletContext().getAttribute("userList");
		if(userList==null){
			userList=new ArrayList<>();
		}
		HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
		String sid=request.getSession().getId();
		if(SessionUtil.getUserBySessionId(userList, sid)==null){
			User u=new User();
			u.setSessionId(sid);
			u.setDate(new SimpleDateFormat("yyyy-MM--dd hh:mm:ss").format(new Date()));
			userList.add(u);
		}
		arg0.getServletContext().setAttribute("userList",userList);
	}
}
