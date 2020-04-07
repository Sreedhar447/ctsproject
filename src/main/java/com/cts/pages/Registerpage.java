package com.cts.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.Base.Testbase;

public class Registerpage extends Testbase {
	@FindBy(xpath = "//input[@id='EmailAddress']")
	WebElement email;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement cnfpasswd;
	@FindBy(xpath = "//button[@id='registerBtn']")
	WebElement registerbtn;

	public Registerpage() {
		PageFactory.initElements(driver, this);
	}

	public void register(String _Email, String _password, String _confirmpwd) {

		email.sendKeys(_Email);
		password.sendKeys(_password);
		cnfpasswd.sendKeys(_confirmpwd);
		registerbtn.click();

	}

}
