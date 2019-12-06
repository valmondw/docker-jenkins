package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchTxt;

    @FindBy(id = "search_button_homepage")
    private WebElement searchBtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "buyFlights")
    private WebElement securePurchasebtn;

    @FindBy(css = "div[class='tile  tile--c--w  tile--vid  has-detail  opt--t-xxs']")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public SearchPage gotoDuckHomePage(){
        driver.get("https://duckduckgo.com");
        return new SearchPage(driver);
    }

    public SearchPage doSearch(String keyword){
        wait.until(ExpectedConditions.visibilityOf(searchTxt));
        searchTxt.sendKeys(keyword);
        searchBtn.click();
        return new SearchPage(driver);

    }
    public SearchPage gotoVideos(){
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        videosLink.click();
        return new SearchPage(driver);
    }

    public int getResult(){
        By by = By.cssSelector("div[class='tile  tile--c--w  tile--vid  has-detail  opt--t-xxs']");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by ,0));
        System.out.println("No. of all Videos listed: "+allVideos.size());
        return allVideos.size();
    }



}//CLASS
