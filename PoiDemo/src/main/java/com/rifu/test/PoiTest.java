package com.rifu.test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class PoiTest {

	@Test
	public void testCreateExcel() throws Exception{
		//fail("Not yet implemented");
		Workbook wb=new HSSFWorkbook();
		wb.createSheet("First sheet");
		wb.createSheet("Second sheet");
		FileOutputStream fos=new FileOutputStream("d:/poiTest/这是一个excel.xls");
		wb.write(fos);
		fos.close();
	}
	
	/**
	 * 创建行和单元格
	 * @throws Exception
	 */
	@Test
	public void testCreateExcelRowAndCell() throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet=wb.createSheet("First sheet");
		Row row=sheet.createRow(0);
		Cell cell=row.createCell(0);            //后面的参数代表列
		cell.setCellValue("看到我了吗");
		FileOutputStream fos=new FileOutputStream("d:/poiTest/这是一个excel.xls");
		wb.write(fos);
		fos.close();
	}
	
	/**
	 * 对日期进行格式转换
	 */
	@Test
	public void testFormatDate()throws Exception{
		Workbook wb=new HSSFWorkbook(); // 定义一个新的工作簿
		Sheet sheet=wb.createSheet("第一个Sheet页");  // 创建第一个Sheet页
		Row row=sheet.createRow(0); // 创建一个行
		Cell cell=row.createCell(0); // 创建一个单元格  第1列
		cell.setCellValue(new Date());  // 给单元格设置值
		
		CreationHelper createHelper=wb.getCreationHelper();
		CellStyle cellStyle=wb.createCellStyle(); //单元格样式类
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyy-mm-dd hh:mm:ss"));
		cell=row.createCell(1); // 第二列
		cell.setCellValue(new Date());
		cell.setCellStyle(cellStyle);
		
		cell=row.createCell(2);  // 第三列
		cell.setCellValue(Calendar.getInstance());
		cell.setCellStyle(cellStyle);
		
		FileOutputStream fileOut=new FileOutputStream("d:/poiTest/工作簿.xls");
		wb.write(fileOut);
		fileOut.close();
	}
	
	/**
	 * 读取excel表格的内容
	 * @throws Exception
	 */
	@Test
	public void testReadExcel()throws Exception{
		InputStream is=new FileInputStream("d:/poiTest/名单.xls");
		POIFSFileSystem fs = new POIFSFileSystem(is);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		if(sheet!=null){
			System.out.println("totalRow:"+sheet.getLastRowNum());
			for(int rownum=0;rownum<=sheet.getLastRowNum();rownum++){
				HSSFRow row = sheet.getRow(rownum);
				if(row!=null){
					for(int cellnum=0;cellnum<=row.getLastCellNum();cellnum++){
						HSSFCell cell = row.getCell(cellnum);
						if(cell!=null){
							String cellValue=formatCellValue(cell);
							System.out.print(cellValue+"\t");
						}
					}
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * 提取excel表格里面的文本
	 */
	@Test
	public void testCatchText()throws Exception{
		InputStream is=new FileInputStream("d:/poiTest/名单.xls");
		POIFSFileSystem fs=new POIFSFileSystem(is);
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		
		ExcelExtractor excelExtractor=new ExcelExtractor(wb);
		excelExtractor.setIncludeSheetNames(false);// 我们不需要Sheet页的名字
		System.out.println(excelExtractor.getText());
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
