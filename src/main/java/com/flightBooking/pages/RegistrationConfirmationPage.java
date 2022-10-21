package com.flightBooking.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;

public class RegistrationConfirmationPage extends BasePage {

	

	
	@FindBy(id="flight-link")
	private WebElement flightLink;
	
	public RegistrationConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickFlightLink() {
		
		wait.until((d)-> flightLink.isDisplayed());
		flightLink.click();
	}
	
	
}
