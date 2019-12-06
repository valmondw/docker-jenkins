package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Val on 09/11/2019.
 */
public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement reserveFlightsBtn;

    @FindBy(name = "buyFlights")
    private WebElement securePurchasebtn;

    public FindFlightPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void clickReserveFlights(){
        wait.until(ExpectedConditions.elementToBeClickable(reserveFlightsBtn));
        reserveFlightsBtn.click();
    }

    public void clickSecurePurchase(){
        wait.until(ExpectedConditions.elementToBeClickable(securePurchasebtn));
        securePurchasebtn.click();
    }










}//CLASS
