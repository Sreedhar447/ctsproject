package Stepdefination;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.cts.Base.Testbase;
import com.cts.academic.util.Testutil;
import com.cts.pages.Academicpage;
import com.cts.pages.Homepage;
import com.cts.pages.Registerpage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Access_purchaseStepDefination extends Testbase {
	Academicpage academicpage;
	Homepage homepage;
	Registerpage registerpage;
	Testutil testutil;
	final static Logger log = LogManager.getLogger(Access_purchaseStepDefination.class);

	public Access_purchaseStepDefination() {
		super();
		PageFactory.initElements(driver, this);
	}
	/*
	 * This method is used to launch the browser then enters into the url after that
	 * logging into the page by using credential
	 */

	@When("^user is  on academic journal home page by signing in$")
	public void user_is_on_academic_journal_home_page_by_signing_in() {
		initialization();
		log.info("url launch");

		academicpage = new Academicpage();
		homepage = new Homepage();
		registerpage = new Registerpage();

		try {
			homepage = academicpage.clickon_signpage(prop.getProperty("username"), prop.getProperty("password"));
			log.info("login into page");
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

	}
	/*
	 * This method is used to move to access and purchase link journal and get the
	 * title then compare it with actual
	 */

	@Then("^user is able to click on Access and purchase link$")
	public void user_is_able_to_click_on_Access_and_purchase_link() {
		String actual = homepage.click_on_Acess_purchase_link();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("gets the title" + actual);
		Assert.assertEquals("Access and Purchase Resource Centre | Journals | Oxford Academic", actual);
		log.info("compares the title");
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
