package Stepdefination;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import com.cts.Base.Testbase;
import com.cts.academic.util.Excelutility;
import com.cts.academic.util.Testutil;
import com.cts.pages.Academicpage;
import com.cts.pages.Homepage;
import com.cts.pages.Registerpage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationPageStepDefination extends Testbase {

	final static Logger log = LogManager.getLogger(RegistrationPageStepDefination.class);

	public RegistrationPageStepDefination() {
		super();
		PageFactory.initElements(driver, this);
	}

	Academicpage academicpage;
	Homepage homepage;
	Registerpage registerpage;
	Testutil testutil;
	Excelutility excel;

	/* This metod is used to move to journal page */
	@Given("^user is academic page$")
	public void user_is_academic_page() {
		initialization();
		log.info("academic page launching");
		academicpage = new Academicpage();
		testutil = new Testutil();
		excel = new Excelutility();

	}

	/* This method is used to click on register link */
	@When("^user clicks on registration link$")
	public void user_clicks_on_registration_link() {
		registerpage = academicpage.clickon_register();
		log.info("click on register link");
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * This method is used to enter the registration details then click on the
	 * registration button
	 */
	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and_and(String arg1, String arg2, String arg3) {
		registerpage.register(arg1, arg2, arg3);
		try {
			testutil.takeScreenshotAtEndOfTest();
			log.info("takes the Screenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
