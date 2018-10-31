package com.rifu.bean;

public class Department {
    private Integer deptId;

    private String deptName;

    public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}

	public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
    
    
}