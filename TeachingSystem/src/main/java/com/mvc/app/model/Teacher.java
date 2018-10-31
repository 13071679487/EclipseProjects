package com.mvc.app.model;

public class Teacher {
    private String tid;

    private String tname;

    private String sex;

    private String jobtype;

    private String tcolid;
    
    private Lecture lecture;
    
    private Course course;
      
    private College college;
    
    public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype == null ? null : jobtype.trim();
    }

	public String getTcolid() {
		return tcolid;
	}

	public void setTcolid(String tcolid) {
		this.tcolid = tcolid;
	}

 
}