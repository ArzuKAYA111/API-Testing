package com.APIhrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class FailedRunner {
	@RunWith(Cucumber.class)
	@CucumberOptions(

	features="@target/failed.txt/", 
			
glue = "com/APIhrms/steps", 

monochrome = true, 

plugin= {
"pretty" // prints gherkin steps in console
//"html:target/cucumber-default-report",// create basic html report on specified location

}

)


public class RegressionRunner {

}

}
