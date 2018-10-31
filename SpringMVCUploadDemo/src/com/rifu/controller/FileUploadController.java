package com.rifu.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file1, HttpServletRequest req)
			throws Exception{
		String filePath = req.getServletContext().getRealPath("/");
		System.out.println(filePath);
		/**
		 * 标志，这里需要从新创建一个变量来存放file,不然会异常，原因不明
		 */
		File file=new File(filePath + "upload/" + file1.getOriginalFilename());
		file1.transferTo(file);
		return "redirect:success.html";
	}

	@RequestMapping("/uploads")
	public String uploadFiles(@RequestParam("file") MultipartFile[] files, HttpServletRequest req)
			throws Exception{
		String filePath = req.getServletContext().getRealPath("/");
		System.out.println(filePath);
		for (MultipartFile file : files) {
			File toFile=new File(filePath + "upload/" + file.getOriginalFilename());
			file.transferTo(toFile);
		}
		return "redirect:success.html";
	}
}
