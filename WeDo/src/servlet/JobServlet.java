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

import bean.Job;
import bean.Reply;
import dao.JobDao;
import util.ResultCodeUtil;

@WebServlet("/job")
public class JobServlet extends HttpServlet {
	private static final int GET_JOBS = 1;
	private static final int GET_JOBS_BY_ID = 2;		//根据用户获取对应的职位列表
	private static final int GET_REPLY_BY_ID = 3;
	private static final int REPLY_TO_JOB = 4;
	private static final int GET_JOB_BY_ID=5;			//根据job_id获取对应的职位信息
	/**
	 * 
	 */
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
		switch (method) {
		case GET_JOBS:
			int type = Integer.parseInt(req.getParameter("type"));
			int index = Integer.parseInt(req.getParameter("index"));
			int num = Integer.parseInt(req.getParameter("num"));
			ArrayList<Job> jobs = new JobDao().getJobs(type, index, num);
			if (jobs.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < jobs.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(jobs.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case GET_JOBS_BY_ID:
			String author_id = req.getParameter("id");
			int index1 = Integer.parseInt(req.getParameter("index"));
			int num1 = Integer.parseInt(req.getParameter("num"));
			ArrayList<Job> jobs1 = new JobDao().getJobsByUserId(author_id, index1, num1);
			if (jobs1.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < jobs1.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(jobs1.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case GET_REPLY_BY_ID:
			String job_id=req.getParameter("id");
			int index2 = Integer.parseInt(req.getParameter("index"));
			int num2 = Integer.parseInt(req.getParameter("num"));
			ArrayList<Reply> replys=new JobDao().getReplyListById(job_id, index2, num2);
			if (replys.size() == 0) {
				printWriter.write(ResultCodeUtil.HAS_NOTHING + "");
			} else {
				JSONArray jsons = new JSONArray();
				for (int i = 0; i < replys.size(); i++) {
					JSONObject json = (JSONObject) JSON.toJSON(replys.get(i));
					System.out.println(json.toString());
					jsons.add(json);
				}
				printWriter.write(jsons.toString());
			}
			break;
		case REPLY_TO_JOB:
			String job_id1=req.getParameter("id");
			String sender_id=req.getParameter("sender_id");
			String content=req.getParameter("content");
			int resultCode=new JobDao().replyToArticle(job_id1, sender_id, content);
			printWriter.write(resultCode+"");
			break;
		case GET_JOB_BY_ID:
			String job_id2=req.getParameter("id");
			Job job=new JobDao().getJobById(job_id2);
			if(job==null){
				printWriter.write(ResultCodeUtil.FAIL+"");
			}else{
				JSONObject json = (JSONObject) JSON.toJSON(job);
				printWriter.write(json.toString());
			}
		}
		printWriter.flush();
	}
}
