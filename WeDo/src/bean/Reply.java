package bean;

public class Reply {
	private String id;
	private String article_id;
	private String sender_id;
	private String sender_headicon;
	private String sender_name;
	private String reply_value;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getSender_headicon() {
		return sender_headicon;
	}
	public void setSender_headicon(String sender_headicon) {
		this.sender_headicon = sender_headicon;
	}
	
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public String getReply_value() {
		return reply_value;
	}
	public void setReply_value(String reply_value) {
		this.reply_value = reply_value;
	}
	
}
