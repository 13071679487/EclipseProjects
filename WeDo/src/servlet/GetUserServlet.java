package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import bean.Article;
import bean.Collection;
import bean.Follow;
import bean.Session;
import bean.User;
import dao.UserDao;
import jdk.nashorn.internal.parser.JSONParser;
import util.ResultCodeUtil;

@WebServlet("/user")
public class GetUserServlet extends HttpServlet {
	private static final int GET_USER_BYPhone = 0;
	private static final int GET_USER_BYID = 1;
	private static final int GET_FRIENDS_BYID = 2;
	private static final int GET_PUBLISHS_BYID = 3;
	private static final int GET_SESSIONS_BYID = 4;
	private static final int GET_COLLECTIONS_BYID = 5;
	private static final int GET_FANS_BYID = 6;
	private static final int GET_LIKES_BYID = 7;
	private static final int GET_MESSAGE_BYID = 8;
	private static final int FOLLOW_TO_USER=9;
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter printWriter = resp.getWriter();
		int method = Integer.parseInt(req.getParameter("method"));
		String id = req.getParameter("id");
		UserDao ud = new UserDao();
		switch (method) {
		case GET_USER_BYPhone:
			User user1=ud.getUserByPhone(id);
			if(user1!=null){
				JSONObject json=(JSONObject) JSONObject.toJSON(user1);
				printWriter.write(json.toString());
			}else printWriter.write(ResultCodeUtil.FAIL+"");
			break;
		case GET_USER_BYID:
			User user = ud.getUserById(id);
			if (user != null) {
				try {
					String result = "{" + "\"id\":\"" + user.getId() + "\"" + "," + "\"username\":\""
							+ user.getUsername() + "\"" + "," + "\"headicon\":\"" + user.getIcon() + "\"" + ","
							+ "\"sex\":\"" + user.getSex() + "\"" + "," + "\"address\":\"" + user.getAddress() + "\""
							+ "," + "\"userdynamic\":\"" + user.getDynamic() + "\"" + "}";
					printWriter.write(result);
				} catch (Exception e) {
					printWriter.write(ResultCodeUtil.FAIL + "");
				}
			} else
				printWriter.write(ResultCodeUtil.FAIL + "");
			break;
		case GET_FRIENDS_BYID:
			ArrayList<Follow> follows = new UserDao().getFollowsListById(id);
			if (follows.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < follows.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(follows.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case GET_PUBLISHS_BYID:
			int startIndex = Integer.parseInt(req.getParameter("index"));
			int limitNum = Integer.parseInt(req.getParameter("num"));
			ArrayList<Article> articles = new UserDao().getPublishsListById(id, startIndex, limitNum);
			if (articles.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < articles.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(articles.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case GET_SESSIONS_BYID:
			ArrayList<Session> sessions = new UserDao().getSessionsById(id);
			if (sessions.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < sessions.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(sessions.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case GET_COLLECTIONS_BYID:
			ArrayList<Collection> colls = new UserDao().getCollectionListById(id);
			if (colls.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < colls.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(colls.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case GET_FANS_BYID:
			ArrayList<Follow> fans = new UserDao().getFansListById(id);
			if (fans.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < fans.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(fans.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case GET_LIKES_BYID:
			ArrayList<Collection> likes = new UserDao().getLikeListById(id);
			if (likes.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < likes.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(likes.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case GET_MESSAGE_BYID:
			ArrayList<Session> sessions1 = new UserDao().getSessionsById(id);
			if (sessions1.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < sessions1.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(sessions1.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case FOLLOW_TO_USER:
			String befollower_id=req.getParameter("befollower_id");
			int type=Integer.parseInt(req.getParameter("type"));
			int resultcode=new UserDao().followToUser(id, befollower_id,type);
			printWriter.write(resultcode+"");
			break;
		}
		printWriter.flush();
	}
}
