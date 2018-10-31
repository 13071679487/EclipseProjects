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
import bean.Content;
import bean.Reply;
import dao.ArticleDao;
import util.ResultCodeUtil;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int GET_ARTICLE_BY_ID=0;
	private final static int GET_ARTICLE = 1;
	private final static int GET_CONTENT = 2;
	private final static int GET_REPLY = 3;
	private final static int POST_REPLY=4;
	
	private final static int LIKE=5;	//µ„‘ﬁ
	private final static int COLLECTION=6;	// ’≤ÿ
	
	

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
		ArticleDao ad = new ArticleDao();
		switch (method) {
		case GET_ARTICLE_BY_ID:
			String article_id4=req.getParameter("id");
			Article article=new ArticleDao().getArticleById(article_id4);
			if(article==null){
				printWriter.write(ResultCodeUtil.FAIL+"");
			}else{
				JSONObject json = (JSONObject) JSON.toJSON(article);
				printWriter.write(json.toString());
			}
			printWriter.flush();
			break;
		case GET_ARTICLE:
			String phone = req.getParameter("phone");
			int article_type = Integer.parseInt(req.getParameter("article_type"));
			int startIndex = Integer.parseInt(req.getParameter("index"));
			int num = Integer.parseInt(req.getParameter("num"));
			ArrayList<Article> articles = ad.getArticleList(phone, article_type, startIndex, num);
			if (articles.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING+"");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < articles.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(articles.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			printWriter.flush();
			break;
		case GET_CONTENT:
			String id = req.getParameter("id");
			ArrayList<Content> contents = ad.getContentById(id);
			if (contents.size() == 0) {
				printWriter.write(ResultCodeUtil.FAIL+"");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < contents.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(contents.get(i));
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			printWriter.flush();
			break;
		case GET_REPLY:
			String article_id = req.getParameter("id");
			System.out.println("id---------"+article_id);
			int startIndex1 = Integer.parseInt(req.getParameter("index"));
			System.out.println("index---------"+startIndex1);
			int num1 = Integer.parseInt(req.getParameter("num"));
			System.out.println("num---------"+num1);
			ArrayList<Reply> replys=ad.getReplyListById(article_id, startIndex1, num1);
			if(replys.size()==0){
				printWriter.write(ResultCodeUtil.HAS_NOTHING+"");
			}else{
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < replys.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(replys.get(i));
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			printWriter.flush();
			break;
		case POST_REPLY:
			String article_id1=req.getParameter("id");
			String sender_id=req.getParameter("sender");
			String name=req.getParameter("name");
			String icon=req.getParameter("icon");
			String content=req.getParameter("content");
			int resultCode=new ArticleDao().replyToArticle(article_id1, sender_id, icon, name, content);
			printWriter.write(resultCode+"");
			printWriter.flush();
			break;
		case LIKE:
			String article_id2=req.getParameter("id");
			String like_id=req.getParameter("like_id");
			int type=Integer.parseInt(req.getParameter("type"));
			int resultCode1;
			if(type==0){
				resultCode1=new ArticleDao().cancelLikeToArticle(article_id2, like_id);
			}else{
				resultCode1=new ArticleDao().likeToArticle(article_id2, like_id);
			}
			printWriter.write(resultCode1+"");
			printWriter.flush();
			break;
		case COLLECTION:
			String article_id3=req.getParameter("id");
			String collector_id=req.getParameter("collector_id");
			int type1=Integer.parseInt(req.getParameter("type"));
			int resultCode2;
			if(type1==0){
				resultCode2=new ArticleDao().cancelCollectToArticle(article_id3, collector_id);
			}else{
				resultCode2=new ArticleDao().collecteToArticle(article_id3, collector_id);
			}
			printWriter.write(resultCode2+"");
			printWriter.flush();
			break;
		}
	}
}
