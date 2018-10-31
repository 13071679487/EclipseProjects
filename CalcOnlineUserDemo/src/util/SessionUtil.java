package util;

import java.util.ArrayList;

import entity.User;

public class SessionUtil {
	public static User getUserBySessionId(ArrayList<User> userList,String sid){
		for(int i=0;i<userList.size();i++){
			User u=userList.get(i);
			if(u.getSessionId().equals(sid)){
				return u;
			}
		}
		return null;
	}
}
