package com.flightBooking.Test;


import org.testng.ITestContext;
import org.testng.annotations.Test;


import com.flightBooking.pages.RegistrationConfirmationPage;
import com.flightBooking.pages.RegistrationPage;
import com.flightDetails.pages.FlightConfirmationPage;
import com.flightDetails.pages.FlightDetailPage;



public class FlightBookingTest extends BaseTest{

	RegistrationPage registrationPage;
	RegistrationConfirmationPage registrationConfirmationPage;
	FlightDetailPage flightDetailPage;
	FlightConfirmationPage flightConfirmationPage;
	
	
	
	@Test
	
	public void registrationTest() {
		System.out.println("RegistrationTest");
		registrationPage = new RegistrationPage(driver);
		registrationPage.goTo();
		registrationPage.enterUserDetails("Deepika", "Arya", "deepika.arya@gg.com");
		registrationPage.enterUserCredentials("Deepika", "Arya");
		registrationPage.submit();
		
	}
	
	@Test (dependsOnMethods = "registrationTest")
	public void registrationConfirmationTest()
	{
		System.out.println("registrationConfirmationTest");
		registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.clickFlightLink();
		
	}
	
	@Test (dependsOnMethods = "registrationConfirmationTest")
	public void flightDetailTest()
	{
		System.out.println("flightDetailTest");
		
		flightDetailPage = new FlightDetailPage(driver);
		flightDetailPage.selectNoOfPassangers("3");
		flightDetailPage.findFlightBtn();
		flightDetailPage.reserveFlightBtn();
		flightDetailPage.buyFlightBtn();
	}
	
	@Test(dependsOnMethods = "flightDetailTest")
	public void flightConfirmationPageTest() {
		System.out.println("flightConfirmationPageTest");
		
		flightConfirmationPage = new FlightConfirmationPage(driver);
		flightConfirmationPage.printOrderId();
		
	}
		
	
}
