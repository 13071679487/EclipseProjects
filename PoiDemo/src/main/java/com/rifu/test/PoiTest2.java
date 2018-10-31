package com.rifu.test;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

public class PoiTest2 {

	/**
	 * 创建单元格并设置对齐方式
	 */
	@Test
	public void testCreateCellWithAlign() throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet = wb.createSheet("test");
		Row row = sheet.createRow(0);
		createCell(wb,row,(short)0,"test123",HorizontalAlignment.CENTER,VerticalAlignment.BOTTOM);
		FileOutputStream fos=new FileOutputStream("d:/poiTest/这是一个excel-01.xls");
		wb.write(fos);
		fos.close();
	}
	
	/**
	 * 创建单元格并设置边框
	 */
	@Test
	public void testCreateCellWithBorder() throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet = wb.createSheet("test");
		Row row = sheet.createRow(0);
		
		Cell cell = row.createCell(1);
		cell.setCellValue("test123456");
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBottomBorderColor(IndexedColors.DARK_YELLOW.getIndex());
		
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setLeftBorderColor(IndexedColors.DARK_RED.getIndex());
		
		cellStyle.setBorderTop(BorderStyle.MEDIUM_DASHED);
		cellStyle.setTopBorderColor(IndexedColors.BLUE.getIndex());
		
		cellStyle.setBorderRight(BorderStyle.DOUBLE);
		cellStyle.setRightBorderColor(IndexedColors.GOLD.getIndex());
		
		cell.setCellStyle(cellStyle);
		File file=new File("d:/poiTest/这是一个excel-02.xls");
		if(file.exists()){
			file.delete();
		}
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
	}
	
	/**
	 * 创建单元格并设置前景色和背景色
	 */
	@Test
	public void testCreateCellWithColor() throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet = wb.createSheet("test");
		Row row = sheet.createRow(0);
		
		Cell cell = row.createCell(1);
		cell.setCellValue("test123456");
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());	//设置背景色
		cellStyle.setFillPattern(FillPatternType.BIG_SPOTS);
		
		cell.setCellStyle(cellStyle);
		
		Cell cell2 = row.createCell(2);
		cell.setCellValue("tes987564");
		CellStyle cellStyle2 = wb.createCellStyle();
		cellStyle2.setFillForegroundColor(IndexedColors.RED.getIndex());	//设置前景色
		cellStyle2.setFillPattern(FillPatternType.BIG_SPOTS);
		
		cell2.setCellStyle(cellStyle2);
		File file=new File("d:/poiTest/这是一个excel.xls");
		if(file.exists()){
			file.delete();
		}
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
	}
	
	/**
	 * 测试合并单元格
	 */
	@Test 
	public void testMergeCell() throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet = wb.createSheet("test");
		Row row = sheet.createRow(0);
		
		Cell cell = row.createCell(1);
		cell.setCellValue("test123456");
		
		sheet.addMergedRegion(new CellRangeAddress(0,0,1,2));
		File file=new File("d:/poiTest/这是一个excel.xls");
		if(file.exists()){
			file.delete();
		}
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
	}
	
	
	/**
	 * 
	 * @param wb
	 * @param row
	 * @param column
	 * @param value
	 * @param hAlign	水平对齐方式
	 * @param vAlign	垂直对齐方式
	 */
	private static void createCell(Workbook wb,Row row,short column,String value,HorizontalAlignment hAlign,VerticalAlignment vAlign){
		Cell cell = row.createCell(column);
		cell.setCellValue(value);
		CellStyle cellStyle = wb.createCellStyle();
		
		cellStyle.setAlignment(hAlign);
		cellStyle.setVerticalAlignment(vAlign);
		
		cell.setCellStyle(cellStyle);
	}
	
	
	
	
	/**
	 * 对传过来的HSSFCell进行数据的转换
	 * @param cell
	 * @return
	 */
	public static String formatCellValue(HSSFCell cell){
		String value="";
		switch(cell.getCellType()){
		case HSSFCell.CELL_TYPE_BOOLEAN:
			value=String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			value=String.valueOf(cell.getNumericCellValue());
			break;
		default:
			value=String.valueOf(cell.getStringCellValue());
				break;
		}
		return value;
	}

}
