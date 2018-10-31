package bean;

public class Article {
	private String id; // 文章id
	private String author_id; // 发布者id
	private String author_name; // 发布者名字
	private String author_headicon; // 发布者头像
	private int article_type;
	private String article_title; // 文章标题
	private String article_content; // 文章的第一个内容
	private String article_cover;	//文章封面
	private String article_contentId; // 改文章对应内容表格的id
	private int collections; // 收藏数
	private int likes; // 点赞数
	private int sees; // 阅览次数
	private String author_time; // 发表时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getAuthor_headicon() {
		return author_headicon;
	}

	public void setAuthor_headicon(String author_headicon) {
		this.author_headicon = author_headicon;
	}

	public int getArtilce_type() {
		return article_type;
	}

	public void setArtilce_type(int artilce_type) {
		this.article_type = artilce_type;
	}

	public String getAuthor_time() {
		return author_time;
	}

	public void setAuthor_time(String author_time) {
		this.author_time = author_time;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_content() {
		return article_content;
	}
	
	

	public String getArticle_cover() {
		return article_cover;
	}

	public void setArticle_cover(String article_cover) {
		this.article_cover = article_cover;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public String getArticle_contentId() {
		return article_contentId;
	}

	public void setArticle_contentId(String article_contentId) {
		this.article_contentId = article_contentId;
	}

	public int getCollections() {
		return collections;
	}

	public void setCollections(int collections) {
		this.collections = collections;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getSees() {
		return sees;
	}

	public void setSees(int sees) {
		this.sees = sees;
	}

	public String getTime() {
		return author_time;
	}

	public void setTime(String time) {
		this.author_time = time;
	}

}
