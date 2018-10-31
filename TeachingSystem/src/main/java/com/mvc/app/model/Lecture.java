package com.mvc.app.model;

public class Lecture extends LectureKey {
    private String ttime;

    private Course course;
    
    
    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime == null ? null : ttime.trim();
    }
}