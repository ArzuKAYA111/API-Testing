package com.hrms.API.steps.practice;



import com.hrms.API.Testbase.BaseClass;
import com.hrms.API.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void start() {
		BaseClass.setUp();
	}
	
	@After
	public void end(Scenario scenario) {
		
		byte[] pic;
		if(scenario.isFailed()) {
			pic=CommonMethods.takeScreenshot("failed/"+scenario.getName());
		}else {
			pic=CommonMethods.takeScreenshot("passed/"+scenario.getName());
		}
		
		scenario.attach(pic, "image/png", scenario.getName());
		
		BaseClass.tearDown();
	}
}