package com.rifu.test;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class PoiTest4 {
	
	/**
	 * ���õ�Ԫ���к͸߶ȵ�
	 * @throws Exception
	 */
	@Test
	public void testReadAndWrite() throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet = wb.createSheet("test");
		Row row = sheet.createRow(3);
		
		
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setWrapText(true);  	//���õ�Ԫ��������Խ��л��У����\n����ʹ��
		
		//�����еĸ߶�ΪĬ�ϵ�����
		row.setHeightInPoints(2*sheet.getDefaultRowHeightInPoints());
		sheet.autoSizeColumn(1); 	//���õڼ��п����Զ��������
		
		Cell cell = row.createCell(1);
		cell.setCellValue("This is a \n interesting thing");
		cell.setCellStyle(cellStyle);
		
		File file=new File("d:/poiTest/����һ��excel.xls");
		if(file.exists()){
			file.delete();
		}
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
	}
	
	/**
	 * �������ݸ�ʽ
	 * @throws Exception
	 */
	@Test
	public void testFormatNumberData() throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet = wb.createSheet("test");
		Row row;
		Cell cell;
		CellStyle cellStyle;
		DataFormat format = wb.createDataFormat();
		short rownum=0;
		
		
		row = sheet.createRow(rownum++);
		cell = row.createCell(1);
		cell.setCellValue(1111111.25);
		cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(format.getFormat("0.0"));
		cell.setCellStyle(cellStyle);
		
		row = sheet.createRow(rownum++);
		cell = row.createCell(1);
		cell.setCellValue(1111111.25);
		cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(format.getFormat("#,##0.000"));
		cell.setCellStyle(cellStyle);
		
		
		File file=new File("d:/poiTest/����һ��excel.xls");
		if(file.exists()){
			file.delete();
		}
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
	}
}
