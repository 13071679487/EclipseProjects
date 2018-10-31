package com.rifu.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File rifu; // �ϴ����ļ�
	private String rifuContentType;// �ļ�����
	private String rifuFileName; // �ļ�����
	/*
	 * ����ǹ̶���ʽ �ļ�����Ϊ�ļ�+ContentType �ļ���Ϊ�ļ�+FileName
	 */

	@Override
	public String execute() throws Exception {
		System.out.println("�ļ�����" + rifuContentType);
		System.out.println("�ļ���" + rifuFileName);
		String rifuPath = "D:/" + rifuFileName;
		File saveFile = new File(rifuPath);
		FileUtils.copyFile(rifu, saveFile);
		return SUCCESS;
	}

	public File getRifu() {
		return rifu;
	}

	public void setRifu(File rifu) {
		this.rifu = rifu;
	}

	public String getRifuContentType() {
		return rifuContentType;
	}

	public void setRifuContentType(String rifuContentType) {
		this.rifuContentType = rifuContentType;
	}

	public String getRifuFileName() {
		return rifuFileName;
	}

	public void setRifuFileName(String rifuFileName) {
		this.rifuFileName = rifuFileName;
	}

}
