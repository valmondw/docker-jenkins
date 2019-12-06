package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by Val on 08/11/2019.
 */
public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "REGISTER")
    private WebElement registerLink;

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "email")
    private WebElement usernameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage goToHomePage() {
        driver.get("http://newtours.demoaut.com");
        return new RegistrationPage(driver);
    }

    public void clickRegister(){
        registerLink.click();
        wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName){
        firstNameTxt.sendKeys(firstName);
        lastNameTxt.sendKeys(lastName);
    }

    public void enterCredentials(String username, String password){
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(password);
    }

    public void clickSubmit(){
        submitBtn.click();
    }


}//CLASS
