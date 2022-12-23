package com.examplet.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

public String[][] readExcelF(String filepath, String sheetName) throws IOException {
		
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook libro =  new XSSFWorkbook(inputStream);
		XSSFSheet hoja = libro.getSheet(sheetName);
		
		int nFilas = hoja.getLastRowNum();
		String [][] matrizUP = new String[hoja.getLastRowNum()][2];
		for (int i = 1; i <= nFilas; i++) {
			XSSFRow row = hoja.getRow(i);
			int nColumna = row.getLastCellNum();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				matrizUP[i-1][j] = row.getCell(j).getStringCellValue();
				}
			}
		
		return matrizUP;
	}
}
