package com.testpackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.basepackage.TestBase;
import com.pagepackage.ContactsPage;
import com.pagepackage.HomePage;
import com.pagepackage.LoginPage;
import com.utilitypackage.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage login;
	HomePage homepage;
	ContactsPage contacts;
	String sheetName="Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		login = new LoginPage();
		homepage = new HomePage();
		contacts = new ContactsPage();
		homepage = login.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		TestUtil.switchToFrame();
		contacts = homepage.validateContactsLink();
	}

	@Test(priority = 1)
	public void crmLogoTest() {
		boolean logo = contacts.validatecrmLogo();
		Assert.assertTrue(logo);
		System.out.println("Logo is Displayed" + logo);
	}

	@Test(priority = 2)
	public void selectContactTest() {
		contacts.validateContacts("Dwayne Johnson");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] getcontactsData() {
		Object[][] data=TestUtil.passData(sheetName);
		return data;
	}

	@Test(priority = 1,dataProvider="getcontactsData")
	public void createNewContactTest(String Title,String FirstName,String LastName,String Company) {
		homepage.clickOnNewContactLink();
		contacts.createNewContact(Title, FirstName, LastName, Company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
