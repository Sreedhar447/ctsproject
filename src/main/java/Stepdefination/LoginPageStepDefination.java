package Stepdefination;

import org.openqa.selenium.support.PageFactory;

import com.cts.Base.Testbase;
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

	@Given("^user is already on Academic page$")
	public void user_is_already_on_Academic_page() {
		initialization();

		academicpage = new Academicpage();

	}

	@When("^title of academic page is Journals  Oxford Academic is$")
	public void title_of_academic_page_is_Journals_Oxford_Academic_is() {
		String actual = academicpage.verifypage();

	}

	@Then("^user verify the oxford img logo is present or not$")
	public void user_verify_the_oxford_img_logo_is_present_or_not() {
		boolean br = academicpage.verifi_oxfordimg();

	}

	@Then("^user clicks on registerpage$")
	public void user_clicks_on_registerpage() {
		registerpage = academicpage.clickon_register();

	}

	@Then("^user verifies  whethere the signin link present$")
	public void user_verifies_whethere_the_signin_link_present() throws Throwable {
		boolean br = academicpage.verify_signinLinlk();
		

	}

	@Then("^user eneter into the home page by enterring login credentials$")
	public void user_eneter_into_the_home_page_by_enterring_login_credentials() {
		homepage = academicpage.clickon_signpage(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Then("^user click on loginbtn$")
	public void user_click_on_loginbtn() {

	}

	@Then("^user entrs into homepage$")
	public void user_entrs_into_homepage() {

	}

}
