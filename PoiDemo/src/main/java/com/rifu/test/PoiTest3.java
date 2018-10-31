package com.rifu.test;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class PoiTest3 {
	
	/**
	 * 设置单元格字体样式
	 */
	@Test 
	public void testFontStyle() throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet = wb.createSheet("test");
		Row row = sheet.createRow(0);
		
		Font font = wb.createFont();
		font.setFontHeightInPoints((short)24);
		font.setFontName("Courier New");
		font.setItalic(true);
		font.setBold(true);
		
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFont(font);
		
		Cell cell = row.createCell(1);
		cell.setCellValue("This is a interesting thing");
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
