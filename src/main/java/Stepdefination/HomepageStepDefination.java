package Stepdefination;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.support.PageFactory;

import com.cts.Base.Testbase;
import com.cts.academic.util.Testutil;
import com.cts.pages.Academicpage;
import com.cts.pages.Homepage;
import com.cts.pages.Registerpage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomepageStepDefination extends Testbase {

	Academicpage academicpage;
	Homepage homepage;
	Registerpage registerpage;
	Testutil testutil;
	final static Logger log = LogManager.getLogger(HomepageStepDefination.class);
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	public HomepageStepDefination() {
		super();
		PageFactory.initElements(driver, this);

	}

	/*
	 * This method is used to launch the browser then enters into the url after that
	 * logging into the page by using credential
	 */
	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		initialization();
		log.info("Enters into academic page");
		academicpage = new Academicpage();
		homepage = new Homepage();
		registerpage = new Registerpage();
		homepage = academicpage.clickon_signpage(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Enters into the login page");
		testutil.takeScreenshotAtEndOfTest();

	}

	/* This method is used to get and verify home page title */
	@When("^user verifies homepage title$")
	public void user_is_on_homepage() {
		String actual = homepage.verify_title_page();
		Assert.assertEquals("Journals | Oxford Academic", actual);
		log.info("compares the title with " + actual);

	}

	/* This method is used to verify the label */
	@Then("^user checks label$")
	public void user_checks_label() {
		boolean br = homepage.check_label();
		Assert.assertTrue("label not found", br);

	}

	/* This method is used to check Journal page Logo */
	@Then("^user verifies the logo$")
	public void user_verifies_the_logo() {
		boolean br = homepage.logo_check();
		Assert.assertTrue("logo not found", br);

	}

	/* This method is used to move to the Arts and humanities link */
	@Then("^user is able to click on Arts&humanities link$")
	public void user_is_able_to_click_on_Arts_humanities_link() {
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
		Assert.assertEquals("Arts and humanities | Journals | Oxford Academic", actual);
		log.info("gets the arts and humanities journal title" + actual);
	}

	/* This method is used to close the browser */
	@Then("^user close the browser$")
	public void user_close_the_browser() {
		driver.close();
		log.info("close the browser");

	}
}
