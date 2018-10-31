package com.rifu.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 多文件上传，关键在于使用数组存储上传的文件、文件类型和文件名
 * @author Lifu
 *
 */
public class FilesUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 这里也可以使用List
	 */
	private File rifu[]; // 上传的文件
	private String rifuContentType[];// 文件类型
	private String rifuFileName[]; // 文件名字
	/*
	 * 这个是固定格式 文件类型为文件+ContentType 文件名为文件+FileName
	 */
	
	

	@Override
	public String execute() throws Exception {
		for(int i=0;i<rifu.length;i++){
			System.out.println("文件类型" + rifuContentType[i]);
			System.out.println("文件名" + rifuFileName[i]);
			String rifuPath = "D:/" + rifuFileName[i];
			File saveFile = new File(rifuPath);
			FileUtils.copyFile(rifu[i], saveFile);
		}
		return SUCCESS;
	}



	public File[] getRifu() {
		return rifu;
	}



	public void setRifu(File[] rifu) {
		this.rifu = rifu;
	}



	public String[] getRifuContentType() {
		return rifuContentType;
	}



	public void setRifuContentType(String[] rifuContentType) {
		this.rifuContentType = rifuContentType;
	}



	public String[] getRifuFileName() {
		return rifuFileName;
	}



	public void setRifuFileName(String[] rifuFileName) {
		this.rifuFileName = rifuFileName;
	}


}
