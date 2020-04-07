package com.cts.runner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "G:\\eclipse\\eclipse2020\\Academic.com\\src\\main\\resources\\Feature\\login.feature", 
                 glue = {"Stepdefination" }, 
                 plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml" }, 
                 monochrome = true,
		         dryRun = false

)
public class TestRunner {
	
	@AfterClass
	public static void extentrepors() {
		Reporter.loadXMLConfig("/src/test/resources/extend_reports");
		Reporter.setSystemInfo("user name", System.getProperty("user.name"));
		
		
		
		
		
		
	}


}
