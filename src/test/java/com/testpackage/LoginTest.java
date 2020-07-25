package com.testpackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.basepackage.TestBase;
import com.pagepackage.HomePage;
import com.pagepackage.LoginPage;


public class LoginTest extends TestBase {
	LoginPage login;
	HomePage homepage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		login = new LoginPage();
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String Title = login.validatePageTitle();
		Assert.assertEquals(Title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void crmLogoTest() {
		boolean flag = login.validateCRMLogo();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void loginTest() {
		homepage = login.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
