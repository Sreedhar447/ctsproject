package Stepdefination;

import java.io.IOException;

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

	public Medicine_healthStepDefination() {
		super();
		PageFactory.initElements(driver, this);

	}

	@When("^user is on academic page journal home$")
	public void user_is_on_academic_page_journal_home()  {
		
		initialization();
		academicpage = new Academicpage();
		homepage = new Homepage();
		registerpage = new Registerpage();

		homepage = academicpage.clickon_signpage(prop.getProperty("username"), prop.getProperty("password"));
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

	@Then("^user is able to click on Medicines&health link$")
	public void user_is_able_to_click_on_Medicines_health_link() throws Throwable {
		String actual = homepage.click_on_medicines_health_link();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		Assert.assertEquals("Medicine and health | Journals | Oxford Academic", actual);
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
