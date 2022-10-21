package com.flightDetails.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;

public class FlightConfirmationPage extends BasePage {

	@FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
	private WebElement filghtConfirmationText;

	@FindBy(xpath = "(//font[contains(text(),'USD')])[2]")
	private WebElement totalPrice;

	public FlightConfirmationPage(WebDriver driver) {

		super(driver);
	}

	public void printOrderId() {

		wait.until((d) -> filghtConfirmationText.isDisplayed());
		System.out.println("Confirmation :" + filghtConfirmationText.getText());

		wait.until((d) -> totalPrice.isDisplayed());
		System.out.println("TotalPrice :" + totalPrice.getText());

	}

}
