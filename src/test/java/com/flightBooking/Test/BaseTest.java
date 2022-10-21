package com.flightBooking.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;

	@BeforeTest
	public void setUp(ITestContext ctx) throws MalformedURLException {

		String host = "localhost";
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		System.out.println("HUB HOST : " + System.getProperty("HUB_HOST"));
		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
			System.out.println("Value of HOST :" + host);
		}
		String completeUrl = "http://" + host + ":4444/wd/hub";
		System.out.println("System.getProperty(BROWSER) : " + System.getProperty("BROWSER"));
		if ((System.getProperty("BROWSER") != null) && System.getProperty("BROWSER").equals("chrome")) {
			System.out.println("Browser is Chrome");
			System.setProperty("BROWSER", "chrome");
			dc = DesiredCapabilities.chrome();
			System.out.println("Complete URL for chrome is :" + completeUrl);
			this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

		} else {

			System.out.println("Browser is Firefox");
			System.setProperty("BROWSER", "firefox");
			dc = DesiredCapabilities.firefox();
			System.out.println("Complete URL for firefox is :" + completeUrl);
			this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

		}

	}

	@AfterTest
	public void closeBrowser() {
		this.driver.quit();
	}

}
