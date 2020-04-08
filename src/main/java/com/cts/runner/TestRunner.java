package com.cts.runner;

import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "G:\\eclipse\\eclipse2020\\Academic.com\\src\\main\\resources\\Feature\\login.feature",
				glue = {"Stepdefination" }, 

				 plugin = { "pretty","json:target/cucumber-reports/Cucumber.json",
						 "junit:target/cucumber-reports/Cucumber.xml",
						 "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
						 },
				monochrome = true, 
				dryRun = false

)
/* This class is used to run the feature file*/
public class TestRunner {



}
