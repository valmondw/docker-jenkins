package com.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.openqa.selenium.WebDriver;
import com.searchmodule.pages.SearchPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Val on 12/12/2019.
 */
public class SearchSteps {

    private SearchPage searchPage;
    private WebDriver driver;

    @Before
    public void setupDriver() throws MalformedURLException {

        String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }


        //String completeUrl = "http://" + host + ":4444/wd/hub";
        String completeUrl = "http://10.0.75.1:4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }

    @After
    public void quitDriver(){
        this.driver.quit();
    }















    @Given("^I am goto the duck-duck go website$")
    public void goto_to_duckduck_website(){
        searchPage.gotoDuckHomePage();
    }

    @And("^I enter the \"(.*?)\" to search$")
    public void enterKeyword(String keyword){
        searchPage.doSearch(keyword);
    }

    @And("^I navigate to the videos search$")
    public void navigateToVideo(){
        searchPage.gotoVideos();
    }

    @Then("^I should get minimum (\\d+) search results$")
    public void verifySearchResults(int min){
        int size = searchPage.getResult();
        Assert.assertTrue(size > min);
    }






}//
