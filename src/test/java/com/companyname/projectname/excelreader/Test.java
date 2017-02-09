package com.companyname.projectname.excelreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class Test {

	public static WebDriver driver;
	
	
	public static void main(String[] args) throws IOException {
		
	
		FileInputStream file;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
	

		
		file = new FileInputStream("C://Users//rakesh//Desktop//Login.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum() + 1;
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();

		
		
		 
		System.out.println(colCount + ", " + rowCount);

		String inputData[][] = new String[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				cell = row.getCell(j);
				inputData[i][j] = cell.getStringCellValue();
				// System.out.println(inputData[i][j]);
			}
		}
		

	}

}
