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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStepDefination extends Testbase {
	public LoginPageStepDefination() {
		super();
		PageFactory.initElements(driver, this);
	}

	Academicpage academicpage;
	Homepage homepage;
	Registerpage registerpage;
	Testutil testutil;
	final static Logger log = LogManager.getLogger(LoginPageStepDefination.class);

	/* This method is used to launch the Chrome and enters into academic page */
	@Given("^user is already on Academic page$")
	public void user_is_already_on_Academic_page() {
		initialization();
		log.info("academic page launching");
		testutil = new Testutil();
		academicpage = new Academicpage();

	}

	/* This method is used to get verify the title */
	@When("title of academic page is Journals  Oxford Academic  or not$")
	public void title_of_academic_page_is_Journals_Oxford_Academic_is() {
		String actual = academicpage.verifypage();
		Assert.assertEquals("Journals | Oxford Academic", actual);
		log.info("comares the title with Journals | Oxford Academic " + actual);

	}

	/* This method is used to verify the image */
	@Then("^user verify the oxford img logo is present or not$")
	public void user_verify_the_oxford_img_logo_is_present_or_not() {
		boolean br = academicpage.verifi_oxfordimg();
		Assert.assertTrue("img not found", br);
		log.info("checks the oxford image");

	}

	/* This method is used to click on register page */
	@Then("^user clicks on registerpage$")
	public void user_clicks_on_registerpage() {
		registerpage = academicpage.clickon_register();

	}

	/* This method checks whether the signlink is present or not */
	@Then("^user verifies  whethere the signin link present$")
	public void user_verifies_whethere_the_signin_link_present() throws Throwable {
		boolean br = academicpage.verify_signinLinlk();
		Assert.assertTrue("sign in link not found", br);

	}

	/* This method is used to enter into home through login */
	@Then("^user eneter into the home page by enterring login credentials and user enters into loginpage$")
	public void user_eneter_into_the_home_page_by_enterring_login_credentials_and_user_enters_into_loginpage() {

		homepage = academicpage.clickon_signpage(prop.getProperty("username"), prop.getProperty("password"));
		log.info("enters into the home page by using login credentials");
		try {
			testutil.takeScreenshotAtEndOfTest();
			log.info("take the screenshot of login page");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* This method is used to close the browser */
	@Then("^user close the bowser$")
	public void user_close_the_bowser() {
		driver.close();
		log.info("close the driver");

	}

}
