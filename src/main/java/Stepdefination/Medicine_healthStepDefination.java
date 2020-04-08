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

public class Medicine_healthStepDefination extends Testbase {

	Academicpage academicpage;
	Homepage homepage;
	Registerpage registerpage;
	Testutil testutil;
	final static Logger log = LogManager.getLogger(Medicine_healthStepDefination.class);

	public Medicine_healthStepDefination() {
		super();
		PageFactory.initElements(driver, this);

	}
	/*
	 * This method is used to launch the browser then enters into the url after that
	 * logging into the page by using credential
	 */

	@When("^user is on academic page journal home$")
	public void user_is_on_academic_page_journal_home() {

		initialization();
		log.info("Enters into academic page");
		academicpage = new Academicpage();
		homepage = new Homepage();
		registerpage = new Registerpage();

		homepage = academicpage.clickon_signpage(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Enters into the login page Through login credentials ");
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
	 * This method is used to move on to the medicines and health link then gets the
	 * title of the medicines and health journal page
	 */
	@Then("^user is able to click on Medicines&health link$")
	public void user_is_able_to_click_on_Medicines_health_link() throws Throwable {
		String actual = homepage.click_on_medicines_health_link();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("gets the title" + actual);
		Assert.assertEquals("Medicine and health | Journals | Oxford Academic", actual);
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
