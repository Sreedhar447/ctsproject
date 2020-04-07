package com.cts.Academic.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cts.Base.Testbase;
import com.cts.academic.util.Testutil;
import com.cts.pages.Academicpage;
import com.cts.pages.Homepage;

public class HomepageTest extends Testbase {
	Homepage homepage;
	Academicpage academicpage;
	Testutil testutil;

	public HomepageTest() {
		super();
		PageFactory.initElements(driver, this);

	}

	@BeforeMethod
	public void setup() {

		initialization();

		homepage = new Homepage();
		academicpage = new Academicpage();
		testutil= new Testutil();
		try {
			homepage = academicpage.clickon_signpage(prop.getProperty("username"), prop.getProperty("password"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 0)
	public void vertify_homepage_title() {
		String actual = homepage.verify_title_page();
		Assert.assertEquals(actual, "Journals | Oxford Academic", "homepage title not matched");
	}

	@Test(priority = 1, alwaysRun = true)
	public void user_name_label_check() throws Throwable {

		boolean br = homepage.check_label();
		Assert.assertTrue(br, "labelnotfound");

	}

	@Test(priority = 2, alwaysRun = true)
	public void verify_logo() {

		boolean br = homepage.logo_check();
		Assert.assertTrue(br, "logo missing");
	}

	@Test(priority = 3, alwaysRun = true)
	public void click_on_Arts_human_link() {
		String actual = homepage.click_on_Arts_hum_link();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(actual, "Arts and humanities | Journals | Oxford Academic", "Arts&humanities page not found");
	}

	@Test(priority = 4, alwaysRun = true)
	public void click_on_medicine_health() throws InterruptedException {
		String actual = homepage.click_on_medicines_health_link();
		Thread.sleep(3000);
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(actual, "Medicine and health | Journals | Oxford Academic", "medicine&health page not found");
		
	}

	@Test(priority = 5, alwaysRun = true)
	public void click_on_Acess_purchase_link() throws Throwable {
		String actual = homepage.click_on_Acess_purchase_link();
		Thread.sleep(3000);
		testutil.takeScreenshotAtEndOfTest();
		Assert.assertEquals(actual, "Access and Purchase Resource Centre | Journals | Oxford Academic",
				"Access and purchase page not found");

	}

	@AfterMethod
	public void tear_down() {
		driver.close();

	}

}
