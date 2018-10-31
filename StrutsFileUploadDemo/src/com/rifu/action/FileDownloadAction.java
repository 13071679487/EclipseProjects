package com.rifu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fileName; // 文件名字
	
	

	public String getFileName() throws Exception {
		fileName=new String(fileName.getBytes(),"iso8859-1");
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * 这个方法名是固定写法
	 * @return
	 * @throws Exception
	 */
	public InputStream getInputStream() throws Exception{
		this.fileName="add";
		File file=new File("D:/background.jpg");
		return new FileInputStream(file);
	}

}
