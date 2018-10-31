package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Job;
import bean.Reply;
import util.C3P0Util;
import util.ResultCodeUtil;

public class JobDao {
	public JobDao() {
	}
	
	/**
	 * 根据id获取对应的职位内容
	 * @param job_id
	 * @return
	 */
	public Job getJobById(String job_id){
		Job job=null;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from job where id='"+job_id+"'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				job=new Job();
				job.setId(rs.getInt("id"));
				job.setAuthor_id(rs.getString("author_id"));
				job.setAuthor_time(rs.getString("author_time"));
				job.setJob_type(rs.getInt("job_type"));
				job.setTitle(rs.getString("title"));
				job.setJob(rs.getString("job_name"));
				job.setDesc(rs.getString("job_desc"));
				job.setSalary(rs.getString("salary"));
				job.setAddress(rs.getString("address"));
				job.setJob_time(rs.getString("job_time"));
				job.setSees(rs.getInt("sees"));
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return job;
	}

	/**
	 * 获取职业列表
	 * 
	 * @param job_type
	 * @param startIndex
	 * @param limitNum
	 * @return
	 */
	public ArrayList<Job> getJobs(int job_type, int startIndex, int limitNum) {
		ArrayList<Job> jobs = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "";
			if (job_type < 5 || job_type > 8) {
				sql = "select * from job limit " + startIndex + "," + limitNum;
			} else {
				sql = "select * from job where job_type=" + job_type + " limit " + startIndex + "," + limitNum;
			}
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Job job = new Job();
				job.setId(rs.getInt("id"));
				job.setAuthor_id(rs.getString("author_id"));
				job.setAuthor_time(rs.getString("author_time"));
				job.setJob_type(rs.getInt("job_type"));
				job.setTitle(rs.getString("title"));
				job.setJob(rs.getString("job_name"));
				job.setDesc(rs.getString("job_desc"));
				job.setSalary(rs.getString("salary"));
				job.setAddress(rs.getString("address"));
				job.setJob_time(rs.getString("job_time"));
				job.setSees(rs.getInt("sees"));
				jobs.add(job);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return jobs;
	}

	/**
	 * 获取职业列表
	 * 
	 * @param job_type
	 * @param startIndex
	 * @param limitNum
	 * @return
	 */
	public ArrayList<Job> getJobsByUserId(String author_id, int startIndex, int limitNum) {
		ArrayList<Job> jobs = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "";
			sql = "select * from job where author_id='" + author_id + "' limit " + startIndex + "," + limitNum;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Job job = new Job();
				job.setId(rs.getInt("id"));
				job.setAuthor_id(rs.getString("author_id"));
				job.setAuthor_time(rs.getString("author_time"));
				job.setJob_type(rs.getInt("job_type"));
				job.setTitle(rs.getString("title"));
				job.setJob(rs.getString("job_name"));
				job.setDesc(rs.getString("job_desc"));
				job.setSalary(rs.getString("salary"));
				job.setAddress(rs.getString("address"));
				job.setJob_time(rs.getString("job_time"));
				job.setSees(rs.getInt("sees"));
				jobs.add(job);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return jobs;
	}
	
	/**
	 * 根据jobId查询回复的内容
	 * 
	 * @param job_id
	 * @param startIndex
	 * @param limitNum
	 * @return
	 */
	public ArrayList<Reply> getReplyListById(String job_id, int startIndex, int limitNum) {
		ArrayList<Reply> replys = new ArrayList<>();
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from job_reply where job_id=" + job_id + " order by id desc limit "
					+ startIndex + "," + limitNum;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Reply reply = new Reply();
				reply.setSender_id(rs.getString("sender_id"));
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
	 * @param job_id
	 *            对应文章的id
	 * @param sender_id
	 *            留言者的id
	 * @param content
	 *            留言的内容
	 */
	public int replyToArticle(String job_id, String sender_id, String content) {
		int resultcode = ResultCodeUtil.REPLY_FAIL;
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "insert job_reply(job_id,sender_id,reply_value) values("
					+ "'" + job_id + "'" + "," + "'" + sender_id + "'" + ","  + "'" + content + "'" + ")";
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
}
