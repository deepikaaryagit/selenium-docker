package com.flightBooking.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;

public class RegistrationPage extends BasePage{

	
	@FindBy(name = "firstName")
	private WebElement firstName;
	
	@FindBy(name = "lastName")
	private WebElement lastName;
	
	@FindBy(name = "userName")
	private WebElement email;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(name = "register")
	private WebElement submitBtn;
	
	
	@FindBy(name = "email")
	private WebElement userName;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public void goTo() {
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		this.wait.until(ExpectedConditions.visibilityOf(firstName));
		wait.until((d)-> firstName.isDisplayed());
	}
	
	public void enterUserDetails(String firstName, String lastName, String email) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		
	}
	
	public void enterUserCredentials(String userName, String password)
	{
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.confirmPassword.sendKeys(password);
	}
	
	public void submit()
	{
		this.submitBtn.click();
		
	}
	
	
}
