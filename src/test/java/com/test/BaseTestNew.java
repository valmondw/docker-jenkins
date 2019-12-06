package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Val on 13/11/2019.
 */
public class BaseTestNew {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        String host = "localhost";
        DesiredCapabilities capabilities;
        String testName = ctx.getCurrentXmlTest().getName();

        if(System.getProperty("BROWSER") != null &&
          System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            capabilities = DesiredCapabilities.firefox();
        }else{
            capabilities = DesiredCapabilities.chrome();
        }
        capabilities.setCapability("name", testName);

        if(System.getProperty("HUB_HOST")!= null){
            host = System.getProperty("HUB_HOST");
            String hubUrl = "http://"+ host + ":4444/wd/hub";
            this.driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        }else{
            System.setProperty("webdriver.chrome.driver","C:\\DockerStuff\\Chromedriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            this.driver = new ChromeDriver(capabilities);
            driver.manage().window().maximize();
        }

    }


    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }
}//CLASS
