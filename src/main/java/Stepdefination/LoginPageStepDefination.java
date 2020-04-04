package Stepdefination;

import java.io.IOException;

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

	@Given("^user is already on Academic page$")
	public void user_is_already_on_Academic_page() {
		initialization();
		testutil = new Testutil();

		academicpage = new Academicpage();

	}

	@When("title of academic page is Journals  Oxford Academic  or not$")
	public void title_of_academic_page_is_Journals_Oxford_Academic_is() {
		String actual = academicpage.verifypage();
		Assert.assertEquals("Journals | Oxford Academic", actual);

	}

	@Then("^user verify the oxford img logo is present or not$")
	public void user_verify_the_oxford_img_logo_is_present_or_not() {
		boolean br = academicpage.verifi_oxfordimg();
		Assert.assertTrue("img not found", br);

	}

	@Then("^user clicks on registerpage$")
	public void user_clicks_on_registerpage() {
		registerpage = academicpage.clickon_register();

	}

	@Then("^user verifies  whethere the signin link present$")
	public void user_verifies_whethere_the_signin_link_present() throws Throwable {
		boolean br = academicpage.verify_signinLinlk();
		Assert.assertTrue("sign in link not found", br);

	}

	@Then("^user eneter into the home page by enterring login credentials and user enters into loginpage$")
	public void user_eneter_into_the_home_page_by_enterring_login_credentials_and_user_enters_into_loginpage()
			 {

		homepage = academicpage.clickon_signpage(prop.getProperty("username"), prop.getProperty("password"));
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^user close the bowser$")
	public void user_close_the_bowser() {
		driver.close();

	}

}
