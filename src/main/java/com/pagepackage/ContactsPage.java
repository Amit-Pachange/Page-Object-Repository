package com.pagepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.basepackage.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'CRMPRO')]")
	WebElement crmLogo;

	@FindBy(xpath = "//select[@name='title']")
	WebElement title;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='surname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validatecrmLogo() {
		return crmLogo.isDisplayed();
	}

	public void validateContacts(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	public void createNewContact(String ttl,String fName,String lName,String comp) {
		Select select = new Select(title);
		select.selectByVisibleText(ttl);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		saveBtn.click();
	}

}