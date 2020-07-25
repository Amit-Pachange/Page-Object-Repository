package com.testpackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.basepackage.TestBase;
import com.pagepackage.ContactsPage;
import com.pagepackage.DealPage;
import com.pagepackage.HomePage;
import com.pagepackage.LoginPage;
import com.utilitypackage.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage login;
	HomePage homepage;
	ContactsPage contactsPage;
	DealPage dealPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		login = new LoginPage();
		homepage = new HomePage();
		contactsPage = new ContactsPage();
		dealPage = new DealPage();
		homepage = login.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}

	@Test(priority = 1)
	public void crmLogoTest() {
		TestUtil.switchToFrame();
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");;
		System.out.println("The Homepage Title is " + title);
	}

	@Test(priority = 2)
	public void contactsLinkTest() {
		TestUtil.switchToFrame();
		contactsPage = homepage.validateContactsLink();
	}

	@Test(priority = 3)
	public void dealPageTest() {
		TestUtil.switchToFrame();
		dealPage = homepage.validateDealsPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
