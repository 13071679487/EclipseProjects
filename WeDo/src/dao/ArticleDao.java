package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBManager.DBManagerUtil;
import bean.Article;
import bean.Content;
import bean.Reply;
import util.C3P0Util;
import util.ResultCodeUtil;

public class ArticleDao {
	public ArticleDao() {

	}
	public Article getArticleById(String article_id){
		Article article=null;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from article where id='"+article_id+"'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				article=new Article();
				article.setId(rs.getInt("id") + "");
				article.setAuthor_id(rs.getString("author_id"));
				article.setAuthor_name(rs.getString("author_name"));
				article.setAuthor_headicon(rs.getString("author_headicon"));
				article.setArtilce_type(rs.getInt("article_type"));
				article.setArticle_title(rs.getString("article_title"));
				article.setArticle_content(rs.getString("article_content"));
				article.setArticle_cover(rs.getString("article_cover"));
				article.setArticle_contentId(rs.getString("article_contentid"));
				article.setCollections(rs.getInt("collections"));
				article.setLikes(rs.getInt("likes"));
				article.setSees(rs.getInt("sees"));
				article.setTime(rs.getString("author_time"));
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return article;
	}

	/**
	 * 获取文章列表
	 * 
	 * @param phone
	 * @param startIndex
	 *            开始的文章id
	 * @param limitNum
	 *            请求的数量
	 * @return
	 */
	public ArrayList<Article> getArticleList(String phone, int article_type, int startIndex, int limitNum) {
		ArrayList<Article> articles = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "";
			if (article_type < 1 || article_type > 4) {
				sql = "select * from article limit " + startIndex + "," + limitNum;
			} else {
				sql = "select * from article where article_type=" + article_type + " limit " + startIndex + ","
						+ limitNum;
			}
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
				article.setArticle_cover(rs.getString("article_cover"));
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

	/**
	 * 根据contentId查询对应的文章内容
	 * 
	 * @param articleId
	 * @return
	 */
	public ArrayList<Content> getContentById(String articleId) {
		ArrayList<Content> contents = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from content where article_id=" + articleId;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Content con = new Content();
				con.setIndex(rs.getInt("position"));
				con.setType(rs.getInt("content_type"));
				con.setValue(rs.getString("content_value"));
				contents.add(con);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return contents;
	}

	/**
	 * 根据articleId查询回复的内容
	 * 
	 * @param article_id
	 * @param startIndex
	 * @param limitNum
	 * @return
	 */
	public ArrayList<Reply> getReplyListById(String article_id, int startIndex, int limitNum) {
		ArrayList<Reply> replys = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from article_reply where article_id=" + article_id + " order by id desc limit "
					+ startIndex + "," + limitNum;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Reply reply = new Reply();
				reply.setSender_id(rs.getString("sender_id"));
				reply.setSender_name(rs.getString("sender_name"));
				reply.setSender_headicon(rs.getString("sender_headicon"));
				reply.setReply_value(rs.getString("reply_value"));
				replys.add(reply);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return replys;
	}

	/**
	 * 文章留言
	 * 
	 * @param article_id
	 *            对应文章的id
	 * @param sender_id
	 *            留言者的id
	 * @param headicon
	 *            留言者的头像
	 * @param name
	 *            留言者的昵称
	 * @param content
	 *            留言的内容
	 */
	public int replyToArticle(String article_id, String sender_id, String headicon, String name, String content) {
		int resultcode = ResultCodeUtil.REPLY_FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "insert article_reply(article_id,sender_id,sender_name,sender_headicon,reply_value) values("
					+ "'" + article_id + "'" + "," + "'" + sender_id + "'" + "," + "'" + name + "'" + "," + "'"
					+ headicon + "'" + "," + "'" + content + "'" + ")";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultcode = ResultCodeUtil.REPLY_SUCCESS;
		} catch (Exception e) {
			resultcode = ResultCodeUtil.REPLY_FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultcode;
	}

	/**
	 * 根据文章id点赞
	 * 
	 * @param article_id
	 * @param like_id
	 * @return
	 */
	public int likeToArticle(String article_id, String like_id) {
		int resultCode = ResultCodeUtil.FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "insert likes(like_id,article_id) values('" + like_id + "'" + "," + "'" + article_id + "')";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultCode = ResultCodeUtil.SUCCESS;
		} catch (Exception e) {
			resultCode = ResultCodeUtil.FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultCode;
	}

	/**
	 * 根据id来取消点赞
	 * 
	 * @param article_id
	 * @param like_id
	 * @return
	 */
	public int cancelLikeToArticle(String article_id, String like_id) {
		int resultCode = ResultCodeUtil.FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "delete from likes where like_id=" + "'" + like_id + "'" + " and article_id=" + "'"
					+ article_id + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultCode = ResultCodeUtil.SUCCESS;
		} catch (Exception e) {
			resultCode = ResultCodeUtil.FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultCode;
	}

	/**
	 * 根据文章ID来收藏
	 * 
	 * @param article_id
	 * @param collector_id
	 * @return
	 */
	public int collecteToArticle(String article_id, String collector_id) {
		int resultCode = ResultCodeUtil.FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "insert collection(collector_id,article_id) values('" + collector_id + "'" + "," + "'"
					+ article_id + "')";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultCode = ResultCodeUtil.SUCCESS;
		} catch (Exception e) {
			resultCode = ResultCodeUtil.FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultCode;
	}
	/**
	 * 取消收藏
	 * @param article_id
	 * @param collector_id
	 * @return
	 */
	public int cancelCollectToArticle(String article_id, String collector_id){
		int resultCode = ResultCodeUtil.FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "delete from collection where collector_id=" + "'" + collector_id + "'" + " and article_id=" + "'"
					+ article_id + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			resultCode = ResultCodeUtil.SUCCESS;
		} catch (Exception e) {
			resultCode = ResultCodeUtil.FAIL;
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return resultCode;
	}
}
