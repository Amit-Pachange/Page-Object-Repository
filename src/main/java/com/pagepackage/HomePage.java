package com.pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basepackage.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealslink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage validateContactsLink() {
		contactslink.click();
		return new ContactsPage();
	}

	public DealPage validateDealsPage() {
		dealslink.click();
		return new DealPage();
	}
	
	public void clickOnNewContactLink() {
		Actions act=new Actions(driver);
		act.moveToElement(contactslink).build().perform();
		newContactsLink.click();
		
	}

}
