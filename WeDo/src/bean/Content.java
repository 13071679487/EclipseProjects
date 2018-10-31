package bean;

public class Content {
	private String id;
	private String article_id;
	private int position;
	private int type;	//1为标题，2为文本内容，3为图片
	private String value;
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
	public int getIndex() {
		return position;
	}
	public void setIndex(int index) {
		this.position = index;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
