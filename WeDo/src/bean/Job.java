package bean;

public class Job {
	private int id;
	private String author_id;
	private String author_time;
	private int job_type; // 职位的类型--全职5，兼职6，实习7，家教8
	private String title;
	private String job; // 岗位名称
	private String desc;
	private String salary;
	private String address;
	private String job_time;
	private int sees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_time() {
		return author_time;
	}

	public void setAuthor_time(String author_time) {
		this.author_time = author_time;
	}

	public int getJob_type() {
		return job_type;
	}

	public void setJob_type(int job_type) {
		this.job_type = job_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob_time() {
		return job_time;
	}

	public void setJob_time(String job_time) {
		this.job_time = job_time;
	}

	public int getSees() {
		return sees;
	}

	public void setSees(int sees) {
		this.sees = sees;
	}

}
