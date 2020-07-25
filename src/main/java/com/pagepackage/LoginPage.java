package com.pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.basepackage.TestBase;

public class LoginPage extends TestBase {

	// Object Repository
	@FindBy(xpath = "//a[contains(@class,'navbar-brand')]")
	WebElement logo;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[contains(@class,'btn btn-small')]")
	WebElement login;

	// Initialize Web Elements

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMLogo() {
		return logo.isDisplayed();
	}

	public HomePage validateLogin(String uname, String pswd) {
		username.sendKeys(uname);
		password.sendKeys(pswd);
		login.submit();
		return new HomePage();
	}

}
