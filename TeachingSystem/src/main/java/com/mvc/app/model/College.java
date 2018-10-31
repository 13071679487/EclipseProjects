package com.mvc.app.model;

public class College {
    private String colid;

    private String colname;

    public String getColid() {
        return colid;
    }

    public void setColid(String colid) {
        this.colid = colid == null ? null : colid.trim();
    }

    public String getColname() {
        return colname;
    }

    public void setColname(String colname) {
        this.colname = colname == null ? null : colname.trim();
    }
}