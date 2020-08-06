package com.cleartrip.utils;

import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private Workbook wb;
	public ExcelReader(String fileNameWithLocation) {
		try {
			FileInputStream inputFile = new FileInputStream(fileNameWithLocation);
			if (fileNameWithLocation.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(inputFile);
			} else if (fileNameWithLocation.endsWith(".xls")) {
				wb = new HSSFWorkbook(inputFile);
			} else
				System.out.println("Invalid File Format...Kindly use .xls/.xlsx");
		} catch (Exception E) {
			System.out.println("Error with File Reading");
			System.out.println("Make sure it is .xls/.xlsx " + E.getMessage());
		}
	}
	public String getCellData(String sheetName, int row, int col) {
		String data = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		return data;
	}
	public int getRowNum(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum()+1;
	}
	public int getColumnNum(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getLastCellNum();
	}
}
