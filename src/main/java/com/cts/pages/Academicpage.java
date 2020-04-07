package com.cts.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.Base.Testbase;

public class Academicpage extends Testbase {

//page repository OR
	@FindBy(xpath = "//li[@class='oup-header-menu-item desktop']//a[@id='header-account-info-user-fullname']")
	WebElement signinlink;
	@FindBy(xpath = "//input[@id='user_LoginFormPopup']")
	WebElement emaiaddress;
	@FindBy(xpath = "//input[@id='pass_LoginFormPopup']")
	WebElement password;
	@FindBy(xpath = "//button[@class='signin-button button']")
	WebElement signinbtn;
	@FindBy(id = "logo-Journals")
	WebElement oxfordimg;
	@FindBy(xpath = "//a[@class='register']")
	WebElement Registerlink;

	public Academicpage() {
		super();
		PageFactory.initElements(driver, this);

	}

	public String verifypage() {

		return driver.getTitle();

	}

	public boolean verifi_oxfordimg() {

		return oxfordimg.isDisplayed();

	}

	public boolean verify_signinLinlk() {
		

		return signinlink.isDisplayed();

	}

	public Homepage clickon_signpage(String un, String pw) {

		
		signinlink.click();
		emaiaddress.sendKeys(un);
		password.sendKeys(pw);
		signinbtn.click();
		return new Homepage();
	}

	public Registerpage clickon_register() {
		Registerlink.click();
		return new Registerpage();
	}

}
