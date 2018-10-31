package bean;

public class Follow {
	private String id;
	private String follower_id;
	private String befollower_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFollower_id() {
		return follower_id;
	}

	public void setFollower_id(String follower_id) {
		this.follower_id = follower_id;
	}

	public String getBefollower_id() {
		return befollower_id;
	}

	public void setBefollower_id(String befollower_id) {
		this.befollower_id = befollower_id;
	}

}
