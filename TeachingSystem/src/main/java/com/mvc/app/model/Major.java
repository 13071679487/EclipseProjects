package com.mvc.app.model;

public class Major extends MajorKey {
    private Double score;

    private String majortime;
    
    private Course course;

    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getMajortime() {
        return majortime;
    }

    public void setMajortime(String majortime) {
        this.majortime = majortime == null ? null : majortime.trim();
    }

	@Override
	public String toString() {
		return "Major [score=" + score + ", majortime=" + majortime + ", course=" + course + "]";
	}
    
}