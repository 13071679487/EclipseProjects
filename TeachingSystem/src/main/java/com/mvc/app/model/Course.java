package com.mvc.app.model;

public class Course {
    private String courseid;

    private String cname;

    private String ctype;

    private String examine;

    private Double credit;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid == null ? null : courseid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }
    

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype == null ? null : ctype.trim();
    }

    public String getExamine() {
        return examine;
    }

    public void setExamine(String examine) {
        this.examine = examine == null ? null : examine.trim();
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", cname=" + cname + ", ctype=" + ctype + ", examine=" + examine
				+ ", credit=" + credit + "]";
	}
    
}