package com.ct.bookflight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IrctcExcel {
	
	
public static void main(String[] args) throws IOException{
	
	String xlpath="C:\\Users\\User\\Desktop\\IrctcData.xlsx";
	FileInputStream fis =new FileInputStream(xlpath);
	//go to workbook
	XSSFWorkbook  wb =new XSSFWorkbook(fis);
	//go to sheet
	Sheet sh=wb.getSheet("Sheet1");
	//get total no of rows
	int totalRows=sh.getLastRowNum();
	System.out.println("total no of rows are"+totalRows);
	//get total no of cols
	int totalCols=sh.getRow(1).getLastCellNum();
	System.out.println("total no of columns are"+totalCols);
    //read cell value
	String origin=sh.getRow(1).getCell(1).getStringCellValue();
	System.out.println("origin is"+origin);
	String destination = sh.getRow(1).getCell(2).getStringCellValue();
	System.out.println("destination is"+destination);
	
}
}
