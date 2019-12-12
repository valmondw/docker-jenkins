package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = ".",
        glue={"com.stepdefinitions"},
        tags = {"~@ignore"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/json-reports/CucumberTestReports.json",
                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"})
public class TestRunner  extends AbstractTestNGCucumberTests{
}
