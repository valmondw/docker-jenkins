package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = ".",
        glue={"com.stepdefinitions"},
        tags = {"~@ignore"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/duckduck-html-report",
                "json:target/cucumber-reports/json-reports/cucumber.json",
                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"})
public class TestRunner  extends AbstractTestNGCucumberTests{
}
