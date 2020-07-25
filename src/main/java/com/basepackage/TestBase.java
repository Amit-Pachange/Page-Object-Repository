package com.basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.utilitypackage.TestUtil;
import com.utilitypackage.WebEventListner;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public static WebEventListner listner;
	public static EventFiringWebDriver efw;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fit = new FileInputStream(
					"C:\\Users\\JaiGanesh\\eclipse-workspace\\PageObjectModel\\src\\main\\java"
							+ "\\com\\propertiespackage\\Config.properties");
			try {
				prop.load(fit);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium jars 3.141.59\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("FF")) {
			System.setProperty("webdriver.geko.driver", "D:\\Selenium jars 3.141.59\\Firefox.exe");
			driver = new FirefoxDriver();
		}

		
		  efw=new EventFiringWebDriver(driver); 
		  listner=new WebEventListner();
		  efw.register(listner); 
		  driver=efw;
		 

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));

	}

	public static void failed(String testMethodName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("C:\\Users\\JaiGanesh\\eclipse-workspace\\PageObjectModel/FailedSceenshots/ " + testMethodName + " .png "));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
