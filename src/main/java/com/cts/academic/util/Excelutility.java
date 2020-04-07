package com.cts.academic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {

	// To read and return username
	public String excel_username(int a) throws IOException {

		FileInputStream fil = new FileInputStream(new File(
				"G:\\eclipse\\eclipse2020\\Academic.com\\src\\test\\resources\\com\\cts\\academic\\testdata\\academic.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int count = sheet.getLastRowNum();
		System.out.println(count);

		XSSFRow row = sheet.getRow(a);
		XSSFCell cell = row.getCell(0);
		String un = cell.getStringCellValue();

		return un;
	}

	// TO read and return password
	public String excel_password(int b) throws IOException {

		FileInputStream fil = new FileInputStream(new File(
				"G:\\eclipse\\eclipse2020\\Academic.com\\src\\test\\resources\\com\\cts\\academic\\testdata\\academic.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int count = sheet.getLastRowNum();
		System.out.println(count);

		XSSFRow row = sheet.getRow(b);
		XSSFCell cell1 = row.getCell(1);
		String pwd = cell1.getStringCellValue();

		return pwd;
	}

	public String excel_cnfpassword(int c) throws IOException {

		FileInputStream fil = new FileInputStream(new File(
				"G:\\eclipse\\eclipse2020\\Academic.com\\src\\test\\resources\\com\\cts\\academic\\testdata\\academic.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int count = sheet.getLastRowNum();
		System.out.println(count);

		XSSFRow row = sheet.getRow(c);
		XSSFCell cell1 = row.getCell(1);
		String cnfpwd = cell1.getStringCellValue();

		return cnfpwd;
	}

}
