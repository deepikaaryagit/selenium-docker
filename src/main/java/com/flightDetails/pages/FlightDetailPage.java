package com.flightDetails.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;

public class FlightDetailPage extends BasePage {

	@FindBy(name = "passCount")
	WebElement passengers;

	@FindBy(name = "findFlights")
	WebElement findFlightsBtn;

	@FindBy(name = "reserveFlights")
	WebElement reserveFlightBtn;

	@FindBy(name = "buyFlights")
	WebElement buyFlightsBtn;

	public FlightDetailPage(WebDriver driver) {
		super(driver);
	}

	public void selectNoOfPassangers(String numberOfPassanger) {
		wait.until((d) -> passengers.isDisplayed());
		Select select = new Select(passengers);
		select.selectByValue(numberOfPassanger);
	}

	public void findFlightBtn() {
		wait.until((d) -> findFlightsBtn.isDisplayed());

		findFlightsBtn.click();
	}

	public void reserveFlightBtn() {
		wait.until((d) -> reserveFlightBtn.isDisplayed());
		reserveFlightBtn.click();
	}

	public void buyFlightBtn() {
		wait.until((d) -> buyFlightsBtn.isDisplayed());
		buyFlightsBtn.click();
	}

}
