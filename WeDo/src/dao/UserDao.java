package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBManager.DBManagerUtil;
import bean.Article;
import bean.Collection;
import bean.Follow;
import bean.Session;
import bean.User;
import util.C3P0Util;
import util.ResultCodeUtil;

public class UserDao {

	public UserDao() {
	}

	public boolean isExist(String phone) {
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from User where phone=" + phone;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return false;
	}

	/**
	 * 注册的逻辑
	 * 
	 * @param phone
	 * @param pwd
	 * @return
	 */
	public int register(String phone, String pwd) {
		int resultcode = ResultCodeUtil.REGISTER_FAIL;
		Connection conn = null;
		if (isExist(phone)) {
			resultcode = ResultCodeUtil.REGISTER_ALREADY;
		} else {
			try {
				conn = C3P0Util.getConnection();
				String sql = "insert User(phone,pwd) values(" + "'" + phone + "'" + "," + "'" + pwd + "'" + ")";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.execute();
				resultcode = ResultCodeUtil.REGISTER_SUCCESS;
			} catch (Exception e) {
				resultcode = ResultCodeUtil.REGISTER_FAIL;
				C3P0Util.releaseConnection(conn);
				e.printStackTrace();
			}
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	};

	public User getUserByPhone(String phone) {
		User user = null;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from User where phone=" + phone;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setIcon(rs.getString("headicon"));
				user.setSex(rs.getInt("sex"));
				user.setAddress(rs.getString("address"));
				user.setDynamic(rs.getString("userdynamic"));
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return user;
	}

	public User getUserById(String id) {
		User user = null;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from User where id=" + id;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setIcon(rs.getString("headicon"));
				user.setSex(rs.getInt("sex"));
				user.setAddress(rs.getString("address"));
				user.setDynamic(rs.getString("userdynamic"));
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return user;
	}

	/**
	 * 登录的逻辑
	 * 
	 * @param phone
	 * @param pwd
	 * @param token
	 * @return
	 */
	public int login(String phone, String pwd, String token) {
		int resultcode = ResultCodeUtil.LOGIN_FAIL;
		Connection conn = null;
		if (!isExist(phone)) {
			resultcode = ResultCodeUtil.NO_REGISTER;
		} else {
			try {
				conn = C3P0Util.getConnection();
				String sql = "select * from User where phone=" + phone + " and pwd=" + pwd;
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					resultcode = ResultCodeUtil.LOGIN_SUCCESS;
				} else {
					resultcode = ResultCodeUtil.LOGIN_FAIL;
				}
			} catch (Exception e) {
				resultcode = ResultCodeUtil.LOGIN_FAIL;
				C3P0Util.releaseConnection(conn);
				e.printStackTrace();
			}
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	}

	/**
	 * 修改密码
	 * 
	 * @param phone
	 * @param pwd
	 * @return
	 */
	public int updatePwd(String phone, String pwd) {
		int resultcode = ResultCodeUtil.UPDATE_FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "update user set pwd='" + pwd + "' where phone='" + phone + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultcode = ResultCodeUtil.UPDATE_SUCCESS;
		} catch (Exception e) {
			resultcode = ResultCodeUtil.UPDATE_FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	}

	/**
	 * 更改头像
	 * 
	 * @param phone
	 * @param path
	 * @return
	 */
	public int updateIcon(String phone, String path) {
		int resultcode = ResultCodeUtil.UPDATE_FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "update user set headicon='" + path + "' where phone='" + phone + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultcode = ResultCodeUtil.UPDATE_SUCCESS;
		} catch (Exception e) {
			resultcode = ResultCodeUtil.UPDATE_FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	}

	/**
	 * 修改用户名
	 * 
	 * @param phone
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int updateName(String phone, String name) {
		int resultcode = ResultCodeUtil.UPDATE_FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "update user set username='" + name + "' where phone='" + phone + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultcode = ResultCodeUtil.UPDATE_SUCCESS;
		} catch (Exception e) {
			resultcode = ResultCodeUtil.UPDATE_FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	}

	/**
	 * 修改性别
	 * 
	 * @param phone
	 * @param sex
	 * @return
	 */
	public int updateSex(String phone, int sex) {
		int resultcode = ResultCodeUtil.UPDATE_FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "update user set sex=" + sex + " where phone='" + phone + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultcode = ResultCodeUtil.UPDATE_SUCCESS;
		} catch (Exception e) {
			resultcode = ResultCodeUtil.UPDATE_FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	}

	/**
	 * 修改地址
	 * 
	 * @param phone
	 * @param address
	 * @return
	 */
	public int updateAddress(String phone, String address) {
		int resultcode = ResultCodeUtil.UPDATE_FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "update user set address='" + address + "' where phone='" + phone + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultcode = ResultCodeUtil.UPDATE_SUCCESS;
		} catch (Exception e) {
			resultcode = ResultCodeUtil.UPDATE_FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	}

	/**
	 * 修改动态
	 * 
	 * @param phone
	 * @param dynamic
	 * @return
	 * @throws Exception
	 */
	public int updateDynamic(String phone, String dynamic) {
		int resultcode = ResultCodeUtil.UPDATE_FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "update user set userdynamic='" + dynamic + "' where phone='" + phone + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultcode = ResultCodeUtil.UPDATE_SUCCESS;
		} catch (Exception e) {
			resultcode = ResultCodeUtil.UPDATE_FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	}

	public ArrayList<Session> getSessionsById(String id) {
		ArrayList<Session> sessions = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from message where sender_id='" + id + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Session session = new Session();
				session.setSession_id(rs.getInt("id"));
				session.setSession_senderId(rs.getString("sender_id"));
				session.setSession_senderName(rs.getString("sender_name"));
				session.setSession_senderIcon(rs.getString("sender_headicon"));
				session.setSession_reciverId(rs.getString("receiver_id"));
				session.setSession_tag(rs.getInt("tag"));
				session.setSession_lastContent(rs.getString("content"));
				session.setSession_lastTime(rs.getString("message_time"));
				sessions.add(session);
			}
			String sql1 = "select * from session where receiver_id='" + id + "'";
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			ResultSet rs1 = stmt1.executeQuery();
			while (rs1.next()) {
				Session session = new Session();
				session.setSession_id(rs.getInt("id"));
				session.setSession_senderId(rs.getString("sender_id"));
				session.setSession_senderName(rs.getString("sender_name"));
				session.setSession_senderIcon(rs.getString("sender_headicon"));
				session.setSession_reciverId(rs.getString("receiver_id"));
				session.setSession_tag(rs.getInt("tag"));
				session.setSession_lastContent(rs.getString("content"));
				session.setSession_lastTime(rs.getString("message_time"));
				sessions.add(session);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return sessions;
	}

	public ArrayList<Session> getSessionContentById(String session_id) {
		ArrayList<Session> sessions = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from message where _id='" + session_id + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Session session = new Session();
				session.setSession_id(rs.getInt("id"));
				session.setSession_senderId(rs.getString("sender_id"));
				session.setSession_senderName(rs.getString("sender_name"));
				session.setSession_senderIcon(rs.getString("sender_headicon"));
				session.setSession_reciverId(rs.getString("receiver_id"));
				session.setSession_tag(rs.getInt("tag"));
				session.setSession_lastContent(rs.getString("content"));
				session.setSession_lastTime(rs.getString("message_time"));
				sessions.add(session);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return sessions;
	}

	/**
	 * 根据用户id获取收藏列表
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<Collection> getCollectionListById(String user_id) {
		ArrayList<Collection> colls = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from collection where collector_id='" + user_id + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Collection coll = new Collection();
				coll.setCollector_id(rs.getString("collector_id"));
				coll.setArticle_id(rs.getString("article_id"));
				colls.add(coll);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return colls;
	}

	/**
	 * 根据用户id获取点赞列表
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<Collection> getLikeListById(String user_id) {
		ArrayList<Collection> colls = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from likes where like_id='" + user_id + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Collection coll = new Collection();
				coll.setCollector_id(rs.getString("like_id"));
				coll.setArticle_id(rs.getString("article_id"));
				colls.add(coll);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return colls;
	}

	/**
	 * 关注的逻辑
	 * 
	 * @param follower_id
	 * @param befollower_id
	 * @return
	 */
	public int followToUser(String follower_id, String befollower_id, int type) {
		int resultcode = ResultCodeUtil.FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "";
			if (type == 1)
				sql = "insert fans(follower_id,befollower_id) values(" + "'" + follower_id + "'" + "," + "'"
						+ befollower_id + "'" + ")";
			else
				sql = "delete from fans where follower_id=" + "'" + follower_id + "'" + " and befollower_id=" + "'"
						+ befollower_id + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultcode = ResultCodeUtil.SUCCESS;
		} catch (Exception e) {
			resultcode = ResultCodeUtil.FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	}

	/**
	 * 根据用户id获取粉丝列表
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<Follow> getFansListById(String user_id) {
		ArrayList<Follow> follows = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from fans where befollower_id='" + user_id + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Follow follow = new Follow();
				follow.setFollower_id(rs.getString("follower_id"));
				follow.setBefollower_id(rs.getString("befollower_id"));
				follows.add(follow);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return follows;
	}

	/**
	 * 根据用户id获取关注列表
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<Follow> getFollowsListById(String user_id) {
		ArrayList<Follow> follows = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from fans where follower_id='" + user_id + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Follow follow = new Follow();
				follow.setFollower_id(rs.getString("follower_id"));
				follow.setBefollower_id(rs.getString("befollower_id"));
				follows.add(follow);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return follows;
	}

	/**
	 * 根据用户id获取发布文章列表
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<Article> getPublishsListById(String user_id, int startIndex, int limitNum) {
		ArrayList<Article> articles = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "";
			sql = "select * from article where author_id=" + user_id + " limit " + startIndex + "," + limitNum;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id") + "");
				article.setAuthor_id(rs.getString("author_id"));
				article.setAuthor_name(rs.getString("author_name"));
				article.setAuthor_headicon(rs.getString("author_headicon"));
				article.setArtilce_type(rs.getInt("article_type"));
				article.setArticle_title(rs.getString("article_title"));
				article.setArticle_content(rs.getString("article_content"));
				article.setArticle_contentId(rs.getString("article_contentid"));
				article.setCollections(rs.getInt("collections"));
				article.setLikes(rs.getInt("likes"));
				article.setSees(rs.getInt("sees"));
				article.setTime(rs.getString("author_time"));
				articles.add(article);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return articles;
	}
}
