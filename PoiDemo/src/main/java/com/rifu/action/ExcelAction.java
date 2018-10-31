package com.rifu.action;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get");
		Workbook wb=new HSSFWorkbook();
		String headers[]={"编号","姓名","邮箱"};
		fillData(wb,headers);
		String fileName="资料.xls";
		resp.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"iso8859-1"));
		resp.setContentType("application/ynd.ms-excel;charset=UTF-8");
		OutputStream outputStream = resp.getOutputStream();
		wb.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do post");
		Workbook wb=new HSSFWorkbook();
		String headers[]={"编号","姓名","邮箱"};
		fillData(wb,headers);
		String fileName="资料.xls";
		resp.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"iso8859-1"));
		resp.setContentType("application/ynd.ms-excel;charset=UTF-8");
		OutputStream outputStream = resp.getOutputStream();
		wb.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}
	
	
	private static void fillData(Workbook wb,String[]headers){
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(0);
		for(int i=0;i<headers.length;i++){
			Cell cell = row.createCell(i);
			cell.setCellValue(headers[i]);
		}
		Row rowcontent = sheet.createRow(1);
		for(int i=0;i<headers.length;i++){
			rowcontent.createCell(i).setCellValue("index"+i);;
		}
	}

}
