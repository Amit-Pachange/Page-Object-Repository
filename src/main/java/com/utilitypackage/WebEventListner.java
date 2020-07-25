package com.utilitypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.basepackage.TestBase;

public class WebEventListner extends TestBase implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Befor Accpting Alert");
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Accpting Alert");
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("After Dismissing Alert");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before Dismissing Alert");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigating to: '" + url + "'");
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before Navigating To Previous Page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After Navigating To Previous Page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before Navigating To Next Page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("After Navigating To Next Page");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before Refreshing a Page");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("After Refreshing a Page");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to Find element by : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found element by : " + by.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Befor Click On : " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After Findby : " + element.toString());
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Befor Changing Value of : " + element.toString() + "Before any Change made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Element value changed to : " + element.toString());
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Before Script : '" + script + "'");
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("After Script : '" + script + "'");
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Before Swithto Window : '" + windowName + "'");
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("After Swithto Window : '" + windowName + "'");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception Occured : " + error);
		try {
			TestUtil.takeScreenShot();
		} catch (Exception e) {
			System.out.println("Exception Occured");
		}
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

	}

	public void beforeGetText(WebElement element, WebDriver driver) {

	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {

	}

}
