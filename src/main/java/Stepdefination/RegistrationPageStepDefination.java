package Stepdefination;

import java.io.IOException;

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

	public RegistrationPageStepDefination() {
		super();
		PageFactory.initElements(driver, this);
	}

	Academicpage academicpage;
	Homepage homepage;
	Registerpage registerpage;
	Testutil testutil;
	Excelutility excel;

	@Given("^user is academic page$")
	public void user_is_academic_page() {
		initialization();
		academicpage = new Academicpage();
		testutil = new Testutil();
		excel = new Excelutility();
	

	}

	@When("^user clicks on registration link$")
	public void user_clicks_on_registration_link() {
		registerpage = academicpage.clickon_register();
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and_and(String arg1, String arg2, String arg3) {
		registerpage.register(arg1, arg2, arg3);
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
}
