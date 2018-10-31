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
		FileOutputStream fos=new FileOutputStream("d:/poiTest/����һ��excel.xls");
		wb.write(fos);
		fos.close();
	}
	
	/**
	 * �����к͵�Ԫ��
	 * @throws Exception
	 */
	@Test
	public void testCreateExcelRowAndCell() throws Exception{
		Workbook wb=new HSSFWorkbook();
		Sheet sheet=wb.createSheet("First sheet");
		Row row=sheet.createRow(0);
		Cell cell=row.createCell(0);            //����Ĳ���������
		cell.setCellValue("����������");
		FileOutputStream fos=new FileOutputStream("d:/poiTest/����һ��excel.xls");
		wb.write(fos);
		fos.close();
	}
	
	/**
	 * �����ڽ��и�ʽת��
	 */
	@Test
	public void testFormatDate()throws Exception{
		Workbook wb=new HSSFWorkbook(); // ����һ���µĹ�����
		Sheet sheet=wb.createSheet("��һ��Sheetҳ");  // ������һ��Sheetҳ
		Row row=sheet.createRow(0); // ����һ����
		Cell cell=row.createCell(0); // ����һ����Ԫ��  ��1��
		cell.setCellValue(new Date());  // ����Ԫ������ֵ
		
		CreationHelper createHelper=wb.getCreationHelper();
		CellStyle cellStyle=wb.createCellStyle(); //��Ԫ����ʽ��
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyy-mm-dd hh:mm:ss"));
		cell=row.createCell(1); // �ڶ���
		cell.setCellValue(new Date());
		cell.setCellStyle(cellStyle);
		
		cell=row.createCell(2);  // ������
		cell.setCellValue(Calendar.getInstance());
		cell.setCellStyle(cellStyle);
		
		FileOutputStream fileOut=new FileOutputStream("d:/poiTest/������.xls");
		wb.write(fileOut);
		fileOut.close();
	}
	
	/**
	 * ��ȡexcel��������
	 * @throws Exception
	 */
	@Test
	public void testReadExcel()throws Exception{
		InputStream is=new FileInputStream("d:/poiTest/����.xls");
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
	 * ��ȡexcel���������ı�
	 */
	@Test
	public void testCatchText()throws Exception{
		InputStream is=new FileInputStream("d:/poiTest/����.xls");
		POIFSFileSystem fs=new POIFSFileSystem(is);
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		
		ExcelExtractor excelExtractor=new ExcelExtractor(wb);
		excelExtractor.setIncludeSheetNames(false);// ���ǲ���ҪSheetҳ������
		System.out.println(excelExtractor.getText());
	}
	
	/**
	 * �Դ�������HSSFCell�������ݵ�ת��
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
