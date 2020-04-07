package com.cts.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.Base.Testbase;

public class Homepage extends Testbase {
	// page repository (OR)
	@FindBy(xpath = "//li[@class='oup-header-menu-item desktop']//a[@id='header-account-info-user-fullname']")
	WebElement usernamelabel;
	@FindBy(xpath = "//img[@id='logo-Journals']")
	WebElement jounal_logo;
	@FindBy(xpath = "//nav[@class='navbar-menu']//a[@class='nav-link dummy-link'][contains(text(),'Journals by Subject')]")
	WebElement jornalby_subject_link;
	@FindBy(xpath = "//nav[@class='navbar-menu']//a[contains(@class,'nav-link')][contains(text(),'Medicine & Health')]")
	WebElement medicine_health_link;
	@FindBy(xpath = "//nav[@class='navbar-menu']//a[contains(@class,'nav-link')][contains(text(),'Arts & Humanities')]")
	WebElement Arts_humanities_link;
	@FindBy(xpath = "//nav[@class='navbar-menu']//a[@class='nav-link dummy-link'][contains(text(),'Customer Services')]")
	WebElement customer_services_link;
	@FindBy(xpath = "//nav[@class='navbar-menu']//a[contains(@class,'nav-link')][contains(text(),'Access & Purchase')]")
	WebElement Acess_purchase_link;

	public Homepage() {
		super();
		PageFactory.initElements(driver, this);

	}

	public String verify_title_page() {

		return driver.getTitle();
	}

	public boolean check_label() {
		return usernamelabel.isDisplayed();
	}

	public boolean logo_check() {
		return jounal_logo.isDisplayed();
	}

	public String click_on_Arts_hum_link() {
		Actions ac = new Actions(driver);
		ac.moveToElement(jornalby_subject_link).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Arts_humanities_link.click();
		return driver.getTitle();

	}

	public String click_on_medicines_health_link() {
		Actions ac = new Actions(driver);
		ac.moveToElement(jornalby_subject_link).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		medicine_health_link.click();
		return driver.getTitle();

	}

	public String click_on_Acess_purchase_link() {
		Actions ac = new Actions(driver);
		ac.moveToElement(customer_services_link).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Acess_purchase_link.click();
		return driver.getTitle();

	}

}
