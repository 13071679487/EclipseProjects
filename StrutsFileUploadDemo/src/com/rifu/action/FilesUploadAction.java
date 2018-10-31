package com.rifu.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ļ��ϴ����ؼ�����ʹ������洢�ϴ����ļ����ļ����ͺ��ļ���
 * @author Lifu
 *
 */
public class FilesUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����Ҳ����ʹ��List
	 */
	private File rifu[]; // �ϴ����ļ�
	private String rifuContentType[];// �ļ�����
	private String rifuFileName[]; // �ļ�����
	/*
	 * ����ǹ̶���ʽ �ļ�����Ϊ�ļ�+ContentType �ļ���Ϊ�ļ�+FileName
	 */
	
	

	@Override
	public String execute() throws Exception {
		for(int i=0;i<rifu.length;i++){
			System.out.println("�ļ�����" + rifuContentType[i]);
			System.out.println("�ļ���" + rifuFileName[i]);
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
