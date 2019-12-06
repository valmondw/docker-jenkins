package com.newtours.tests;

import com.newtours.pages.*;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String numPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"numPassengers", "expectedPrice"})
    public void setupParameters(String numPassengers, String expectedPrice){
        this.numPassengers = numPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void  registrationPageTest() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goToHomePage()
                        .clickRegister();
        registrationPage.enterUserDetails("selenium","docker");
        registrationPage.enterCredentials("selenium","docker");
        //Thread.sleep(20000);
        registrationPage.clickSubmit();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods ="registrationPageTest")
    public void registrationConfirmationPageTest() throws InterruptedException {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.gotoFindFlightsPage();
    }

    @Test(dependsOnMethods ="registrationConfirmationPageTest")
    public void flightDetailsPageTest(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(numPassengers);
        flightDetailsPage.clickContinue();
    }

    @Test(dependsOnMethods ="flightDetailsPageTest")
    public void findFlightPageTest(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.clickReserveFlights();
        findFlightPage.clickSecurePurchase();
    }

    @Test(dependsOnMethods ="findFlightPageTest")
    public void flightConfirmationPageTest(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }



}//CLASS
