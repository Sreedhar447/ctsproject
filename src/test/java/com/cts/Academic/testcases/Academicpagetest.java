package com.cts.Academic.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cts.Base.Testbase;
import com.cts.academic.util.Testutil;
import com.cts.pages.Academicpage;
import com.cts.pages.Homepage;
import com.cts.pages.Registerpage;

public class Academicpagetest extends Testbase {
	Academicpage academicpage;
	Homepage homepage;
	Registerpage registerpage;
	Testutil testutil;

	public Academicpagetest() {
		super();

	}

	@BeforeMethod
	public void setup() {

		initialization();
		academicpage = new Academicpage();
		testutil= new Testutil();

	}

	@Test(priority = 0)
	public void validate_login_page() {

		String title = academicpage.verifypage();
		Assert.assertEquals(title, "Journals | Oxford Academic");

	}

	@Test(priority = 1)
	public void verify_img() {
		boolean br = academicpage.verifi_oxfordimg();
		Assert.assertTrue(br);

	}

	@Test(priority = 2)
	public void Registration_link() {
		registerpage = academicpage.clickon_register();

	}

	@Test(priority = 3)
	public void validate_signin_link() {
		boolean br = academicpage.verify_signinLinlk();
		Assert.assertTrue(br);

	}

	@Test(priority = 4)
	public void login_check() {
		homepage = academicpage.clickon_signpage(prop.getProperty("username"), prop.getProperty("password"));
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void browserclose() {
		driver.close();
	}

}
