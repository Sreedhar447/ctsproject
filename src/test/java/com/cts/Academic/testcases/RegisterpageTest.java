package com.cts.Academic.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cts.Base.Testbase;
import com.cts.academic.util.Testutil;
import com.cts.pages.Academicpage;
import com.cts.pages.Registerpage;

public class RegisterpageTest extends Testbase {

	Academicpage academicpag;
	Registerpage register;
	Academicpagetest acpagtest;
	Testutil testutil;
	String sheetName = "Registerdata";

	public RegisterpageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		acpagtest = new Academicpagetest();
		academicpag = new Academicpage();
		register = new Registerpage();
		testutil = new Testutil();

		register = academicpag.clickon_register();

	}

	@DataProvider(name = "user_credentials")
	public Object[][] get_reg_data() throws IOException {
		Object[][] testData = null;

		// Opening the Excel File
		FileInputStream file = new FileInputStream("C:\\Users\\sreed\\OneDrive\\Desktop\\academic.xlsx");
		// OPening the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		// Open the Sheet and pass the sheet name "Login"
		XSSFSheet loginSheet = workbook.getSheet("Registerdata");
		// to get the number of row in the excel
		int numberOfData = loginSheet.getPhysicalNumberOfRows();
		System.out.println(numberOfData);
		//
		testData = new Object[numberOfData][3];

		for (int i = 0; i < numberOfData; i++) {
			XSSFRow row = loginSheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			XSSFCell cnfpwd = row.getCell(2);
			// to get the value of the cells
			testData[i][0] = username.getStringCellValue();
			testData[i][1] = password.getStringCellValue();
			testData[i][2] = cnfpwd.getStringCellValue();

			System.out.println(testData[i][0]);
			System.out.println(testData[i][1]);
			System.out.println(testData[i][2]);
		}
		workbook.close();
		return testData;
	}

	@Test(dataProvider = "user_credentials")
	public void Registertest_check(String Email, String password, String confirmpwd) {
		register.register(Email, password, confirmpwd);

	}

	@AfterMethod
	public void browserclose() {
		driver.close();
	}

}
